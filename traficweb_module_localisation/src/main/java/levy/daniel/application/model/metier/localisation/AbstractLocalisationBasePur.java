package levy.daniel.application.model.metier.localisation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




/**
 * class AbstractLocalisationBasePur :<br/>
 * CLASSE ABSTRAITE factorisant tous les attributs et comportements 
 * des LocalisationBasePur.
 * <ul>
 * <li>IMPLEMENTE ILocalisationBasePur.</li>
 * </ul>
 * 
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
@Entity(name="AbstractLocalisationBasePur")
@Table(name = "ABSTRACT_LOCALISATIONS_BASE_PURES", schema = "PUBLIC"
, uniqueConstraints=@UniqueConstraint(name="UNICITE_ROUTE_CUMUL_COTE"
, columnNames={"ROUTE", "CUMUL", "COTE"})
, indexes={@Index(name = "INDEX_ROUTE", columnList="ROUTE")})
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractLocalisationBasePur 
	implements ILocalisationBasePur, Serializable
		, Comparable<ILocalisationBasePur>, Cloneable {

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
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	protected Long id;
	
		
	/**
	 * route : String :<br/>
	 * Route sur laquelle est située la localisation.<br/>
	 */
	protected String route;
	
	
	/**
	 * cumul : Float :<br/>
	 * Abscisse cumulée de la localisation.<br/>
	 * ATTENTION : l'abscisse cumulée peut dépendre
	 * de la chaussée (côté) lorsque deux chaussées
	 * d'une même route ne sont pas jointives.<br/>
	 */
	protected Float cumul;

	
	/**
	 * cote : String :<br/>
	 * chaussée (I pour indéfini, D pour Droit, G pour Gauche).<br/>
	 */
	protected String cote;
	
			
	/**
	 * SET_COTES_VALABLES : Set<String> :<br/>
	 * Ensemble des cotes admis (I, G, D).<br/>
	 */
	public static final Set<String> SET_COTES_VALABLES 
		= new HashSet<String>();
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(AbstractLocalisationBasePur.class);

	
	static {
		
		SET_COTES_VALABLES.add("I");
		SET_COTES_VALABLES.add("i");
		SET_COTES_VALABLES.add("G");
		SET_COTES_VALABLES.add("g");
		SET_COTES_VALABLES.add("D");
		SET_COTES_VALABLES.add("d");

	}

	

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public AbstractLocalisationBasePur() {		
		this(null, null, null, null);		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationBasePur(
	 * String pRoute
	 * , Float pCumul) :<br/>
	 * CONSTRUCTEUR : <br/>
	 * - SANS IDENTIFIANT EN BASE (null).<br/>
	 * - SANS COTE = AVEC COTE INDETERMINE "I" (portée ROUTE).<br/>
	 * <br/>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 */
	public AbstractLocalisationBasePur(
			final String pRoute
				, final Float pCumul) {		
		this(null, pRoute, pCumul, "I");		
	} // Fin de CONSTRUCTEUR AbstractLocalisationBasePur(
	 // String pRoute
	 // , Float pCumul).___________________________________________________
	

		
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationBasePur(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET :<br/>
	 * <ul>
	 * <li>SANS IDENTIFIANT EN BASE (null).</li>
	 * <li>AVEC COTE.</li>
	 * </ul>
	 *
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 */
	public AbstractLocalisationBasePur(
			final String pRoute
					, final Float pCumul						
							, final String pCote) {
		
		this(null, pRoute, pCumul, pCote);
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationBasePur(
	 * Long pIdBase
	 * , String pRoute
	 * , Float pCumul
	 * , String pCote
	 * , IORS pOrs) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.
	 * <ul>
	 * <li>AVEC IDENTIFIANT EN BASE.</li>
	 * <li>AVEC COTE.</li>
	 * </ul>
	 * 
	 * @param pId : Long : identifiant en base.<br/>
	 * @param pRoute : String : Nom ISIDOR de la route.<br/>
	 * @param pCumul : Float : abscisse cumulée de la localisation.<br/>
	 * @param pCote : String : cote de la route (I, D ou G).<br/>
	 */
	public AbstractLocalisationBasePur(
			final Long pId
				, final String pRoute
					, final Float pCumul						
							, final String pCote) {
		
		super();
		
		/* Identifiant en Base. */
		this.id = pId;
		
		/* route. */
		/* ATTENTION : force la mise au format ISIDOR de la route. 
		 * null si impossible. */
		this.route = pRoute;
		
		/* abscisse cumulée. */
		this.cumul = pCumul;
		
		/* côté. */
		this.cote = pCote;

				
	} // Fin de CONSTRUCTEUR AbstractLocalisationBasePur(
	 // Long pIdBase
	 // , String pRoute
	 // , Float pCumul
	 // , String pCote
	 // , IORS pOrs)._______________________________________________
	 
	 

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result
			+ ((this.route == null) ? 0 : this.route.hashCode());
		result = prime * result
			+ ((this.cumul == null) ? 0 : this.cumul.hashCode());
		result = prime * result
				+ ((this.cote == null) ? 0 : this.cote.hashCode());		
		
		return result;
		
	} // Fin de hashCode().________________________________________________


	
	/**
	 * {@inheritDoc}<br/>
	 * <br/>
	 * Egalité métier de deux Localisation.<br/>
	 * <br/>
	 * 1 - route.<br/>
	 * 2 - cumul.<br/>
	 * 3 - cote.<br/>
	 * <br/>
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
				
		/* Mauvaise instance : false. */
		if (!(pObj instanceof ILocalisationBasePur)) {
			return false;
		}
		
		/* Cast. */
		final ILocalisationBasePur other 
			= (ILocalisationBasePur) pObj;
		
		/* 1 - route. */
		if (this.getRoute() == null) {
			if (other.getRoute() != null) {
				return false;
			}
		} else if (!this.getRoute()
				.equalsIgnoreCase(other.getRoute())) {
			return false;
		}
		
		/* 2 - cumul. */
		if (this.getCumul() == null) {
			if (other.getCumul() != null) {
				return false;
			}
		} else if (!this.getCumul().equals(other.getCumul())) {
			return false;
		}

		/* 3 - cote. */
		if (this.getCote() == null) {
			if (other.getCote() != null) {
				return false;
			}
		} else if (!this.getCote().equalsIgnoreCase(other.getCote())) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(
	 // Object pObj).______________________________________________________
	
	

	/**
	 * method compareTo(
	 * ILocalisationBasePur pLoc) :<br/>
	 * Comparaison entre deux valueobject pour l'affichage.<br/>
	 * <br/>
	 * 1 - route.<br/>
	 * 2 - cumul.<br/>
	 * 3 - cote.<br/>
	 * <br/>
	 * Contrat Java : x.equals(y) ---> x.compareTo(y) == 0.<br/>
	 * <br/>
	 *
	 * @param pLoc : ILocalisationBasePur.<br/>
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
			final ILocalisationBasePur pLoc) {
		
		/* Même instance : 0. */
		if (this == pLoc) {
			return 0;
		}
		
		/* Paramètre null : -1. */
		if (pLoc == null) {
			return -1;
		}
								
		int compRoute = 0;
		int compCumul = 0;
		int compCote = 0;

		/* 1 - route. */
		if (this.getRoute() == null) {
			if (pLoc.getRoute() != null) {
				return +1;
			}			
		}
		else {
			if (pLoc.getRoute() == null) {
				return -1;
			}
			
			compRoute = this.getRoute()
				.compareToIgnoreCase(pLoc.getRoute());
			
			if (compRoute != 0) {
				return compRoute;
			}
			
		} // Fin de compRoute.________________________

		/* 2 - cumul. */
		if (this.getCumul() == null) {
			if (pLoc.getCumul() != null) {
				return +1;
			}
		}
		else {
			if (pLoc.getCumul() == null) {
				return -1;
			}
			
			compCumul = this.getCumul()
				.compareTo(pLoc.getCumul());
			
			if (compCumul != 0) {
				return compCumul;
			}
			
		} // Fin de compCumul.________________________
		
		/* 3 - cote. */
		if (this.getCote() == null) {
			if (pLoc.getCote() != null) {
				return +1;
			}
			
			return 0;
		}

		if (pLoc.getCote() == null) {
			return -1;
		}
			
		compCote = this.getCote()
				.compareToIgnoreCase(pLoc.getCote());
			
		return compCote;
		
	} // Fin de compareTo(
	 // Object pValueObject).______________________________________________
	
		

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		/* Création du clone. */
		final AbstractLocalisationBasePur clone 
			= (AbstractLocalisationBasePur) super.clone();
				
		/* Passage des attributs au clone. */
		clone.setId(this.id);
		clone.setRoute(this.route);
		clone.setCumul(this.cumul);
		clone.setCote(this.cote);
						
		return clone;
		
	} // Fin de clone().___________________________________________________
	

	
	/**
	 * method toString() :<br/>
	 * Affichage d'une Localisation.<br/>
	 * <br/>
	 *
	 * @return String.<br/>
	 */
	@Override
	public String toString() {
		
		final StringBuffer stb = new StringBuffer();
		
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
		
		stb.append(']');
		
		return stb.toString();
		
	} // Fin de toString().________________________________________________
	

	
	/**
	 * method getEnTeteCsv() :<br/>
	 * Retourne l'En-Tête pour les fichiers CSV de Localisation.<br/>
	 * <br/>
	 * id;route;cumul;cote;<br/>
	 * <br/>
	 *
	 * @return : String : En-Tête de la Localisation en CSV.<br/>
	 */
	@Transient
	@Override
	public String getEnTeteCsv() {
		
		final StringBuffer stb = new StringBuffer();
		
		stb.append("id");			
		stb.append(POINT_VIRGULE);
				
		stb.append("route");
		stb.append(POINT_VIRGULE);
		
		stb.append("cumul");
		stb.append(POINT_VIRGULE);
		
		stb.append("cote");
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * method toStringCsv() :<br/>
	 * Retourne la localisation en CSV avec le séparateur
	 * ";" correspondant à l'en-tête fourni par getEnTeteCsv().<br/>
	 * L'ordre des champs est :<br/>
	 * "id;route;cumul;cote;"<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	@Override
	public String toStringCsv() {
		
		final StringBuffer stb = new StringBuffer();
		
		/* idBase. */
		stb.append(this.id);					
		stb.append(POINT_VIRGULE);
		
		/* route. */
		stb.append(this.route);
		stb.append(POINT_VIRGULE);
		
		/* cumul. */
		stb.append(this.cumul);
		stb.append(POINT_VIRGULE);
		
		/* cote. */
		stb.append(this.cote);
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toCsv().___________________________________________________
	

		
	/**
	 * {@inheritDoc} <br/>
	 * "id;route;cumul;cote;"<br/>;
	 */
	@Override
	public String getEnTeteColonne(final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "route";
			break;

		case 2:
			entete = "cumul";
			break;

		case 3:
			entete = "cote";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne().________________________________________

	
	
	/**
	 * {@inheritDoc} <br/>
	 * "id;route;cumul;cote;"<br/>
	 */
	@Transient
	@Override
	public Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.id != null) {
				valeur = String.valueOf(this.id);
			} 
			
			break;

		case 1:
			valeur = this.route;
			break;

		case 2:
			if (this.cumul != null) {
				valeur = String.valueOf(this.cumul);
			}
			
			break;

		case 3:
			valeur = this.cote;
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean devance(
			final ILocalisationBasePur pLocalisation) {
		
		/* retourne toujours false si pLocalisation est null. */
		if (pLocalisation == null) {
			return false;
		}
		
		/* retourne toujours false si pLocalisation est 
		 * la présente Localisation.*/
		if (this == pLocalisation) {
			return false;
		}
		
		/* retourne toujours false si la route de la 
		 * présente Localisation ou de pLocalisation est null.*/
		if (StringUtils.isBlank(this.route) 
					|| StringUtils.isBlank(pLocalisation.getRoute())) {
			return false;
		}
		
		/* retourne toujours false si le côté de la route de la 
		 * présente Localisation ou de pLocalisation est null.*/
		if (StringUtils.isBlank(this.cote) 
				|| StringUtils.isBlank(pLocalisation.getCote())) {
			return false;
		}
		
		/* traitement métier. */
		/* Même route et même côté obligatoires. */
		if (StringUtils.equalsIgnoreCase(this.route, pLocalisation.getRoute()) 
				&& StringUtils.equalsIgnoreCase(this.cote, pLocalisation.getCote())) {
			
			/* retourne toujours false si this.cumul == null. */
			if (this.cumul == null) {
				return false;
			}
			
			/* retourne toujours false si pLocalisation.getCumul() == null. */
			if (pLocalisation.getCumul() == null) {
				return false;
			}
			
			if (this.cumul < pLocalisation.getCumul()) {
				return true;
			}
			
			return false;
		}
		
		/* retourne toujours false si routes différentes ou côtés différents. */
		return false;
		
	} // Fin de devance(
	 // ILocalisationBase pLocalisation).__________________________________
	
			

	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ABSTRACTLOCALISATIONBASEPUR")
	@Override
	public Long getId() {	
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {	
		this.id = pId;
	} // Fin de setId(...).________________________________________________



	/**
	 * method getRoute() :<br/>
	 * Getter de la Route de la localisation.<br/>
	 * <br/>
	 *
	 * @return route : String.<br/>
	 */
	@Column(name = "ROUTE"
	, unique = false, nullable = true
	, updatable = true, insertable = true)	
	@Override
	public String getRoute() {
		return this.route;
	} // Fin de getRoute().________________________________________________
	
	

	/**
	 * method setRoute(
	 * String pRoute) :<br/>
	 * Setter de la Route de la localisation.<br/>
	 * <br/>
	 *
	 * @param pRoute : String : valeur à passer à route.<br/>
	 */	
	@Override
	public void setRoute(
			final String pRoute) {		
		this.route = pRoute;
	} // Fin de setRoute(
	 // String pRoute).____________________________________________________
	

	
	/**
	 * method getCumul() :<br/>
	 * Getter de l'abscisse cumulée de la localisation.<br/>
	 * <br/>
	 *
	 * @return cumul : Float.<br/>
	 */
	@Column(name = "CUMUL"
	, unique = false, nullable = true
	, updatable = true, insertable = true)
	@Override
	public Float getCumul() {
		return this.cumul;
	} // Fin de getCumul().________________________________________________
	
	

	/**
	 * method setCumul(
	 * Float pCumul) :<br/>
	 * Setter de l'abscisse cumulée de la localisation.<br/>
	 * <br/>
	 *
	 * @param pCumul : Float.<br/>
	 */
	@Override
	public void setCumul(
			final Float pCumul) {
		this.cumul = pCumul;
	} // Fin de setCumul(
	 // Float pCumul)._____________________________________________________


		
	/**
	 * method getCote() :<br/>
	 * Getter de la chaussée 
	 * (I pour indéfini, D pour Droit, G pour Gauche).<br/>
	 * <br/>
	 *
	 * @return cote : String.<br/>
	 */
	@Column(name = "COTE"
		, unique = false, nullable = true
		, updatable = true, insertable = true)
	@Override
	public String getCote() {
		return this.cote;
	} // Fin de getCote()._________________________________________________



	/**
	 * method setCote(
	 * String pCote) :<br/>
	 * Setter de la chaussée 
	 * (I pour indéfini, D pour Droit, G pour Gauche).<br/>
	 * <br/>
	 *
	 * @param pCote : String : valeur à passer à cote.<br/>
	 */
	@Override
	public void setCote(
			final String pCote) {
		this.cote = pCote;
	} // Fin de setCote(
	 // String pCote)._____________________________________________________


	
} // FIN DE LA CLASSE AbstractLocalisationBasePur.------------------------------
