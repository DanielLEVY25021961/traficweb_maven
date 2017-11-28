package levy.daniel.application.model.metier.localisation;

import java.io.Serializable;

import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




/**
 * class AbstractLocalisationBasePur :<br/>
 * <ul>
 * <li>CLASSE ABSTRAITE COPIE de AbstractLocalisationBasePur 
 * <b>UTILE POUR LA LECTURE DES VUES</b>.</li>
 * <li>Tous les attributs sont passés en String.</li>
 * </ul>
 * CLASSE ABSTRAITE factorisant tous les attributs et comportements 
 * des LocalisationBasePur.
 * <ul>
 * <li>Un <b>même</b> point routier peut être localisé selon les 3 modes suivants : </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/modes_localisation.png" 
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
 * <img src="../../../../../../../../../javadoc/images/modes_localisation_factorises.png" 
 * alt="les 3 modes de localisation" border="1" align="center" />
 * </li>
 * <br/>
 * <ul>
 * <li>la CLASSE ABSTRAITE AbstractLocalisationBasePur IMPLEMENTE ILocalisationBasePur.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/localisation_pures.png" 
 * alt="Localisations pures" border="1" align="center" />
 * </li>
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
public abstract class AbstractLocalisationBasePurString 
	implements ILocalisationBasePurString, Serializable
		, Comparable<ILocalisationBasePurString>, Cloneable {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * serialVersionUID.<br/>
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
	 * route : String :<br/>
	 * Route sur laquelle est située la localisation.<br/>
	 */
	protected String route;
	
	
	/**
	 * cumul : String :<br/>
	 * Abscisse cumulée de la localisation.<br/>
	 * ATTENTION : l'abscisse cumulée peut dépendre
	 * de la chaussée (côté) lorsque deux chaussées
	 * d'une même route ne sont pas jointives.<br/>
	 */
	protected String cumul;

	
	/**
	 * cote : String :<br/>
	 * chaussée (I pour indéfini, D pour Droit, G pour Gauche).<br/>
	 */
	protected String cote;

	
	/**
	 * voie : String :<br/>
	 * Voie de la localisation 
	 * (1 pour la première voie à droite dans le sens de la route).<br/>
	 */
	protected String voie;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(AbstractLocalisationBasePurString.class);

	

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationBasePur() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * A utiliser avec les Setters.<br/>
	 * <br/>
	 */
	public AbstractLocalisationBasePurString() {		
		this(null, null, null, null);		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
		
	
	 /**
	 * method CONSTRUCTEUR AbstractLocalisationBasePur(
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
	public AbstractLocalisationBasePurString(
			final String pRoute
					, final String pCumul						
							, final String pCote
								, final String pVoie) {
		
		super();
		
		/* route. */
		/* ATTENTION : force la mise au format ISIDOR de la route. 
		 * null si impossible. */
		this.route = pRoute;
		
		/* abscisse cumulée. */
		this.cumul = pCumul;
		
		/* côté. */
		this.cote = pCote;

		/* voie. */
		this.voie = pVoie;
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

		 

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
		result = prime * result
				+ ((this.voie == null) ? 0 : this.voie.hashCode());
		
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
	 * 4 - voie.<br/>
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
		if (!(pObj instanceof ILocalisationBasePurString)) {
			return false;
		}
		
		/* Cast. */
		final ILocalisationBasePurString other 
			= (ILocalisationBasePurString) pObj;
		
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
		
		/* 4 - voie. */
		if (this.getVoie() == null) {
			if (other.getVoie() != null) {
				return false;
			}
		} else if (!this.getVoie().equals(other.getVoie())) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(
	 // Object pObj).______________________________________________________
	
	

	/**
	 * method compareTo(
	 * ILocalisationBasePurString pLoc) :<br/>
	 * Comparaison entre deux valueobject pour l'affichage.<br/>
	 * <br/>
	 * 1 - route.<br/>
	 * 2 - cumul.<br/>
	 * 3 - cote.<br/>
	 * 4 - voie.<br/>
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
			final ILocalisationBasePurString pLoc) {
		
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
		int compVoie = 0;

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
				.compareToIgnoreCase(pLoc.getCumul());
			
			if (compCumul != 0) {
				return compCumul;
			}
			
		} // Fin de compCumul.________________________
		
		/* 3 - cote. */
		if (this.getCote() == null) {
			if (pLoc.getCote() != null) {
				return +1;
			}

		} else {
			if (pLoc.getCote() == null) {
				return -1;
			}
				
			compCote = this.getCote()
					.compareToIgnoreCase(pLoc.getCote());
			
			if (compCote != 0) {
				return compCote;
			}
			
		} // Fin de compCote._________________________

				
		/* 4 - voie. */
		if (this.getVoie() == null) {
			if (pLoc.getVoie() != null) {
				return +1;
			}
			
			return 0;
		}

		if (pLoc.getVoie() == null) {
			return -1;
		}
			
		compVoie = this.getVoie()
				.compareTo(pLoc.getVoie());
			
		return compVoie;
		
	} // Fin de compareTo(
	 // Object pValueObject).______________________________________________
	
		

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		/* Création du clone. */
		final ILocalisationBasePurString clone 
			= (ILocalisationBasePurString) super.clone();
				
		/* Passage des attributs au clone. */		
		clone.setRoute(this.route);
		clone.setCumul(this.cumul);
		clone.setCote(this.cote);
		clone.setVoie(this.voie);
						
		return clone;
		
	} // Fin de clone().___________________________________________________
	

	
	/**
	 * {@inheritDoc}<br/>
	 *  Affichage d'une Localisation.<br/>
	 * <br/>
	 */
	@Override
	public String toString() {
		
		final StringBuffer stb = new StringBuffer();
		
		stb.append('[');
		
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
		
		stb.append(']');
		
		return stb.toString();
		
	} // Fin de toString().________________________________________________
	

		
	/**
	 * {@inheritDoc}
	 * <br/>
	 * id;route;cumul;cote;voie;<br/>
	 * <br/>
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
		
		stb.append("voie");
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	
	/**
	 * {@inheritDoc}
	 * <ul>
	 * <li>Retourne la localisation en CSV avec le séparateur
	 * ";" correspondant à l'en-tête fourni par getEnTeteCsv().</li>
	 * <li>L'ordre des champs est :<br/>
	 * "id;route;cumul;cote;voie;"</li>
	 * <li>Remplace les valeurs null par "null" comme 
	 * dans "27;N0186;5896.36;G;null;" avec une voie=null.</li>
	 * </ul>
	 */
	@Override
	public String toStringCsv() {
		
		final StringBuffer stb = new StringBuffer();
		
		/* id. */
		stb.append("null");
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
		
		/* voie. */
		stb.append(this.voie);
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toCsv().___________________________________________________
	

		
	/**
	 * {@inheritDoc} <br/>
	 * "id;route;cumul;cote;voie;"<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public String getEnTeteColonne(
			final int pI) {

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
			
		case 4:
			entete = "voie";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne().________________________________________

	
	
	/**
	 * {@inheritDoc} <br/>
	 * "id;route;cumul;cote;voie;"<br/>
	 */
	@Transient
	@Override
	public Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;

		switch (pI) {

		case 0:
			
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
			
		case 4:
			if (this.voie != null) {
				valeur = String.valueOf(this.voie);
			}
			
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
	public String getRoute() {
		return this.route;
	} // Fin de getRoute().________________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRoute(
			final String pRoute) {		
		this.route = pRoute;
	} // Fin de setRoute(
	 // String pRoute).____________________________________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCumul() {
		return this.cumul;
	} // Fin de getCumul().________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCumul(
			final String pCumul) {
		this.cumul = pCumul;
	} // Fin de setCumul(
	 // Float pCumul)._____________________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCote() {
		return this.cote;
	} // Fin de getCote()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCote(
			final String pCote) {
		this.cote = pCote;
	} // Fin de setCote(
	 // String pCote)._____________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getVoie() {	
		return this.voie;
	} // Fin de getVoie()._________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setVoie(
			final String pVoie) {	
		this.voie = pVoie;
	} // Fin de setVoie(...).______________________________________________

	
	
} // FIN DE LA CLASSE AbstractLocalisationBasePur.------------------------------
