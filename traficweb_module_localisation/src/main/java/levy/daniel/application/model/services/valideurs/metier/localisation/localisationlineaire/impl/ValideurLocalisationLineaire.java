package levy.daniel.application.model.services.valideurs.metier.localisation.localisationlineaire.impl;

import java.net.MalformedURLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.localisationlineaire.ILocalisationLineaireString;
import levy.daniel.application.model.services.valideurs.AbstractValideurGeneric;

/**
 * class ValideurLocalisationLineaire :<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 24 nov. 2017
 *
 */
public class ValideurLocalisationLineaire extends AbstractValideurGeneric<ILocalisationLineaireString> {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ValideurLocalisationLineaire.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Map<String, String>> validate(
			final ILocalisationLineaireString pObject) throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}

	// *************************METHODES************************************/
}
