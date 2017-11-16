package levy.daniel.application.model.dao.daoexceptions;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.SQLGrammarException;
import org.postgresql.util.PSQLException;

import levy.daniel.application.model.dao.daoexceptions.technical.impl.DaoDoublonException;
import levy.daniel.application.model.dao.daoexceptions.technical.impl.DaoPSQLException;
import levy.daniel.application.model.dao.daoexceptions.technical.impl.DaoTransactionException;

/**
 * class GestionnaireDaoException :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * StringUtils.splitByWholeSeparator, Split, Casser une chaine,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 18 sept. 2017
 *
 */
public class GestionnaireDaoException {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_GESTIONNAIREDAOEXCEPTION : String :<br/>
	 * "Classe GestionnaireDaoException".<br/>
	 */
	public static final String CLASSE_GESTIONNAIREDAOEXCEPTION 
		= "Classe GestionnaireDaoException";

	
	/**
	 * METHOD_GEREREXCEPTION : String :<br/>
	 * "Méthode gererException(Exception pE)".<br/>
	 */
	public static final String METHOD_GEREREXCEPTION 
		= "Méthode gererException(Exception pE)";
	
	
	/**
	 * METHOD_GERER_DOUBLONS : String :<br/>
	 * "Méthode gererDoublon(Exception pE
	 * , Throwable pCauseMere, Throwable pCauseGrandMere)".<br/>
	 */
	public static final String METHOD_GERER_DOUBLONS 
		= "Méthode gererDoublon(Exception pE"
				+ ", Throwable pCauseMere, Throwable pCauseGrandMere)";
	
	
	/**
	 * TIRET_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String TIRET_AERE = " - ";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnaireDaoException.class);
	

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR GestionnaireDaoException() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GestionnaireDaoException() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method gererException(
	 * Exception pE) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pE : Exception.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	public void gererException(final Exception pE) 
				throws AbstractDaoException {
		
		final Throwable causeMere = pE.getCause();
		Throwable causeGrandMere = null;
		
		if (causeMere != null) {
			causeGrandMere = causeMere.getCause();
		}

		
		/* Violation de contraintes ou Tables absentes. */
		if (pE instanceof PersistenceException) {
			
			/* Tables absentes. */
			if (causeMere != null 
					&& causeMere instanceof SQLGrammarException) {
				
				final String baseMessage = "PROBLEME GRAVE POSTGRESQL";
				final String baseUtilisateur = "Prévenez le centre serveur";
				
				String messageUtilisateur = null;			
				String messageTechnique = null;
			
				if (causeGrandMere != null && causeGrandMere instanceof PSQLException) {
					
					messageUtilisateur 
						= baseMessage + TIRET_AERE 
						+ causeGrandMere.getMessage() + TIRET_AERE 
						+ baseUtilisateur;
					
					messageTechnique 
						= CLASSE_GESTIONNAIREDAOEXCEPTION + TIRET_AERE 
						+ METHOD_GEREREXCEPTION + TIRET_AERE 
						+ baseMessage + TIRET_AERE 
						+ causeGrandMere.getMessage() + TIRET_AERE 
						+ pE.getMessage();
					
				} else {
					
					messageUtilisateur 
					= baseMessage + TIRET_AERE 
					+ baseUtilisateur;
					
					messageTechnique 
					= CLASSE_GESTIONNAIREDAOEXCEPTION + TIRET_AERE 
						+ METHOD_GEREREXCEPTION + TIRET_AERE 
						+ baseMessage + TIRET_AERE 
						+ pE.getMessage();
					
				}
								
				final DaoPSQLException daoPSQLExc 
				= new DaoPSQLException(pE.getMessage(), pE);
				
				daoPSQLExc.setMessageUtilisateur(messageUtilisateur);
				daoPSQLExc.setMessageTechnique(messageTechnique);
				
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageUtilisateur, pE);
				}
				
				throw daoPSQLExc;						
			}
			
			/* Problème de transaction. */
			if (pE instanceof TransactionRequiredException) {
								
				final String messageUtilisateur 
					= "PROBLEME GRAVE DE TRANSACTION - Prévenez le centre serveur";
				
				final String messageTechnique 
					= "PROBLEME GRAVE DE TRANSACTION - "
						+ pE.getMessage();
				
				
				final DaoTransactionException daoTransactionExc 
				= new DaoTransactionException(pE.getMessage(), pE);
				
				daoTransactionExc.setMessageUtilisateur(messageUtilisateur);
				daoTransactionExc.setMessageTechnique(messageTechnique);
				
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageUtilisateur, pE);
				}
				
				throw daoTransactionExc;			
			}
						
			/* problème de doublon. */
			gererDoublon(pE, causeMere, causeGrandMere);			
		}
		
		if (pE instanceof EntityExistsException) {
			System.out.println("PROBLEME DE PERSISTANCE EntityExistsException : " + pE);
		}

	} // Fin de gererException(...)._______________________________________
	
	
	

	/**
	 * method gererDoublonPostgres(
	 * Exception pE
	 * , Throwable pCauseMere
	 * , Throwable pCauseGrandMere) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pE
	 * @param pCauseMere
	 * @param pCauseGrandMere
	 * 
	 * @throws DaoDoublonException :  :  .<br/>
	 */
	private void gererDoublon(
			final Exception pE
				, final Throwable pCauseMere
					, final Throwable pCauseGrandMere) 
							throws DaoDoublonException {
				
		if (pCauseGrandMere != null) {
			
			if (pCauseGrandMere instanceof PSQLException) {
				
				final String messageUtilisateur 
					= "TENTATIVE DE CREATION DE DOUBLON - " 
							+ this.getDetailpostgresqlException(
									pCauseGrandMere.getMessage());
				
				final String messageTechnique 
					= CLASSE_GESTIONNAIREDAOEXCEPTION + TIRET_AERE
						+ METHOD_GERER_DOUBLONS + TIRET_AERE
						+ "TENTATIVE DE CREATION DE DOUBLON"
						+ TIRET_AERE
						+ pCauseGrandMere.getMessage() 
						+ TIRET_AERE 
						+ pCauseGrandMere.getClass().getName();
				
				
				final DaoDoublonException daoDoublonExc 
				= new DaoDoublonException(
						pCauseGrandMere.getMessage(), pCauseGrandMere);
				
				daoDoublonExc.setMessageUtilisateur(messageUtilisateur);
				daoDoublonExc.setMessageTechnique(messageTechnique);
				
				if (LOG.isDebugEnabled()) {
					LOG.debug(messageUtilisateur, pCauseGrandMere);
				}
				
				throw daoDoublonExc;
				
			}
		}
		else if (pCauseMere != null) {
			
			final String messageUtilisateur 
			= "CAUSE MERE : " 
			+ pCauseMere.getClass().getName() 
			+ TIRET_AERE 
			+  pCauseMere.getMessage();
			
			final String messageTechnique 
			= "CAUSE MERE : " 
			+ pCauseMere.getClass().getName() 
			+ TIRET_AERE 
			+  pCauseMere.getMessage();
			
			final DaoDoublonException daoDoublonExc 
			= new DaoDoublonException(
					pCauseMere.getMessage(), pCauseMere);
			
			daoDoublonExc.setMessageUtilisateur(messageUtilisateur);
			daoDoublonExc.setMessageTechnique(messageTechnique);
			
			throw daoDoublonExc;
			
		}
		else {
			
			final String messageUtilisateur 
			= "CAUSE DE L'EXCEPTION : " 
			+ pE.getClass().getName() 
			+ TIRET_AERE 
			+  pE.getMessage();
			
			final String messageTechnique 
			= "CAUSE MERE : " 
			+ pE.getClass().getName() 
			+ TIRET_AERE 
			+  pE.getMessage();
			
			final DaoDoublonException daoDoublonExc 
			= new DaoDoublonException(
					pE.getMessage(), pE);
			
			daoDoublonExc.setMessageUtilisateur(messageUtilisateur);
			daoDoublonExc.setMessageTechnique(messageTechnique);
			
			throw daoDoublonExc;			
		}
				
	} // Fin de gererDoublonPostgres(...)._________________________________
	

	
	/**
	 * method getDetailpostgresqlException(
	 * String pString) :<br/>
	 * Split.<br/>
	 * <br/>
	 *
	 * @param pString
	 * @return :  :  .<br/>
	 */
	private String getDetailpostgresqlException(
			final String pString) {
		
		if (StringUtils.isBlank(pString)) {
			return null;
		}
				
		String resultat = null;
		
		final String[] tableauString 
			= StringUtils.splitByWholeSeparator(pString, "Détail : ");
				
		if (tableauString != null) {
			
			final int taille = tableauString.length;
			
			resultat = tableauString[taille - 1];
						
		}
		
		return resultat;
		
	} // Fin de getDetailpostgresqlException(...)._________________________
	
	
	
} // FIN DE LA CLASSE GestionnaireDaoException.------------------------------
