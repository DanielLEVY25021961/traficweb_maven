package levy.daniel.application.model.metier.localisation.localisationlineaire.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.localisationlineaire.AbstractLocalisationLineaire;

/**
 * class LocalisationPR :<br/>
 * <ul>
 * <li>Modélisation d'une Localisation en PR.</li>
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
@Entity(name="LocalisationPR")
@Table(name="LOCALISATIONS_PR", schema="PUBLIC")
@PrimaryKeyJoinColumn(name="ID_ABSTRACTLOCALISATIONBASEPUR"
, foreignKey=@ForeignKey(name="FK_LOCALISATIONPR_LOCSBASEPURES"))
public class LocalisationPR extends AbstractLocalisationLineaire {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * depPr : String :<br/>
	 * Département de la localisation 
	 * ("07" pour Ardèche, "30" pour le Gard).<br/>
	 */
	private String depPr;
	
	
	/**
	 * concessionPr : String :<br/>
	 * Code concession de la localisation.<br/>
	 * "C" pour Concédé, "N" ou rien pour non concédé.<br/>
	 */
	private String concessionPr;
	

	/**
	 * pr : Integer :<br/>
	 * PR de la localisation (numéro).<br/>
	 */
	private Integer pr;
	
	
	/**
	 * absPr : Float :<br/>
	 * Abscisse EN PR de la localisation.<br/>
	 * ATTENTION : cette abscisse est obligatoirement
	 * positive, contrairement à l'abscisse d'un PLO.<br/>
	 */
	private Float absPr;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LocalisationPR.class);

	// *************************METHODES************************************/

	

	/**
	 * method getDepPr() :<br/>
	 * Getter du Département de la localisation 
	 * ("07" pour Ardèche, "30" pour le Gard).<br/>
	 * <br/>
	 *
	 * @return depPr : String.<br/>
	 */
	@Column(name = "DEPARTEMENT_PR"
		, unique = false, nullable = true
		, insertable = true, updatable = true)
	public String getDepPr() {
		return this.depPr;
	} // Fin de getDepPr().________________________________________________



	/**
	 * method setDepPr(
	 * String pDepPR) :<br/>
	 * Setter du Département de la localisation 
	 * (07 pour Ardèche, "30" pour le Gard).<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pDepPR : String : 
	 * valeur à passer à depPr.<br/>
	 */
	public void setDepPr(
			final String pDepPR) {
		
		this.depPr = pDepPR;

	} // Fin de setDepPr(
	 // String pDepPR).____________________________________________________


	
	/**
	 * method getConcessionPr() :<br/>
	 * Getter du Code concession de la localisation.<br/>
	 * ("C" pour Concédé, "N" ou rien  pour Non Concédé).<br/>
	 * <br/>
	 *
	 * @return concessionPr : String.<br/>
	 */
	@Column(name = "CONCESSION_PR"
		, unique = false, nullable = true
		, insertable = true, updatable = true)
	public String getConcessionPr() {
		return this.concessionPr;
	} // Fin de getConcessionPr()._________________________________________



	/**
	 * method setConcessionPr(
	 * String pConcessionPr) :<br/>
	 * Setter du Code concession de la localisation 
	 * ("C" pour Concédé, "N" ou rien pour Non Concédé).<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pConcessionPr : String :
	 *  valeur à passer à concessionPr.<br/>
	 */
	public void setConcessionPr(
			final String pConcessionPr) {
		
		this.concessionPr = pConcessionPr;
		
	} // Fin de setConcessionPr(
	 // String pConcessionPR)._____________________________________________


	
	/**
	 * method getPr() :<br/>
	 * Getter du PR de la localisation.<br/>
	 * <br/>
	 *
	 * @return pr : Integer.<br/>
	 */
	@Column(name = "PR"
		, unique = false, nullable = true
		, insertable = true, updatable = true)
	public Integer getPr() {
		return this.pr;
	} // Fin de getPr().___________________________________________________



	/**
	 * method setPr(
	 * Integer pPr) :<br/>
	 * Setter du PR de la localisation 
	 * (Valeur entière indiquant le "numéro de la borne" comme 7 ou 114).<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pPr : Integer : valeur à passer à pr.<br/>
	 */
	public void setPr(
			final Integer pPr) {
		
		this.pr = pPr;
						
	} // Fin de setPr(
	 // Integer pPr).______________________________________________________


		
	/**
	 * method getAbsPr() :<br/>
	 * Getter de l'Abscisse en PR de la localisation.<br/>
	 * ATTENTION : cette abscisse est obligatoirement
	 * positive, contrairement à l'abscisse d'un PLO.<br/>
	 * <br/>
	 * RG-absPr2-incohérence : la Localisation est incohérente 
	 * si l'abscisse du PR est négative.<br/>
	 * <br/>
	 *
	 * @return absPr : Float.<br/>
	 */
	@Column(name = "ABSCISSE_PR"
		, unique = false, nullable = true
		, insertable = true, updatable = true)
	public Float getAbsPr() {
		return this.absPr;
	} // Fin de getAbsPr().________________________________________________



	/**
	 * method setAbsPr(
	 * Float pAbsPr) :<br/>
	 * Setter de l'Abscisse en PR de la localisation.<br/>
	 * ATTENTION : cette abscisse est obligatoirement
	 * positive, contrairement à l'abscisse d'un PLO.<br/>
	 * <br/>
	 * RG-absPr2-incohérence : la Localisation est incohérente 
	 * si l'abscisse du PR est négative.<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pAbsPr : Float : valeur à passer à absPr.<br/>
	 */
	public void setAbsPr(
			final Float pAbsPr) {
		
		this.absPr = pAbsPr;

	} // Fin de setAbsPr(
	 // Float pAbsPr)._____________________________________________________


		
} // FIN DE LA CLASSE LocalisationPR.----------------------------------------
