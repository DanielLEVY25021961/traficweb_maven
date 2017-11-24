package levy.daniel.application.model.metier.localisation.localisationlineaire.impl;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.localisationlineaire.AbstractLocalisationLineaire;

/**
 * class LocalisationPloConstruction :<br/>
 * <ul>
 * <li>Modélisation d'une Localisation en PLO de Construction.</li>
 * <ul>
 * <li>PLO de Type Construction <b>plo</b>.<br/>
 * par exemple FFxxxx pour "Fin de fourchexxxx".</li>
 * <li>abscisse du PLO <b>abs</b>.<br/>
 * Cette abscisse peut être négative pour un PLO 
 * (comptée en sens décroissant par rapport au PLO).</li>
 * </ul>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 21 nov. 2017
 *
 */
@Entity(name="LocalisationPloConstruction")
@Table(name="LOCALISATIONS_PLO_CONSTRUCTION", schema="PUBLIC")
@PrimaryKeyJoinColumn(name="ID_ABSTRACTLOCALISATIONBASEPUR"
, foreignKey=@ForeignKey(name="FK_LOCALISATIONPLOCONSTRUCTION_LOCSBASEPURES"))
public class LocalisationPloConstruction extends AbstractLocalisationLineaire {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LocalisationPloConstruction.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPloConstruction() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public LocalisationPloConstruction() {
		
		this(null, null, null, null, null, null, null);
				
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
	 /**
	 * method CONSTRUCTEUR LocalisationPloConstruction(
	 * String pRoute
	 * , String pPlo, Float pAbs) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR RAPIDE <b>(portée route)</b>.</li>
	 * Le cumul (abscisse cumulée) n'est pas renseigné dans les fichiers 
	 * de trafic fournis par les gestionnaires.<br/>
	 * Cette donnée sera alimentée par l'appel au 
	 * Web Service d'ISIDOR.</li>
	 * <li>SANS id.</li>
	 * <li>SANS cumul.</li>
	 * <li>SANS cote ("I").</li>
	 * <li>SANS voie (100).</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pPlo : String : PLO de la localisation.<br/>
	 * @param pAbs : Float : Abscisse curviligne de la localisation.<br/>
	 * ATTENTION : cette abscisse peut être négative 
	 * (contrairement à l'abscisse d'un PR).<br/>
	 */
	public LocalisationPloConstruction(
			final String pRoute
			, final String pPlo, final Float pAbs) {
		
		this(null, pRoute, null, "I", 100, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR RAPIDE._______________________________________

	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPloConstruction(
	 * String pRoute, Float pCumul, 
	 * String pPlo, Float pAbs) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR UTILE <b>(portée route)</b>.</li>
	 * <li>SANS id.</li>
	 * <li>SANS cote ("I").</li>
	 * <li>SANS voie (100).</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pPlo : String : PLO de la localisation.<br/>
	 * @param pAbs : Float : Abscisse curviligne de la localisation.<br/>
	 * ATTENTION : cette abscisse peut être négative 
	 * (contrairement à l'abscisse d'un PR).<br/>
	 */
	public LocalisationPloConstruction(
			final String pRoute, final Float pCumul
			, final String pPlo, final Float pAbs) {
		
		this(null, pRoute, pCumul, "I", 100, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR UTILE.________________________________________
	

	
	 /**
	 * method CONSTRUCTEUR LocalisationPloConstruction(
	 * COMPLET) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS id.</li>
	 * </ul>>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 * @param pVoie : Integer : Voie de la localisation.<br/>
	 * @param pPlo : String : PLO de la localisation.<br/>
	 * @param pAbs : Float : Abscisse curviligne de la localisation.<br/>
	 * ATTENTION : cette abscisse peut être négative 
	 * (contrairement à l'abscisse d'un PR).<br/>
	 */
	public LocalisationPloConstruction(
			final String pRoute, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs) {
		
		this(null, pRoute, pCumul, pCote, pVoie, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPloConstruction(
	 * COMPLET BASE) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC id</li>
	 * </ul>
	 *
	 * @param pId : Long : identifiant en base.<br/>
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 * @param pVoie : Integer : Voie de la localisation.<br/>
	 * @param pPlo : String : PLO de la localisation.<br/>
	 * @param pAbs : Float : Abscisse curviligne de la localisation.<br/>
	 * ATTENTION : cette abscisse peut être négative 
	 * (contrairement à l'abscisse d'un PR).<br/>
	 */
	public LocalisationPloConstruction(
			final Long pId
			, final String pRoute, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs) {
		
		super(pId, pRoute, pCumul, pCote, pVoie, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
		
} // FIN DE LA CLASSE LocalisationPloConstruction.---------------------------
