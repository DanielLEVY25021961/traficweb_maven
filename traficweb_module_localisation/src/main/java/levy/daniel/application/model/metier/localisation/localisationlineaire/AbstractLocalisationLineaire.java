package levy.daniel.application.model.metier.localisation.localisationlineaire;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Index;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;
import levy.daniel.application.model.metier.localisation.ILocalisationBasePur;

/**
 * class AbstractLocalisationLineaire :<br/>
 * <ul>
 * <li>CLASSE ABSTRAITE FACTORISANT LES ATTRIBUTS ET COMPORTEMENTS
 * de toutes les localisations LINEAIRES 
 * (en PLO + ABSCISSE dans le FEOR).</li>
 * <br/>
 * <li>HERITE de AbstractLocalisationBasePur ce qui fournit : </li>
 * <ul>
 * <li>idBase</li>
 * <li><b>route</b></li>
 * <li><b>cumul</b></li>
 * <li><b>cote</b></li>
 * <li><b>voie</b></li>
 * </ul>
 * <li>Introduit :</li>
 * <ul>
 * <li><b>plo</b></li>
 * <li><b>abs</b> : ATTENTION, c'est une abscisse de PLO 
 * (peut donc être négatif contrairement aux abscisses de PR)</li>
 * </ul>
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
 * @author DAN Lévy
 * @version 1.0
 * @since 24 juin 2012
 *
 */
@Entity(name="AbstractLocalisationLineaire")
@Table(name = "ABSTRACT_LOCALISATIONS_LINEAIRES", schema = "PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_ROUTE_LATERALISATION_PLO_ABS"
, columnNames={"ROUTE", "COTE", "VOIE", "PLO", "ABSCISSE"})
, indexes={@Index(name = "INDEX_ROUTE_LATERALISATION_PLO_ABS", columnList= "ROUTE, COTE, VOIE, PLO, ABSCISSE")})
@PrimaryKeyJoinColumn(name = "ID_ABSTRACTLOCALISATIONBASEPUR"
, foreignKey=@ForeignKey(name="FK_ABSTRACTLOCALISATIONLINEAIRE_ABSTRACTLOCALISATIONBASEPUR"))
public abstract class AbstractLocalisationLineaire 
						extends AbstractLocalisationBasePur 
								implements ILocalisationLineaire {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * UNDERSCORE : char :<br/>
	 * Caractère '_'.<br/>
	 */
	public static final char UNDERSCORE = '_';
	
	
	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';

	
	/**
	 * VIRGULE_SPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_SPACE = ", ";

	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";

	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	

	
	/**
	 * plo : String :<br/>
	 * PLO de la localisation.<br/>
	 */
	protected String plo;

	
	/**
	 * abs : Float :<br/>
	 * Abscisse curviligne de la localisation.<br/>
	 * ATTENTION : cette abscisse peut être négative 
	 * (contrairement à l'abscisse d'un PR).<br/>
	 */
	protected Float abs;


	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(AbstractLocalisationLineaire.class);
	

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationLineaire() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public AbstractLocalisationLineaire() {
		
		this(null, null, null, null, null, null, null);
				
	} // Fin de CONSTRUCTEUR AbstractLocalisationLineaire()._______________
	

		
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationLineaire(
	 * String pRoute, Float pCumul, 
	 * String pPlo, Float pAbs) :<br/>
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
	 */
	public AbstractLocalisationLineaire(
			final String pRoute, final Float pCumul
			, final String pPlo, final Float pAbs) {
		
		this(null, pRoute, pCumul, "I", 100, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR UTILE.________________________________________
	

	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationLineaire(
	 * COMPLET) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS id.</li>
	 * </ul>>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 * @param pVoie : Integer : Voie de la localisation.<br/>
	 * @param pPlo : String : PLO de la localisation.<br/>
	 * @param pAbs : Float : Abscisse curviligne de la localisation.<br/>
	 * ATTENTION : cette abscisse peut être négative 
	 * (contrairement à l'abscisse d'un PR).<br/>
	 */
	public AbstractLocalisationLineaire(
			final String pRoute, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs) {
		
		this(null, pRoute, pCumul, pCote, pVoie, pPlo, pAbs);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationLineaire(
	 * COMPLET BASE) :<br/>
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
	 */
	public AbstractLocalisationLineaire(
			final Long pId
			, final String pRoute, final Float pCumul
			, final String pCote, final Integer pVoie
			, final String pPlo, final Float pAbs) {
		
		super(pId, pRoute, pCumul, pCote, pVoie);
		
		this.plo = pPlo;
		this.abs = pAbs;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		/* passage du hashCode de la super-classe. */
		/* [route;cumul;cote;voie] */
		int result = super.hashCode();
		
		result = prime * result
			+ ((this.plo == null) ? 0 : this.plo.hashCode());
		result = prime * result
			+ ((this.abs == null) ? 0 : this.abs.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________


	
	/**
	 * method equals(
	 * Object pObj) :<br/>
	 * Egalité métier de deux Localisation.<br/>
	 * <br/>
	 * 0 - super-classe.<br/>
	 * 1 - plo.<br/>
	 * 2 - abs.<br/>
	 * <br/>
	 *
	 * @param pObj : Object.<br/>
	 * 
	 * @return boolean.<br/>
	 */
	@Override
	public boolean equals(
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
		 /* [route;cumul;cote;voie;]. */
		if (!super.equals(pObj)) {
			return false;
		}
		
		/* Mauvaise instance : false. */
		if (!(pObj instanceof AbstractLocalisationLineaire)) {
			return false;
		}
		
		/* Cast. */
		final AbstractLocalisationLineaire other 
			= (AbstractLocalisationLineaire) pObj;
		
		/* 1 - plo. */
		if (this.plo == null) {
			if (other.plo != null) {
				return false;
			}
		} else if (!this.plo.equalsIgnoreCase(other.plo)) {
			return false;
		}
		
		/* 2 - abs. */
		if (this.abs == null) {
			if (other.abs != null) {
				return false;
			}
		} else if (!this.abs.equals(other.abs)) {
			return false;
		}
				
		return true;
		
	} // Fin de equals(
	 // Object pObj).______________________________________________________

	
	
	/**
	 * method compareTo(
	 * ILocalisationBasePur pOther) :<br/>
	 * Comparaison de deux localisations linéaires pour l'affichage.<br/>
	 * <br/>
	 * 0 - Super-Classe.<br/>
	 * 1 - plo.<br/>
	 * 2 - abs.<br/>
	 * <br/>
	 * Contrat Java : x.equals(y) ---> x.compareTo(y) == 0.<br/>
	 * <br/>
	 *
	 * @param pOther : Object.<br/>
	 * 
	 * @return int :<br/>
	 * - -1 si le présent valueobjet est "plus petit", 
	 * "au dessus" ou "avant" le comparé dans l'affichage d'une liste.<br/>
	 *  Par exemple, 'a avant b'
	 * ou '1 au dessus de 2' dans l'affichage.<br/>
	 * - 0 si ils sont au même niveau.<br/>
	 * - +1 si le comparé est "plus grand" ou "au dessous" ou "avant" le
	 * comparé dans l'afichage d'une liste.<br/>
	 */
	@Override
	public int compareTo(
			final ILocalisationBasePur pOther) {
		
		/* Même instance : 0. */
		if (this == pOther) {
			return 0;
		}
		
		/* Paramètre null : -1. */
		if (pOther == null) {
			return -1;
		}
		
		/* Mauvaise instance : -1. */
		if (!(pOther instanceof ILocalisationLineaire)) {
			return -1;
		}
		
		/* Cast. */
		final ILocalisationLineaire other 
			= (ILocalisationLineaire) pOther;
		
		/* 0 - Comparaison des super-classes 
		 * (si héritage). */
		if (super.compareTo(other) != 0) {
			return super.compareTo(other);
		}
		
		
		int compPlo = 0;
		int compAbs = 0;

		
		/* 1 - plo. */
		if (this.getPlo() == null) {
			if (other.getPlo() != null) {
				return +1;
			}
		}
		else {
			if (other.getPlo() == null) {
				return -1;
			}
			
			compPlo = this.getPlo()
				.compareToIgnoreCase(other.getPlo());
			
			if (compPlo != 0) {
				return compPlo;
			}
			
		} // Fin de compPlo.____________________________
		
		/* 2 - abs. */
		if (this.getAbs() == null) {
			if (other.getAbs() != null) {
				return +1;
			}
			
			/* Retourne 0 si tous 
			 * les membres de equals() sont null. */
			return 0;
		}
		
		compAbs = this.getAbs()
			.compareTo(other.getAbs());
		
		return compAbs;
		
	} // Fin de compareTo(
	 // Object pLocalisation)._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() 
			throws CloneNotSupportedException {
		
		/* Création du clone. */
		final ILocalisationLineaire clone 
			= (ILocalisationLineaire) super.clone();
						
		/* Passage des attributs au clone. */
		clone.setId(this.id);
		
		clone.setRoute(this.route);
		clone.setCumul(this.cumul);
		clone.setCote(this.cote);
		clone.setVoie(this.voie);
		
		clone.setPlo(this.plo);
		clone.setAbs(this.abs);
		
		return clone;
		
	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}<br/>
	 * <ul>
	 * <li>Affichage d'une Localisation Linéaire.</li>
	 * <li>[id - route - cumul - cote - voie - plo - abs]</li>
	 * </ul>
	 */
	@Override
	public String toString() {
		
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
		
		stb.append(']');
		
		return stb.toString();
		
	} // Fin de toString().________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * Pour une Localisation linéaire en PLO :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public String getEnTeteCsv() {
		
		final StringBuffer stb = new StringBuffer();
		
		/* Ajout de id;route;cumul;cote;voie;. */
		stb.append(super.getEnTeteCsv());
		
		/* Ajout de plo;abs; */
		stb.append("plo");
		stb.append(POINT_VIRGULE);
		
		stb.append("abs");
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 * <ul>
	 * <li>Retourne la localisation en CSV avec le séparateur
	 * ";" correspondant à l'en-tête fourni par getEnTeteCsv().</li>
	 * <li>L'ordre des champs est :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;".</li>
	 * <li>Remplace les valeurs null par "null" comme 
	 * dans "27;N0186;5896.36;G;null;" avec une voie=null.</li>
	 * </ul>
	 */
	@Override
	public String toStringCsv() {
		
		final StringBuffer stb = new StringBuffer();
		
		/* Ajout de id;route;cumul;cote;voie;. */
		stb.append(super.toStringCsv());
		
		stb.append(this.plo);
		stb.append(POINT_VIRGULE);
		
		stb.append(this.abs);
		stb.append(POINT_VIRGULE);
						
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________
	
	

	/**
	 * {@inheritDoc} <br/>
	 * Pour une Localisation linéaire en PLO :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public String getEnTeteColonne(
			final int pI) {
		
		String entete = null;
		
		if (pI < 5) {
			return super.getEnTeteColonne(pI);
		}
		
		switch (pI) {

		case 5:
			entete = "plo";
			break;

		case 6:
			entete = "abs";
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
	 * Pour une Localisation linéaire en PLO :<br/>
	 * "id;route;cumul;cote;voie;plo;abs;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;
		
		if (pI < 5) {
			return super.getValeurColonne(pI);
		}
		
		switch (pI) {

		case 5:
			valeur = this.plo;
			break;

		case 6:
			if (this.abs != null) {
				valeur = String.valueOf(this.abs);
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
	 * method getPlo() :<br/>
	 * Getter du PLO de la localisation.<br/>
	 * <br/>
	 *
	 * @return plo : String.<br/>
	 */
	@Column(name = "PLO"
		, unique = false, nullable = true
		, updatable = true, insertable = true)
	@Override
	public String getPlo() {
		return this.plo;
	} // Fin de getPlo().__________________________________________________
	

	
	/**
	 * method setPlo(
	 * String pPlo) :<br/>
	 * Setter du PLO de la localisation.<br/>
	 * <br/>
	 * [dept - 'PR' -n°PR - Indice du PR (lettre opt) 
	 * - Côté (U,D, ou G) - Concession (C ou rien)] 
	 * comme dans 73PR7UC ou 74PR118aG pour un PLO de Type PR.<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pPlo : String.<br/>
	 */
	@Override
	public void setPlo(
			final String pPlo) {
		
		this.plo = pPlo;
				
	} // Fin de setPlo(
	 // String pPlo).______________________________________________________


	
	/**
	 * method getAbs() :<br/>
	 * Getter de l'abscisse curviligne de la localisation.<br/>
	 * <br/>
	 *
	 * @return abs : Float.<br/>
	 */
	@Column(name = "ABSCISSE"
			, unique = false, nullable = true
			, updatable = true, insertable = true)
	@Override
	public Float getAbs() {
		return this.abs;
	} // Fin de getAbs().__________________________________________________

	
	
	/**
	 * method setAbs(
	 * Float pAbscisse) :<br/>
	 * Setter de l'abscisse curviligne de la localisation.<br/>
	 * <br/>
	 * ATTENTION : Setter à utiliser par Hibernate. 
	 * Ne fait qu'injecter la valeur lue dans la base.<br/>
	 * <br/>
	 *
	 * @param pAbscisse : Float.<br/>
	 */
	@Override
	public void setAbs(
			final Float pAbscisse) {
		
		this.abs = pAbscisse;
				
	} // Fin de setAbs(
	 // Float pAbscisse).__________________________________________________
	


} // FIN DE LA CLASSE AbstractLocalisationLineaire.--------------------------
