package levy.daniel.application.model.services.metier.localisation;

import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;

/**
 * class IServiceLocalisationBasePur :<br/>
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
public interface IServiceLocalisationBasePur {
	

	
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
