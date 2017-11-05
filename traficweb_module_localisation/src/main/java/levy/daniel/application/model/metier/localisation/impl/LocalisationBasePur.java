package levy.daniel.application.model.metier.localisation.impl;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;


/**
 * class LocalisationBasePur :<br/>
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
 * @since 5 nov. 2017
 *
 */
@Entity(name="LocalisationBasePur")
@Table(name="LOCALISATIONS_BASE_PURES", schema="PUBLIC")
@PrimaryKeyJoinColumn(name="ID_ABSTRACTLOCALISATIONBASEPUR"
, foreignKey=@ForeignKey(name="FK_ABSTRACTLOCSPURES_LOCSPURES"))
public class LocalisationBasePur extends AbstractLocalisationBasePur {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LocalisationBasePur.class);


	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public LocalisationBasePur() {
		
		this(null, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur(
	 * String pRoute
	 * , Float pCumul) :<br/>
	 * CONSTRUCTEUR : <br/>
	 * - SANS IDENTIFIANT EN BASE (null).<br/>
	 * - SANS COTE = AVEC COTE INDETERMINE "I" (portée ROUTE).<br/>
	 * <br/>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 */
	public LocalisationBasePur(
			final String pRoute
				, final Float pCumul) {
		
		this(null, pRoute, pCumul, "I");
		
	} // Fin de CONSTRUCTEUR LocalisationBasePur(
	 // String pRoute
	 // , Float pCumul).___________________________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET :<br/>
	 * <ul>
	 * <li>SANS IDENTIFIANT EN BASE (null).</li>
	 * <li>AVEC COTE.</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 */
	public LocalisationBasePur(
			final String pRoute
				, final Float pCumul
					, final String pCote) {
		
		this(null, pRoute, pCumul, pCote);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur(
	 * Long pIdBase
	 * , String pRoute
	 * , Float pCumul
	 * , String pCote
	 * , IORS pOrs) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.
	 * <ul>
	 * <li>AVEC IDENTIFIANT EN BASE.</li>
	 * <li>AVEC COTE.</li>
	 * </ul>
	 *
	 * @param pId : Long : identifiant en base.<br/>
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 */
	public LocalisationBasePur(
			final Long pId
				, final String pRoute
					, final Float pCumul
						, final String pCote) {
		
		super(pId, pRoute, pCumul, pCote);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
} // FIN DE LA CLASSE LocalisationBasePur.-----------------------------------
