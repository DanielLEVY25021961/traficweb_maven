package levy.daniel.application.model.metier.localisation.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import static org.junit.Assert.*;

import levy.daniel.application.model.metier.localisation.ILocalisationBasePur;


/**
 * class LocalisationBasePurTest :<br/>
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
 * @since 5 nov. 2017
 *
 */
public class LocalisationBasePurTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LocalisationBasePurTest.class);


	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePurTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LocalisationBasePurTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testToString() :<br/>
	 * <ul>
	 * Teste la méthode toString() :
	 * <li>garantit que locNull.toString() retourne 
	 * [id : null - route : null - cumul : null - cote : null].</li>
	 * </ul>
	 */
	@Test
	public void testToString() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		final ILocalisationBasePur locNull = new LocalisationBasePur();

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(locNull.toString());
		}
		
		/* garantit que locNull.toString() retourne [id : null - route : null - cumul : null - cote : null]. */
		assertEquals("locNull.toString() retourne une chaine : "
				, "[id : null - route : null - cumul : null - cote : null]"
						, locNull.toString());
		
	} // Fin de testToString().____________________________________________


} // FIN DE LA CLASSE LocalisationBasePurTest.-------------------------------
