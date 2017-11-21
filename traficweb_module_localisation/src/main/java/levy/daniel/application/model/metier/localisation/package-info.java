/**
 * class package-info :<br/>
 * <ul>
 * <li>Ce package LOCALISATION contient toutes les classes métier 
 * permettant de décrire les <b>localisations routières</b> conformes 
 * à notre <b>Modèle d’Echange des Référentiels Inter-Urbains 
 * de 2ème génération (MERIU v2)</b> et au <b>FEOR</b> 
 * (Format d'Echange des Objets Routiers).</li>
 * <li>Dans notre <b>Référentiel Inter-Urbain de 2ème génération 
 * (RIU v2)</b>, tout point d'une route peut être localisé selon le 
 * <i>mode de localisation</i> <b>"en PR"</b> avec les 
 * informations suivantes :
 * <ol>
 * <li><b>route</b> : nom de la route dans le RIU v2 comme 
 * A0006b ou N0886.<br/>
 * Une route possède toujours un sens croissant (sens droit) 
 * dans le Référentiel (RIU v2).
 * </li>
 * <li><b>departement</b> : Le département où est situé le point 
 * routier comme "01" pour l'Ain, "07" pour l'Ardèche, 
 * "13" pour les Bouches-du-Rhône, ...<br/>
 * Le département est indispensable car les Points de Repère (PR) 
 * comme des bornes kilométriques sont renumérotés dans chaque 
 * département. Il peut donc y avoir un PR0 sur l'A0006 dans le 
 * département 71 et un PR0 sur l'A0006 dans le département 69.
 * </li>
 * <li><b>codeConcession</b> : "N" pour le réseau <i>non concédé</i> géré 
 * directement par l'état, "C" pour le réseau <i>concédé</i> géré par 
 * les Sociétés Concessionnaires d'Autoroute (SCA).<br/>
 * Le Code Concession n'est pas strictement nécessaire pour localiser 
 * un point sur une route, mais le FEOR impose qu'il soit précisé.</li>
 * <li><b>pr</b> : point de repère. Analogue à la notion de borne 
 * kilométrique mais les distances inter-pr ne font pas 
 * nécessairement 1 km.</li>
 * <li><b>abscisse</b> : abscisse par rapport au PR.<br/>
 * l'abscisse est toujours positive et toujours comptée 
 * dans le sens croissant.
 * </li>
 * <li><b>cumul</b> : abscisse cumulée le long de la route depuis 
 * son PR0 au début de la route.<br/>
 * [route + cumul + cote + voie] suffirait à localiser un point routier.<br/> 
 * Mais le mode de localisation "metier" traditionnellement utilisé 
 * était le <i>mode de localisation en PR</i> 
 * [route + dept +CodeConcession + PR + abscisse + cote + voie].<br/>
 * Les gestionnaires se repéraient à l'intérieur de leur département 
 * et ne connaissaient pas l'abscisse cumulée d'un point routier.<br/>
 * Le cumul n'est donc jamais fourni par le métier et doit être 
 * calculé dans le référentiel (appel du Web Service d'ISIDOR).
 * </li>
 * <li><b>cote</b> : D pour droit, G pour gauche, I pour indéterminé.<br/>
 * Les localisations utilisées dans TraficWeb adressant des 
 * <b>Sections de Trafic</b> de <i>portée</i> <b>route</b>
 * , le coté sera toujours "I".</li>
 * <li><b>voie</b> : 1 pour la première voie sens droit, 
 * 2 pour l'éventuelle deuxième voie sens droit, ...<br/>
 * Les localisations utilisées dans TraficWeb adressant des 
 * <b>Sections de Trafic</b> de <i>portée</i> <b>route</b>
 * , la voie sera toujours 100 (pour avoir un Integer 
 * non null et signifier que la voie n'est pas précisée).</li>
 * </ol>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/localisation_sens.png" 
 * alt="Localisations et sens" border="1" align="center" />
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/localisation_sens_2.png" 
 * alt="Localisations et sens" border="1" align="center" />
 * </li>
 * <br/>
 * <li>Nous utilisons également d'<b>autres modes de localisation</b> :
 * <ol>
 * <br/>
 * <li>
 * la <b>localisation en Point de LOcalisation (PLO)</b> :<br/>
 * Le Point de LOcalisation (PLO) est une généralisation 
 * du Point de Repère (PR).<br/> 
 * Un PLO peut être une adresse « numéro + nom de la rue », 
 * Un élément de construction comme un début de fourche (DF...)
 * , un PR, ….<br/> 
 * En résumé, un PLO est un repère unique facilement identifiable sur 
 * une route ou un dispositif d’échange à partir duquel 
 * on peut repérer d’autres objets.<br/> 
 * Les PR sont un cas particulier de PLO. Ce sont les repères 
 * les plus utilisés dans les applications métier traitant du trafic.<br/> 
 * Cependant, certains PLO deviennent de plus en plus utilisés : 
 * <b>les PLO « de type PR »</b>.<br/> 
 * En fait, le PLO de type PR est construit à partir d’un PR et 
 * concentre dans sa dénomination toutes les caractéristiques 
 * utiles du PR.<br/> 
 * Par exemple, le PR numéro 37 situé dans le Département 73 
 * sur la chaussée droite (D) en zone concédée (C) peut s’écrire 
 * sous la forme de PLO de type PR : 73PR37DC.<br/> 
 * On pourra donc passer d’un PR à un PLO de type PR 
 * dans TraficWeb avec une expression régulière de type :<br/> 
 * <b>PLO de type PR : [Département] PR [numéroPR] [Côté] [CodeConcession]</b>
 * </li>
 * <br/>
 * <li>
 * la <b>localisation géométrique</b> :<br/>
 * C'est la localisation avec les coordonnées x, y, z Lambert 1993.<br/>
 * Stricto sensu [x, y, z] permettent de localiser n'importe quel 
 * point du réseau routier.<br/>
 * Mais du fait du manque de précision des coordonnées fournies, 
 * le MERIU v2 recommande de préciser également 
 * [route + cumul + cote + voie]. 
 * </li>
 * </ol>
 * </li>
 * <li>Un <b>même</b> point routier peut donc être localisé selon les 3 modes suivants : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/modes_localisation.png" 
 * alt="les 3 modes de localisation" border="1" align="center" />
 * </li>
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
 * @since 4 nov. 2017
 *
 */
package levy.daniel.application.model.metier.localisation;
