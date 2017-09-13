package levy.daniel.application.configurationmanagers;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.ConfigurationApplicationManager;

/**
 * class ConfigurationRessourcesManager :<br/>
 * Classe UTILITAIRE 
 * Chargée de gérer la configuration des RESSOURCES PARAMETRABLES 
 * PAR LA Maîtrise d'Ouvrage (MOA) de l'application.<br/>
 * Met à disposition de l'ensemble de l'application 
 * des Singletons pour 
 * les fichiers .properties PARAMETRABLES par la MOA dont l'application 
 * a besoin pour fonctionner.<br/>
 * bundleRessources encapsule 
 * 'configuration_ressources_parametrables.properties'. 
 * Ce fichier SITUE DANS LE CLASSPATH (sous la racine des binaires) ne doit être accédé 
 * que par le centre serveur. 
 * Il contient notamment le chemin <i>déterminé par le centre serveur</i> 
 * vers les fichiers de configuration paramétrables par la MOA. 
 * Ce chemin est forcément <i>hors classpath</i> pour que les ressources 
 * contenues ne soient pas incorporées dans les jar ou war<br/>
 * <br/>
 * Les fichiers paramétrables par la MOA sont :
 * <ul>
 * <li>messagescontroles.properties contenant les messages émis 
 * par les contrôles.</li>
 * <li>messagestechniques.properties contenant les messages 
 * émis par les classes pour les LOG.</li>
 * <li>labels.properties contenant les labels (textes) affichés 
 * par l'application dans les IHM (pages Web ou fenêtres JavaFX).</li>
 * <li>Les descriptions de fichiers (HIT, HistonatF07, ...).</li>
 * <li>Les nomenclatures applicables à certains champs 
 * de certains fichiers 
 * (nomenclature pour les sens dans un fichier HIT, ....).</li> 
 * </ul>
 * <br/>
 * <ul>
 * <li>La méthode getBundleRessources fournit 
 * un singleton de BundleRessource qui encapsule 
 * 'configuration_ressources_parametrables.properties'.</li><br/>
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
 * @since 4 août 2017
 *
 */
public final class ConfigurationRessourcesManager {

	// ************************ATTRIBUTS************************************/

	
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


	
	/**
	 * METHODE_GET_CHEMIN_REPERTOIRE_RESSOURCES : String :<br/>
	 * "Méthode getCheminRepertoireRessources()".<br/>
	 */
	public static final String METHODE_GET_CHEMIN_REPERTOIRE_RESSOURCES
		= "Méthode getCheminRepertoireRessources()";
	
	
	
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
	 * Contient les chemins vers les fichiers PARAMETRABLES PAR LA MOA
	 * (donc, hors classpath) de l'application.<br/>
	 * encapsule racine_binaires/configuration_ressources_
	 * parametrables.properties.
	 */
	private static transient ResourceBundle bundleRessources;
	

	
	/**
	 * cheminRepertoireRessources : String :<br/>
	 * Chemin du répertoire contenant les Ressources 
	 * PARAMETRABLES PAR LA MOA stocké dans 
	 * configuration_ressources_parametrables.properties.<br/>
	 * Par exemple "D:/Donnees/Traficweb_ressources_parametrables/".<br/>
	 * Ce chemin est déterminé par le centre serveur qui désippera 
	 * le jar ou le war pour l'implémenter.<br/>
	 * Clé = "application.repertoire.resources".<br/>
	 */
	private static transient String cheminRepertoireRessources;

	

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
	private static final Log LOG 
		= LogFactory.getLog(ConfigurationRessourcesManager.class);

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
	 * method getCheminRepertoireRessources() :<br/>
	 * Getter du Chemin du répertoire contenant les Ressources 
	 * PARAMETRABLES PAR LA MOA stocké dans 
	 * configuration_ressources_parametrables.properties.<br/>
	 * Par exemple "D:/Donnees/Traficweb_ressources_parametrables/".<br/>
	 * Ce chemin est déterminé par le centre serveur qui désippera 
	 * le jar ou le war pour l'implémenter.<br/>
	 * Clé = "application.repertoire.resources".<br/>
	 * <br/>
	 *
	 * @return cheminRepertoireRessources : String.<br/>
	 */
	public static String getCheminRepertoireRessources() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationRessourcesManager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;
			
			if (cheminRepertoireRessources == null) {
				
				/* Si le properties n'est pas manquant. */
				if (ConfigurationApplicationManager
						.getBundleRessources() != null) {
					
					/* Essaie de récupérer la valeur 
					 * dans le properties. */
					try {
						
						final String valeur 
							= bundleRessources
								.getString(
								fournirCleCheminRepertoireRessources());
						
						
						/* Si la valeur est blank. */
						/* (Oubli d'implémentation de la 
						 * clé dans le properties). */
						if (StringUtils.isBlank(valeur)) {
							
							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
									METHODE_GET_CHEMIN_REPERTOIRE_RESSOURCES
									, fournirCleCheminRepertoireRessources()
									, bundleRessources);
							
							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}
							
							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);
							
							/* utilise la valeur fournie en dur. */
							cheminRepertoireRessources 
								= fournirCheminRepertoireRessourcesEnDur();
							
						} // Fin de Si la valeur est blank._________
						
						/* Valeur remplie dans le properties. */
						else {
							
							/* Nettoie la valeur lue dans le 
							 * .properties avec trim(). */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);
							
							cheminRepertoireRessources 
								= valeurNettoyee; 
							
						} // Fin de Valeur remplie dans le properties.____
						
						
					/* Cas de la clé manquante dans le properties. */
					} catch (MissingResourceException mre) {
						
						/* Création du message. */
						messageIndividuelRapport 
						= creerMessageManqueCle(
								METHODE_GET_CHEMIN_REPERTOIRE_RESSOURCES
								, fournirCleCheminRepertoireRessources()
								, bundleRessources);
						
						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}
						
						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);
						
						/* utilise la valeur fournie en dur. */
						cheminRepertoireRessources 
							= fournirCheminRepertoireRessourcesEnDur();
						
					} // Fin de catch (MissingResourceException mre)._____
					
				} // Fin de if (getBundleRessources() != null).___ 
				
				/* getBundleRessources() == null. */
				/* Properties manquant. */
				else {
					
					/* utilise la valeur fournie en dur. */
					cheminRepertoireRessources 
						= fournirCheminRepertoireRessourcesEnDur();
					
				} // Fin de if getBundleRessources() == null._____
				
				
			} // Fin de if (cheminRepertoireRessources == null).___
			
			return cheminRepertoireRessources;

		} // Fin de synchronized.________________________________________
		
	} // Fin de getCheminRepertoireRessources().___________________________


		
	/**
	 * method fournirCleCheminRepertoireRessources() :<br/>
	 * clé du chemin du répertoire contenant les Ressources 
	 * PARAMETRABLES PAR LA MOA stocké dans 
	 * configuration_ressources_parametrables.properties 
	 * sous la racine des binaires.<br/>
	 * Clé = "application.repertoire.resources".
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.resources".<br/>
	 */
	private static String fournirCleCheminRepertoireRessources() {
		return "application.repertoire.resources";
	} // Fin de fournirCleCheminRepertoireRessources().____________________________
	

	
	/**
	 * method fournirCheminRepertoireRessourcesEnDur() :<br/>
	 * Fournit une valeur stockée en dur 
	 * dans la classe pour cheminRepertoireRessources.<br/>
	 * <br/>
	 * "D:/Donnees/Traficweb_ressources_parametrables/".<br/>
	 * <br/>
	 *
	 * @return : String : "D:/Donnees/Traficweb_ressources_parametrables/".<br/>
	 */
	private static String fournirCheminRepertoireRessourcesEnDur() {
		return "D:/Donnees/Traficweb_ressources_parametrables/";
	} // Fin de fournirCheminRepertoireRessourcesEnDur().__________________________
	

		
	/**
	 * method creerMessage(
	 * String pMethode
	 * , String pFichier) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si problème lors du chargement des ResourceBundle.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "Classe ConfigurationRessourcesManager 
	 * - Méthode getBundleRessources() 
	 * - Le fichier 'configuration_ressources_parametrables.properties' 
	 * est introuvable. 
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
		synchronized (ConfigurationRessourcesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONRESSOURCESMANAGER);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("Le fichier '");
			stb.append(pFichier);
			stb.append("' est introuvable. "
					+ "Il devrait se trouver juste "
					+ "sous la racine des binaires.");
			
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
		synchronized (ConfigurationRessourcesManager.class) {
			
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
		synchronized (ConfigurationRessourcesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONRESSOURCESMANAGER);
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
		synchronized (ConfigurationRessourcesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONRESSOURCESMANAGER);
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



} // FIN DE LA CLASSE ConfigurationRessourcesManager.------------------------
