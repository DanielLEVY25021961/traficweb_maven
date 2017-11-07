package levy.daniel.application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaSystemException;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;
import levy.daniel.application.model.metier.localisation.impl.LocalisationBasePur;
import levy.daniel.application.model.services.metier.localisation.impl.ServiceConcret;



/**
 * class AppSpring :<br/>
 * Lanceur de l'application SPRING avec parametrage 
 * de SPRING par un fichier XML
 * (applicationContext.xml).
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
 * @author oric
 * @version 1.0
 * @since 17 oct. 2017
 *
 */
public final class AppSpring {

	// ************************ATTRIBUTS************************************/

	/**
	 * APPLICATIONCONTEXT_PATH : String :<br/>
	 * "classpath*:applicationContext.xml".<br/>
	 */
	private static final String APPLICATIONCONTEXT_PATH 
		= "classpath*:applicationContext.xml";

	
	/**
	 * serviceConcret : ServiceConcret :<br/>
	 * .<br/>
	 */
	private static transient ServiceConcret serviceConcret;

	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR AppSpring() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private AppSpring() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/**
	 * method main(
	 * String[] pArgs) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pArgs : String[] :  .<br/>
	 */
	public static void main(final String[] pArgs) {

		// Création de l'applicationContext SPRING 
		// avec le fichier de configuration
		// applicationContext.xml.
		final AbstractApplicationContext context 
			= new ClassPathXmlApplicationContext(APPLICATIONCONTEXT_PATH);

		/* Obtention du bean DaoLocalisationBasePur. */
		serviceConcret 
			= context.getBean(ServiceConcret.class);
		
		final String serviceConcretClassName = serviceConcret.getClass().getName();
		
		System.out.println("PROXY : " + serviceConcretClassName);

		final AbstractLocalisationBasePur objetNull = null;
		
		final AbstractLocalisationBasePur objet1 
			= new LocalisationBasePur("A0006", 5892.36F, "G");
		
		final AbstractLocalisationBasePur objet2 
			= new LocalisationBasePur("A0006", 7888F, "G");
		
		final AbstractLocalisationBasePur objet3 
			= new LocalisationBasePur("N0187", 36000F, "D");
		
		final AbstractLocalisationBasePur objet4 
		= new LocalisationBasePur("N0186", 12000F, "I");

							
//		serviceConcret.create(objetNull);
		
//		try {
//			serviceConcret.create(objet1);
//		}
//		catch (JpaSystemException jpaExc){
//			System.out.println("JPA SYSTEM EXCEPTION : " + jpaExc.toString());
//		}
//		
//		try {
//			serviceConcret.create(objet2);
//		}
//		catch (JpaSystemException jpaExc){
//			System.out.println("JPA SYSTEM EXCEPTION : " + jpaExc.toString());
//		}
//		
//		try {
//			serviceConcret.create(objet3);
//		}
//		catch (JpaSystemException jpaExc){
//			System.out.println("JPA SYSTEM EXCEPTION : " + jpaExc.toString());
//		}
//
//		
//		try {
//			serviceConcret.create(objet4);
//		}
//		catch (JpaSystemException jpaExc){
//			System.out.println("JPA SYSTEM EXCEPTION : " + jpaExc.toString());
//		}
		
		creer(objetNull);
		creer(objet1);
		creer(objet2);
		creer(objet3);
		creer(objet4);
		
		/* Clôture du contexte, sinon, fuite de mémoire. */
		context.close();
							
	} // Fin de main(...)._________________________________________________
	
	
	
	/**
	 * method creer() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pObject
	 * @return :  :  .<br/>
	 */
	public static AbstractLocalisationBasePur creer(AbstractLocalisationBasePur pObject) {
		
		AbstractLocalisationBasePur objetPersistant = null;
		
		try {
			objetPersistant = serviceConcret.create(pObject);
		}
		catch (JpaSystemException jpaExc){
			System.out.println("APPLICATION - JPA SYSTEM EXCEPTION : " + jpaExc.toString());
		}
		catch (AbstractDaoException daoExc) {
			System.out.println("APPLICATION - ABSTRACT_DAO EXCEPTION : " + daoExc.getMessageUtilisateur());
		}
		catch (Exception exc) {
			System.out.println("APPLICATION - EXCEPTION : " + exc.toString());
		}
		
		return objetPersistant;
	}

	
	
} // FIN DE LA CLASSE AppSpring.---------------------------------------------
