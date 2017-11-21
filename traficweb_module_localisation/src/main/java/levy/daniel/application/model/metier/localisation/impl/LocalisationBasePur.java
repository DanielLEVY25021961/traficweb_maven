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
 * <ul>
 * <li>Un <b>même</b> point routier peut être localisé selon les 3 modes suivants : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/modes_localisation.png" 
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
 * <img src="../../../../../../../../../../javadoc/images/modes_localisation_factorises.png" 
 * alt="les 3 modes de localisation" border="1" align="center" />
 * </li>
 * <br/>
 * <ul>
 * <li>la CLASSE CONCRETE LocalisationBasePur modélise les LocalisationBasePur. 
 * Elle n'est utile que pour les TESTS.</li>
 * <li>HERITE de AbstractLocalisationBasePur.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/localisation_pures.png" 
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
 * @author dan Lévy
 * @version 1.0
 * @since 5 nov. 2017
 *
 */
@Entity(name="LocalisationBasePur")
@Table(name="LOCALISATIONS_BASE_PURES", schema="PUBLIC")
@PrimaryKeyJoinColumn(name="ID_ABSTRACTLOCALISATIONBASEPUR"
, foreignKey=@ForeignKey(name="FK_ABSTRACTLOCSBASEPURES_LOCSBASEPURES"))
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
		
		this(null, null, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur(
	 * String pRoute
	 * , Float pCumul) :<br/>
	 * CONSTRUCTEUR UTILE POUR LA PORTEE ROUTE : <br/>
	 * <ul>
	 * <li>SANS IDENTIFIANT EN BASE (null).</li>
	 * <li>SANS COTE = AVEC COTE INDETERMINE "I" (portée ROUTE).</li>
	 * <li>SANS VOIE (voie = null pour portée ROUTE).</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 */
	public LocalisationBasePur(
			final String pRoute
				, final Float pCumul) {		
		this(null, pRoute, pCumul, "I", null);		
	} // Fin de CONSTRUCTEUR AbstractLocalisationBasePur(
	 // String pRoute
	 // , Float pCumul).___________________________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET PORTEE CHAUSSEE :<br/>
	 * <ul>
	 * <li>SANS IDENTIFIANT EN BASE (null).</li>
	 * <li>AVEC COTE.</li>
	 * <li>SANS VOIE</li>
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
		
		this(null, pRoute, pCumul, pCote, null);
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET PORTEE VOIE :<br/>
	 * <ul>
	 * <li>SANS IDENTIFIANT EN BASE (null).</li>
	 * <li>AVEC COTE.</li>
	 * <li>AVEC VOIE</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 * @param pVoie : Integer : Voie de la localisation.<br/>
	 */
	public LocalisationBasePur(
			final String pRoute
					, final Float pCumul						
							, final String pCote
								, final Integer pVoie) {
		
		this(null, pRoute, pCumul, pCote, pVoie);
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur(
	 * Long pIdBase
	 * , String pRoute
	 * , Float pCumul
	 * , String pCote
	 * , Integer pVoie) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.
	 * <ul>
	 * <li>AVEC IDENTIFIANT EN BASE.</li>
	 * <li>AVEC COTE.</li>
	 * <li>AVEC VOIE.</li>
	 * </ul>
	 *
	 * @param pId : Long : identifiant en base.<br/>
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 * @param pVoie : Integer : Voie de la localisation.<br/>
	 */
	public LocalisationBasePur(
			final Long pId
				, final String pRoute
					, final Float pCumul
						, final String pCote
							, final Integer pVoie) {
		
		super(pId, pRoute, pCumul, pCote, pVoie);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
} // FIN DE LA CLASSE LocalisationBasePur.-----------------------------------
