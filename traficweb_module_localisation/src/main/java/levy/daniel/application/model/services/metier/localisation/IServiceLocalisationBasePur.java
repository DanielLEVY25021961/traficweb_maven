package levy.daniel.application.model.services.metier.localisation;

import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;
import levy.daniel.application.model.services.metier.IServiceGenericSpring;

/**
 * class IServiceLocalisationBasePur :<br/>
 * <ul>
 * <li>Interface des SERVICES pour les <b>AbstractLocalisationBasePur</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IServiceGenericSpring&lt;T, ID extends Serializable&gt;.
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
public interface IServiceLocalisationBasePur 
	extends IServiceGenericSpring<AbstractLocalisationBasePur, Long>{
	

	
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
	 */
	AbstractLocalisationBasePur 
		retrieveByIdMetier(AbstractLocalisationBasePur pObjet);



} // Fin de IServiceLocalisationBasePur.-------------------------------------
