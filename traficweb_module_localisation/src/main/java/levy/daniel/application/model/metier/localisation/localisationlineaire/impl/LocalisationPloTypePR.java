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
 * <li>Modélisation d'une Localisation en PLO de Type PR.</li>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 21 nov. 2017
 *
 */
@Entity(name="LocalisationPloTypePR")
@Table(name="LOCALISATIONS_PLO_TYPE_PR", schema="PUBLIC")
@PrimaryKeyJoinColumn(name="ID_ABSTRACTLOCALISATIONBASEPUR"
, foreignKey=@ForeignKey(name="FK_LOCALISATIONPLOTYPEPR_LOCSBASEPURES"))
public class LocalisationPloTypePR extends AbstractLocalisationLineaire {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LocalisationPloTypePR.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPloTypePR() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public LocalisationPloTypePR() {
		
		this(null, null, null, null, null, null, null);
				
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
	 /**
	 * method CONSTRUCTEUR LocalisationPloTypePR(
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
	public LocalisationPloTypePR(
			final String pRoute, final Float pCumul
			, final String pPlo, final Float pAbs) {
		
		this(null, pRoute, pCumul, "I", 100, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR UTILE.________________________________________
	

	
	 /**
	 * method CONSTRUCTEUR LocalisationPloTypePR(
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
	public LocalisationPloTypePR(
			final String pRoute, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs) {
		
		this(null, pRoute, pCumul, pCote, pVoie, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPloTypePR(
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
	public LocalisationPloTypePR(
			final Long pId
			, final String pRoute, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs) {
		
		super(pId, pRoute, pCumul, pCote, pVoie, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


		
} // FIN DE LA CLASSE LocalisationPloTypePR.---------------------------------
