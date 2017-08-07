package levy.daniel.application.configurationmanagers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class ConfigurationBundlesManager :<br/>
 * Classe UTILITAIRE 
 * Chargée de gérer la configuration des BUNDLES de l'application.<br/>
 * Met à disposition de l'ensemble de l'application 
 * des Singletons pour 
 * les fichiers .properties et tout ce dont l'application 
 * a besoin pour fonctionner.<br/>
 * <br/>
 * <ul>
 * <li>Les méthodes getBundleXXX fournissent 
 * un singleton de BundleXXX.</li><br/>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<code>final ResourceBundle bundleApplication 
 * = ConfigurationBundlesManager.getBundleApplication();<br/>
 * // RAPPORT AU FORMAT CSV si problème (le rapport est alors non null).<br/>
 * ConfigurationBundlesManager.getRapportConfigurationCsv().</code><br/> 
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
public final class ConfigurationBundlesManager {

	// ************************ATTRIBUTS************************************/
	/**
	 * CLASSE_CONFIGURATIONBUNDLESMANAGER : String :<br/>
	 * "Classe ConfigurationBundlesManager".<br/>
	 */
	public static final String CLASSE_CONFIGURATIONBUNDLESMANAGER 
		= "Classe ConfigurationBundlesManager";
	
	
	/**
	 * METHODE_GET_BUNDLEAPPLICATION : String :<br/>
	 * "Méthode getBundleApplication()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEAPPLICATION 
		= "Méthode getBundleApplication()";

	
	/**
	 * METHODE_GET_BUNDLEMESSAGESCONTROLES : String :<br/>
	 * "Méthode getBundleMessagesControles()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEMESSAGESCONTROLES 
		= "Méthode getBundleMessagesControles()";
	
	/**
	 * METHODE_GET_BUNDLERESSOURCES : String :<br/>
	 * "Méthode getBundleRessources()".<br/>
	 */
	public static final String METHODE_GET_BUNDLERESSOURCES
		= "Méthode getBundleRessources()";
	
	/**
	 * METHODE_GET_BUNDLEMESSAGESTECHNIQUES : String :<br/>
	 * "Méthode getBundleMessagesTechniques()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEMESSAGESTECHNIQUES 
		= "Méthode getBundleMessagesTechniques()";

	
	/**
	 * METHODE_GET_BUNDLEMESSAGESDIFF : String :<br/>
	 * "Méthode getBundleMessagesDiff()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEMESSAGESDIFF 
		= "Méthode getBundleMessagesDiff()";

	
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
	//**************************** BUNDLES ****************************/
	//*****************************************************************/
	/**
	 * bundleApplication : ResourceBundle : <br/>
	 * racine_binaires/application_fr_FR.properties.<br/>
	 * Contient les paramétrages généraux 
	 * de l'application.<br/>
	 */
	private static transient ResourceBundle bundleApplication;

	
	
	/**
	 * bundleRessources : ResourceBundle : <br/>
	 * configuration_ressources_parametrables_fr_FR.properties.<br/>
	 * Contient les chemins vers les fichiers PARAMETRABLES PAR LA MOA
	 * (donc, hors classpath) de l'application.<br/>
	 * encapsule racine_binaires/configuration_ressources_
	 * parametrables.properties.
	 */
	private static transient ResourceBundle bundleRessources;

	
	
	/**
	 * bundleMessagesControles : ResourceBundle : <br/>
	 * .\src\messagescontroles_fr_FR.properties.<br/>
	 * Contient les paramétrages des contrôles 
	 * de l'application.<br/>
	 */
	private static transient ResourceBundle bundleMessagesControles;


	
	/**
	 * bundleMessagesTechniques : ResourceBundle : <br/>
	 * .\src\messagestechniques_fr_FR.properties.<br/>
	 * Contient les paramétrages des messages techniques 
	 * de l'application.<br/>
	 */
	private static transient ResourceBundle bundleMessagesTechniques ;

	
	/**
	 * bundleMessagesDiff : ResourceBundle : <br/>
	 * .\src\messagesdiff_fr_FR.properties.<br/>
	 * Contient les paramétrages des messages 
	 * pour les différences entre objets métier 
	 * de l'application.<br/>
	 */
	private static transient ResourceBundle bundleMessagesDiff;
	

	/**
	 * rapportConfigurationCsv : String :<br/>
	 * Rapport du chargement de la configuration au format csv.<br/>
	 * Le rapport est null si il n'y a eu aucun 
	 * problème d'initialisation de l'application.<br/>
	 */
	private static transient String rapportConfigurationCsv;

	
	/**
	 * messageIndividuelRapport : String :<br/>
	 * Message pour le Rapport du chargement de la configuration au format csv 
	 * généré par chaque méthode individuellement.<br/>
	 */
	private static transient String messageIndividuelRapport;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory
			.getLog(ConfigurationBundlesManager.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationBundlesManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour interdire l'instanciation.<br/>
	 * <br/>
	 */
	private ConfigurationBundlesManager() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * method getBundleApplication() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleApplication.</li>
	 * <li>bundleApplication encapsule 
	 * ./classpath/application_fr_FR.properties.</li><br/>
	 * <li>bundleApplication contient les paramétrages généraux 
	 * de l'application (chemins vers les ressources
	 * , titre de l'application, ...).</li><br/>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleApplication() 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires 
	 * ./classpath".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleApplication.<br/>
	 */
	public static ResourceBundle getBundleApplication() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;
			
			if (bundleApplication == null) {
								
				try {
					
					bundleApplication 
						= ResourceBundle.getBundle("application", LOCALE_FR);
					
				} catch (MissingResourceException mre) {
										
					/* Création du message. */
					messageIndividuelRapport 
					= creerMessageRessourcesClassPath(
							METHODE_GET_BUNDLEAPPLICATION
								, "application_fr_FR.properties");
					
					/* LOG.FATAL. */
					if (LOG.isFatalEnabled()) {
						LOG.fatal(messageIndividuelRapport, mre);
					}
					
					/* Rapport. */
					/* Ajout du message au rapport. */
					ajouterMessageAuRapportConfigurationCsv(
							messageIndividuelRapport);
					
					/* retourne null. */
					return null;
				}
				
			} // Fin de if (bundleApplication == null)._________________
			
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
		synchronized (ConfigurationRessourcesManager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;
			
			if (bundleRessources == null) {
								
				try {
					
					bundleRessources 
						= ResourceBundle.getBundle(
								"configuration_ressources_parametrables"
									, LOCALE_FR);
					
				} catch (MissingResourceException mre) {
										
					/* Création du message. */
					messageIndividuelRapport 
					= creerMessageRessourcesClassPath(
							METHODE_GET_BUNDLERESSOURCES
				, "configuration_ressources_parametrables.properties");
					
					/* LOG.FATAL. */
					if (LOG.isFatalEnabled()) {
						LOG.fatal(messageIndividuelRapport, mre);
					}
					
					/* Rapport. */
					/* Ajout du message au rapport. */
					ajouterMessageAuRapportConfigurationCsv(
							messageIndividuelRapport);
					
					/* retourne null. */
					return null;
				}
				
			} // Fin de if (bundleRessources == null)._________________
			
			return bundleRessources;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleRessources()._____________________________________
	
		
	
	/**
	 * method getBundleMessagesControles() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleMessagesControles.</li><br/>
	 * <li>bundleMessagesControles encapsule 
	 * .\src\messagescontroles_fr_FR.properties.</li><br/>
	 * <li>bundleMessagesControles contient les paramétrages des contrôles 
	 * de l'application.</li><br/>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
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
		synchronized (ConfigurationBundlesManager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (bundleMessagesControles == null) {
								
				try {
					
					bundleMessagesControles 
						= getBundleExterne(
								"messagescontroles", new Locale("en", "US"));
					
				} catch (MissingResourceException mre) {
										
					/* Création du message. */
					messageIndividuelRapport 
					= creerMessageRessourcesClassPath(
							METHODE_GET_BUNDLEMESSAGESCONTROLES
								, "messagescontroles_fr_FR.properties");
					
					/* LOG.FATAL. */
					if (LOG.isFatalEnabled()) {
						LOG.fatal(messageIndividuelRapport, mre);
					}
					
					/* Rapport. */
					/* Ajout du message au rapport. */
					ajouterMessageAuRapportConfigurationCsv(
							messageIndividuelRapport);
					
					/* retourne null. */
					return null;
				}
				
			} // Fin de if (bundleMessagesControles == null).____________
			
			return bundleMessagesControles;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleMessagesControles().______________________________
	

	
	/**
	 * method getBundleMessagesTechniques() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleMessagesTechniques.</li><br/>
	 * <li>bundleMessagesTechniques encapsule 
	 * .\src\messagestechniques_fr_FR.properties.</li><br/>
	 * <li>bundleMessagesTechniques contient les paramétrages 
	 * des messages techniques 
	 * de l'application.</li><br/>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
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
		synchronized (ConfigurationBundlesManager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (bundleMessagesTechniques == null) {
								
				try {
					
					bundleMessagesTechniques 
						= ResourceBundle.getBundle(
								"messagestechniques", LOCALE_FR);
					
				} catch (MissingResourceException mre) {
										
					/* Création du message. */
					messageIndividuelRapport 
					= creerMessageRessourcesClassPath(
							METHODE_GET_BUNDLEMESSAGESTECHNIQUES
								, "messagestechniques_fr_FR.properties");
					
					/* LOG.FATAL. */
					if (LOG.isFatalEnabled()) {
						LOG.fatal(messageIndividuelRapport, mre);
					}
					
					/* Rapport. */
					/* Ajout du message au rapport. */
					ajouterMessageAuRapportConfigurationCsv(
							messageIndividuelRapport);
					
					/* retourne null. */
					return null;
				}
				
			} // Fin de if (bundleMessagesTechniques == null).___________
			
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
		synchronized (ConfigurationBundlesManager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (bundleMessagesDiff == null) {
								
				try {
					
					bundleMessagesDiff 
						= ResourceBundle.getBundle(
								"messagesdiff", LOCALE_FR);
					
				} catch (MissingResourceException mre) {
										
					/* Création du message. */
					messageIndividuelRapport 
					= creerMessageRessourcesClassPath(
							METHODE_GET_BUNDLEMESSAGESDIFF
								, "messagesdiff_fr_FR.properties");
					
					/* LOG.FATAL. */
					if (LOG.isFatalEnabled()) {
						LOG.fatal(messageIndividuelRapport, mre);
					}
					
					/* Rapport. */
					/* Ajout du message au rapport. */
					ajouterMessageAuRapportConfigurationCsv(
							messageIndividuelRapport);
					
					/* retourne null. */
					return null;
				}
				
			} // Fin de if (bundleMessagesDiff == null)._________________
			
			return bundleMessagesDiff;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleMessagesDiff().___________________________________
	

	
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
		synchronized (ConfigurationBundlesManager.class) {
			
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
		synchronized (ConfigurationBundlesManager.class) {
			return messageIndividuelRapport;
		} // Fin de synchronized.________________________________________
		
	} // Fin de getMessageIndividuelRapport()._____________________________



	/**
	 * method creerMessageRessourcesClassPath(
	 * String pMethode
	 * , String pFichier) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si problème lors du chargement des ResourceBundle 
	 * sous le classpath (.properties techniques).<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleApplication() 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires 
	 * ./classpath/".<br/>
	 * <br/>
	 *
	 * @param pMethode : String : Nom de la méthode appelante.<br/>
	 * @param pFichier : String : Nom du .properties à charger.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessageRessourcesClassPath(
			final String pMethode
				, final String pFichier) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONBUNDLESMANAGER);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("Le fichier '");
			stb.append(pFichier);
			stb.append("' est introuvable. "
					+ "Il devrait se trouver juste "
					+ "sous la racine des binaires ./classpath/");
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessageRessourcesClassPath(
	 // String pMethode
	 // , String pFichier).________________________________________________


	
	
	/**
	 * method creerMessageRessourcesParametrables(
	 * String pMethode
	 * , String pFichier) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si problème lors du chargement des ResourceBundle 
	 * sous le répertoire des ressources paramétrables 
	 * (.properties paramétrables par la Maîtrise d'Ouvrage (MOA)).<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleApplication() 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires \bin".<br/>
	 * <br/>
	 *
	 * @param pMethode : String : Nom de la méthode appelante.<br/>
	 * @param pFichier : String : Nom du .properties à charger.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessageRessourcesParametrables(
			final String pMethode
				, final String pFichier) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONBUNDLESMANAGER);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("Le fichier '");
			stb.append(pFichier);
			stb.append("' est introuvable. "
					+ "Il devrait se trouver juste "
					+ "sous la racine des binaires \\bin");
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessageRessourcesParametrables(
	 // String pMethode
	 // , String pFichier).________________________________________________
	
	
	
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
		synchronized (ConfigurationBundlesManager.class) {
			
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
	


	
	
	/**
	 * method getBundleExterne(
	 * String pBaseName
	 * , Locale pLocale) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pBaseName : String : Nom de base du .properties.
	 * @param pLocale : java.util.Locale.
	 * 
	 * @return :  :  .<br/>
	 */
	private static ResourceBundle getBundleExterne(
			final String pBaseName
				, final Locale pLocale) {
		
		ResourceBundle resourceBundle = null;
		
		try {
			
			final File repertoireRessourcesParametrables 
			= new File("D:/Donnees/Traficweb_ressources_parametrables");
			
			final URL[] urlsRessourcesParametrables 
				= {repertoireRessourcesParametrables.toURI().toURL()};
			
			final ClassLoader loaderRessourcesParametrables 
				= new URLClassLoader(urlsRessourcesParametrables);
			
			resourceBundle 
				= ResourceBundle
					.getBundle(pBaseName
							, pLocale
								, loaderRessourcesParametrables);
			
			
			
		} catch (MalformedURLException malformedURLEx) {
			
			malformedURLEx.printStackTrace();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		return resourceBundle;
		
	} // Fin de getBundleExterne(
	 // String pBaseName
	 // , Locale pLocale)._________________________________________________
	
	

} // FIN DE LA CLASSE ConfigurationBundlesManager.---------------------------
