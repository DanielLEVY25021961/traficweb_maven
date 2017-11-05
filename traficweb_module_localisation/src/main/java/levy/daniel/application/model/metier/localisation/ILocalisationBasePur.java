package levy.daniel.application.model.metier.localisation;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * class ILocalisationBasePur :<br/>
 * INTERFACE factorisant tous les comportements 
 * des LocalisationPur.
 * <ul>
 * Garantit que tous les LocalisationPur :<br/>
 * <li>Connaitront leur identifiant en base id.</li>
 * <li>Connaitront leur route.</li>
 * <li>Connaitront éventuellement leur abscisse cumulée.</li>
 * <li>Connaitront leur cote (Chaussée I, D, ou G).</li>
 * <li>Pourront être <b>exportés</b> au format <b>csv</b>.</li>
 * <li>Pourront être affichés sous forme de <b>JTable</b>.</li>
 * </ul>
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
 * @author DAN Lévy
 * @version 1.0
 * @since 24 juin 2012
 *
 */
public interface ILocalisationBasePur 
			extends IExportateurCsv, IExportateurJTable {

	
	/**
	 * method compareTo(
	 * AbstractLocalisationBasePur pLoc) :<br/>
	 * Comparaison entre deux valueobject pour l'affichage.<br/>
	 * <br/>
	 * 1 - route.<br/>
	 * 2 - cumul.<br/>
	 * 3 - cote.<br/>
	 * <br/>
	 * Contrat Java : x.equals(y) ---> x.compareTo(y) == 0.<br/>
	 * <br/>
	 *
	 * @param pLoc : AbstractLocalisationBasePur.<br/>
	 * 
	 * @return int :<br/>
	 * - -1 si le présent valueobjet est "plus petit", 
	 * "au dessus" ou "avant" le comparé dans l'affichage d'une liste.<br/>
	 *  Par exemple, 'a avant b'
	 * ou '1 au dessus de 2' dans l'affichage.<br/>
	 * - 0 si ils sont au même niveau.<br/>
	 * - +1 si le comparé est "plus grand" ou "au dessous" ou "avant" le
	 * comparé dans l'afichage d'une liste.<br/>
	 */
	int compareTo(ILocalisationBasePur pLoc);
	
	

	/**
	 * method clone() :<br/>
	 * Clone.<br/>
	 * <br/>
	 *
	 * @return Object.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	Object clone() throws CloneNotSupportedException;

	
	
	/**
	 * method devance(
	 * ILocalisationBasePur pLocalisation) :<br/>
	 * <ul>
	 * Précise si la présente Localisation "devance" pLocalisation
	 * sur une même route (Abscisse cumulée plus petite).
	 * <li>retourne toujours false si pLocalisation est null.</li>
	 * <li>retourne toujours false si pLocalisation est 
	 * la présente Localisation.</li>
	 * <li>retourne toujours false si la route de la 
	 * présente Localisation est null.</li>
	 * <li>retourne toujours false si routes différentes.</li>
	 * <li>retourne toujours false si this.cumul == null.</li>
	 * <li>retourne toujours false si 
	 * pLocalisation.getCumul() == null.</li>
	 * </ul>
	 *
	 * @param pLocalisation : ILocalisationBasePur.<br/>
	 * 
	 * @return : boolean : true si la présente Localisation
	 * a une abscisse curviligne plus petite que pLocalisation
	 * sur une même route.<br/>
	 */
	boolean devance(
			ILocalisationBasePur pLocalisation);
	

	
	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();


	
	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	void setId(Long pId);


	
	/**
	 * method getRoute() :<br/>
	 * Getter de la Route de la localisation.<br/>
	 * <br/>
	 *
	 * @return route : String.<br/>
	 */	
	String getRoute();
	


	/**
	 * method setRoute(
	 * String pRoute) :<br/>
	 * Setter de la Route de la localisation.<br/>
	 * <br/>
	 *
	 * @param pRoute : String : valeur à passer à route.<br/>
	 */	
	void setRoute(String pRoute);
	

	
	/**
	 * method getCumul() :<br/>
	 * Getter de l'abscisse cumulée de la localisation.<br/>
	 * <br/>
	 *
	 * @return cumul : Float.<br/>
	 */
	Float getCumul();
	

	
	/**
	 * method setCumul(
	 * Float pCumul) :<br/>
	 * Setter de l'abscisse cumulée de la localisation.<br/>
	 * <br/>
	 *
	 * @param pCumul : Float.<br/>
	 */
	void setCumul(Float pCumul);


	
	/**
	 * method getCote() :<br/>
	 * Getter de la chaussée 
	 * (I pour indéfini, D pour Droit, G pour Gauche).<br/>
	 * <br/>
	 *
	 * @return cote : String.<br/>
	 */
	String getCote();
	

	
	/**
	 * method setCote(
	 * String pCote) :<br/>
	 * Setter de la chaussée 
	 * (I pour indéfini, D pour Droit, G pour Gauche).<br/>
	 * <br/>
	 *
	 * @param pCote : String : valeur à passer à cote.<br/>
	 */
	void setCote(String pCote);
	
	
	
} // FIN DE LA CLASSE ILocalisationBasePur.-------------------------------------
