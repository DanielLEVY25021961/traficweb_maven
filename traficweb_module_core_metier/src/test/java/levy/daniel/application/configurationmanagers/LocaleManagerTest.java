package levy.daniel.application.configurationmanagers;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * class LocaleManagerTest :<br/>
 * Test JUnit de la classe LocaleManager.<br/>
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
 * @since 9 août 2017
 *
 */
public class LocaleManagerTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LocaleManagerTest.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR LocaleManagerTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LocaleManagerTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method testGetLocaleParDefaut() :<br/>
	 * .<br/>
	 * <br/>
	 */
	@Test
	public void testGetLocaleParDefaut() {
		
//		final Locale localeParDefaut = LocaleManager.getLocaleParDefaut();
		final Locale localeParDefaut = new Locale("en", "US");
		
		System.out.println(localeParDefaut.getLanguage());
		System.out.println(localeParDefaut.getCountry());
		System.out.println("Variant : " + localeParDefaut.getVariant());
		System.out.println("getDisplayCountry() : " + localeParDefaut.getDisplayCountry());
		System.out.println("getDisplayLanguage() : " + localeParDefaut.getDisplayLanguage());
		System.out.println("getDisplayName() : " + localeParDefaut.getDisplayName());
		
	} // Fin de testGetLocaleParDefaut().__________________________________
	
	
	
} // FIN DE LA CLASSE LocaleManagerTest.-------------------------------------
