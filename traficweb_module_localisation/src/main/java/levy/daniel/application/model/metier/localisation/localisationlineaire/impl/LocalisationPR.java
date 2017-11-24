package levy.daniel.application.model.metier.localisation.localisationlineaire.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.localisationlineaire.AbstractLocalisationLineaire;

/**
 * class LocalisationPR :<br/>
 * <ul>
 * <li>Modélisation d'une Localisation en PR.</li>
 * <ul>
 * <li>departement du PR <b>depPr</b>.</li>
 * <li>Code Concession ("C" ou "N" ou rien pour "N") 
 * <b>concessionPr</b>.</li>
 * <li>Numéro du PR <b>pr</b>.</li>
 * <li>Abscisse positive par rapport au PR <b>absPr</b>.</li>
 * </ul>
 * <br/>
 * <li>
 * Voici un exemple d'un même point localisé en 
 * [PR + abscisse], [PLO de type PR + abscisse]
 * , [PLO de construction + abscisse (négative)] et 
 * localisation géométrique :</li>
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/Route_A2_Dept59.png" 
 * alt="image de 4 localisations d'un même point" border="1" align="center" />
 * </li>
 * <br/>
 * <li>Voici le diagramme des classes linéaires implémentées : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/localisations_lineaires_concretes.png" 
 * alt="implémentation des localisations linéaires" border="1" align="center" />
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
	 * method CONSTRUCTEUR LocalisationPR() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public LocalisationPR() {
		
		this(null
				, null
				, null
				, null, null
				, null, null
				, null, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPR(
	 * String pRoute
	 * , String pDepPr, String pConcessionPr
	 * , Integer pPr, Float pAbsPr) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR RAPIDE <b>(portée route)</b>.</li>
	 * <li>Constructeur utile pour instancier une localisation à partir 
	 * d'un fichier de trafic fourni par les gestionnaires 
	 * (HIT, DARWIN).<br/>
	 * Le cumul (abscisse cumulée), le côté, la voie, le plo et 
	 * l'abscisse ne sont pas renseignés dans les fichiers 
	 * de trafic fournis.<br/>
	 * Ces données seront alimentées par l'appel au Web Service d'ISIDOR 
	 * ou par application d'une expression régulière calculant 
	 * le PLO de type PR à partir d'un PR.</li>
	 * <li>SANS id.</li>
	 * <li>SANS cumul.</li>
	 * <li>SANS cote ("I").</li>
	 * <li>SANS voie (100).</li>
	 * <li>SANS plo.</li>
	 * <li>SANS abscisse du plo.</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pDepPr : String :  Département de la localisation 
	 * ("07" pour Ardèche, "30" pour le Gard).<br/>
	 * @param pConcessionPr : String : 
	 * Code concession de la localisation.<br/>
	 * "C" pour Concédé, "N" ou rien pour non concédé.<br/>
	 * @param pPr : Integer : PR de la localisation (numéro).<br/>
	 * @param pAbsPr : Float : Abscisse EN PR de la localisation.<br/>
	 * ATTENTION : cette abscisse est obligatoirement
	 * positive, contrairement à l'abscisse d'un PLO.<br/>
	 */
	public LocalisationPR(
			final String pRoute
			, final String pDepPr, final String pConcessionPr
			, final Integer pPr, final Float pAbsPr) {
		
		this(null
				, pRoute
				, null
				, "I", 100
				, null, null
				, pDepPr, pConcessionPr, pPr, pAbsPr);
		
	} // Fin du CONSTRUCTEUR RAPIDE._______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR LocalisationPR(
	 * String pRoute
	 * , Float pCumul
	 * , String pPlo, Float pAbs
	 * , String pDepPr, String pConcessionPr
	 * , Integer pPr, Float pAbsPr) :<br/>
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
	 * @param pDepPr : String :  Département de la localisation 
	 * ("07" pour Ardèche, "30" pour le Gard).<br/>
	 * @param pConcessionPr : String : 
	 * Code concession de la localisation.<br/>
	 * "C" pour Concédé, "N" ou rien pour non concédé.<br/>
	 * @param pPr : Integer : PR de la localisation (numéro).<br/>
	 * @param pAbsPr : Float : Abscisse EN PR de la localisation.<br/>
	 * ATTENTION : cette abscisse est obligatoirement
	 * positive, contrairement à l'abscisse d'un PLO.<br/>
	 */
	public LocalisationPR(
			final String pRoute
			, final Float pCumul
			, final String pPlo, final Float pAbs
			, final String pDepPr, final String pConcessionPr
			, final Integer pPr, final Float pAbsPr) {
		
		this(null
				, pRoute
				, pCumul
				, "I", 100
				, pPlo, pAbs
				, pDepPr, pConcessionPr, pPr, pAbsPr);
		
	} // Fin de CONSTRUCTEUR UTILE.________________________________________


	
	 /**
	 * method CONSTRUCTEUR LocalisationPR(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS id</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 * @param pVoie : Integer : Voie de la localisation.<br/>
	 * @param pPlo : String : PLO de la localisation.<br/>
	 * @param pAbs : Float : Abscisse curviligne de la localisation.<br/>
	 * ATTENTION : cette abscisse peut être négative 
	 * (contrairement à l'abscisse d'un PR).<br/>
	 * @param pDepPr : String :  Département de la localisation 
	 * ("07" pour Ardèche, "30" pour le Gard).<br/>
	 * @param pConcessionPr : String : 
	 * Code concession de la localisation.<br/>
	 * "C" pour Concédé, "N" ou rien pour non concédé.<br/>
	 * @param pPr : Integer : PR de la localisation (numéro).<br/>
	 * @param pAbsPr : Float : Abscisse EN PR de la localisation.<br/>
	 * ATTENTION : cette abscisse est obligatoirement
	 * positive, contrairement à l'abscisse d'un PLO.<br/>
	 */
	public LocalisationPR(
			final String pRoute
			, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs
			, final String pDepPr, final String pConcessionPr
			, final Integer pPr, final Float pAbsPr) {
		
		this(null
				, pRoute
				, pCumul
				, pCote, pVoie
				, pPlo, pAbs
				, pDepPr, pConcessionPr, pPr, pAbsPr);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________



	
	 /**
	 * method CONSTRUCTEUR LocalisationPR(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
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
	 * @param pDepPr : String :  Département de la localisation 
	 * ("07" pour Ardèche, "30" pour le Gard).<br/>
	 * @param pConcessionPr : String : 
	 * Code concession de la localisation.<br/>
	 * "C" pour Concédé, "N" ou rien pour non concédé.<br/>
	 * @param pPr : Integer : PR de la localisation (numéro).<br/>
	 * @param pAbsPr : Float : Abscisse EN PR de la localisation.<br/>
	 * ATTENTION : cette abscisse est obligatoirement
	 * positive, contrairement à l'abscisse d'un PLO.<br/>
	 */
	public LocalisationPR(
			final Long pId
			, final String pRoute
			, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs
			, final String pDepPr, final String pConcessionPr
			, final Integer pPr, final Float pAbsPr) {
		
		super(pId, pRoute, pCumul, pCote, pVoie, pPlo, pAbs);

		this.depPr = pDepPr;
		this.concessionPr = pConcessionPr;
		this.pr = pPr;
		this.absPr = pAbsPr;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;
		
		/* passage du hashCode de la super-classe. */
		/* [route;cumul;cote;voie;plo;abs;] */
		int result = super.hashCode();
		
		result = prime * result 
				+ ((this.depPr == null) ? 0 : this.depPr.hashCode());
		result = prime * result 
				+ ((this.concessionPr == null) ? 0 : this.concessionPr.hashCode());
		result = prime * result 
				+ ((this.pr == null) ? 0 : this.pr.hashCode());
		result = prime * result 
				+ ((this.absPr == null) ? 0 : this.absPr.hashCode());
				
		return result;
		
	} // Fin de hashCode()._________________________________________________



	/**
	 * method equals(
	 * Object pObj) :<br/>
	 * Egalité métier de deux Localisation.<br/>
	 * <br/>
	 * 0 - super-classe.<br/>
	 * 1 - depPr.<br/>
	 * 2 - concessionPr.<br/>
	 * 3 - pr.<br/>
	 * 4 - absPr.<br/>
	 * <br/>
	 *
	 * @param pObj : Object.<br/>
	 * 
	 * @return boolean.<br/>
	 */
	@Override
	public final boolean equals(
			final Object pObj) {

		/* Meme instance : true. */
		if (this == pObj) {
			return true;
		}
		
		/* Paramètre null : false. */
		if (pObj == null) {
			return false;
		}
		
		/* InEgalite super-classe (si héritage) : false. */
		 /* [route;cumul;cote;voie;plo;abs;]. */
		if (!super.equals(pObj)) {
			return false;
		}
		
		/* Mauvaise instance : false. */
		if (!(pObj instanceof LocalisationPR)) {
			return false;
		}
		
		/* Cast. */
		final LocalisationPR other = (LocalisationPR) pObj;

		/* 1 - depPr. */
		if (this.depPr == null) {
			if (other.depPr != null) {
				return false;
			}
		}
		else if (!this.depPr.equals(other.depPr)) {
			return false;
		}
		
		/* 2 - concessionPr. */
		if (this.concessionPr == null) {
			if (other.concessionPr != null) {
				return false;
			}
		}
		else if (!this.concessionPr.equals(other.concessionPr)) {
			return false;
		}

		/* 3 - pr. */
		if (this.pr == null) {
			if (other.pr != null) {
				return false;
			}
		}
		else if (!this.pr.equals(other.pr)) {
			return false;
		}

		/* 4 - absPr. */
		if (this.absPr == null) {
			if (other.absPr != null) {
				return false;
			}
		}
		else if (!this.absPr.equals(other.absPr)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object clone() 
			throws CloneNotSupportedException {
		
		/* Création du clone. */
		final LocalisationPR clone 
			= (LocalisationPR) super.clone();
						
		/* Passage des attributs au clone. */
		clone.setId(this.id);
		
		clone.setRoute(this.route);
		clone.setCumul(this.cumul);
		clone.setCote(this.cote);
		clone.setVoie(this.voie);
		
		clone.setPlo(this.plo);
		clone.setAbs(this.abs);
		
		clone.setDepPr(this.depPr);
		clone.setConcessionPr(this.concessionPr);
		clone.setPr(this.pr);
		clone.setAbsPr(this.absPr);
		
		return clone;
		
	} // Fin de clone().___________________________________________________

	
	
	/**
	 * {@inheritDoc}<br/>
	 * <ul>
	 * <li>Affichage d'une Localisation en PR.</li>
	 * <li>[id - route - cumul - cote - voie - plo - abs 
	 * - depPr - concessionPr - pr - absPr]</li>
	 * </ul>
	 */
	@Override
	public final String toString() {
		
		final StringBuffer stb = new StringBuffer();
		
		/* Ajout de Identifiant de [id - route - cumul - cote]. */
		stb.append('[');
		
		/* Identifiant en base. */
		stb.append("id : ");
		stb.append(this.id);
		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* route. */
		stb.append("route : ");
		if (this.route != null) {
			stb.append(this.route);
		} else {
			stb.append(NULL);
		}
		
		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* cumul. */
		stb.append("cumul : ");
		if (this.cumul != null) {
			stb.append(this.cumul);
		} else {
			stb.append(NULL);
		}
		
		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* cote. */
		stb.append("cote : ");
		if (this.cote != null) {
			stb.append(this.cote);
		} else {
			stb.append(NULL);
		}
		
		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* voie. */
		stb.append("voie : ");
		if (this.voie != null) {
			stb.append(this.voie);
		} else {
			stb.append(NULL);
		}
		
		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* plo. */
		stb.append("plo : ");
		if (this.plo != null) {
			stb.append(this.plo);
		} else {
			stb.append(NULL);
		}
			
		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* abscisse du plo. */
		stb.append("abscisse : ");
		if (this.abs != null) {
			stb.append(this.abs);
		} else {
			stb.append(NULL);
		}

		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* depPr. */
		stb.append("depPr : ");
		if (this.depPr != null) {
			stb.append(this.depPr);
		} else {
			stb.append(NULL);
		}

		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* concessionPr. */
		stb.append("concessionPr : ");
		if (this.concessionPr != null) {
			stb.append(this.concessionPr);
		} else {
			stb.append(NULL);
		}

		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* pr. */
		stb.append("pr : ");
		if (this.pr != null) {
			stb.append(this.pr);
		} else {
			stb.append(NULL);
		}

		stb.append(SEPARATEUR_MOINS_AERE);
		
		/* absPr. */
		stb.append("absPr : ");
		if (this.absPr != null) {
			stb.append(this.absPr);
		} else {
			stb.append(NULL);
		}

		stb.append(']');
		
		return stb.toString();
		
	} // Fin de toString().________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * Pour une Localisation en PR :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;depPr;concessionPr;pr;absPr;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String getEnTeteCsv() {
		
		final StringBuffer stb = new StringBuffer();
		
		/* Ajout de id;route;cumul;cote;voie;plo;abs;. */
		stb.append(super.getEnTeteCsv());
		
		/* Ajout de depPr;concessionPr;pr;absPr; */
		stb.append("depPr");
		stb.append(POINT_VIRGULE);
		
		stb.append("concessionPr");
		stb.append(POINT_VIRGULE);
		
		stb.append("pr");
		stb.append(POINT_VIRGULE);
		
		stb.append("absPr");
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 * <ul>
	 * <li>Retourne la localisation en CSV avec le séparateur
	 * ";" correspondant à l'en-tête fourni par getEnTeteCsv().</li>
	 * <li>L'ordre des champs est :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;depPr;concessionPr;pr;absPr;".</li>
	 * <li>Remplace les valeurs null par "null" comme 
	 * dans "27;N0186;5896.36;G;null;" avec une voie=null.</li>
	 * </ul>
	 */
	@Override
	public final String toStringCsv() {
		
		final StringBuffer stb = new StringBuffer();
		
		/* Ajout de id;route;cumul;cote;voie;plo;abs;. */
		stb.append(super.toStringCsv());
		
		stb.append(this.depPr);
		stb.append(POINT_VIRGULE);
		
		stb.append(this.concessionPr);
		stb.append(POINT_VIRGULE);

		stb.append(this.pr);
		stb.append(POINT_VIRGULE);

		stb.append(this.absPr);
		stb.append(POINT_VIRGULE);

		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________
	
	

	/**
	 * {@inheritDoc} <br/>
	 * Pour une Localisation en PR :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;depPr;concessionPr;pr;absPr;".<br/>
	 */
	@Transient
	@Override
	public final String getEnTeteColonne(
			final int pI) {
		
		String entete = null;
		
		if (pI < 7) {
			return super.getEnTeteColonne(pI);
		}
		
		switch (pI) {

		case 7:
			entete = "depPr";
			break;

		case 8:
			entete = "concessionPr";
			break;
			
		case 9:
			entete = "pr";
			break;
			
		case 10:
			entete = "absPr";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________
		
		return entete;
		
	} // Fin de getEnTeteColonne(
	 // int pI).___________________________________________________________
	

	
	/**
	 * {@inheritDoc} <br/>
	 * Pour une Localisation en PR :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;depPr;concessionPr;pr;absPr;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;
		
		if (pI < 7) {
			return super.getValeurColonne(pI);
		}
		
		switch (pI) {

		case 7:
			valeur = this.depPr;
			break;

		case 8:
			valeur = this.concessionPr;			
			break;
			
		case 9:
			if (this.pr != null) {
				valeur = String.valueOf(this.pr);
			}
				
			break;
			
		case 10:
			if (this.absPr != null) {
				valeur = String.valueOf(this.absPr);	
			}
					
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________
		
		return valeur;
		
	} // Fin de getValeurColonne(
	 // int pI).___________________________________________________________
	
	
	
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
