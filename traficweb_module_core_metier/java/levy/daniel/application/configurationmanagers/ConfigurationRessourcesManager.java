package levy.daniel.application.configurationmanagers;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class ConfigurationRessourcesManager :<br/>
 * .<br/>
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
 * @since 4 août 2017
 *
 */
public final class ConfigurationRessourcesManager {

	// ************************ATTRIBUTS************************************/

	

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
	 * CLASSE_CONFIGURATIONRESSOURCESMANAGER : String :<br/>
	 * "Classe ConfigurationRessourcesManager".<br/>
	 */
	public static final String CLASSE_CONFIGURATIONRESSOURCESMANAGER 
		= "Classe ConfigurationRessourcesManager";

	
	
	/**
	 * METHODE_GET_BUNDLERESSOURCES : String :<br/>
	 * "Méthode getBundleRessources()".<br/>
	 */
	public static final String METHODE_GET_BUNDLERESSOURCES
		= "Méthode getBundleRessources()";

	
	
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
	 * bundleRessources : ResourceBundle : <br/>
	 * configuration_ressources_parametrables_fr_FR.properties.<br/>
	 * Contient les chemins vers les fichiers paramètrables
	 * de l'application.<br/>
	 */
	private static ResourceBundle bundleRessources;
	
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ConfigurationRessourcesManager.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationRessourcesManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour interdire l'instanciation.<br/>
	 * <br/>
	 */
	private ConfigurationRessourcesManager() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method getBundleRessources() :<br/>
	 * <ul>
	 * <li>Fournit un singleton de bundleRessources 
	 * (configuration_ressources_parametrables_fr_FR.properties).</li>
	 * <li>bundleRessources encapsule 
	 * .\src\configuration_ressources_parametrables_fr_FR.</li>
	 * <li>bundleRessources contient les paramétrages généraux 
	 * de l'Ressources (chemins vers les ressources
	 * , titre de l'Ressources, ...).</li>
	 * <br/>
	 * - retourne null, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * <br/>
	 * Exemple de message d'erreur :<br/>
	 * "Classe ConfigurationRessourcesManager 
	 * - Méthode getBundleRessources() 
	 * - Le fichier 'Ressources_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires \bin".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleRessources.<br/>
	 */
	public static ResourceBundle getBundleRessources() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;
			
			if (bundleRessources == null) {
								
				try {
					
					bundleRessources 
						= ResourceBundle.getBundle("configuration_ressources_parametrables", LOCALE_FR);
					
				} catch (MissingResourceException mre) {
										
					/* Création du message. */
					messageIndividuelRapport 
					= creerMessage(
							METHODE_GET_BUNDLERESSOURCES
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
			
			return bundleRessources;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getBundleApplication().____________________________________
	
	

	/**
	 * method creerMessage(
	 * String pMethode
	 * , String pFichier) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si problème lors du chargement des ResourceBundle.<br/>
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
	private static String creerMessage(
			final String pMethode
				, final String pFichier) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONRESSOURCESMANAGER);
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
		
	} // Fin de creerMessage(
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
	



}
