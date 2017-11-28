package levy.daniel.application.model.metier.localisation;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * INTERFACE ILocalisationBasePur :<br/>
 * <ul>
 * <li>INTERFACE COPIE de ILocalisationBasePur 
 * <b>UTILE POUR LA LECTURE DES VUES</b>.</li>
 * <li>Tous les attributs sont passés en String.</li>
 * </ul>
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
public interface ILocalisationBasePurString 
			extends IExportateurCsv, IExportateurJTable {


	
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
	 * @return cumul : String.<br/>
	 */
	String getCumul();
	

	
	/**
	 * method setCumul(
	 * String pCumul) :<br/>
	 * Setter de l'abscisse cumulée de la localisation.<br/>
	 * <br/>
	 *
	 * @param pCumul : String : 
	 * valeur à passer à this.cumul.<br/>
	 */
	void setCumul(String pCumul);


	
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
	 * @return voie : String.<br/>
	 */
	String getVoie();


	
	/**
	* method setVoie(
	* String pVoie) :<br/>
	* Setter de la Voie de la localisation 
	 * (1 pour la première voie à droite dans le sens de la route).<br/>
	* <br/>
	*
	* @param pVoie : String : valeur à passer à voie.<br/>
	*/
	void setVoie(String pVoie);

	
	
} // FIN DE LA CLASSE ILocalisationBasePur.-------------------------------------
