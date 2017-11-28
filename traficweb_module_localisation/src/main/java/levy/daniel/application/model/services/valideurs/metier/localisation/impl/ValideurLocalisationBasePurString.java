package levy.daniel.application.model.services.valideurs.metier.localisation.impl;

import java.net.MalformedURLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.ILocalisationBasePurString;
import levy.daniel.application.model.services.valideurs.AbstractValideurGeneric;

/**
 * class ValideurLocalisationBasePurString :<br/>
 * <ul>
 * <li>
 * CLASSE CONCRETE <b>SERVICE</b> chargée de la <b>validation</b> 
 * des <b>Règles de Gestion (RG)</b> s'appliquant sur chaque 
 * <b>attribut</b> de l'Objet Métier 
 * <b>LocalisationBasePurString</b>.</li>
 * <li></li>
 * <li></li>
 * <li></li>
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
 * @author dan Lévy
 * @version 1.0
 * @since 24 nov. 2017
 *
 */
public class ValideurLocalisationBasePurString 
			extends AbstractValideurGeneric<ILocalisationBasePurString> {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ValideurLocalisationBasePurString.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ValideurLocalisationBasePurString() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ValideurLocalisationBasePurString() {		
		super();		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Map<String, String>> validate(
			final ILocalisationBasePurString pObject) 
							throws MalformedURLException {

		/* nom. */
		this.validerRoute(pObject);
		
		return this.erreurs;
		
	} // Fin de validate(...)._____________________________________________
	


	/**
	 * method validerRoute() :<br/>
	 * <ul>
	 * <li>Valide <b>toutes les RG</b> s'appliquant à l'attribut 
	 * <b>"route"</b> d'une Localisation.</li>
	 * </ul>
	 *
	 * @param pObject : ILocalisationBasePurString.<br/>
	 * 
	 * @return boolean : false si l'attribut 
	 * à vérifier n'est pas valide.<br/>
	 * 
	 * @throws MalformedURLException :  :  .<br/>
	 */
	public boolean validerRoute(
			final ILocalisationBasePurString pObject) 
						throws MalformedURLException {
		
	}
	
	
	
} // FIN DE LA CLASSE ValideurLocalisationBasePurString.---------------------
