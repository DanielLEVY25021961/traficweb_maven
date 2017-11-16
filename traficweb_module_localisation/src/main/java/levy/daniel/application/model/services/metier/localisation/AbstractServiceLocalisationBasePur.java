package levy.daniel.application.model.services.metier.localisation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.metier.localisation.AbstractDaoLocalisationBasePur;
import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;
import levy.daniel.application.model.services.metier.AbstractServiceGenericSpring;


/**
 * class AbstractServiceLocalisationBasePur :<br/>
 * <ul>
 * <li>
 * SERVICE ABSTRAIT SPRING pour les 
 * <b>AbstractLocalisationBasePur</b>.
 * </li>
 * <li>
 * Comporte l'implémentation des méthodes <b>spécifiques</b> aux 
 * AbstractLocalisationBasePur.
 * </li>
 * <li>IMPLEMENTE L'INTERFACE IServiceLocalisationBasePur.</li>
 * <li>
 * HERITE DE LA CLASSE ABSTRAITE 
 * AbstractServiceGenericSpring&lt;AbstractLocalisationBasePur, Long&gt;.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_SERVICEs_1.png" 
 * alt="implémentation des SERVICEs" border="1" align="center" />
 * </li>
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
 * @author dan Lévy
 * @version 1.0
 * @since 7 nov. 2017
 *
 */
public abstract class AbstractServiceLocalisationBasePur 
	extends AbstractServiceGenericSpring<AbstractLocalisationBasePur, Long>
										implements IServiceLocalisationBasePur {

	// ************************ATTRIBUTS************************************/

	
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
	 * method CONSTRUCTEUR AbstractServiceLocalisationBasePur(
	 * IDaoGenericJPASpring&lt;AbstractLocalisationBasePur, Long&gt; pDao) :<br/>
	 * CONSTRUCTEUR AVEC DAO.<br/>
	 * <br/>
	 *
	 * @param pDao : IDaoGenericJPASpring&lt;AbstractLocalisationBasePur, Long&gt;.<br/>
	 */
	public AbstractServiceLocalisationBasePur(
			final AbstractDaoLocalisationBasePur  pDao) {
		
		super(pDao);
		
	} // Fin du CONSTRUCTEUR AVEC DAO._____________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractLocalisationBasePur retrieveByIdMetier(
			final AbstractLocalisationBasePur pObjet) {
		return null;
	} // Fin de retrieveByIdMetier(...).___________________________________



} // FIN DE LA CLASSE AbstractServiceLocalisationBasePur.--------------------
