package levy.daniel.application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import levy.daniel.application.model.metier.localisation.impl.LocalisationBasePur;
import levy.daniel.application.model.services.metier.localisation.impl.ServiceLocalisationBasePur;



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
		final ServiceLocalisationBasePur serviceLocalisationBasePur 
			= context.getBean(ServiceLocalisationBasePur.class);

		final LocalisationBasePur objetNull = null;
		
		final LocalisationBasePur objet1 
			= new LocalisationBasePur("A0006", 5892.36F, "G");
		
		final LocalisationBasePur objet2 
			= new LocalisationBasePur("A0006", 7888F, "G");
		
		final LocalisationBasePur objet3 
		= new LocalisationBasePur("N0187", 36000F, "D");
		
		
		
		
			
		serviceLocalisationBasePur.create(objetNull);
		serviceLocalisationBasePur.create(objet1);
		serviceLocalisationBasePur.create(objet2);
		serviceLocalisationBasePur.create(objet3);
		

		
		/* Clôture du contexte, sinon, fuite de mémoire. */
		context.close();
							
	} // Fin de main(...)._________________________________________________
	
	

} // FIN DE LA CLASSE AppSpring.---------------------------------------------
