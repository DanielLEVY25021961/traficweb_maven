package levy.daniel.application.model.metier.localisation.localisationlineaire;

import levy.daniel.application.model.metier.localisation.ILocalisationBasePur;

/**
 * class ILocalisationLineaire :<br/>
 * <ul>
 * <li>INTERFACE factorisant tous les comportements des
 * LocalisationLineaire (plo, abs).</li>
 * <li>HERITE de ILocalisationBasePur.</li>
 * </ul>
 * 
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
 * @author DAN Lévy
 * @version 1.0
 * @since 24 juin 2012
 *
 */
public interface ILocalisationLineaire extends ILocalisationBasePur {

	

	
	/**
	 * method getPlo() :<br/>
	 * Getter du PLO de la localisation.<br/>
	 * <br/>
	 *
	 * @return plo : String.<br/>
	 */
	String getPlo();
	

	
	/**
	 * method setPlo(
	 * String pPlo) :<br/>
	 * Setter du PLO de la localisation.<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pPlo : String.<br/>
	 */
	void setPlo(String pPlo);



	
	/**
	 * method getAbs() :<br/>
	 * Getter de l'abscisse curviligne de la localisation 
	 * par rapport à son Repère (PLO).<br/>
	 * <br/>
	 *
	 * @return abs : Float.<br/>
	 */
	Float getAbs();

	
	
	/**
	 * method setAbs(
	 * Float pAbscisse) :<br/>
	 * Setter de l'abscisse curviligne de la localisation 
	 * par rapport à son Repère (PLO).<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pAbscisse : Float.<br/>
	 */
	void setAbs(Float pAbscisse);

	
	
} // FIN DE LA CLASSE ILocalisationLineaire.-------------------------------
