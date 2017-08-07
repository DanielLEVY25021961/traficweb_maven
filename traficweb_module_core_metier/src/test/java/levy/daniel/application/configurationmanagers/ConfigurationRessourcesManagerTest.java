package levy.daniel.application.configurationmanagers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.ConfigurationApplicationManager;

/**
 * class ConfigurationRessourcesManagerTest :<br/>
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
public class ConfigurationRessourcesManagerTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(ConfigurationRessourcesManagerTest.class);
	
	// *************************METHODES************************************/

	/**
	 * method testGetBundleRessources() :<br/>
	 * .<br/>
	 * <br/>
	 * :  :  .<br/>
	 */
	@Test
	public void testGetBundleRessources() {
		
		/* Récupère le ResourceBundle encapsulant 
		 * configuration_ressources_parametrables_fr_FR.properties. */
		final ResourceBundle bundleRessources 
			= ConfigurationRessourcesManager
				.getBundleRessources();
		
		final ResourceBundle bundleRessources2 
			= ConfigurationRessourcesManager
				.getBundleRessources();
		
		/* Garantit que getbundleRessources() retourne 
		 * un Singleton de ResourceBundle. */
		assertEquals("Une seule instance de ResourceBundle : "
				, bundleRessources
					, bundleRessources2);
		
		assertTrue("Une seule instance de ResourceBundle : "
				, bundleRessources == bundleRessources2);
		
		/* Récupère le rapport de chargement de la configuration. */
		final String rapportCsv 
			= ConfigurationApplicationManager
				.getRapportConfigurationCsv();
		
		/* Garantit que le rapport fourni par getRapportConfigurationCsv() 
		 * est null si pas de problème d'import. */
		assertNull("Le rapport est null si pas de pb d'import : "
				, rapportCsv);
		
	}


}
