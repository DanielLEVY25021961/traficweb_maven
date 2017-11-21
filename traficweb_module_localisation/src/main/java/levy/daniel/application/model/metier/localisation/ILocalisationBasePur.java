package levy.daniel.application.model.metier.localisation;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * INTERFACE ILocalisationBasePur :<br/>
 * INTERFACE factorisant tous les comportements 
 * des LocalisationBasePur.
 * <ul>
 * <li>Un <b>même</b> point routier peut être localisé selon les 3 modes suivants : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/modes_localisation.png" 
 * alt="les 3 modes de localisation" border="1" align="center" />
 * </li>
 * <br/>
 * <li>
 * On peut <b>factoriser</b> ces 3 modes de localisation en faisant 
 * apparaitre le concept de <b>LocalisationBasePur</b> 
 * [route + cumul + cote + voie] : 
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/modes_localisation_factorises.png" 
 * alt="les 3 modes de localisation" border="1" align="center" />
 * </li>
 * <br/>
 * </ul>
 * <br/>
 * <ul>
 * L' INTERFACE ILocalisationBasePur garantit que tous les LocalisationBasePur :<br/>
 * <li>Connaitront leur identifiant en base <b>id</b>.</li>
 * <li>Connaitront leur <b>route</b>.</li>
 * <li>Connaitront <i>éventuellement</i> leur abscisse cumulée <b>cumul</b>.</li>
 * <li>Connaitront leur <b>cote</b> 
 * (Chaussée "I", "D", ou "G", "I" pour un côté indéterminé).</li>
 * <li>Connaitront leur <b>voie</b> (100 pour une voie indéterminée).</li>
 * <li>Implémenteront un Comparator.<br/>
 * <li>Pourront être clonés.</li>
 * <li>sauront si une Localisation sur la même route 
 * avec la même latéralisation (cote + voie) précède la présente.</li>
 * <li>Pourront être <b>exportés</b> au format <b>csv</b>.</li>
 * <li>Pourront être affichés sous forme de <b>JTable</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/localisation_pures.png" 
 * alt="Localisations pures" border="1" align="center" />
 * </li>
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
	 * <b>Précise si la présente Localisation "devance" pLocalisation
	 * sur une même route (Abscisse cumulée plus petite 
	 * sur une <i>même route</i>, un <i>même côté</i> 
	 * et une <i>même voie</i>).</b>
	 * <li>retourne toujours false si pLocalisation est null.</li>
	 * <li>retourne toujours false si pLocalisation est 
	 * la présente Localisation.</li>
	 * <li>retourne toujours false si la route de la 
	 * présente Localisation ou de pLocalisation est null.</li>
	 * <li>retourne toujours false si le côté de la route de la 
	 * présente Localisation ou de pLocalisation est null.</li>
	 * <li>retourne false si la voie d'une des Localisation 
	 * est null et pas la voie de l'autre.</li>
	 * <li>retourne toujours false si routes différentes 
	 * , côtés différents ou voies différentes (MEME LATERALISATION).</li>
	 * <li>retourne toujours false si this.cumul == null.</li>
	 * <li>retourne toujours false si 
	 * pLocalisation.getCumul() == null.</li>
	 * </ul>
	 *
	 * @param pLocalisation : ILocalisationBasePur.<br/>
	 * 
	 * @return : boolean : true si la présente Localisation
	 * a une abscisse curviligne plus petite que pLocalisation
	 * sur une même route avec une même latéralisation 
	 * (cote + voie).<br/>
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
	 * @param pRoute : String : 
	 * valeur à passer à route.<br/>
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
	 * @param pCumul : Float : 
	 * valeur à passer à this.cumul.<br/>
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
	
	
	
	/**
	 * method getVoie() :<br/>
	 * Getter de la Voie de la localisation 
	 * (1 pour la première voie à droite dans le sens de la route).<br/>
	 * <br/>
	 *
	 * @return voie : Integer.<br/>
	 */
	Integer getVoie();


	
	/**
	* method setVoie(
	* Integer pVoie) :<br/>
	* Setter de la Voie de la localisation 
	 * (1 pour la première voie à droite dans le sens de la route).<br/>
	* <br/>
	*
	* @param pVoie : Integer : valeur à passer à voie.<br/>
	*/
	void setVoie(Integer pVoie);

	
	
} // FIN DE LA CLASSE ILocalisationBasePur.-------------------------------------
