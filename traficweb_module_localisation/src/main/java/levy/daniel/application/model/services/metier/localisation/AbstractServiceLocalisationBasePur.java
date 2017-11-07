package levy.daniel.application.model.services.metier.localisation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;
import levy.daniel.application.model.services.metier.AbstractServiceGenericSpring;


/**
 * class AbstractServiceLocalisationBasePur :<br/>
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
 * @since 7 nov. 2017
 *
 */
@Service("AbstractServiceLocalisationBasePur")
//@Qualifier("AbstractServiceGenericSpring")
public abstract class AbstractServiceLocalisationBasePur 
	extends AbstractServiceGenericSpring<AbstractLocalisationBasePur, Long>
										implements IServiceLocalisationBasePur {

	// ************************ATTRIBUTS************************************/

	/**
	 * dao : AbstractDaoGenericJPASpring<T,Serializable> :<br/>
	 * DAO pour le service.<br/>
	 */
//	@Autowired(required=true)
//	@Qualifier("DaoLocalisationBasePur")
//	protected AbstractDaoLocalisationBasePur dao;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractServiceLocalisationBasePur.class);


	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractServiceLocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractServiceLocalisationBasePur() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractLocalisationBasePur retrieveByIdMetier(
			final AbstractLocalisationBasePur pObjet) {

		return null;
	} // Fin de retrieveByIdMetier(...).___________________________________
	


} // FIN DE LA CLASSE AbstractServiceLocalisationBasePur.--------------------
