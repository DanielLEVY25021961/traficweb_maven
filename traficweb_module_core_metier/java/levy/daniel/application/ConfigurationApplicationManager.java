package levy.daniel.application;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import levy.daniel.application.configurationmanagers.ConfigurationBundlesManager;
import levy.daniel.application.configurationmanagers.ConfigurationDescriptionsFichiersManager;
import levy.daniel.application.configurationmanagers.ConfigurationNomenclaturesDarwinManager;
import levy.daniel.application.configurationmanagers.ConfigurationNomenclaturesHistoF07Manager;
import levy.daniel.application.configurationmanagers.ConfigurationNomenclaturesHitManager;
import levy.daniel.application.configurationmanagers.ConfigurationPersistenceManager;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class ConfigurationApplicationManager :<br/>
 * Classe UTILITAIRE (méthodes statiques)
 * Chargée de gérer la configuration de l'application.<br/>
 * Met à disposition de l'ensemble de l'application 
 * des Singletons pour 
 * les fichiers .properties et tout ce dont l'application 
 * a besoin pour fonctionner.<br/>
 * - Délègue à des ConfigurationCCCManagers.
 * <br/>
 * <ul>
 * <li>Les méthodes getBundleZZZ fournissent 
 * un singleton de BundleZZZ.</li>
 * <li>La méthode getCheminDescriptions fournit un Singleton 
 * du chemin vers les descriptions des fichiers 
 * (HIT, HISTO_F07, Darwin.csv, ...).</li>
 * <li>Les méthodes getNomDescriptionXXX fournissent un singleton  
 * du nom du fichier de description du fichierXXX 
 * (HIT, HISTO_F07, Darwin.csv, ...).</li>
 * <li>Les méthodes getFichierDescriptionXXX fournissent un singleton  
 * du fichier de description du fichierXXX 
 * (HIT, HISTO_F07, Darwin.csv, ...).</li>
 * <li>Les méthodes getNomNomenclatureXXXChampYYY fournissent un singleton  
 * du nom du fichier de la nomenclature du champ YYY 
 * dans le fichierXXX 
 * (HIT, HISTO_F07, Darwin.csv, ...).</li>
 * </ul>
 *
 * - Exemple d'utilisation :<br/>
 * <code> // Récupération du bundleApplication qui encapsule 
 * application_fr_FR.properties</code><br/>
 * <code>final ResourceBundle bundleApplication 
 * = ConfigurationApplicationManager.getBundleApplication();<br/>
 * // RAPPORT AU FORMAT CSV si problème (le rapport est alors non null).<br/>
 * ConfigurationApplicationManager.getRapportConfigurationCsv().</code><br/> 
 *<br/>
 * 
 * - Mots-clé :<br/>
 * pattern délégation, DELEGATION, <br/>
 * pattern Singleton, singleton, Singleton,<br/>
 * Rapport du chargement de la configuration au format csv,<br/>
 * classpath,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 15 avr. 2016
 *
 */
public final class ConfigurationApplicationManager {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_CONFIGURATION_APPLICATION_MANAGER : String :<br/>
	 * "Classe ConfigurationApplicationManager".<br/>
	 */
	public static final String CLASSE_CONFIGURATION_APPLICATION_MANAGER 
		= "Classe ConfigurationApplicationManager";


	/**
	 * METHODE_GET_CHEMINNOMENCLATURES_HISTOF07 : String :<br/>
	 * "Méthode getCheminNomenclaturesHistoF07Utf8".<br/>
	 */
	public static final String METHODE_GET_CHEMINNOMENCLATURES_HISTOF07 
		= "Méthode getCheminNomenclaturesHistoF07Utf8";

	
	/**
	 * METHODE_GET_CHEMINNOMENCLATURES_DARWIN : String :<br/>
	 * "Méthode getCheminNomenclaturesDarwinUtf8".<br/>
	 */
	public static final String METHODE_GET_CHEMINNOMENCLATURES_DARWIN 
		= "Méthode getCheminNomenclaturesDarwinUtf8";
	
	
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
	

	/**
	 * rapportConfigurationCsv : String :<br/>
	 * Rapport du chargement de la configuration au format csv.<br/>
	 * Le rapport est null si il n'y a eu aucun 
	 * problème d'initialisation de l'application.<br/>
	 */
	private static transient String rapportConfigurationCsv;
	
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ConfigurationApplicationManager.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationApplicationManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour interdire l'instanciation.<br/>
	 * <br/>
	 */
	private ConfigurationApplicationManager() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method getBundleApplication() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleApplication 
	 * (application_fr_FR.properties).</li>
	 * <li>bundleApplication encapsule 
	 * .\src\application_fr_FR.properties.</li>
	 * <li>bundleApplication contient les paramétrages généraux 
	 * de l'application (chemins vers les ressources
	 * , titre de l'application, ...).</li>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * <br/>
	 * Exemple de message d'erreur :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleApplication() 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires.".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleApplication.<br/>
	 */
	public static ResourceBundle getBundleApplication() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Bundle. */
			/* DELEGATION auprès du ConfigurationBundlesManager. */
			final ResourceBundle bundleApplication 
				= ConfigurationBundlesManager.getBundleApplication();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return bundleApplication;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleApplication().____________________________________
	

	
	/**
	 * method getBundleRessources() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleRessources 
	 * (configuration_ressources_parametrables.properties).</li>
	 * <li>bundleRessources encapsule 
	 * racine_binaires/
	 * configuration_ressources_parametrables.properties</li>
	 * <li>bundleRessources contient les paramétrages généraux 
	 * des Ressources PARAMETRABLES PAR LA MOA 
	 * (chemins vers les ressources externes au classpath).</li>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * <br/>
	 * Exemple de message d'erreur :<br/>
	 * "Classe ConfigurationRessourcesManager 
	 * - Méthode getBundleRessources() 
	 * - Le fichier 'configuration_ressources_parametrables.properties' 
	 * est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires.".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleRessources.<br/>
	 */
	public static ResourceBundle getBundleRessources() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Bundle. */
			/* DELEGATION auprès du ConfigurationBundlesManager. */
			final ResourceBundle bundleRessources 
				= ConfigurationBundlesManager.getBundleRessources();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return bundleRessources;
			
		} // Fin de synchronized.________________________________________
				
	}
	
	
	
	/**
	 * method getBundleMessagesControles() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleMessagesControles 
	 * (messagescontroles_fr_FR.properties).</li>
	 * <li>bundleMessagesControles encapsule 
	 * .\src\messagescontroles_fr_FR.properties.</li>
	 * <li>bundleMessagesControles contient les paramétrages des contrôles 
	 * de l'application.</li>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * <br/>
	 * Exemple de message d'erreur :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleMessagesControles() 
	 * - Le fichier 'messagescontroles_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires \bin".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleMessagesControles.<br/>
	 */
	public static ResourceBundle getBundleMessagesControles() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
								
			/* Récupération du Bundle. */
			final ResourceBundle bundleMessagesControles 
				= ConfigurationBundlesManager.getBundleMessagesControles();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return bundleMessagesControles;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleMessagesControles().______________________________
	

	
	/**
	 * method getBundleMessagesTechniques() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleMessagesTechniques 
	 * (messagestechniques_fr_FR.properties).</li>
	 * <li>bundleMessagesTechniques encapsule 
	 * .\src\messagestechniques_fr_FR.properties.</li>
	 * <li>bundleMessagesTechniques contient les paramétrages 
	 * des messages techniques 
	 * de l'application.</li>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * <br/>
	 * Exemple de message d'erreur :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleMessagesTechniques() 
	 * - Le fichier 'messagestechniques_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires \bin".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleMessagesTechniques.<br/>
	 */
	public static ResourceBundle getBundleMessagesTechniques() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
						
			/* Récupération du Bundle. */
			final ResourceBundle bundleMessagesTechniques 
			= ConfigurationBundlesManager.getBundleMessagesTechniques();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return bundleMessagesTechniques;

		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleMessagesTechniques()._____________________________
	

	
	/**
	 * method getBundleMessagesDiff() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleMessagesDiff.</li><br/>
	 * <li>bundleMessagesDiff encapsule 
	 * .\src\messagesdiff_fr_FR.properties.</li><br/>
	 * <li>bundleMessagesDiff contient les paramétrages 
	 * des messages des différences entre objets métier 
	 * de l'application.</li><br/>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleMessagesDiff() 
	 * - Le fichier 'messagesdiff_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires \bin".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleMessagesDiff.<br/>
	 */
	public static ResourceBundle getBundleMessagesDiff() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
						
			/* Récupération du Bundle. */
			final ResourceBundle bundleMessagesDiff
			= ConfigurationBundlesManager.getBundleMessagesDiff();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return bundleMessagesDiff;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleMessagesDiff().___________________________________
	

		
	/**
	 * method getClassPath() :<br/>
	 * Retourne le classpath de l'application.<br/>
	 * Le classpath est l'ensemble des chemins utilisé par le compilateur 
	 * et le machine virtuelle java pour retrouver les classes 
	 * (répertoires de classes et jar)
	 * dont a besoin une application pour fonctionner.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * C:\Users\dan\git\traficweb_maven\traficweb_module_core_metier\
	 * target\test-classes;C:\Users\dan\git\traficweb_maven
	 * \traficweb_module_core_metier\target\classes;
	 * C:\Users\dan\.m2\repository\commons-lang\commons-lang
	 * \2.6\commons-lang-2.6.jar;.....
	 * <br/>
	 *
	 * @return : String : classpath de l'application.<br/>
	 */
	public static String getClassPath() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			final String classPath 
				= System.getProperty("java.class.path");
			
			return classPath;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getClassPath().____________________________________________
	
	
	
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
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Boolean. */
			final Boolean statsActivees 
				= ConfigurationPersistenceManager.getStatsActivees();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationPersistenceManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return statsActivees;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getStatsActivees().________________________________________
	
	
	
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
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Chemin. */
			final String cheminSqlVidageBase 
				= ConfigurationPersistenceManager.getCheminSqlVidageBase();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationPersistenceManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return cheminSqlVidageBase;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getCheminSqlVidageBase().__________________________________
	

	
	/**
	 * method getCheminDescriptions() :<br/>
	 * Getter du Chemin des descriptions de fichier 
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\descriptions\\".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirCheminDescriptionsEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.descriptions".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminDescriptionsEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminDescriptionsEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return cheminDescriptions : String.<br/>
	 */
	public static String getCheminDescriptions() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Chemin. */
			final String cheminDescriptions 
				= ConfigurationDescriptionsFichiersManager
					.getCheminDescriptions();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationDescriptionsFichiersManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return cheminDescriptions;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getCheminDescriptions().___________________________________
	

	
	/**
	 * method getNomDescriptionHit() :<br/>
	 * Getter du Nom du fichier de description du HIT
	 * stocké dans application.properties.<br/>
	 * "2014-07-19_Description_HIT_Utf8.csv".<br/>
	 * <br/>
	 *  <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomDescriptionHitEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.descriptions.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionHitEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionHitEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomDescriptionHit : String.<br/>
	 */
	public static String getNomDescriptionHit() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Nom. */
			final String nomDescriptionHit 
				= ConfigurationDescriptionsFichiersManager
					.getNomDescriptionHit();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationDescriptionsFichiersManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomDescriptionHit;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomDescriptionHit().____________________________________

	
	
	/**
	 * method getFichierDescriptionHit() :<br/>
	 * Fournit le Fichier sur disque au format csv 
	 * contenant la description du HIT en UTF-8.<br/>
	 * <br/>
	 * .\\ressources\\Descriptions de fichier\\Hit\\Descriptions en UTF-8
	 * \\2014-07-19_Description_HIT_Utf8.csv.<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de description est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierDescriptionHIT.<br/> 
	 */
	public static File getFichierDescriptionHit() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Fichier. */
			File fichierDescriptionHIT = null;
			
			try {
				
				fichierDescriptionHIT = ConfigurationDescriptionsFichiersManager
					.getFichierDescriptionHit();
				
			} catch (Exception e) {
				
				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationDescriptionsFichiersManager
						.getMessageIndividuelRapport();
				
				/* Ajout du message de rapport éventuel 
				 * au rapportConfigurationCsv. */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}
				
				return null;
				
			}
					
			return fichierDescriptionHIT;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getFichierDescriptionHit().________________________________

	
	
	/**
	 * method getNomDescriptionHistoF07() :<br/>
	 * Getter du Nom du fichier de description du HistoF07 
	 * stocké dans application.properties.<br/>
	 * "2014-07-19_Description_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomDescriptionHistoF07EnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.descriptions.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionHistoF07EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionHistoF07EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomDescriptionHistoF07 : String.<br/>
	 */
	public static String getNomDescriptionHistoF07() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Nom. */
			final String nomDescriptionHistoF07 
				= ConfigurationDescriptionsFichiersManager
					.getNomDescriptionHistoF07();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationDescriptionsFichiersManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomDescriptionHistoF07;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomDescriptionHistoF07()._______________________________

	

	/**
	 * method getFichierDescriptionHistoF07() :<br/>
	 * Fournit le Fichier sur disque au format csv 
	 * contenant la description du HISTO_F07 en UTF-8.<br/>
	 * <br/>
	 * .\\ressources\\Descriptions de fichier\\HistonatF07\\
	 * Descriptions en UTF-8\\2014-07-19_Description_HistoF07_Utf8.csv.<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de description est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierDescriptionHistoF07.<br/>
	 */
	public static File getFichierDescriptionHistoF07() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Fichier. */
			File fichierDescriptionHistoF07 = null;
			
			try {
				
				fichierDescriptionHistoF07 
					= ConfigurationDescriptionsFichiersManager
						.getFichierDescriptionHistoF07();
				
			} catch (Exception e) {
				
				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationDescriptionsFichiersManager
						.getMessageIndividuelRapport();
				
				/* Ajout du message de rapport éventuel 
				 * au rapportConfigurationCsv. */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}
				
				return null;
			}
						
			return fichierDescriptionHistoF07;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getFichierDescriptionHistoF07().___________________________
	
	

	/**
	 * method getNomDescriptionDarwinCsv() :<br/>
	 * Getter du Nom du fichier de description du Darwin.csv
	 * stocké dans application.properties.<br/>
	 * "Description_DarwinCsv.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomDescriptionDarwinCsvEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.descriptions.darwincsv".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionDarwinCsvEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionDarwinCsvEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomDescriptionDarwinCsv : String.<br/>
	 */
	public static String getNomDescriptionDarwinCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Nom. */
			final String nomDescriptionDarwinCsv 
				= ConfigurationDescriptionsFichiersManager
					.getNomDescriptionDarwinCsv();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationDescriptionsFichiersManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomDescriptionDarwinCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomDescriptionDarwinCsv().______________________________
	
	
	
	/**
	 * method getFichierDescriptionDarwinCsv() :<br/>
	 * Fournit le Fichier sur disque au format csv 
	 * contenant la description du DARWIN_CSV en UTF-8.<br/>
	 * <br/>
	 * .\\ressources\\Descriptions de fichier\\Darwin csv
	 * \\Descriptions en UTF-8\\2014-07-19_Description_DarwinCsv_Utf8.csv.<br/>
	 * <br/>
	 *- LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de description est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierDescriptionDarwinCsv.<br/>
	 */
	public static File getFichierDescriptionDarwinCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Fichier. */
			File fichierDescriptionDarwinCsv = null;
			
			try {
				
				fichierDescriptionDarwinCsv 
					= ConfigurationDescriptionsFichiersManager
						.getFichierDescriptionDarwinCsv();
				
			} catch (Exception e) {
				
				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationDescriptionsFichiersManager
						.getMessageIndividuelRapport();
				
				/* Ajout du message de rapport éventuel 
				 * au rapportConfigurationCsv. */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}
				
				return null;
			}
						
			return fichierDescriptionDarwinCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getFichierDescriptionDarwinCsv().__________________________
	
	
	
	/**
	 * method getNomDescriptionMapping() :<br/>
	 * Getter du Nom du fichier de description 
	 * du Mapping Histo-Hit-Darwin-Isidor 
	 * stocké dans application.properties.<br/>
	 * "Description_MAPPING_HistoF07_Hit_Darwin_Isidor.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomDescriptionMappingEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.descriptions.mapping".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionMappingEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomDescriptionMappingEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomDescriptionMapping : String.<br/>
	 */
	public static String getNomDescriptionMapping() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Nom. */
			final String nomDescriptionMapping 
				= ConfigurationDescriptionsFichiersManager
					.getNomDescriptionMapping();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationDescriptionsFichiersManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomDescriptionMapping;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomDescriptionMapping().________________________________
	

	
	/**
	 * method getFichierDescriptionMapping() :<br/>
	 * Fournit le Fichier sur disque au format csv 
	 * encodé en UTF-8
	 * contenant la description du MAPPING.<br/>
	 * <br/>
	 * .\\ressources\\Descriptions de fichier\\Mapping\\
	 * Descriptions en UTF-8\\2014-07-19_Description_Mapping_Utf8.csv.<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de description est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierDescriptionMapping.<br/>
	 */
	public static File getFichierDescriptionMapping() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Fichier. */
			File fichierDescriptionMapping = null;
			
			try {
				
				fichierDescriptionMapping 
					= ConfigurationDescriptionsFichiersManager
						.getFichierDescriptionMapping();
				
			} catch (Exception e) {
				
				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationDescriptionsFichiersManager
						.getMessageIndividuelRapport();
				
				/* Ajout du message de rapport éventuel 
				 * au rapportConfigurationCsv. */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}
				
				return null;
				
			}
						
			return fichierDescriptionMapping;
			
		} // Fin de synchronized.________________________________________
	
	} // Fin de getFichierDescriptionMapping().____________________________

	
	
	/**
	 * method getCheminNomenclaturesHitUtf8() :<br/>
	 * Getter du Chemin des nomenclatures en UTF-8 des champs pour les HIT
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8\\".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirCheminNomenclaturesHitUtf8EnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.chemin.hit.utf8".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesHitUtf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesHitUtf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return cheminNomenclaturesHitUtf8 : String.<br/>
	 */
	public static String getCheminNomenclaturesHitUtf8() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du chemin. */
			final String cheminNomenclaturesHitUtf8 
				= ConfigurationNomenclaturesHitManager
					.getCheminNomenclaturesHitUtf8();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return cheminNomenclaturesHitUtf8;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getCheminNomenclaturesHitUtf8().___________________________
	
	

	/**
	 * method getNomNomenclatureHitSens() :<br/>
	 * Getter du Nom du fichier de nomenclature du sens pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitSensEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.sens.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitSensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitSensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitSens : String.<br/>
	 */
	public static String getNomNomenclatureHitSens() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHitSens 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitSens();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitSens;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHitSens()._______________________________


	
	/**
	 * method getFichierNomenclatureHitSensUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le SENS
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8\\
	 * 2014-07-15_Nomenclature_Sens_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitSensUtf8.<br/>
	 */
	public static File getFichierNomenclatureHitSensUtf8() {
				
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Fichier. */
			File fichierNomenclatureHitSensUtf8 = null;
			
			try {
				
				fichierNomenclatureHitSensUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitSensUtf8();
				
			} catch (Exception e) {
				
				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();
				
				/* Ajout du message de rapport éventuel 
				 * au rapportConfigurationCsv. */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}
				
				return null;
				
			}
						
			return fichierNomenclatureHitSensUtf8;
			
		} // Fin de synchronized.________________________________________
	
	} // Fin de getFichierNomenclatureHitSensUtf8()._______________________
	
	
	
	/**
	 * method getNomNomenclatureHitNature() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la NATURE du comptage 
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Nature_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitNatureEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.nature.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitNatureEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitNatureEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitNature : String.<br/>
	 */
	public static String getNomNomenclatureHitNature() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHitNature 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitNature();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitNature;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHitNature()._____________________________
	

	
	/**
	 * method getFichierNomenclatureHitNatureUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la NATURE du comptage 
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Nature_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitNatureUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitNatureUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitNatureUtf8 = null;

			try {

				fichierNomenclatureHitNatureUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitNatureUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitNatureUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitNatureUtf8()._____________________
	
	
	
	/**
	 * method getNomNomenclatureHitCatAdminRoute() :<br/>
	 * Getter Nom du fichier de nomenclature 
	 * de la CATEGORIE ADMINISTRATIVE de la route 
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Categorie_Adm_Hit_Utf8.csv".<br/> 
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitCatAdminRouteEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.catadminroute.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitCatAdminRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitCatAdminRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitCatAdminRoute : String.<br/>
	 */
	public static String getNomNomenclatureHitCatAdminRoute() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHitCatAdminRoute 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitCatAdminRoute();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitCatAdminRoute;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHitCatAdminRoute().______________________
	
	
	
	/**
	 * method getFichierNomenclatureHitCatAdminRouteUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CATEGORIE ADMINISTRATIVE de la route 
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Categorie_Adm_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitCatAdminRouteUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitCatAdminRouteUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitCatAdminRouteUtf8 = null;

			try {

				fichierNomenclatureHitCatAdminRouteUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitCatAdminRouteUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitCatAdminRouteUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitCatAdminRouteUtf8().______________
	

	
	/**
	 * method getNomNomenclatureHitTypeComptage() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du TYPE DE COMPTAGE 
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Comptage_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitTypeComptageEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.typecomptage.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitTypeComptageEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitTypeComptageEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitTypeComptage : String.<br/>
	 */
	public static String getNomNomenclatureHitTypeComptage() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHitTypeComptage 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitTypeComptage();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitTypeComptage;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHitTypeComptage()._______________________


	
	/**
	 * method getFichierNomenclatureHitTypeComptageUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE COMPTAGE 
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Comptage_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitTypeComptageUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitTypeComptageUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitTypeComptageUtf8 = null;

			try {

				fichierNomenclatureHitTypeComptageUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitTypeComptageUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitTypeComptageUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitTypeComptageUtf8()._______________
	

	
	/**
	 * method getNomNomenclatureHitClassementRoute() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du CLASSEMENT DE LA ROUTE 
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classement_Route_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitClassementRouteEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classementroute.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitClassementRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitClassementRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitClassementRoute : String.<br/>
	 */
	public static String getNomNomenclatureHitClassementRoute() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHitClassementRoute 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitClassementRoute();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitClassementRoute;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHitClassementRoute().____________________
	

	
	/**
	 * method getFichierNomenclatureHitClassementRouteUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le CLASSEMENT DE LA ROUTE 
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classement_Route_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitClassementRouteUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitClassementRouteUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitClassementRouteUtf8 = null;

			try {

				fichierNomenclatureHitClassementRouteUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitClassementRouteUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitClassementRouteUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitClassementRouteUtf8().____________
	

	
	/**
	 * method getNomNomenclatureHitClasseLargeurChausseeU() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitClasseLargeurChausseeUEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classelargeurchausseeu.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitClasseLargeurChausseeUEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitClasseLargeurChausseeUEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitClasseLargeurChausseeU : String.<br/>
	 */
	public static String getNomNomenclatureHitClasseLargeurChausseeU() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHitClasseLargeurChausseeU 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitClasseLargeurChausseeU();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitClasseLargeurChausseeU;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHitClasseLargeurChausseeU()._____________

	
	
	/**
	 * method getFichierNomenclatureHitClasseLargeurChausseeUUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE 
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitClasseLargeurChausseeUUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitClasseLargeurChausseeUUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitClasseLargeurChausseeUUtf8 = null;

			try {

				fichierNomenclatureHitClasseLargeurChausseeUUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitClasseLargeurChausseeUUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitClasseLargeurChausseeUUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitClasseLargeurChausseeUUtf8()._____
	

	
	/**
	 * method getNomNomenclatureHitClasseLargeurChausseesS() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chaussees_Separees_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitClasseLargeurChausseesSEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classelargeurchausseess.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitClasseLargeurChausseesSEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitClasseLargeurChausseesSEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitClasseLargeurChausseesS : String.<br/>
	 */
	public static String getNomNomenclatureHitClasseLargeurChausseesS() {
			
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHitClasseLargeurChausseesS 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitClasseLargeurChausseesS();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitClasseLargeurChausseesS;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHitClasseLargeurChausseesS().____________


	
	/**
	 * method getFichierNomenclatureHitClasseLargeurChausseesSUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES 
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausses_Séparées_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitClasseLargeurChausseesSUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitClasseLargeurChausseesSUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitClasseLargeurChausseesSUtf8 = null;

			try {

				fichierNomenclatureHitClasseLargeurChausseesSUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitClasseLargeurChausseesSUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitClasseLargeurChausseesSUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitClasseLargeurChausseesSUtf8().____
	


	/**
	 * method getNomNomenclatureHitTypeReseau() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du TYPE DE RESEAU
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Reseau_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitTypeReseauEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.typereseau.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitTypeReseauEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitTypeReseauEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitTypeReseau : String.<br/>
	 */
	public static String getNomNomenclatureHitTypeReseau() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
		
			/* Récupération du nom. */
			final String nomNomenclatureHitTypeReseau 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitTypeReseau();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitTypeReseau;
		
		} // Fin de synchronized.________________________________________
	
	} // Fin de getNomNomenclatureHitTypeReseau().__________________________
	

	
	/**
	 * method getFichierNomenclatureHitTypeReseauUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE RESEAU 
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Reseau_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitTypeReseauUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitTypeReseauUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitTypeReseauUtf8 = null;

			try {

				fichierNomenclatureHitTypeReseauUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitTypeReseauUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitTypeReseauUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitTypeReseauUtf8()._________________
	


	/**
	 * method getNomNomenclatureHitPrPk() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du TYPE PR/PK
	 * pour les HIT en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_PR_PK_Hit_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHitPrPkEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.prpk.hit".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitPrPkEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHitPrPkEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHitPrPk : String.<br/>
	 */
	public static String getNomNomenclatureHitPrPk() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
		
			/* Récupération du nom. */
			final String nomNomenclatureHitPrPk 
				= ConfigurationNomenclaturesHitManager
					.getNomNomenclatureHitPrPk();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHitManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHitPrPk;
		
		} // Fin de synchronized.________________________________________
	
	} // Fin de getNomNomenclatureHitPrPk()._______________________________


	
	/**
	 * method getFichierNomenclatureHitPrPkUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE PR/PK
	 * dans un HIT.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Hit\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_PR_PK_Hit_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHitPrPkUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHitPrPkUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHitPrPkUtf8 = null;

			try {

				fichierNomenclatureHitPrPkUtf8 
					= ConfigurationNomenclaturesHitManager
						.getFichierNomenclatureHitPrPkUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHitManager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHitPrPkUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHitPrPkUtf8()._______________________
	

	
	/**
	 * method getCheminNomenclaturesHistoF07Utf8() :<br/>
	 * Getter du Chemin des nomenclatures en UTF-8 des champs
	 *  pour les HISTO_F07
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirCheminNomenclaturesHistoF07Utf8EnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.chemin.histof07.utf8".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesHistoF07Utf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesHistoF07Utf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return cheminNomenclaturesHistoF07Utf8 : String.<br/>
	 */
	public static String getCheminNomenclaturesHistoF07Utf8() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du chemin. */
			final String cheminNomenclaturesHistoF07Utf8 
				= ConfigurationNomenclaturesHistoF07Manager
					.getCheminNomenclaturesHistoF07Utf8();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return cheminNomenclaturesHistoF07Utf8;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getCheminNomenclaturesHistoF07Utf8().___________________________
	
	

	/**
	 * method getNomNomenclatureHistoF07Sens() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du sens pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07SensEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.sens.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07SensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07SensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07Sens : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07Sens() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHistoF07Sens 
				= ConfigurationNomenclaturesHistoF07Manager
					.getNomNomenclatureHistoF07Sens();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHistoF07Sens;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHistoF07Sens()._______________________________


	
	/**
	 * method getFichierNomenclatureHistoF07SensUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le SENS
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\histoF07\\Nomenclatures en UTF-8\\
	 * 2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07SensUtf8.<br/>
	 */
	public static File getFichierNomenclatureHistoF07SensUtf8() {
				
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Fichier. */
			File fichierNomenclatureHistoF07SensUtf8 = null;
			
			try {
				
				fichierNomenclatureHistoF07SensUtf8 
					= ConfigurationNomenclaturesHistoF07Manager
						.getFichierNomenclatureHistoF07SensUtf8();
				
			} catch (Exception e) {
				
				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHistoF07Manager
						.getMessageIndividuelRapport();
				
				/* Ajout du message de rapport éventuel 
				 * au rapportConfigurationCsv. */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}
				
				return null;
				
			}
						
			return fichierNomenclatureHistoF07SensUtf8;
			
		} // Fin de synchronized.________________________________________
	
	} // Fin de getFichierNomenclaturehistoF07SensUtf8()._______________________
	

	
	/**
	 * method getNomNomenclatureHistoF07Nature() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la NATURE du comptage 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07NatureEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.nature.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07NatureEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07NatureEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07Nature : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07Nature() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHistoF07Nature 
				= ConfigurationNomenclaturesHistoF07Manager
					.getNomNomenclatureHistoF07Nature();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHistoF07Nature;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHistoF07Nature()._____________________________
	

	
	/**
	 * method getFichierNomenclatureHistoF07NatureUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la NATURE du comptage 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07NatureUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHistoF07NatureUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHistoF07NatureUtf8 = null;

			try {

				fichierNomenclatureHistoF07NatureUtf8 
					= ConfigurationNomenclaturesHistoF07Manager
						.getFichierNomenclatureHistoF07NatureUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHistoF07Manager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHistoF07NatureUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHistoF07NatureUtf8()._____________________
	

	
	/**
	 * method getNomNomenclatureHistoF07TypeComptage() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du TYPE DE COMPTAGE 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07TypeComptageEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.typecomptage.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeComptageEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeComptageEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07TypeComptage : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07TypeComptage() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHistoF07TypeComptage 
				= ConfigurationNomenclaturesHistoF07Manager
					.getNomNomenclatureHistoF07TypeComptage();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHistoF07TypeComptage;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHistoF07TypeComptage()._______________________


	
	/**
	 * method getFichierNomenclatureHistoF07TypeComptageUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE COMPTAGE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07TypeComptageUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHistoF07TypeComptageUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHistoF07TypeComptageUtf8 = null;

			try {

				fichierNomenclatureHistoF07TypeComptageUtf8 
					= ConfigurationNomenclaturesHistoF07Manager
						.getFichierNomenclatureHistoF07TypeComptageUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHistoF07Manager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHistoF07TypeComptageUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHistoF07TypeComptageUtf8()._______________
	

	
	/**
	 * method getNomNomenclatureHistoF07ClassementRoute() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du CLASSEMENT DE LA ROUTE 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07ClassementRouteEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classementroute.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClassementRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClassementRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07ClassementRoute : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07ClassementRoute() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHistoF07ClassementRoute 
				= ConfigurationNomenclaturesHistoF07Manager
					.getNomNomenclatureHistoF07ClassementRoute();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHistoF07ClassementRoute;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHistoF07ClassementRoute().____________________
	

	
	/**
	 * method getFichierNomenclatureHistoF07ClassementRouteUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le CLASSEMENT DE LA ROUTE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07ClassementRouteUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHistoF07ClassementRouteUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHistoF07ClassementRouteUtf8 = null;

			try {

				fichierNomenclatureHistoF07ClassementRouteUtf8 
					= ConfigurationNomenclaturesHistoF07Manager
						.getFichierNomenclatureHistoF07ClassementRouteUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHistoF07Manager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHistoF07ClassementRouteUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHistoF07ClassementRouteUtf8().____________
	

	
	/**
	 * method getNomNomenclatureHistoF07ClasseLargeurChausseeU() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classelargeurchausseeu.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07ClasseLargeurChausseeU : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07ClasseLargeurChausseeU() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHistoF07ClasseLargeurChausseeU 
				= ConfigurationNomenclaturesHistoF07Manager
					.getNomNomenclatureHistoF07ClasseLargeurChausseeU();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHistoF07ClasseLargeurChausseeU;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHistoF07ClasseLargeurChausseeU()._____________

	
	
	/**
	 * method getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8 = null;

			try {

				fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8 
					= ConfigurationNomenclaturesHistoF07Manager
						.getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHistoF07Manager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8()._____
	

	
	/**
	 * method getNomNomenclatureHistoF07ClasseLargeurChausseesS() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chaussees_Separees_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classelargeurchausseess.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07ClasseLargeurChausseesS : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07ClasseLargeurChausseesS() {
			
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureHistoF07ClasseLargeurChausseesS 
				= ConfigurationNomenclaturesHistoF07Manager
					.getNomNomenclatureHistoF07ClasseLargeurChausseesS();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHistoF07ClasseLargeurChausseesS;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureHistoF07ClasseLargeurChausseesS().____________


	
	/**
	 * method getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausses_Séparées_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8 = null;

			try {

				fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8 
					= ConfigurationNomenclaturesHistoF07Manager
						.getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHistoF07Manager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8().____
	


	/**
	 * method getNomNomenclatureHistoF07TypeReseau() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du TYPE DE RESEAU
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07TypeReseauEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.typereseau.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeReseauEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeReseauEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07TypeReseau : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07TypeReseau() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
		
			/* Récupération du nom. */
			final String nomNomenclatureHistoF07TypeReseau 
				= ConfigurationNomenclaturesHistoF07Manager
					.getNomNomenclatureHistoF07TypeReseau();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesHistoF07Manager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureHistoF07TypeReseau;
		
		} // Fin de synchronized.________________________________________
	
	} // Fin de getNomNomenclatureHistoF07TypeReseau().__________________________
	

	
	/**
	 * method getFichierNomenclatureHistoF07TypeReseauUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE RESEAU 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07TypeReseauUtf8.<br/> 
	 */
	public static File getFichierNomenclatureHistoF07TypeReseauUtf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {

			/* Récupération du Fichier. */
			File fichierNomenclatureHistoF07TypeReseauUtf8 = null;

			try {

				fichierNomenclatureHistoF07TypeReseauUtf8 
					= ConfigurationNomenclaturesHistoF07Manager
						.getFichierNomenclatureHistoF07TypeReseauUtf8();

			} catch (Exception e) {

				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesHistoF07Manager
						.getMessageIndividuelRapport();

				/*
				 * Ajout du message de rapport éventuel au
				 * rapportConfigurationCsv.
				 */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}

				return null;

			}

			return fichierNomenclatureHistoF07TypeReseauUtf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getFichierNomenclatureHistoF07TypeReseauUtf8()._________________
	

	
	/**
	 * method getCheminNomenclaturesDarwinUtf8() :<br/>
	 * Getter du Chemin des nomenclatures en UTF-8 des champs pour les DARWIN
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\Darwin\\Nomenclatures en UTF-8\\".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirCheminNomenclaturesDarwinUtf8EnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.chemin.darwin.utf8".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesDarwinUtf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesDarwinUtf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return cheminNomenclaturesDarwinUtf8 : String.<br/>
	 */
	public static String getCheminNomenclaturesDarwinUtf8() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du chemin. */
			final String cheminNomenclaturesDarwinUtf8 
				= ConfigurationNomenclaturesDarwinManager
					.getCheminNomenclaturesDarwinUtf8();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesDarwinManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return cheminNomenclaturesDarwinUtf8;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getCheminNomenclaturesDarwinUtf8().___________________________
	
	

	/**
	 * method getNomNomenclatureDarwinSens() :<br/>
	 * Getter du Nom du fichier de nomenclature du sens pour les DARWIN en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_Darwin_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureDarwinSensEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.sens.darwin".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureDarwinSensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureDarwinSensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureDarwinSens : String.<br/>
	 */
	public static String getNomNomenclatureDarwinSens() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du nom. */
			final String nomNomenclatureDarwinSens 
				= ConfigurationNomenclaturesDarwinManager
					.getNomNomenclatureDarwinSens();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationNomenclaturesDarwinManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return nomNomenclatureDarwinSens;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getNomNomenclatureDarwinSens()._______________________________


	
	/**
	 * method getFichierNomenclatureDarwinSensUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le SENS
	 * dans un DARWIN.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\Darwin\\Nomenclatures en UTF-8\\
	 * 2014-07-15_Nomenclature_Sens_Darwin_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et retourne null
	 * si le fichier de nomenclature est 
	 * null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureDarwinSensUtf8.<br/>
	 */
	public static File getFichierNomenclatureDarwinSensUtf8() {
				
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Récupération du Fichier. */
			File fichierNomenclatureDarwinSensUtf8 = null;
			
			try {
				
				fichierNomenclatureDarwinSensUtf8 
					= ConfigurationNomenclaturesDarwinManager
						.getFichierNomenclatureDarwinSensUtf8();
				
			} catch (Exception e) {
				
				/* Récupération du message de rapport éventuel. */
				final String messageRapport 
					= ConfigurationNomenclaturesDarwinManager
						.getMessageIndividuelRapport();
				
				/* Ajout du message de rapport éventuel 
				 * au rapportConfigurationCsv. */
				if (!StringUtils.isBlank(messageRapport)) {
					ajouterMessageAuRapportConfigurationCsv(messageRapport);
				}
				
				return null;
				
			}
						
			return fichierNomenclatureDarwinSensUtf8;
			
		} // Fin de synchronized.________________________________________
	
	} // Fin de getFichierNomenclatureDarwinSensUtf8()._______________________
	
	

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
		synchronized (ConfigurationApplicationManager.class) {
			
			return rapportConfigurationCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getRapportConfigurationCsv().______________________________


	
	/**
	 * method ajouterMessageAuRapportConfigurationCsv(
	 * String pMessage) :<br/>
	 * Rajoute le message pMessage au rapport 
	 * de chargement de la configuration au format csv (à la ligne).<br/>
	 * <br/>
	 * - Ne fait rien si pMessage est blank.<br/>
	 * - Rajoute l'en-tête (avec BOM_UTF-8) 
	 * pour le rapport de chargement de la configuration si nécessaire.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à rajouter 
	 * au rapport de chargement de la configuration.<br/>
	 */
	private static void ajouterMessageAuRapportConfigurationCsv(
			final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Ne fait rien si pMessage est blank. */
			if (StringUtils.isBlank(pMessage)) {
				return;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			/* Rajoute l'en-tête (avec BOM_UTF-8) 
			 * pour le rapport de chargement de la configuration 
			 * si nécessaire. */
			if (StringUtils.isBlank(rapportConfigurationCsv)) {
				rapportConfigurationCsv 
					= fournirEnTeteRapportConfigurationCsv();
			}
			
			/* Rajoute le message au rapport de 
			 * chargement de la configuration au format csv (à la ligne). */			
			stb.append(rapportConfigurationCsv);
			stb.append(NEWLINE);
			stb.append(pMessage);
			stb.append(SEP_PV);
			
			rapportConfigurationCsv = stb.toString();
			
		} // Fin de synchronized.________________________________________
			
	} // Fin de ajouterMessageAuRapportConfigurationCsv(
	 // String pMessage).__________________________________________________
	

	
	/**
	 * method fournirEnTeteRapportConfigurationCsv() :<br/>
	 * Fournit l'en-tête pour le rapport de chargement de la configuration 
	 * au format csv 'rapportConfigurationCsv'.<br/>
	 * <br/>
	 * - rajoute un caractère BOM_UTF-8 au début de l'en-tête 
	 * pour forcer Excel à détecter l'encodage UTF-8.<br/>
	 * <br/>
	 *
	 * @return : String : en-tête pour le rapport de chargement 
	 * de la configuration.<br/>
	 */
	private static String fournirEnTeteRapportConfigurationCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			/* rajoute un caractère BOM_UTF-8 au début de l'en-tête 
			 * pour forcer Excel à détecter l'encodage UTF-8. */
			stb.append(BOM_UTF_8);
			stb.append("messages de chargement de la configuration");
			stb.append(SEP_PV);
						
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de fournirEnTeteRapportConfigurationCsv().____________________

	
	
} // FIN DE LA CLASSE ConfigurationApplicationManager.-----------------------
