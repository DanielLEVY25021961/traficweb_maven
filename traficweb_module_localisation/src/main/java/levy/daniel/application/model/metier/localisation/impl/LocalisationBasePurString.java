package levy.daniel.application.model.metier.localisation.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePurString;


/**
 * class LocalisationBasePurString :<br/>
 * <ul>
 * <li>CLASSE COPIE de LocalisationBasePur 
 * <b>UTILE POUR LA LECTURE DES VUES</b>.</li>
 * <li>Tous les attributs sont passés en String.</li>
 * </ul>
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
public class LocalisationBasePurString 
			extends AbstractLocalisationBasePurString {

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
	private static final Log LOG = LogFactory.getLog(LocalisationBasePurString.class);


	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR LocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public LocalisationBasePurString() {
		
		this(null, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
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
	 * @param pCumul : String : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 * @param pVoie : String : Voie de la localisation.<br/>
	 */
	public LocalisationBasePurString(
			final String pRoute
					, final String pCumul						
							, final String pCote
								, final String pVoie) {
		
		super(pRoute, pCumul, pCote, pVoie);
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________



	
} // FIN DE LA CLASSE LocalisationBasePur.-----------------------------------
