package levy.daniel.application.configurationmanagers;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class LocaleManager :<br/>
 * Classe de CONFIGURATION (finale avec des méthodes statiques)
 * chargée de fournir une Locale unique à toute l'application.<br/>
 * Classe PERSISTENTE car la Locale courante doit être stockée en base.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Locale, Locale("fr", "FR") en France, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 9 août 2017
 *
 */
public final class LocaleManager {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_LOCALEMANAGER : String :<br/>
	 * "Classe LocaleManager".<br/>
	 */
	public static final String CLASSE_LOCALEMANAGER 
		= "Classe LocaleManager";
	
	
	/**
	 * localeApplication : Locale :<br/>
	 * Locale à utiliser dans toute l'application.<br/>
	 * L'application doit être internationalisable.<br/>
	 */
	private static Locale localeApplication;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LocaleManager.class);

	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR LocaleManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private LocaleManager() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method getLangageLocaleApplication() :<br/>
	 * Retourne le langage (fr, en, ...) de localeApplication.<br/>
	 * <br/>
	 *
	 * @return : String : Le langage (fr, en, ...) 
	 * de localeApplication.<br/>
	 */
	public static String getLangageLocaleApplication() {
		return localeApplication.getLanguage();
	} // Fin de getLangageLocaleApplication()._____________________________


	
	/**
	 * method getCountryLocaleApplication() :<br/>
	 * Retourne le country (FR, US, ...) de localeApplication.<br/>
	 * <br/>
	 *
	 * @return : String : le country (FR, US, ...) 
	 * de localeApplication.<br/>
	 */
	public static String getCountryLocaleApplication() {
		return localeApplication.getCountry();
	} // Fin de getCountryLocaleApplication()._____________________________
	

	
	/**
	 * method getLocaleParDefaut() :<br/>
	 * Retourne la Locale retournée par la JVM en fonction 
	 * de la position de la machine dans le monde.<br/>
	 * Locale("fr", "FR") en France.<br/>
	 * <br/>
	 *
	 * @return : Locale : Locale("fr", "FR") en France.<br/>
	 */
	public static Locale getLocaleParDefaut() {
		return Locale.getDefault();
	} // Fin de getLocaleParDefaut().______________________________________

	
	
	/**
	 * method getLocaleApplication() :<br/>
	 * Getter de la Locale à utiliser dans toute l'application.<br/>
	 * L'application doit être internationalisable.<br/>
	 * <br/>
	 *
	 * @return localeApplication : Locale.<br/>
	 */
	public static Locale getLocaleApplication() {
		return localeApplication;
	} // Fin de getLocaleApplication().____________________________________
	

	
	/**
	* method setLocaleApplication(
	* Locale pLocaleApplication) :<br/>
	* Setter de la Locale à utiliser dans toute l'application.<br/>
	* L'application doit être internationalisable.<br/>
	* <br/>
	*
	* @param pLocaleApplication : Locale : 
	* valeur à passer à localeApplication.<br/>
	*/
	public static void setLocaleApplication(
			final Locale pLocaleApplication) {
		localeApplication = pLocaleApplication;
	} // Fin de setLocaleApplication(
	// Locale pLocaleApplication)._________________________________________
	
	
	
	
} // FIN DE LA CLASSE LocaleManager.-----------------------------------------
