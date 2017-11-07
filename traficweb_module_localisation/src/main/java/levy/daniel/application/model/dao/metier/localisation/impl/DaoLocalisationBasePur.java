package levy.daniel.application.model.dao.metier.localisation.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.metier.localisation.AbstractDaoLocalisationBasePur;


/**
 * class DaoLocalisationBasePur :<br/>
 * <ul>
 * <li>DAO pour les AbstractLocalisationBasePur.<br/></li>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DAOs.png" 
 * alt="implémentation des DAOs" border="1" align="center" />
 * </li>
 * </ul>
 * <br/>
 * 
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
@Repository("DaoLocalisationBasePur")
//@Qualifier("AbstractDaoLocalisationBasePur")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DaoLocalisationBasePur extends AbstractDaoLocalisationBasePur {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(DaoLocalisationBasePur.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR DaoLocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public DaoLocalisationBasePur() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
} // FIN DE LA CLASSE DaoLocalisationBasePur.--------------------------------
