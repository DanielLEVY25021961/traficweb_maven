package levy.daniel.application.model.dao.metier.localisation;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.AbstractDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;


/**
 * class AbstractDaoLocalisationBasePur :<br/>
 * <ul>
 * <li>
 * DAO ABSTRAIT SPRING pour les 
 * <b>AbstractLocalisationBasePur</b>.
 * </li>
 * <li>
 * Comporte l'implémentation des méthodes <b>spécifiques</b> aux 
 * AbstractLocalisationBasePur.
 * </li>
 * <li>IMPLEMENTE L'INTERFACE IDaoLocalisationBasePur.</li>
 * <li>
 * HERITE DE LA CLASSE ABSTRAITE 
 * AbstractDaoGenericJPASpring&lt;AbstractLocalisationBasePur, Long&gt;.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_DAOs.png" 
 * alt="implémentation des DAOs" border="1" align="center" />
 * </li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 7 nov. 2017
 *
 */
@Repository("AbstractDaoLocalisationBasePur")
//@Qualifier("AbstractDaoGenericJPASpring")
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AbstractDaoLocalisationBasePur 
	extends AbstractDaoGenericJPASpring<AbstractLocalisationBasePur, Long> 
					implements IDaoLocalisationBasePur {

	// ************************ATTRIBUTS************************************/

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';
	
	/**
	 * SELECT_OBJET : String :<br/>
	 * "select abstractLocalisationBasePur from 
	 * AbstractLocalisationBasePur as abstractLocalisationBasePur ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select abstractLocalisationBasePur from "
				+ "AbstractLocalisationBasePur as abstractLocalisationBasePur ";

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractDaoLocalisationBasePur.class);



	// *************************METHODES************************************/

	
	
	 /**
	 * method CONSTRUCTEUR AbstractDaoLocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractDaoLocalisationBasePur() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final AbstractLocalisationBasePur pObject) 
					throws AbstractDaoException {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		/* Crée l'Objet en base. */
		final AbstractLocalisationBasePur objetPersistant 
			= this.create(pObject);
		
		/* retourne l'ID de l'objet persistant. */
		return objetPersistant.getId();	
		
	} // Fin de createReturnId(...)._______________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractLocalisationBasePur retrieve(
			final AbstractLocalisationBasePur pObject) 
						throws AbstractDaoException {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}
		
		AbstractLocalisationBasePur objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where abstractLocalisationBasePur.route = :route "
				+ "and abstractLocalisationBasePur.cumul = :cumul "
				+ "and abstractLocalisationBasePur.cote = :cote";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("route", pObject.getRoute());
		requete.setParameter("cumul", pObject.getCumul());
		requete.setParameter("cote", pObject.getCote());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (AbstractLocalisationBasePur) requete.getSingleResult();
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
				
		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractLocalisationBasePur retrieveByIdMetier(
			final AbstractLocalisationBasePur pObjet) 
									throws AbstractDaoException {
		return this.retrieve(pObjet);
	} // Fin de retrieveByIdMetier(...).___________________________________




	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(Long pId) 
			throws AbstractDaoException {
		
		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		AbstractLocalisationBasePur objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where abstractLocalisationBasePur.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (AbstractLocalisationBasePur) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
		}

		
		try {
			
			if (objetPersistant != null) {
				
				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);
				
				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);
				
			}

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
		
	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}
		
		boolean resultat = false;
		
		AbstractLocalisationBasePur objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where abstractLocalisationBasePur.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (AbstractLocalisationBasePur) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
			resultat = false;
		}

		
		try {
			
			if (objetPersistant != null) {
				
				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);
				
				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);
				
				resultat = true;
			}

		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
		
		return resultat;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final AbstractLocalisationBasePur pObject) 
								throws AbstractDaoException {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		AbstractLocalisationBasePur objetResultat = null;
		
		/* REQUETE HQL PARMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where abstractLocalisationBasePur.route = :route "
				+ "and abstractLocalisationBasePur.cumul = :cumul "
				+ "and abstractLocalisationBasePur.cote = :cote";
		
		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);
		
		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("route", pObject.getRoute());
		requete.setParameter("cumul", pObject.getCumul());
		requete.setParameter("cote", pObject.getCote());
		
		try {
			
			/* Execution de la requete HQL. */
			objetResultat 
			= (AbstractLocalisationBasePur) requete.getSingleResult();
			
			/* retourne true si l'objet existe en base. */
			if (objetResultat != null) {
				resultat = true;
			}
			
		}
		catch (NoResultException noResultExc) {
			
			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;
			
		}
		catch (Exception e) {
			
			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}
			
			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(e);
		}
				
		return resultat;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(Long pId) throws AbstractDaoException {
		
		/* retourne false si pId == null . */
		if (pId == null) {
			return false;
		}
		
		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}
		
		return false;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListe(
			final List<AbstractLocalisationBasePur> pListe) {
		
		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final AbstractLocalisationBasePur objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		return stb.toString();
		
	} // Fin de afficherListe(...).________________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void renseignerClassObjetMetier() {

		this.setClassObjetMetier(AbstractLocalisationBasePur.class);

	} // Fin de renseignerClassObjetMetier().______________________________

	
	
} // FIN DE LA CLASSE AbstractDaoLocalisationBasePur.------------------------
