package levy.daniel.application.model.dao.metier.localisation.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import levy.daniel.application.model.dao.metier.localisation.IDaoLocalisationBasePur;
import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;
import levy.daniel.application.model.metier.localisation.impl.LocalisationBasePur;


/**
 * class DaoLocalisationBasePurTest :<br/>
 * Test JUnit de la classe DaoLocalisationBasePur.<br/>
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
 * @since 13 nov. 2017
 *
 */
public class DaoLocalisationBasePurTest {

	// ************************ATTRIBUTS************************************/
	

	/**
	 * APPLICATIONCONTEXT_PATH : String :<br/>
	 * "classpath*:applicationContext.xml".<br/>
	 */
	private static final String APPLICATIONCONTEXT_PATH 
		= "classpath*:applicationContext.xml";

	
	/**
	 * SAUT_LIGNE : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE = '\n';
	
	
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
	


	public transient EntityManagerFactory entityManagerFactory;
	
	/**
	 * entityManager : javax.persistence.EntityManager :<br/>
	 * JPA EntityManager fourni par SPRING.<br/>
	 */
	protected transient EntityManager entityManager;

	/**
	 * dao : IDaoLocalisationBasePur :<br/>
	 * .<br/>
	 */
	protected transient IDaoLocalisationBasePur dao;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(DaoLocalisationBasePurTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR DaoLocalisationBasePurTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoLocalisationBasePurTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testCreate() :<br/>
	 * .<br/>
	 * <br/>
	 * :  :  .<br/>
	 */
	@Test
	public void testCreate() {
		
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************

		// ******************************************
		// Création de l'applicationCONTEXT SPRING 
		// avec lecture du fichier de configuration
		// applicationContext.xml.
		// ******************************************
		final AbstractApplicationContext context 
			= new ClassPathXmlApplicationContext(APPLICATIONCONTEXT_PATH);

		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			/* Affichage des Beans SPRING instanciés dans le Contexte. */
			final String affichageBeans = beansToString(context);
			
			System.out.println();
			System.out.println(TIRETS);
			System.out.println("BEANS INSTANCIES DANS LE CONTENEUR SPRING : ");
			System.out.println(TIRETS);
			System.out.println(affichageBeans);
			System.out.println(TIRETS);
			System.out.println();
			
		}

		this.dao = (IDaoLocalisationBasePur) 
				context.getBean("DaoLocalisationBasePur");
		
		final AbstractLocalisationBasePur objetNull = null;
		
		final AbstractLocalisationBasePur objet1 
			= new LocalisationBasePur("A0006", 5892.36F, "G", 0);
		
		final AbstractLocalisationBasePur objet2 
			= new LocalisationBasePur("A0006", 7888F, "G", 0);
		
		final AbstractLocalisationBasePur objet3 
			= new LocalisationBasePur("N0187", 36000F, "D", 0);
		
		final AbstractLocalisationBasePur objet4 
		= new LocalisationBasePur("N0186", 12000F, "I", 0);
		
		
		try {
			this.dao.create(objet1);
			this.dao.create(objetNull);
			this.dao.create(objet2);
			this.dao.create(objet3);
			this.dao.create(objet4);
		}
		catch (Exception jpaExc){
			System.out.println("JPA SYSTEM EXCEPTION : " + jpaExc.toString());
		}
		
	}
	
	
	
	/**
	 * method creer(
	 * AbstractLocalisationBasePur pObject) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pObject
	 * @return :  :  .<br/>
	 */
//	public static AbstractLocalisationBasePur creer(
//			final AbstractLocalisationBasePur pObject) {
//		
//		AbstractLocalisationBasePur objetPersistant = null;
//		
//		try {
//			objetPersistant = serviceLoc.create(pObject);
//		}
//		catch (JpaSystemException jpaExc){
//			System.out.println("APPLICATION AppSpring - "
//					+ "Méthode creer(AbstractLocalisationBasePur pObject) "
//					+ "- JPA SYSTEM EXCEPTION : " + jpaExc.toString());
//		}
//		catch (Exception exc) {
//			System.out.println("APPLICATION AppSpring - "
//					+ "Méthode creer(AbstractLocalisationBasePur pObject) "
//					+ "- EXCEPTION : " + exc.toString());
//		}
//		
//		return objetPersistant;
//		
//	} // Fin de creer(...).________________________________________________

	
	
	/**
	 * method beansToString(
	 * AbstractApplicationContext pContext) :<br/>
	 * <ul>
	 * <b>Crée et retourne une String</b> pour l'<i>affichage</i> 
	 * de la <b>liste des Beans SPRING</b> instanciés contenus dans le 
	 * contexte SPRING pContext.<br/>
	 * <li>retourne null si pContext == null.</li>
	 * </ul>
	 * <br/>
	 *
	 * @param pContext : AbstractApplicationContext : Context Spring.<br/>
	 * 
	 * @return : String : Liste des Beans instanciés contenus 
	 * dans le Context SPRING avec saut de ligne.<br/>
	 */
	public static String beansToString(
			final AbstractApplicationContext pContext) {
		
		/* retourne null si pContext == null. */
		if (pContext == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		/* Récupération du tableau de Beans 
		 * instanciés dans le conteneur SPRING. */
		final String[] tableauBeans = pContext.getBeanDefinitionNames();
		
		for (int i = 0; i < tableauBeans.length; i ++) {
			stb.append(tableauBeans[i]);
			stb.append(SAUT_LIGNE);
		}
		
		return stb.toString();
		
	} // Fin de beansToString(...).________________________________________

	



}
