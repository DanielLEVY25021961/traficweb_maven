package levy.daniel.application.model.dao.metier.localisation;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;

/**
 * class IDaoLocalisationBasePur :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>AbstractLocalisationBasePur</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux AbstractLocalisationBasePur
 * </li>
 * <li>
 * Définit en particulier la méthode de recherche 
 * par identifiant métier.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_DAOs.png" 
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
 * @since 6 nov. 2017
 *
 */
public interface IDaoLocalisationBasePur 
		extends IDaoGenericJPASpring<AbstractLocalisationBasePur, Long> {
	
	
	/**
	 * method retrieveByIdMetier(
	 * AbstractLocalisationBasePur pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un AbstractLocalisationBasePur pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne AbstractLocalisationBasePur trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : AbstractLocalisationBasePur : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : AbstractLocalisationBasePur : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	AbstractLocalisationBasePur 
		retrieveByIdMetier(AbstractLocalisationBasePur pObjet) 
				throws AbstractDaoException;



} // FIN DE L'INTERFACE IDaoLocalisationBasePur.-----------------------------
