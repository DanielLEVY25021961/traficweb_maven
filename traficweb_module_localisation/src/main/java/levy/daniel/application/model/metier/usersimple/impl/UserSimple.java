package levy.daniel.application.model.metier.usersimple.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.usersimple.IUserSimple;

/**
 * class UserSimple :<br/>
 * <ul>
 * <li>Implémentation <b>CONCRETE</b> de IUserSimple.</li>
 * <li>IMPLEMENTE Serializable.</li>
 * <li>IMPLEMENTE IUserSimple.</li>
 * <br/>
 * <li>Les attributs d'un UserSimple sont : </li>
 * <ul>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>civilite</b> (M., Mme, ...).</li>
 * <li><b>prenom</b>.</li>
 * <li><b>nom</b>.</li>
 * <li><b>e-mail</b>.</li>
 * <li><b>login</b>.</li>
 * <li><b>mot de passe</b>.</li>
 * <li><b>profil</b> (Adminstrateur, Utilisateur, ...).</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_UserSimple.png" 
 * alt="implémentation du UserSimple" border="1" align="center" />
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
 * @since 25 sept. 2017
 *
 */
public class UserSimple 
	implements Serializable, IUserSimple {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	
	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	
	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	private Long id;

	
	/**
	 * civilite : String :<br/>
	 * Civilité du UserSimple (M., Mme, Mlle, ...).<br/>
	 */
	private String civilite;
	
	
	/**
	 * prenom : String :<br/>
	 * Prénom du User.<br/>
	 */
	private String prenom;
	
	
	/**
	 * nom : String :<br/>
	 * Nom du User.<br/>
	 */
	private String nom;
	

	/**
	 * email : String :<br/>
	 * E-mail du UserSimple.<br/>
	 */
	private String email;
	
	
	/**
	 * login : String :<br/>
	 * login.<br/>
	 */
	private String login;

	
	/**
	 * mdp : String :<br/>
	 * Mot de passe.<br/>
	 */
	private String mdp;

	
	/**
	 * profil : String :<br/>
	 * Profil du UserSimple (administrateur, modérateur, ...).<br/>
	 */
	private String profil;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(UserSimple.class);


	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR UserSimple() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public UserSimple() {
		this(null, null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR UserSimple() :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en Base.</li>
	 * </ul>>
	 *
	 * @param pCivilite : String : Civilité du UserSimple 
	 * (M., Mme, Mlle, ...).<br/>
	 * @param pPrenom : String : Prénom du User.<br/>
	 * @param pNom : String : Nom du User.<br/>
	 * @param pEmail : String : E-mail du UserSimple.<br/>
	 * @param pLogin : String : Login.<br/>
	 * @param pMdp : String : Mot de passe.<br/>
	 * @param pProfil : String : Profil du UserSimple 
	 * (administrateur, modérateur, ...).<br/>
	 */
	public UserSimple(
			final String pCivilite
			, final String pPrenom, final String pNom
			, final String pEmail
			, final String pLogin, final String pMdp
				, final String pProfil) {
		
		this(null
				, pCivilite
				, pPrenom, pNom
				, pEmail
				, pLogin, pMdp
				, pProfil);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR UserSimple(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID EN BASE.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCivilite : String : Civilité du UserSimple 
	 * (M., Mme, Mlle, ...).<br/>
	 * @param pPrenom : String : Prénom du User.<br/>
	 * @param pNom : String : Nom du User.<br/>
	 * @param pEmail : String : E-mail du UserSimple.<br/>
	 * @param pLogin : String : Login.<br/>
	 * @param pMdp : String : Mot de passe.<br/>
	 * @param pProfil : String : Profil du UserSimple 
	 * (administrateur, modérateur, ...).<br/>
	 */
	public UserSimple(
			final Long pId
			, final String pCivilite
			, final String pPrenom, final String pNom
			, final String pEmail
			, final String pLogin, final String pMdp
				, final String pProfil) {
		
		super();
		
		this.id = pId;
		this.civilite = pCivilite;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.email = pEmail;
		this.login = pLogin;
		this.mdp = pMdp;
		this.profil = pProfil;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;
		
		int result = 1;
		
		result = prime * result 
				+ ((this.login == null) ? 0 : this.login.hashCode());
		result = prime * result 
				+ ((this.mdp == null) ? 0 : this.mdp.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ol>
	 * equals sur
	 * <li><b>login</b>.</li>
	 * <li><b>mot de passe</b>.</li>
	 * </ol>
	 */
	@Override
	public final boolean equals(
			final Object pObj) {

		if (this == pObj) {
			return true;
		}
		
		if (pObj == null) {
			return false;
		}
		
		if (!(pObj instanceof UserSimple)) {
			return false;
		}
		
		final UserSimple other = (UserSimple) pObj;
		
		/* login. */
		if (this.login == null) {
			if (other.login != null) {
				return false;
			}
		}
		else if (!this.login.equals(other.login)) {
			return false;
		}
		
		/* mdp. */
		if (this.mdp == null) {
			if (other.mdp != null) {
				return false;
			}
		}
		else if (!this.mdp.equals(other.mdp)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IUserSimple pUserSimple) {

		if (this == pUserSimple) {
			return 0;
		}

		if (pUserSimple == null) {
			return -1;
		}

		int compareLogin = 0;
		int compareMdp = 0;
		
		/* login. */
		if (this.getLogin() == null) {
			if (pUserSimple.getLogin() != null) {
				return +1;
			}
		} else {
			if (pUserSimple.getLogin() == null) {
				return -1;
			}
			
			compareLogin 
			= this.getLogin().compareToIgnoreCase(pUserSimple.getLogin());
		
			if (compareLogin != 0) {
				return compareLogin;
			}
		}
		
		

		/* Mdp. */
		if (this.getMdp() == null) {
			if (pUserSimple.getMdp() != null) {
				return +1;
			}
			return 0;
		} 
		
		if (pUserSimple.getMdp() == null) {
			return -1;
		}
		
		compareMdp 
			= this.getMdp().compareToIgnoreCase(pUserSimple.getMdp());
		
		return compareMdp;
		
	} // Fin de compareTo(...).____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IUserSimple clone() throws CloneNotSupportedException {
		
		final IUserSimple userClone = (IUserSimple) super.clone();
		
		userClone.setId(this.getId());
		userClone.setCivilite(this.getCivilite());
		userClone.setPrenom(this.getPrenom());
		userClone.setNom(this.getNom());
		userClone.setEmail(this.getEmail());
		userClone.setLogin(this.getLogin());
		userClone.setMdp(this.getMdp());
		userClone.setProfil(this.getProfil());
		
		return userClone;
		
	} // Fin de clone().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("UserSimple [");
		
		/* id. */
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);
		} else {
			builder.append("null");
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* civilite. */
		builder.append("civilité=");
		if (this.civilite != null) {
			builder.append(this.civilite);
		} else {
			builder.append("null");
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* prenom. */
		builder.append("prénom=");
		if (this.prenom != null) {
			builder.append(this.prenom);
		} else {
			builder.append("null");
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* nom. */
		builder.append("nom=");
		if (this.nom != null) {
			builder.append(this.nom);
		} else {
			builder.append("null");
		}
		
		builder.append(VIRGULE_ESPACE);

		/* email. */
		builder.append("e-mail=");
		if (this.email != null) {
			builder.append(this.email);
		} else {
			builder.append("null");
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* login. */
		builder.append("login=");
		if (this.login != null) {			
			builder.append(this.login);
		} else {
			builder.append("null");
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* mdp. */
		builder.append("mdp=");
		if (this.mdp != null) {			
			builder.append(this.mdp);
		} else {
			builder.append("null");
		}
		
		builder.append(VIRGULE_ESPACE);
		
		/* profil. */
		builder.append("profil=");
		if (this.profil != null) {			
			builder.append(this.profil);
		} else {
			builder.append("null");
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getEnTeteCsv() {
		return "id;civilité;prénom;nom;e-mail;login;mdp;profil;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toStringCsv() {
		
		final StringBuilder stb = new StringBuilder();
		
		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		/* civilite. */
		stb.append(this.getCivilite());
		stb.append(POINT_VIRGULE);
		/* prenom. */
		stb.append(this.getPrenom());
		stb.append(POINT_VIRGULE);
		/* nom. */
		stb.append(this.getNom());
		stb.append(POINT_VIRGULE);
		/* email. */
		stb.append(this.getEmail());
		stb.append(POINT_VIRGULE);
		/* login. */
		stb.append(this.getLogin());
		stb.append(POINT_VIRGULE);
		/* mdp. */
		stb.append(this.getMdp());
		stb.append(POINT_VIRGULE);
		/* profil. */
		stb.append(this.getProfil());
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getEnTeteColonne(
			final int pI) {
		
		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;
			
		case 1:
			entete = "civilité";
			break;
			
		case 2:
			entete = "prénom";
			break;
			
		case 3:
			entete = "nom";
			break;
			
		case 4:
			entete = "e-mail";
			break;

		case 5:
			entete = "login";
			break;

		case 6:
			entete = "mdp";
			break;

		case 7:
			entete = "profil";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			
			break;

		case 1:
			valeur = this.getCivilite();
			break;
			
		case 2:
			valeur = this.getPrenom();
			break;
			
		case 3:
			valeur = this.getNom();
			break;
			
		case 4:
			valeur = this.getEmail();
			break;
			
		case 5:
			valeur = this.getLogin();
			break;

		case 6:
			valeur = this.getMdp();
			break;

		case 7:
			valeur = this.getProfil();
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
	 * {@inheritDoc}
	 */
	@Override
	public String getCivilite() {
		return this.civilite;
	} // Fin de getCivilite()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCivilite(
			final String pCivilite) {
		this.civilite = pCivilite;
	} // Fin de setCivilite(...).__________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrenom() {
		return this.prenom;
	} // Fin de getPrenom()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrenom(
			final String pPrenom) {
		this.prenom = pPrenom;
	} // Fin de setPrenom(...).____________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNom() {
		return this.nom;
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {
		this.nom = pNom;
	} // Fin de setNom(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEmail() {
		return this.email;
	} // Fin de getEmail().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEmail(
			final String pEmail) {
		this.email = pEmail;
	} // Fin de setEmail(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLogin() {	
		return this.login;
	} // Fin de getLogin().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLogin(
			final String pLogin) {	
		this.login = pLogin;
	} // Fin de setLogin(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMdp() {	
		return this.mdp;
	} // Fin de getMdp().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMdp(
			final String pMdp) {	
		this.mdp = pMdp;
	} // Fin de setMdp(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getProfil() {	
		return this.profil;
	} // Fin de getProfil()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProfil(
			final String pProfil) {	
		this.profil = pProfil;
	} // Fin de setProfil(...).____________________________________________

	
	
} // FIN DE LA CLASSE UserSimple.--------------------------------------------------
