package levy.daniel.application.apptechnic.configurationmanagers;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.ConfigurationApplicationManager;


/**
 * class ConfigurationPersistenceManager :<br/>
 * Classe UTILITAIRE 
 * Chargée de gérer la configuration des DONNEES DE PERSISTENCE 
 * de l'application.<br/>
 * Met à disposition de l'ensemble de l'application 
 * des Singletons.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<code>final ResourceBundle bundleApplication 
 * = ConfigurationPersistenceManager.getBundleApplication();<br/>
 * // RAPPORT AU FORMAT CSV si problème (le rapport est alors non null).<br/>
 * ConfigurationPersistenceManager.getRapportConfigurationCsv().</code><br/> 
 *<br/>
 * 
 * - Mots-clé :<br/>
 * pattern délégation, DELEGATION, <br/>
 * pattern Singleton, singleton, <br/>
 * Rapport du chargement de la configuration au format csv,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 16 avr. 2016
 *
 */
public final class ConfigurationPersistenceManager {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_CONFIGURATIONPERSISTENCEMANAGER : String :<br/>
	 * "Classe ConfigurationPersistenceManager".<br/>
	 */
	public static final String CLASSE_CONFIGURATIONPERSISTENCEMANAGER 
		= "Classe ConfigurationPersistenceManager";
	
	
	/**
	 * METHODE_GET_STATSACTIVEES : String :<br/>
	 * "Méthode getStatsActivees()".<br/>
	 */
	public static final String METHODE_GET_STATSACTIVEES
		= "Méthode getStatsActivees()";

	
	/**
	 * METHODE_GET_CHEMINSQLVIDAGEBASE : String :<br/>
	 * "Méthode getCheminSqlVidageBase()".<br/>
	 */
	public static final String METHODE_GET_CHEMINSQLVIDAGEBASE
		= "Méthode getCheminSqlVidageBase()";

	
	//*****************************************************************/
	//**************************** BOM_UTF-8 **************************/
	//*****************************************************************/
	/**
	 * BOM_UTF : char :<br/>
	 * BOM UTF-8 pour forcer Excel 2010 à lire en UTF-8.<br/>
	 */
	public static final char BOM_UTF_8 = '\uFEFF';

	
	//*****************************************************************/
	//**************************** SEPARATEURS ************************/
	//*****************************************************************/
	/**
	 * SEP_PV : String :<br/>
	 * Séparateur pour les CSV ";".<br/>
	 */
	public static final String SEP_PV = ";";

    
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";
	
	
	/**
	 * UNDERSCORE : String :<br/>
	 * "_".<br/>
	 */
	public static final String UNDERSCORE = "_";


	//*****************************************************************/
	//**************************** SAUTS ******************************/
	//*****************************************************************/	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");

	
	//*****************************************************************/
	//**************************** LOCALE *****************************/
	//*****************************************************************/
	/**
	 * LOCALE_FR : Locale : <br/>
	 * Locale France.<br/>
	 */
	public static final Locale LOCALE_FR = new Locale("fr", "FR");


	
	//*****************************************************************/
	//**************************** PERSISTENCE ************************/
	//*****************************************************************/

	
	/**
	 * statsActivees : Boolean :<br/>
	 * Affiche les Stats Hibernate si true.<br/>
	 * Clé : ""abstractdao.statsactivees"".<br/>
	 */
	private static Boolean statsActivees;

	
	/**
	 * cheminSqlVidageBase : String :<br/>
	 * Chemin du Script SQL de vidage de la base 
	 * (stocké dans application_fr_FR.properties).<br/>
	 */
	private static String cheminSqlVidageBase;
	

	/**
	 * rapportConfigurationCsv : String :<br/>
	 * Rapport du chargement de la configuration au format csv.<br/>
	 * Le rapport est null si il n'y a eu aucun 
	 * problème d'initialisation de l'application.<br/>
	 */
	private static String rapportConfigurationCsv;

	
	/**
	 * messageIndividuelRapport : String :<br/>
	 * Message pour le Rapport du chargement de la configuration au format csv 
	 * généré par chaque méthode individuellement.<br/>
	 */
	private static String messageIndividuelRapport;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(ConfigurationPersistenceManager.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationPersistenceManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour interdire l'instanciation.<br/>
	 * <br/>
	 */
	private ConfigurationPersistenceManager() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method getStatsActivees() :<br/>
	 * Getter du Boolean qui Affiche les Stats Hibernate si true.<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * messagestechniques_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirStatsActiveesEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "abstractdao.statsactivees".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par fournirStatsActiveesEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return : Boolean : statsActivees.<br/>
	 */
	public static Boolean getStatsActivees() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationPersistenceManager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;
			
			if (statsActivees == null) {
								
				if (ConfigurationApplicationManager
						.getBundleMessagesTechniques() != null) {
					
					try {
						
						/* Essaie de récupérer la valeur dans le properties. */
						final String valeurStatsActivees 
						= ConfigurationApplicationManager
							.getBundleMessagesTechniques()
								.getString(
									fournirCleStatsActivees());
						
						/* Nettoie la valeur lue dans le 
						 * .properties avec trim(). */
						final String valeurStatsActiveesNettoyee 
							= StringUtils.trim(valeurStatsActivees);
						
						statsActivees 
							= Boolean.valueOf(valeurStatsActiveesNettoyee);
						
					} catch (MissingResourceException mre) {
						
						/* Création du message. */
						messageIndividuelRapport 
						= creerMessageManqueCle(
								METHODE_GET_STATSACTIVEES
								, fournirCleStatsActivees()
								, ConfigurationApplicationManager
									.getBundleMessagesTechniques());
						
						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}
						
						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);
						
						/* utilise la valeur en dur fournie 
						 * par fournirStatsActiveesEnDur(). */
						statsActivees = fournirStatsActiveesEnDur();
						
					} // Fin de catch (MissingResourceException mre)._____
					
				} // Fin de if (getBundleMessagesTechniques() != null).___
				
				/* if (getBundleMessagesTechniques() == null)*/
				else {
					
					/* utilise la valeur en dur fournie 
					 * par fournirStatsActiveesEnDur(). */
					statsActivees = fournirStatsActiveesEnDur();
					
				} // Fin de if (getBundleMessagesTechniques() == null)._
								
			} // Fin de if (statsActivees == null).____________________
			
			return statsActivees;
									
		} // Fin de synchronized.________________________________________
		
	} // Fin de getStatsActivees().________________________________________
	


	/**
	 * method fournirCleStatsActivees() :<br/>
	 * clé du Boolean statsActivees dans 
	 * messagestechniques_fr_FR.properties.<br/>
	 * "abstractdao.statsactivees".<br/>
	 * <br/>
	 *
	 * @return : String : "abstractdao.statsactivees".<br/>
	 */
	private static String fournirCleStatsActivees() {
		return "abstractdao.statsactivees";
	} // Fin de fournirCleStatsActivees()._________________________________
	


	/**
	 * method fournirStatsActiveesEnDur() :<br/>
	 * Fournit une valeur stockée en dur 
	 * dans la classe pour statsActivees.<br/>
	 * <br/>
	 * false.<br/>
	 * <br/>
	 *
	 * @return : Boolean : false.<br/>
	 */
	private static Boolean fournirStatsActiveesEnDur() {
		return false;
	} // Fin de fournirStatsActiveesEnDur()._______________________________
	

	
	/**
	 * method getCheminSqlVidageBase() :<br/>
	 * Getter du Chemin du Script SQL de vidage de la base 
	 * (stocké dans application_fr_FR.properties).<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirCheminSqlVidageBaseEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "chemin.scriptvidagebase".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminSqlVidageBaseEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminSqlVidageBaseEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return cheminSqlVidageBase : String : cheminSqlVidageBase.<br/>
	 */
	public static String getCheminSqlVidageBase() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationPersistenceManager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;
			
			if (cheminSqlVidageBase == null) {
								
				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {
					
					try {
						
						/* Essaie de récupérer la valeur 
						 * dans le properties. */
						final String valeurCheminSqlVidageBase 
						= ConfigurationApplicationManager
							.getBundleApplication()
								.getString(
									fournirCleCheminSqlVidageBase());
						
						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeurCheminSqlVidageBase)) {
							
							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
									METHODE_GET_CHEMINSQLVIDAGEBASE
									, fournirCleCheminSqlVidageBase()
									, ConfigurationApplicationManager
										.getBundleApplication());
							
							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}
							
							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);
							
							/* utilise la valeur en dur fournie 
							 * par fournirCheminSqlVidageBaseEnDur(). */
							cheminSqlVidageBase 
								= fournirCheminSqlVidageBaseEnDur();
							
						} // Fin de Si la valeur est blank._________
						
						/* Valeur remplie dans le properties. */
						else {
							
							/* Nettoie la valeur lue dans le 
							 * .properties avec trim(). */
							final String valeurCheminSqlVidageBaseNettoyee 
								= StringUtils
									.trim(valeurCheminSqlVidageBase);
							
							cheminSqlVidageBase 
								= valeurCheminSqlVidageBaseNettoyee; 
							
						} // Fin de Valeur remplie dans le properties.____
												
					} catch (MissingResourceException mre) {
						
						/* Création du message. */
						messageIndividuelRapport 
						= creerMessageManqueCle(
								METHODE_GET_CHEMINSQLVIDAGEBASE
								, fournirCleCheminSqlVidageBase()
								, ConfigurationApplicationManager
									.getBundleApplication());
						
						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}
						
						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);
						
						/* utilise la valeur en dur fournie 
						 * par fournirCheminSqlVidageBaseEnDur(). */
						cheminSqlVidageBase 
							= fournirCheminSqlVidageBaseEnDur();
						
					} // Fin de catch (MissingResourceException mre)._____
					
				} // Fin de if (getBundleApplication() != null)._____

				
				/* if (getBundleApplication() == null). */
				else {
					
					/* utilise la valeur en dur fournie 
					 * par fournirCheminSqlVidageBaseEnDur(). */
					cheminSqlVidageBase 
						= fournirCheminSqlVidageBaseEnDur();
					
				} // Fin de if (getBundleApplication() == null).___
				
				
			} // Fin de if (cheminSqlVidageBase == null)._________
			
			return cheminSqlVidageBase;
									
		} // Fin de synchronized.________________________________________
		
	} // Fin de getCheminSqlVidageBase().__________________________________

	
	
	/**
	 * method fournirCleCheminSqlVidageBase() :<br/>
	 * clé du chemin du script de vidage de la base dans 
	 * application_fr_FR.properties.<br/>
	 * "chemin.scriptvidagebase".<br/>
	 * <br/>
	 *
	 * @return : String : "chemin.scriptvidagebase".<br/>
	 */
	private static String fournirCleCheminSqlVidageBase() {
		return "chemin.scriptvidagebase";
	} // Fin de fournirCleCheminSqlVidageBase().___________________________


	
	/**
	 * method fournirCheminSqlVidageBaseEnDur() :<br/>
	 * Fournit une valeur stockée en dur 
	 * dans la classe pour cheminSqlVidageBaseEnDur.<br/>
	 * <br/>
	 * ".\\database\\Script_Effacements_Base.sql".<br/>
	 * <br/>
	 *
	 * @return : String : ".\\database\\Script_Effacements_Base.sql".<br/>
	 */
	private static String fournirCheminSqlVidageBaseEnDur() {
		return ".\\database\\Script_Effacements_Base.sql";
	} // Fin de fournirCheminSqlVidageBaseEnDur()._________________________
	
	
	
	/**
	 * method getRapportConfigurationCsv() :<br/>
	 * Getter du Rapport du chargement de la configuration au format csv.<br/>
	 * <br/>
	 * - Le rapport est null si il n'y a eu aucun 
	 * problème d'initialisation de l'application.<br/>
	 * <br/>
	 *
	 * @return rapportConfigurationCsv : String.<br/>
	 */
	public static String getRapportConfigurationCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationPersistenceManager.class) {
			
			return rapportConfigurationCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getRapportConfigurationCsv().______________________________


	
	/**
	 * method getMessageIndividuelRapport() :<br/>
	 * Getter du Message pour le 
	 * Rapport du chargement de la configuration au format csv 
	 * généré par chaque méthode individuellement.<br/>
	 * <br/>
	 *
	 * @return messageIndividuelRapport : String.<br/>
	 */
	public static String getMessageIndividuelRapport() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationPersistenceManager.class) {
			return messageIndividuelRapport;
		} // Fin de synchronized.________________________________________
		
	} // Fin de getMessageIndividuelRapport()._____________________________


	
	/**
	 * method creerMessageManqueCle(
	 * String pMethode
	 * , String pCle
	 * , ResourceBundle pBundle) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si une clé est absente dans un ResourceBundle.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getStatsActivees() 
	 * - La clé 'abstractdao.statsactivees' 
	 * n'existe pas dans messagestechniquesfr_FR.properties".<br/>
	 * <br/>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pCle : String : Clé dans le ResourceBundle.<br/>
	 * @param pBundle : ResourceBundle.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessageManqueCle(
			final String pMethode
			 	, final String pCle
			 		, final ResourceBundle pBundle) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationPersistenceManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONPERSISTENCEMANAGER);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("La clé '");
			stb.append(pCle);
			stb.append("' n'existe pas dans ");
			stb.append(pBundle.getBaseBundleName());
			stb.append("fr_FR.properties");
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessageManqueCle(
	 // String pMethode
	 // , String pCle
	 // , ResourceBundle pBundle)._________________________________________
	

	
	/**
	 * method creerMessageManqueValeur(
	 * String pMethode
	 * , String pCle
	 * , ResourceBundle pBundle) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si une valeur en face d'une clé est absente 
	 * dans un ResourceBundle.<br/>
	 * <br/>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pCle : String : Clé dans le ResourceBundle.<br/>
	 * @param pBundle : ResourceBundle.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessageManqueValeur(
			final String pMethode
			 	, final String pCle
			 		, final ResourceBundle pBundle) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationPersistenceManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONPERSISTENCEMANAGER);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("La valeur associée à la clé '");
			stb.append(pCle);
			stb.append("' n'existe pas (null ou vide) dans ");
			stb.append(pBundle.getBaseBundleName());
			stb.append("fr_FR.properties");
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessageManqueValeur(
	 // String pMethode
	 // , String pCle
	 // , ResourceBundle pBundle)._________________________________________


	
	/**
	 * method ajouterMessageAuRapportConfigurationCsv(
	 * String pMessage) :<br/>
	 * Rajoute le message pMessage au rapport 
	 * de chargement de la configuration au format csv (à la ligne).<br/>
	 * <br/>
	 * - Ne fait rien si pMessage est blank.<br/>
	 * - Ne Rajoute PAS l'en-tête (avec BOM_UTF-8) 
	 * pour le rapport de chargement de la configuration si nécessaire.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à rajouter 
	 * au rapport de chargement de la configuration.<br/>
	 */
	private static void ajouterMessageAuRapportConfigurationCsv(
			final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationPersistenceManager.class) {
			
			/* Ne fait rien si pMessage est blank. */
			if (StringUtils.isBlank(pMessage)) {
				return;
			}
			
			final StringBuilder stb = new StringBuilder();
						
			/* Rajoute le message au rapport de 
			 * chargement de la configuration au format csv (à la ligne). */
			if (!StringUtils.isBlank(rapportConfigurationCsv)) {
				stb.append(rapportConfigurationCsv);
				stb.append(NEWLINE);
			}
			
			stb.append(pMessage);
			stb.append(SEP_PV);
			
			rapportConfigurationCsv = stb.toString();
			
		} // Fin de synchronized.________________________________________
			
	} // Fin de ajouterMessageAuRapportConfigurationCsv(
	 // String pMessage).__________________________________________________
	

	
} // FIN DE LA CLASSE ConfigurationPersistenceManager.-----------------------
