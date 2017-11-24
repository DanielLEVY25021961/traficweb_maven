/**
 * class package-info :<br/>
 * <ul>
 * <li>
 * Ce package <b>levy.daniel.application.model.services</b> contient 
 * tous les <b>SERVICES</b>.
 * </li>
 * <li>
 * Les SERVICES sont seuls habilités à ête sollicités 
 * par les <b>CONTROLLERS</b>.
 * </li>
 * <li>
 * Les SERVICES sollicitent la couche <b>DAO</b> 
 * pour la persistance des données.
 * </li>
 * <li>
 * Les SERVICES <i>implémentent</i> tous les Cas d'Utilisation <b>
 * (CU)</b> de l'application.
 * </li>
 * <li>
 * Les SERVICES délèguent à des <b>transformeurs</b> 
 * l'application des <b>Règles Métier (RM)</b>.<br/>
 * (par exemple, si le côté d'une Localisation n'est pas renseigné, 
 * le mettre automatiquement à "I" pour Indéterminé).
 * </li>
 * <li>
 * Les SERVICES délèguent à des <b>valideurs</b> l'application 
 * des <b>Règles de Gestion (RG)</b>.<br/>
 * (par exemple, le côté d'une Localisation doit être 
 * "I", "G", ou "D").
 * </li>
 * <li>
 * Les SERVICES fournissent les <b>rapports de contrôle</b> 
 * (map erreurs) aux CONTROLLERS.
 * </li>
 * <li>
 * Les SERVICES fournissent le <b>résultat de la logique métier</b> 
 * aux CONTROLLERS.
 * </li>
 * <br/>
 * <li>L'arborescence du package services est la suivante :</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../javadoc/images/arborescence_model.png" 
 * alt="arborescence du package services" border="1" align="center" />
 * </li>
 * <br/>
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
 * @since 22 sept. 2017
 *
 */
package levy.daniel.application.model.services;
