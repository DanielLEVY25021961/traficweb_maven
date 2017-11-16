package levy.daniel.application.model.services.metier.localisation.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import levy.daniel.application.model.dao.metier.localisation.impl.DaoLocalisationBasePur;
import levy.daniel.application.model.services.metier.localisation.AbstractServiceLocalisationBasePur;

/**
 * class ServiceLocalisationBasePur :<br/>
 * <ul>
 * <li>SERVICE <b>CONCRET</b> pour les <b>AbstractLocalisationBasePur</b>.</li>
 * <li>
 * HERITE DU SERVICE ABSTRAIT AbstractServiceLocalisationBasePur.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_SERVICEs_1.png" 
 * alt="implémentation des SERVICEs" border="1" align="center" />
 * </li>
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
 * @since 7 nov. 2017
 *
 */
@Service(value="ServiceLocalisationBasePur")
public class ServiceLocalisationBasePur 
				extends AbstractServiceLocalisationBasePur {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_SERVICE_LOCALISATIONBASEPUR : String :<br/>
	 * "Classe ServiceLocalisationBasePur".<br/>
	 */
	public static final String CLASSE_SERVICE_LOCALISATIONBASEPUR 
		= "Classe ServiceLocalisationBasePur";
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ServiceLocalisationBasePur.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ServiceLocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ServiceLocalisationBasePur() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	 /**
	 * method CONSTRUCTEUR ServiceLocalisationBasePur(
	 * IDaoGenericJPASpring<AbstractLocalisationBasePur, Long> pDao) :<br/>
	 * CONSTRUCTEUR AVEC DAO.<br/>
	 * <br/>
	 *
	 * @param pDao : IDaoGenericJPASpring&lt;AbstractLocalisationBasePur, Long&gt;.<br/>
	 */
	@Autowired(required=true)
	public ServiceLocalisationBasePur(
			@Qualifier("DaoLocalisationBasePur")
				final DaoLocalisationBasePur pDao) {
		
		super(pDao);
		
	} // Fin du CONSTRUCTEUR AVEC DAO._____________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String founirNomClasse() {
		return CLASSE_SERVICE_LOCALISATIONBASEPUR;
	} // Fin de founirNomClasse()._________________________________________
	


} // FIN DE LA CLASSE ServiceLocalisationBasePur.----------------------------
