package levy.daniel.application;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * class ConfigurationApplicationManagerTest :<br/>
 * Test JUnit de la classe ConfigurationApplicationManager.<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 26 juil. 2017
 *
 */
public class ConfigurationApplicationManagerTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	@SuppressWarnings("unused")
	private static final Log LOG 
		= LogFactory.getLog(ConfigurationApplicationManagerTest.class);
	
	
	// *************************METHODES************************************/

	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationApplicationManagerTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ConfigurationApplicationManagerTest() {
		super();
	} // Fin de  CONSTRUCTEUR D'ARITE NULLE._______________________________

	
	
	/**
	 * method testGetBundleApplication() :<br/>
	 * Teste la méthode getBundleApplication().<br/>
	 * Pré-requis : application_fr_FR.properties doit avoir été 
	 * incorporé sous src/main/resources.<br/>
	 * <br/>
	 * Garantit que : <ul>
	 * <li>getBundleApplication() retourne 
	 * un Singleton de ResourceBundle.</li>
	 * <li>le rapport fourni par getRapportConfigurationCsv() 
	 * est null si pas de problème d'import.</li>
	 * </ul>
	 * <br/>
	 */
	@Test
	public void testGetBundleApplication() {
		
		/* Récupère le ResourceBundle encapsulant 
		 * application.properties. */
		final ResourceBundle bundleApplication 
			= ConfigurationApplicationManager.getBundleApplication();
		
		final ResourceBundle bundleApplication2 
		= ConfigurationApplicationManager.getBundleApplication();
		
		/* Garantit que getBundleApplication() retourne 
		 * un Singleton de ResourceBundle. */
		assertEquals("Une seule instance de ResourceBundle : "
				, bundleApplication
					, bundleApplication2);
		
		assertTrue("Une seule instance de ResourceBundle : "
				, bundleApplication == bundleApplication2);
		
		/* Récupère le rapport de chargement de la configuration. */
		final String rapportCsv 
			= ConfigurationApplicationManager.getRapportConfigurationCsv();
		
		/* Garantit que le rapport fourni par getRapportConfigurationCsv() 
		 * est null si pas de problème d'import. */
		assertNull("Le rapport est null si pas de pb d'import : "
				, rapportCsv);
		
	} // Fin de testGetBundleApplication().________________________________
	


} // FIN DE LA CLASSE ConfigurationApplicationManagerTest.-------------------
