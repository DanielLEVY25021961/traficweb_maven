/**
 * class package-info :<br/>
 * <ul>
 * <li>
 * Ce package contient toutes les classes métier nécessaires 
 * pour décrire les localisations dites <b>"linéaires"</b>, 
 * c'est à dire les Localisations exprimées en <b>Points de 
 * LOcalisation (PLO)</b> ou en <b>Points de Repère (PR)</b>.
 * </li>
 * <li>
 * Pour mémoire, <b>toutes les Localisations</b> 
 * (linéaires ou géométriques) <b>héritent d'une 
 * LocalisationBasePur</b> et connaissent leur 
 * <b>[route + cumul + cote + voie]</b>.</li>
 * </li>
 * <li>
 * La notion de localisation <b>linéaire</b> sert à distinguer 
 * la notion de localisation <b>géométrique</b>.
 * </li>
 * <li>
 * Avec une localisation <i>linéaire</i>, on localise toujours 
 * un point routier avec un <b>repère</b> (PLO ou PR) et une 
 * <b>abscisse</b> dans le sens croissant par rapport à ce repère.<br/>
 * Par exemple, un même point routier pourra être exprimé en 
 * localisation linéaire comme suit :<br/> 
 * <b>LocalisationBasePur</b>=[route_A0006 + cumul_null + cote_G + voie_1] 
 * + <b>repère PR</b>=[Dept73 + Concedé + PR7] 
 * + <b>abscisse</b>=987 en <b>PR</b>.<br/>
 * <b>LocalisationBasePur</b>=[route_A0006 + cumul_null + cote_G + voie_1] 
 * + <b>repère PLO</b>=[73PR7GC] + <b>abscisse</b>=987 en <b>PLO</b> (de type PR).<br/>
 * </li>
 * <li>
 * Avec une localisation <i>géométrique</i>, on repère un 
 * point routier avec des coordonnées Lambert 93 [x, y, z]. 
 * Les notions de repère et d'abscisse <i>disparaissent</i>.<br/>
 * Le même point routier que dans l'exemple précédent pourrait s'écrire :<br/>
 * <b>LocalisationBasePur</b>=[route_A0006 + cumul_null + cote_G + voie_1] 
 * + [x=18554422,323 y=7778555,65 z=200,58] en <b>localisation géométrique</b>. 
 * </li>
 * <li>
 * TOUTE LOCALISATION EN PR peut s'exprimer en PLO. Le PR n'est qu'un 
 * <i>cas particulier</i> de PLO.
 * </li>
 * <li>
 * Un PR <b>est un</b> PLO. On peut toujours l'exprimer en "PLO de type PR".<br/>
 * On utilise une expression régulière de type :<br/> 
 * <b>PLO de type PR : [Département] PR [numéroPR] [Côté] [CodeConcession]</b>
 * </li>
 * <li>
 * L'inverse n'est pas vrai : <b>un PLO ne peut pas toujours être 
 * directement exprimé en PR</b>.<br/>
 * Ceci est dû à la présence dans le référentiel RIU v2 des PLO dits 
 * de "construction" comme "fin de fourche" (FF...).<br/>
 * Seul un <b>appel au référentiel via le Web Service d'ISIDOR</b> 
 * permet de récupérer le PR et l'abscisse de ces PLO de construction.<br/>
 * </li>
 * <li>
 * La notion de <b>repère</b> précédemment évoquée pour les 
 * localisations linéaires peut être ramenée au PLO puisque un PR est un PLO.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/localisations_lineaires.png" 
 * alt="localisations linéaires" border="1" align="center" />
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
 * @since 6 nov. 2017
 *
 */
package levy.daniel.application.model.metier.localisation.localisationlineaire.impl;
