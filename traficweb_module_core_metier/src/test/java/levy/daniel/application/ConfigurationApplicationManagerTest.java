package levy.daniel.application;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.apptechnic.exceptions.technical.impl.BundleManquantRunTimeException;

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
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * CAS_EXCEPTION : String :<br/>
	 * "pas être null en cas d'Exception : ".<br/>
	 */
	public static final String CAS_EXCEPTION 
		= "pas être null en cas d'Exception : ";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
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
	 * teste la méthode getBundleApplication() qui charge 
	 * un properties INTERNE (dans le classpath).
	 * <ul>
	 * <li>garantit que bundleApplication n'est pas null 
	 * (application.properties sous la racine).</li>
	 * <li>garantit que getBundleApplication() retourne un Singleton.</li>
	 * <li>Garantit que le rapport fourni par 
	 * getRapportConfigurationCsv() est null 
	 * si pas de problème d'import.</li>
	 * <li>garantit que rapportConfigurationCsv n'est pas null 
	 * en cas d'Exception.</li>
	 * <li>garantit que rapportUtilisateurCsv n'est pas null 
	 * en cas d'Exception.</li>
	 * <li>garantit que l'absence de application.properties jette une 
	 * BundleManquantRunTimeException provoquée par une 
	 * BundleManquantRunTimeException provenant de ConfigurationBundlesManager.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test
	public void testGetBundleApplication() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************


		try {
			final ResourceBundle bundleApplication1 
				= ConfigurationApplicationManager.getBundleApplication();
			
			/* garantit que bundleApplication n'est pas null. */
			assertNotNull("bundleApplication ne doit pas être null : "
					, bundleApplication1);
			
			final ResourceBundle bundleApplication2 
			= ConfigurationApplicationManager.getBundleApplication();
			
			/* garantit que getBundleApplication() retourne un Singleton. */
			assertTrue(
					"bundleApplication1 doit être la même "
					+ "instance que bundleApplication2"
					, bundleApplication1 == bundleApplication2);   // NOPMD by dan on 02/10/17 23:16
			
			/* Récupère le rapport de chargement de la configuration. */
			final String rapportCsv 
				= ConfigurationApplicationManager
					.getRapportConfigurationCsv();
			
			/* Garantit que le rapport fourni par getRapportConfigurationCsv() 
			 * est null si pas de problème d'import. */
			assertNull("Le rapport est null si pas de pb d'import : "
					, rapportCsv);

		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= ConfigurationApplicationManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= ConfigurationApplicationManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("RAPPORT DE CONFIGURATION : ");
				System.out.println(rapportConfigurationCsv);
				
				System.out.println();
				System.out.println("RAPPORT UTILISATEUR : ");
				System.out.println(rapportUtilisateurCsv);
				
				System.out.println();
				System.out.print("LISTE DES EXCEPTIONS ENCAPSULEES DANS e : ");
				System.out.println(e.listeExceptionsToString());
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull("Le rapport de configuration ne doit "
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull("Le rapport utilisateur ne doit "
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);

			/* garantit que l'absence de application.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException provenant 
			 * de ConfigurationBundlesManager. */
			assertTrue("La cause de la BundleManquantRunTimeException "
					+ "doit être une BundleManquantRunTimeException : "
					, e.getCause() instanceof BundleManquantRunTimeException);
			
		}
				
	} // Fin de testGetBundleApplication().________________________________
	

	
	/**
	 * method testGetBundleRessourcesExternes() :<br/>
	 * teste la méthode getBundleRessourcesExternes() qui charge 
	 * un properties INTERNE (dans le classpath).
	 * <ul>
	 * <li>garantit que bundleRessourcesExternes n'est pas null 
	 * (application.properties sous la racine).</li>
	 * <li>garantit que getBundleRessourcesExternes() retourne un Singleton.</li>
	 * <li>Garantit que le rapport fourni par 
	 * getRapportConfigurationCsv() est null 
	 * si pas de problème d'import.</li>
	 * <li>garantit que rapportConfigurationCsv n'est pas null 
	 * en cas d'Exception.</li>
	 * <li>garantit que rapportUtilisateurCsv n'est pas null 
	 * en cas d'Exception.</li>
	 * <li>garantit que l'absence de application.properties jette une 
	 * BundleManquantRunTimeException provoquée par une 
	 * BundleManquantRunTimeException provenant de ConfigurationBundlesManager.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test
	public void testGetBundleRessourcesExternes() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************


		try {
			final ResourceBundle bundleRessourcesExternes1 
				= ConfigurationApplicationManager.getBundleRessourcesExternes();
			
			/* garantit que bundleRessourcesExternes n'est pas null. */
			assertNotNull("bundleRessourcesExternes ne doit pas être null : "
					, bundleRessourcesExternes1);
			
			final ResourceBundle bundleRessourcesExternes2 
			= ConfigurationApplicationManager.getBundleRessourcesExternes();
			
			/* garantit que getBundleRessourcesExternes() retourne un Singleton. */
			assertTrue(
					"bundleRessourcesExternes1 doit être la même "
					+ "instance que bundleRessourcesExternes2"
					, bundleRessourcesExternes1 == bundleRessourcesExternes2);   // NOPMD by dan on 02/10/17 23:16
			
			/* Récupère le rapport de chargement de la configuration. */
			final String rapportCsv 
				= ConfigurationApplicationManager
					.getRapportConfigurationCsv();
			
			/* Garantit que le rapport fourni par getRapportConfigurationCsv() 
			 * est null si pas de problème d'import. */
			assertNull("Le rapport est null si pas de pb d'import : "
					, rapportCsv);

		}
		catch (BundleManquantRunTimeException e) {
			
			/* rapport développeurs.*/
			final String rapportConfigurationCsv 
			= ConfigurationApplicationManager.getRapportConfigurationCsv();
			
			/* rapport utilisateurs. */
			final String rapportUtilisateurCsv 
			= ConfigurationApplicationManager.getRapportUtilisateurCsv();
			
			/* AFFICHAGE A LA CONSOLE. */
			if (AFFICHAGE_GENERAL && affichage) {
				
				System.out.println();
				System.out.println("RAPPORT DE CONFIGURATION : ");
				System.out.println(rapportConfigurationCsv);
				
				System.out.println();
				System.out.println("RAPPORT UTILISATEUR : ");
				System.out.println(rapportUtilisateurCsv);
				
				System.out.println();
				System.out.print("LISTE DES EXCEPTIONS ENCAPSULEES DANS e : ");
				System.out.println(e.listeExceptionsToString());
			}
			
			/* garantit que rapportConfigurationCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull("Le rapport de configuration ne doit "
					+ CAS_EXCEPTION
					, rapportConfigurationCsv);
			
			/* garantit que rapportUtilisateurCsv 
			 * n'est pas null en cas d'Exception. */
			assertNotNull("Le rapport utilisateur ne doit "
					+ CAS_EXCEPTION
					, rapportUtilisateurCsv);

			/* garantit que l'absence de application.properties jette 
			 * une BundleManquantRunTimeException provoquée par une 
			 * BundleManquantRunTimeException provenant 
			 * de ConfigurationBundlesManager. */
			assertTrue("La cause de la BundleManquantRunTimeException "
					+ "doit être une BundleManquantRunTimeException : "
					, e.getCause() instanceof BundleManquantRunTimeException);
			
		}
				
	} // Fin de testGetBundleRessourcesExternes().________________________________
	
	
	
	/**
	 * method testGetBundleMessagesControles() :<br/>
	 * Teste la méthode getBundleMessagesControles().<br/>
	 * Pré-requis : messagescontroles_fr_FR.properties doit avoir été 
	 * incorporé sous 
	 * chemin_ressources_externes/Traficweb_ressources_parametrables/.<br/>
	 * <br/>
	 * Garantit que : <ul>
	 * <li>getBundleMessagesControles() retourne 
	 * un Singleton de ResourceBundle.</li>
	 * <li>le rapport fourni par getRapportConfigurationCsv() 
	 * est null si pas de problème d'import.</li>
	 * </ul>
	 */
	@Test
	public void testGetBundleMessagesControles() {
		
		/* Récupère le ResourceBundle encapsulant 
		 * messagescontroles.properties. */
		final ResourceBundle bundleMessagesControle 
			= ConfigurationApplicationManager
				.getBundleMessagesControles();
		
		final ResourceBundle bundleMessagesControle2 
			= ConfigurationApplicationManager
				.getBundleMessagesControles();
		
		/* Garantit que getBundleMessagesControles() retourne 
		 * un Singleton de ResourceBundle. */
		assertEquals("Une seule instance de ResourceBundle : "
				, bundleMessagesControle
					, bundleMessagesControle2);
		
		assertTrue("Une seule instance de ResourceBundle : "
				, bundleMessagesControle == bundleMessagesControle2);
		
		/* Récupère le rapport de chargement de la configuration. */
		final String rapportCsv 
			= ConfigurationApplicationManager
				.getRapportConfigurationCsv();
		
		/* Garantit que le rapport fourni par getRapportConfigurationCsv() 
		 * est null si pas de problème d'import. */
		assertNull("Le rapport est null si pas de pb d'import : "
				, rapportCsv);
		
	} // Fin de testGetBundleMessagesControles().__________________________

	
	
	
	/**
	 * method testGetBundleMessagesTechniques() :<br/>
	 * Teste la méthode getBundleMessagesTechniques().<br/>
	 * Pré-requis : messagesTechniques_fr_FR.properties doit avoir été 
	 * incorporé sous src/main/resources.<br/>
	 * <br/>
	 * Garantit que : <ul>
	 * <li>getBundleMessagesTechniques() retourne 
	 * un Singleton de ResourceBundle.</li>
	 * <li>le rapport fourni par getRapportConfigurationCsv() 
	 * est null si pas de problème d'import.</li>
	 * </ul>
	 */
	@Test
	public void testGetBundleMessagesTechniques() {
		
		/* Récupère le ResourceBundle encapsulant 
		 * messagestechniques.properties. */
		final ResourceBundle bundleMessagesTechnique 
			= ConfigurationApplicationManager
				.getBundleMessagesTechniques();
		
		final ResourceBundle bundleMessagesTechnique2 
		= ConfigurationApplicationManager
			.getBundleMessagesTechniques();
		
		/* Garantit que getBundleMessagesTechniques() retourne 
		 * un Singleton de ResourceBundle. */
		assertEquals("Une seule instance de ResourceBundle : "
				, bundleMessagesTechnique
					, bundleMessagesTechnique2);
		
		assertTrue("Une seule instance de ResourceBundle : "
				, bundleMessagesTechnique == bundleMessagesTechnique2);
		
		/* Récupère le rapport de chargement de la configuration. */
		final String rapportCsv 
			= ConfigurationApplicationManager
				.getRapportConfigurationCsv();
		
		/* Garantit que le rapport fourni par getRapportConfigurationCsv() 
		 * est null si pas de problème d'import. */
		assertNull("Le rapport est null si pas de pb d'import : "
				, rapportCsv);
		
	} // Fin de testGetBundleMessagesTechniques().__________________________
	

	
	
	/**
	 * method testGetClassPath() :<br/>
	 * Teste la méthode getClassPath().<br/>
	 * <br/>
	 */
	@Test
	public void testGetClassPath() {
		
		final String classPath 
			= ConfigurationApplicationManager.getClassPath();
		
		System.out.println(classPath);
		
	} // Fin de testGetClassPath().________________________________________
	
	

} // FIN DE LA CLASSE ConfigurationApplicationManagerTest.-------------------
