package levy.daniel.application.model.metier.localisation.localisationlineaire.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import levy.daniel.application.model.metier.localisation.localisationlineaire.ILocalisationLineaire;

/**
 * class LocalisationPloTypePRTest :<br/>
 * <ul>
 * <li>Test JUnit de la classe LocalisationPloTypePR.</li>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 21 nov. 2017
 *
 */
public class LocalisationPloTypePRTest {

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
	private static final Log LOG 
		= LogFactory.getLog(LocalisationPloTypePRTest.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPloTypePRTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LocalisationPloTypePRTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method testEquals() :<br/>
	 * <ul>
	 * Teste la méthode <b>equals(Object pObj)</b> :
	 * <li>garantit le contrat Java reflexif x.equals(x).</li>
	 * <li>garantit le contrat Java symétrique 
	 * x.equals(y) ----> y.equals(x).</li>
	 * <li>garantit le contrat Java transitif 
	 * x.equals(y) et y.equals(z) ----> x.equals(z).</li>
	 * <li>garantit le contrat Java sur les hashcode 
	 * x.equals(y) ----> x.hashcode() == y.hashcode().</li>
	 * <li>garantit que les null sont bien gérés 
	 * dans equals(Object pObj).</li>
	 * <li>garantit que x.equals(null) retourne false 
	 * (avec x non null).</li>
	 * <li>garantit le bon fonctionnement de equals() 
	 * en cas d'égalité métier.</li>
	 * <li>garantit le bon fonctionnement de equals() 
	 * en cas d'inégalité métier.</li>
	 * </ul>
	 */
	@Test
	public void testEquals() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objet1 
		= new LocalisationPloTypePR(2L, "A0006", 5896F, "D", null, "73PR7DC", 785F);
		
		final ILocalisationLineaire objet2 
		= new LocalisationPloTypePR(3L, "A0006", 5896F, "D", null, "73PR7DC", 785F);
		
		final ILocalisationLineaire objet3 
		= new LocalisationPloTypePR(4L, "A0006", 5896F, "D", null, "73PR7DC", 785F);

		
		/* garantit le contrat Java reflexif x.equals(x). */
		assertTrue("x.equals(x) : "
				, objet1.equals(objet1));
				
		/* garantit le contrat Java symétrique 
		 * x.equals(y) ----> y.equals(x). */
		assertEquals("objet1.equals(objet2) : "
				, objet2
					, objet1);
		
		/* garantit le contrat Java transitif 
		 * x.equals(y) et y.equals(z) ----> x.equals(z). */
		assertEquals("objet1.equals(objet2) : ", objet1, objet2);
		assertEquals("objet2.equals(objet3) : ", objet2, objet3);
		assertEquals("objet1.equals(objet3) : ", objet1, objet3);
		
		/* garantit le contrat Java sur les hashcode 
		 * x.equals(y) ----> x.hashcode() == y.hashcode(). */
		assertEquals("objet1.hashCode().equals(objet2.hashCode()) : "
				, objet1.hashCode()
					, objet2.hashCode());

				
		/* garantit que les null sont bien gérés dans equals(...). */
		final ILocalisationLineaire objetNull1 
			= new LocalisationPloTypePR();
		final ILocalisationLineaire objetNull2 
			= new LocalisationPloTypePR();

		assertEquals("objetNull1.equals(objetNull2) : "
				, objetNull1
					, objetNull2);
		assertEquals("objetNull1.hashCode().equals(objetNull2.hashCode()) : "
				, objetNull1.hashCode()
					, objetNull2.hashCode());

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJETNULL1 : " 
					+ objetNull1.toString());
			System.out.println("OBJETNULL2 : " 
					+ objetNull2.toString());
		}
		
		final ILocalisationLineaire objet1AvecNull 
			= new LocalisationPloTypePR(2L, null, null, "D", null, null, null);
		
		final ILocalisationLineaire objet2AvecNull 
			= new LocalisationPloTypePR(3L, null, null, "D", null, null, null);

		assertEquals("objet1AvecNull.equals(objet2AvecNull) : "
				, objet1AvecNull
					, objet2AvecNull);
		assertEquals("objet1AvecNull.hashCode()"
				+ ".equals(objet2AvecNull.hashCode()) : "
				, objet1AvecNull.hashCode()
					, objet2AvecNull.hashCode());

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJET1AVECNULL : " 
					+ objet1AvecNull.toString());
			System.out.println("OBJET2AVECNULL : " 
					+ objet2AvecNull.toString());
		}

		
		/* garantit que x.equals(null) retourne false (avec x non null). */
		assertFalse("objet1 pas equals(null) : "
				, objet1.equals(null));
				
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'égalité métier. */
		assertEquals("objet1.equals(objet2) : "
				, objet1
					, objet2);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJET1 : " 
					+ objet1.toString());
			System.out.println("OBJET2 : " 
					+ objet2.toString());
		}

		
		/* garantit le bon fonctionnement de equals() 
		 * en cas d'inégalité métier. */
		final ILocalisationLineaire objetDiff1 
			= new LocalisationPloTypePR(2L, "A0006", 5896F, "D", 1, "75PR5D", 563.21F);
		
		final ILocalisationLineaire objetDiff2 
			= new LocalisationPloTypePR(3L, "A0087", 5896F, "D", 2, "75PR5D", 563.21F);
		
		assertFalse("objetDiff1 PAS equals(objetDiff2) : "
				, objetDiff1.equals(objetDiff2));
		assertFalse("objetDiff1.hashCode() "
				+ "PAS equals(objetDiff2.hashCode()) : "
				, objetDiff1.hashCode() == objetDiff2.hashCode());
		

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("OBJETDIFF1 : " 
					+ objetDiff1.toString());
			System.out.println("OBJETDIFF2 : " 
					+ objetDiff2.toString());
		}
		
	} // Fin de testEquals().______________________________________________

	

	/**
	 * method testCompareTo() :<br/>
	 * <ul>
	 * Teste la méthode <b>compareTo(ILocalisationLineaire pLoc)</b> :
	 * <li>garantit que compareTo(memeInstance) retourne 0.</li>
	 * <li>garantit que compareTo(null) retourne un nombre négatif.</li>
	 * <li>garantit le contrat Java Contrat Java : 
	 * x.equals(y) ---> x.compareTo(y) == 0.</li>
	 * <li>garantit que les null sont bien gérés 
	 * dans compareTo(ILocalisationLineaire pLoc).</li>
	 * <li>garantit le bon fonctionnement (bon ordre) de compareTo().</li>
	 * </ul>
	 */
	@Test
	public void testCompareTo() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(2L, "A0006", 5896F, "D", 1, "73PR7DC", 785F);
		
		final ILocalisationLineaire objet1MemeInstance = objet1;
		
		final ILocalisationLineaire objetEquals1 
			= new LocalisationPloTypePR(10L, "N0221", 5896.23F, "G", 2, "37PR88GC", 78.20F);
		
		final ILocalisationLineaire objetEquals2 
			= new LocalisationPloTypePR(11L, "N0221", 5896.23F, "G", 2, "37PR88GC", 78.20F);

		final ILocalisationLineaire objetNull1 
		= new LocalisationPloTypePR();
	
		final ILocalisationLineaire objetNull2 
			= new LocalisationPloTypePR();
				
		final ILocalisationLineaire objetCompAvant1 
			= new LocalisationPloTypePR(3L, "A0006", null, "D", 3, "01PR88D", 78.20F);

		final ILocalisationLineaire objetCompApres2 
			= new LocalisationPloTypePR(3L, "A0006", null, "D", 3, "37PR88D", 78.20F);

	
		/* garantit que compareTo(memeInstance) retourne 0. */		
		final int compareMemeInstance 
			= objet1.compareTo(objet1MemeInstance);
		
		assertTrue("compareTo(memeInstance) doit retourner 0 : "
				, compareMemeInstance == 0);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO() DE LA MEME INSTANCE : " 
					+ compareMemeInstance);
		}
		
		/* garantit que compareTo(null) retourne -1. */
		final int compareToNull = objet1.compareTo(null);
		
		assertTrue("compareTo(null) doit retourner négatif : "
				, compareToNull < 0);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(null)  : " 
					+ compareToNull);
		}
		
		/* garantit le contrat Java Contrat Java : 
		 * x.equals(y) ---> x.compareTo(y) == 0. */		
		final int compareToEquals = objetEquals1.compareTo(objetEquals2);

		assertTrue("Instance.compareTo(equalsInstance) doit retourner 0 : "
				, compareToEquals == 0);
		assertTrue("loc10.hashCode() == loc11.hashCode() : "
				, objetEquals1.hashCode() == objetEquals2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(equalsInstance)  : " 
					+ compareToEquals);
		}
		
		
		/* garantit que les null sont bien gérés dans 
		 * compareTo(ILocalisationLineaire pLoc). */		
		final int compareToEqualsNull = objetNull1.compareTo(objetNull2);
		
		assertTrue("InstanceNull.compareTo(equalsInstanceNull) doit retourner 0 : "
				, compareToEqualsNull == 0);
		assertTrue("locNull10.hashCode() == locNull11.hashCode() : "
				, objetNull1.hashCode() == objetNull2.hashCode());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(equalsInstanceNull)  : " 
					+ compareToEqualsNull);
		}

		
		/* garantit le bon fonctionnement (bon ordre) de compareTo(). */		
		final int compare = objetCompAvant1.compareTo(objetCompApres2);
		
		assertTrue("objetCompAvant1 doit être avant objetCompApres2 : "
				, compare < 0);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("COMPARETO(existant)  : " 
					+ compare);
		}
		
	} // Fin de testCompareTo().___________________________________________
	

	
	/**
	 * method testClone() :<br/>
	 * <ul>
	 * Teste la méthode <b>clone()</b> :
	 * <li>garantit que les null sont bien gérés dans clone().</li>
	 * <li>garantit que clonex.equals(x).</li>
	 * <li>garantit que x et son clone ne sont pas la même instance.</li>
	 * </ul>
	 * @throws CloneNotSupportedException 
	 */
	@Test
	public void testClone() throws CloneNotSupportedException {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		final ILocalisationLineaire objetNull1 
			= new LocalisationPloTypePR();
		
		final ILocalisationLineaire objetNullClone1 
			= (ILocalisationLineaire) objetNull1.clone();
		
		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(23L, "N0844", 5698.36F, "G", null, "73PR7G", 785F);
		
		final ILocalisationLineaire objetClone1 
		= (ILocalisationLineaire) objet1.clone();
		
		
		/* garantit que les null sont bien gérés dans clone(). */
		assertEquals("objetNull1.equals(objetNullClone1) : "
				, objetNull1
					, objetNullClone1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("objetNull1 : " 
					+ objetNull1.toString());
			System.out.println("objetNullClone1 : " 
					+ objetNullClone1.toString());
		}
		
		/* garantit que clonex.equals(x). */
		assertEquals("clonex.equals(x) : "
				, objet1
					, objetClone1);
		
		/* garantit que x et son clone ne sont pas la même instance. */
		assertFalse("x != clonex : "
				, objet1 == objetClone1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("objet1 : " 
					+ objet1.toString());
			System.out.println("objetClone1 : " 
					+ objetClone1.toString());
		}

	} // Fin de testClone()._______________________________________________
	
	
	
	/**
	 * method testToString() :<br/>
	 * <ul>
	 * Teste la méthode <b>toString()</b> :
	 * <li>garantit que les null sont bien gérés dans toString().</li>
	 * <li>garantit le bon affichage de toString().</li>
	 * </ul>
	 */
	@Test
	public void testToString() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objetNull 
			= new LocalisationPloTypePR();
		
		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(2L, "A0006", 5896F, "D", 1, "77PR25D", 412.36F);

		
		/* garantit que les null sont bien gérés dans toString(). */
		assertEquals("objetNull.toString() retourne une chaine : "
				, "[id : null - route : null - cumul : null - cote : null - voie : null - plo : null - abscisse : null]"
						, objetNull.toString());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(objetNull.toString());
		}
		
		/* garantit le bon affichage de toString(). */
		assertEquals("affichage : "
				, "[id : 2 - route : A0006 - cumul : 5896.0 - cote : D - voie : 1 - plo : 77PR25D - abscisse : 412.36]"
						, objet1.toString());
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println(objet1.toString());
		}
		
	} // Fin de testToString().____________________________________________


	
	/**
	 * method testgetEnTeteCsv() :<br/>
	 * <ul>
	 * Teste la méthode <b>getEnTeteCsv()</b> :
	 * <li>garantit que getEnTeteCsv() retourne le bon en-tête csv.</li>
	 * </ul>
	 */
	@Test
	public void testgetEnTeteCsv() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(2L, "A0006", 5896F, "D", null, "77PR2DC", 0F);

		/* garantit que getEnTeteCsv() retourne le bon en-tête csv. */
		final String entete = objet1.getEnTeteCsv();
		
		assertEquals("en-tête csv : "
				, "id;route;cumul;cote;voie;plo;abs;"
					, entete);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println(entete);
		}
		
	} // Fin de testgetEnTeteCsv().________________________________________
	

	
	/**
	 * method testToStringCsv() :<br/>
	 * <ul>
	 * Teste la méthode <b>toStringCsv()</b> :
	 * <li>garantit que les null sont gérés dans toStringCsv().</li> 
	 * <li>garantit que toStringCsv() retourne la bonne ligne csv.</li>
	 * </ul>
	 */
	@Test
	public void testToStringCsv() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objetNull 
		= new LocalisationPloTypePR();
	
		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(27L, "N0186", 5896.36F, "G", null, "77PR12G", 0F);
		
		/* garantit que les null sont gérés dans toStringCsv(). */
		final String ligneCsvNull = objetNull.toStringCsv();
						
		assertEquals("ligne csv null : "
				, "null;null;null;null;null;null;null;"
					, ligneCsvNull);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println(ligneCsvNull);
		}
						
		/* garantit que toStringCsv() retourne la bonne ligne csv. */
		final String ligneCsv = objet1.toStringCsv();
		
		assertEquals("ligne csv : "
				, "27;N0186;5896.36;G;null;77PR12G;0.0;"
					, ligneCsv);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println(ligneCsv);
		}
		
	} // Fin de testToStringCsv()._________________________________________
	

	
	/**
	 * method testGetEnTeteColonne() :<br/>
	 * <ul>
	 * Teste la méthode <b>getEnTeteColonne(int pI)</b> :
	 * <li>garantit que les null sont gérés dans 
	 * getEnTeteColonne(int pI).</li> 
	 * <li>garantit que getEnTeteColonne(int pI) retourne 
	 * la bonne en-tête de colonne.</li>
	 * </ul>
	 */
	@Test
	public void testGetEnTeteColonne() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objetNull 
		= new LocalisationPloTypePR();
	
		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(27L, "N0186", 5896.36F, "G", null, "77PR2G", 0F);
		
		/* garantit que les null sont gérés 
		 * dans getEnTeteColonne(int pI). */
		final String entete0 = objet1.getEnTeteColonne(0);
		final String enteteNull0 = objetNull.getEnTeteColonne(0);
		
		/* garantit que getEnTeteColonne(int pI) retourne 
		 * la bonne en-tête de colonne. */
		final String entete1 = objet1.getEnTeteColonne(1);
		final String enteteNull1 = objetNull.getEnTeteColonne(1);
		
		assertEquals("entete0 : ", "id", entete0);
		assertEquals("enteteNull0 : ", "id", enteteNull0);
		
		assertEquals("entete1 : ", "route", entete1);
		assertEquals("enteteNull1 : ", "route", enteteNull1);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println("entete0 : " + entete0);
			System.out.println("enteteNull0 : " + enteteNull0);
			
			System.out.println("entete1 : " + entete1);
			System.out.println("enteteNull1 : " + enteteNull1);
		}

	} // Fin de testGetEnTeteColonne().____________________________________
	

	
	/**
	 * method testGetValeurColonne() :<br/>
	 * <ul>
	 * Teste la méthode <b>getValeurColonne(int pI)</b> :
	 * <li>garantit que les null sont gérés dans 
	 * getValeurColonne(int pI).</li> 
	 * <li>garantit que getValeurColonne(int pI) retourne 
	 * la bonne valeur de colonne.</li>
	 * </ul>
	 */
	@Test
	public void testGetValeurColonne() {

		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objetNull 
		= new LocalisationPloTypePR();
	
		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(27L, "N0186", 5896.36F, "G", 2, "77PR2GC", 0F);
		
		/* garantit que les null sont gérés 
		 * dans getValeurColonne(int pI). */
		final String valeurNull0 = (String) objetNull.getValeurColonne(0);
		final String valeurNull1 = (String) objetNull.getValeurColonne(1);
		final String valeurNull2 = (String) objetNull.getValeurColonne(2);
		final String valeurNull3 = (String) objetNull.getValeurColonne(3);
		final String valeurNull4 = (String) objetNull.getValeurColonne(4);
		final String valeurNull5 = (String) objetNull.getValeurColonne(5);
		final String valeurNull6 = (String) objetNull.getValeurColonne(6);
		
		assertEquals("valeurNull0 : ", null, valeurNull0);
		assertEquals("valeurNull1 : ", null, valeurNull1);
		assertEquals("valeurNull2 : ", null, valeurNull2);
		assertEquals("valeurNull3 : ", null, valeurNull3);
		assertEquals("valeurNull4 : ", null, valeurNull4);
		assertEquals("valeurNull5 : ", null, valeurNull5);
		assertEquals("valeurNull6 : ", null, valeurNull6);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println("valeurNull0 : " + valeurNull0);
			System.out.println("valeurNull1 : " + valeurNull1);			
			System.out.println("valeurNull2 : " + valeurNull2);
			System.out.println("valeurNull3 : " + valeurNull3);
			System.out.println("valeurNull4 : " + valeurNull4);
			System.out.println("valeurNull5 : " + valeurNull5);
			System.out.println("valeurNull6 : " + valeurNull6);
		}

		
		/* garantit que getValeurColonne(int pI) retourne 
		 * la bonne en-tête de colonne. */
		final String valeur0 = (String) objet1.getValeurColonne(0);
		final String valeur1 = (String) objet1.getValeurColonne(1);		
		final String valeur2 = (String) objet1.getValeurColonne(2);
		final String valeur3 = (String) objet1.getValeurColonne(3);
		final String valeur4 = (String) objet1.getValeurColonne(4);
		final String valeur5 = (String) objet1.getValeurColonne(5);
		final String valeur6 = (String) objet1.getValeurColonne(6);
		
		assertEquals("valeur0 : ", "27", valeur0);		
		assertEquals("valeur1 : ", "N0186", valeur1);
		assertEquals("valeur2 : ", "5896.36", valeur2);
		assertEquals("valeur3 : ", "G", valeur3);
		assertEquals("valeur4 : ", "2", valeur4);
		assertEquals("valeur5 : ", "77PR2GC", valeur5);
		assertEquals("valeur6 : ", "0.0", valeur6);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println("valeur0 : " + valeur0);
			System.out.println("valeur1 : " + valeur1);			
			System.out.println("valeur2 : " + valeur2);
			System.out.println("valeur3 : " + valeur3);
			System.out.println("valeur4 : " + valeur4);
			System.out.println("valeur5 : " + valeur5);
			System.out.println("valeur6 : " + valeur6);
		}

	} // Fin de testGetValeurColonne().____________________________________
	

	
	/**
	 * method testDevance() :<br/>
	 * <ul>
	 * Teste la méthode <b>devance(ILocalisationLineaire pLocalisation)</b> :
	 * <li>garantit que x.devance(null) retourne toujours false.</li> 
	 * <li>garantit que x.devance(x) retourne toujours false.</li>
	 * <li>garantit que x(sans route).devance(y) retourne toujours false.</li>
	 * <li>garantit que x(avec route sans cote).devance(y) retourne toujours false.</li>
	 * <li>garantit que x.devance(y(autreRoute)) retourne toujours false.</li>
	 * <li>garantit que x.devance(y(autreCote)) retourne toujours false.</li>
	 * <li>garantit le traitement des null dans 
	 * devance(ILocalisationLineaire pLocalisation).</li>
	 * <li>garantit le bon fonctionnement de 
	 * devance(ILocalisationLineaire pLocalisation).</li>
	 * </ul>
	 */
	@Test
	public void testDevance() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************

		final ILocalisationLineaire objet1 
			= new LocalisationPloTypePR(27L, "N0186", 5896.36F, "G", null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objetSansRoute1 
			= new LocalisationPloTypePR(27L, null, 5896.36F, "G", null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objetAvecRouteSansCote1 
			= new LocalisationPloTypePR(27L, "N0186", 5896.36F, null, null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objet2 
			= new LocalisationPloTypePR(27L, "N0186", 8888.88F, "G", null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objet3 
			= new LocalisationPloTypePR(27L, "N0186", 1000F, "G", null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objetRouteDiff 
			= new LocalisationPloTypePR(27L, "A0186", 8888.88F, "G", null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objetCoteDiff 
			= new LocalisationPloTypePR(27L, "A0186", 8888.88F, "D", null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objetCumulNull1 
			= new LocalisationPloTypePR(27L, "N0186", null, "G", null, "73PR7GC", 0F);
		
		final ILocalisationLineaire objetCumulNull2 
			= new LocalisationPloTypePR(27L, "N0186", null, "G", null, "73PR7GC", 0F);
		
		
		/* garantit que x.devance(null) retourne toujours false. */
		assertFalse("x.devance(null) doit être false : "
				, objet1.devance(null));
		
		/* garantit que x.devance(x) retourne toujours false. */
		assertFalse("x.devance(x) doit retourner false : "
				, objet1.devance(objet1));
		
		/* garantit que x(sans route).devance(y) 
		 * retourne toujours false. */
		assertFalse("x(sans route) devance(y) doit retourner false : "
				, objetSansRoute1.devance(objet2));
		
		/* garantit que x(avec route sans cote).devance(y) 
		 * retourne toujours false.*/
		assertFalse("x(avec route sans cote).devance(y) doit retourner false ; "
				, objetAvecRouteSansCote1.devance(objet2));
		
		/* garantit que x.devance(y(autreRoute)) 
		 * retourne toujours false.*/
		assertFalse("x.devance(y(autreRoute)) doit retourner false : "
				, objet1.devance(objetRouteDiff));
		
		/* garantit que x.devance(y(autreCote)) retourne toujours false.*/
		assertFalse("x.devance(y(memeRouteAutreCote)) doit retourner false : "
				, objet1.devance(objetCoteDiff));
		
		/* garantit le traitement des null dans 
		 * devance(ILocalisationLineaire pLocalisation). */
		final boolean compCumulNull1 
			= objetCumulNull1.devance(objetCumulNull2);
		
		final boolean compCumulNull2 
			= objet1.devance(objetCumulNull2);
		
		assertFalse("x(cumul null).devance(y(cumul null)) doit retourner false : "
				, compCumulNull1);
		
		assertFalse("x(cumul non null).devance(y(cumul null)) doit retourner false : "
				, compCumulNull2);
		
		/* garantit le bon fonctionnement de devance(ILocalisationLineaire pLocalisation). */
		final boolean compObjet1Objet2 = objet1.devance(objet2);
		final boolean compObjet3Objet1 = objet3.devance(objet1);
		final boolean compObjet1Objet3 = objet1.devance(objet3);
		
		assertTrue("objet1 devance objet2 : "
				, compObjet1Objet2);
		assertTrue("objet3 devance objet1"
				, compObjet3Objet1);
		assertFalse("objet1 devance objet3 : "
				, compObjet1Objet3);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {			
			System.out.println("objet1 devance objet2 ? : " 
					+ compObjet1Objet2);
			System.out.println("objet3 devance objet1 ? : " 
					+ compObjet3Objet1);
			System.out.println("objet1 devance objet3 ? : " 
					+ compObjet1Objet3);
		}

	} // Fin de testDevance()._____________________________________________
	
	

} // FIN DE LA CLASSE LocalisationPloTypePRTest.-----------------------------
