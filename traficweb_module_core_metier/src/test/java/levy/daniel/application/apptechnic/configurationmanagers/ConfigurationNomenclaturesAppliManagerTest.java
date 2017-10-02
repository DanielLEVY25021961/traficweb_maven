package levy.daniel.application.apptechnic.configurationmanagers;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Set;
import java.util.SortedMap;

import levy.daniel.application.ConfigurationApplicationManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * class ConfigurationNomenclaturesAppliManagerTest :<br/>
 * Test JUnit de la classe ConfigurationNomenclaturesAppliManager.<br/>
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
 * @since 30 mai 2016
 *
 */
public class ConfigurationNomenclaturesAppliManagerTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(ConfigurationNomenclaturesAppliManagerTest.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationNomenclaturesAppliManagerTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ConfigurationNomenclaturesAppliManagerTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * method testGetCheminNomenclaturesAppli() :<br/>
	 * Teste getCheminNomenclaturesAppliUtf8().<br/>
	 * <br/>
	 */
	@Test
	public void testGetCheminNomenclaturesAppli() {

//		System.out.println("CHEMIN DES NOMENCLATURES APPLI : "
//				+ ConfigurationNomenclaturesAppliManager
//						.getCheminNomenclaturesAppliUtf8());
//		System.out
//				.println("RAPPORT DANS ConfigurationNomenclaturesAppliManager : \n"
//						+ ConfigurationNomenclaturesAppliManager
//								.getRapportConfigurationCsv());
//		System.out.println("RAPPORT DANS ConfigurationApplicationManager : \n"
//				+ ConfigurationApplicationManager.getRapportConfigurationCsv());
		
		ConfigurationNomenclaturesAppliManager
			.getCheminNomenclaturesAppliUtf8();
		
		assertNull("Le rapport ConfigurationNomenclaturesAppliManager doit être null : "
				, ConfigurationNomenclaturesAppliManager.getRapportConfigurationCsv());
		assertNull("Le rapport ConfigurationApplicationManager doit être null : "
				, ConfigurationApplicationManager.getRapportConfigurationCsv());
	
	} // Fin de testGetCheminNomenclaturesAppli()._________________________
	

	
	/**
	 * method testGetNomNomenclaturesAppliTypeErreur() :<br/>
	 * Teste getNomNomenclatureAppliTypeErreur().<br/>
	 * <br/>
	 */
	@Test
	public void testGetNomNomenclaturesAppliTypeErreur() {

//		System.out.println("NOM NOMENCLATURES APPLI typeErreur: "
//				+ ConfigurationNomenclaturesAppliManager
//						.getNomNomenclatureAppliTypeErreur());
//		System.out
//				.println("RAPPORT DANS ConfigurationNomenclaturesAppliManager : \n"
//						+ ConfigurationNomenclaturesAppliManager
//								.getRapportConfigurationCsv());
//		System.out.println("RAPPORT DANS ConfigurationApplicationManager : \n"
//				+ ConfigurationApplicationManager.getRapportConfigurationCsv());
		
		ConfigurationNomenclaturesAppliManager
			.getNomNomenclatureAppliTypeErreur();
		
		assertNull("Le rapport ConfigurationNomenclaturesAppliManager doit être null : "
				, ConfigurationNomenclaturesAppliManager.getRapportConfigurationCsv());
		assertNull("Le rapport ConfigurationApplicationManager doit être null : "
				, ConfigurationApplicationManager.getRapportConfigurationCsv());
		
	} // Fin de testGetNomNomenclaturesAppliTypeErreur().__________________


	
	/**
	 * method testGetFichierNomenclaturesAppliTypeErreur() :<br/>
	 * Teste getFichierNomenclatureAppliTypeErreurUtf8().<br/>
	 * <br/>
	 */
	@Test
	public void testGetFichierNomenclaturesAppliTypeErreur() {
		
//		System.out.println("FICHIER NOMENCLATURES APPLI typeErreur: "
//				+ ConfigurationNomenclaturesAppliManager
//						.getFichierNomenclatureAppliTypeErreurUtf8());
//		System.out
//				.println("RAPPORT DANS ConfigurationNomenclaturesAppliManager : \n"
//						+ ConfigurationNomenclaturesAppliManager
//								.getRapportConfigurationCsv());
//		System.out.println("RAPPORT DANS ConfigurationApplicationManager : \n"
//				+ ConfigurationApplicationManager.getRapportConfigurationCsv());
		
		ConfigurationNomenclaturesAppliManager
			.getFichierNomenclatureAppliTypeErreurUtf8();
		
		assertNull("Le rapport ConfigurationNomenclaturesAppliManager doit être null : "
				, ConfigurationNomenclaturesAppliManager.getRapportConfigurationCsv());
		assertNull("Le rapport ConfigurationApplicationManager doit être null : "
				, ConfigurationApplicationManager.getRapportConfigurationCsv());
		
	} // Fin de testGetFichierNomenclaturesAppliTypeErreur().______________

	
	
	/**
	 * method testGetSetClesNomenclatureUtf8() :<br/>
	 * Teste getSetClesNomenclatureUtf8(File pNomenclature).<br/>
	 * <br/>
	 */
	@Test
	public void testGetSetClesNomenclatureUtf8() {
		
		/* Nomenclature typeErreur. */
		final File nomenclatureErreurType 
			= ConfigurationNomenclaturesAppliManager
				.getFichierNomenclatureAppliTypeErreurUtf8();
		
		final Set<Integer> clesTypeErreur 
		= ConfigurationNomenclaturesAppliManager
			.getSetClesNomenclatureUtf8(nomenclatureErreurType);
		
//		System.out.println("CLES TypeErreur : " + clesTypeErreur.toString());
		
		assertNotNull(
				"CLES TypeErreur ne doit pas être null : "
					, clesTypeErreur);
		
	} // Fin de testGetSetClesNomenclatureUtf8().__________________________
	

	
	/**
	 * method testGetMapNomenclatureUtf8() :<br/>
	 * Teste testGetMapNomenclatureUtf8(File pNomenclature).<br/>
	 * <br/>
	 */
	@Test
	public void testGetMapNomenclatureUtf8() {
		
		/* Nomenclature typeErreur. */
		final File nomenclatureErreurType 
			= ConfigurationNomenclaturesAppliManager
				.getFichierNomenclatureAppliTypeErreurUtf8();
		
		final SortedMap<Integer, String> mapNomenclature 
			= ConfigurationNomenclaturesAppliManager
				.getMapNomenclatureUtf8(nomenclatureErreurType);
		
//		System.out.println("NOMENCLATURE MAP typeErreur: " 
//				+ mapNomenclature.toString());
		
		assertNotNull(
				"NOMENCLATURE MAP TypeErreur ne doit pas être null : "
					, mapNomenclature);
		
	} // Fin de testGetMapNomenclatureUtf8().______________________________

	
	
} // FIN DE LA CLASSE ConfigurationNomenclaturesAppliManagerTest.------------
