package levy.daniel.application.model.metier.usersimple;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;

/**
 * INTERFACE IUserSimple :<br/>
 * <ul>
 * HERITE de :
 * <li><b>IExportateurCsv</b> pour l'export d'un Objet 
 * métier en csv.</li>
 * <li><b>IExportateurJTable</b> pour l'affichage dans 
 * une JTable (Swing).</li>
 * <li><b>Comparable</b> pour l'affichage des Collections 
 * sous forme triée.</li>
 * <li><b>Cloneable</b> pour garantir que tout objet métier 
 * implémentant cette interface saura se cloner.</li>
 * </ul>
 * <ul>
 * Garantit que tout UserSimple sait :<br/>
 * <li>se comparer à un autre IUserSimple.</li>
 * <li>se cloner.</li>
 * <li>s'exporter sous forme csv.</li>
 * <li>s'exporter sous forme JTable.</li>
 * </ul>
 * Garantit que tout UserSimple possède :<br/>
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
 * <img src="../../../../../../../../../javadoc/images/implementation_UserSimple.png" 
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 28 nov. 2017
 *
 */
public interface IUserSimple 
	extends IExportateurCsv, IExportateurJTable
		, Comparable<IUserSimple>, Cloneable {


	
	/**
	 * method compareTo(
	 * IUserSimple pUserSimple) :<br/>
	 * <ol>
	 * Comparaison de 2 UserSimple par rapport : <br/>
	 * <li>au login.</li>
	 * <li>au mot de passe.</li>
	 * </ol>
	 *
	 * @param pUserSimple : pUserSimple
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pUserSimple.<br/>
	 */
	@Override
	int compareTo(IUserSimple pUserSimple);

	
		
	/**
	 * method clone() :<br/>
	 * Clone un IUserSimple.<br/>
	 * <br/>
	 *
	 * @return IUserSimple : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	IUserSimple clone() throws CloneNotSupportedException;
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * en-tête csv pour un UserSimple :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 */
	@Override
	String getEnTeteCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * ligne csv pour un UserSimple :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 */
	@Override
	String toStringCsv();

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * en-tête Jtable pour un UserSimple :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 */
	@Override
	String getEnTeteColonne(int pI);

	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * ligne Jtable pour un UserSimple :<br/>
	 * "id;civilité;prénom;nom;e-mail;login;mdp;profil;".<br/>
	 * <br/>
	 */
	@Override
	Object getValeurColonne(int pI);
	
	

	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();

	
	
	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	void setId(Long pId);
	
	

	/**
	 * method getCivilite() :<br/>
	 * Getter de la Civilité du UserSimple (M., Mme, Mlle, ...).<br/>
	 * <br/>
	 *
	 * @return civilite : String.<br/>
	 */
	String getCivilite();
	
	

	/**
	* method setCivilite(
	* String pCivilite) :<br/>
	* Setter de la Civilité du UserSimple (M., Mme, Mlle, ...).<br/>
	* <br/>
	*
	* @param pCivilite : String : valeur à passer à civilite.<br/>
	*/
	void setCivilite(String pCivilite);
	
	

	/**
	 * method getPrenom() :<br/>
	 * Getter du Prénom du User.<br/>
	 * <br/>
	 *
	 * @return prenom : String.<br/>
	 */
	String getPrenom();
	
	

	/**
	* method setPrenom(
	* String pPrenom) :<br/>
	* Setter du Prénom du User.<br/>
	* <br/>
	*
	* @param pPrenom : String : valeur à passer à prenom.<br/>
	*/
	void setPrenom(String pPrenom);
	
	

	/**
	 * method getNom() :<br/>
	 * Getter du Nom du User.<br/>
	 * <br/>
	 *
	 * @return nom : String.<br/>
	 */
	String getNom();
	
	

	/**
	* method setNom(
	* String pNom) :<br/>
	* Setter du Nom du User.<br/>
	* <br/>
	*
	* @param pNom : String : valeur à passer à nom.<br/>
	*/
	void setNom(String pNom);
	
	

	/**
	 * method getEmail() :<br/>
	 * Getter de l'E-mail du UserSimple.<br/>
	 * <br/>
	 *
	 * @return email : String.<br/>
	 */
	String getEmail();
	
	

	/**
	* method setEmail(
	* String pEmail) :<br/>
	* Setter de l'E-mail du UserSimple.<br/>
	* <br/>
	*
	* @param pEmail : String : valeur à passer à email.<br/>
	*/
	void setEmail(String pEmail);
	
	

	/**
	 * method getLogin() :<br/>
	 * Getter du Login.<br/>
	 * <br/>
	 *
	 * @return login : String.<br/>
	 */
	String getLogin();
	
	

	/**
	* method setLogin(
	* String pLogin) :<br/>
	* Setter du Login.<br/>
	* <br/>
	*
	* @param pLogin : String : valeur à passer à login.<br/>
	*/
	void setLogin(String pLogin);
	
	

	/**
	 * method getMdp() :<br/>
	 * Getter du Mot de passe.<br/>
	 * <br/>
	 *
	 * @return mdp : String.<br/>
	 */
	String getMdp();
	
	

	/**
	* method setMdp(
	* String pMdp) :<br/>
	* Setter du Mot de passe.<br/>
	* <br/>
	*
	* @param pMdp : String : valeur à passer à mdp.<br/>
	*/
	void setMdp(String pMdp);
	
	

	/**
	 * method getProfil() :<br/>
	 * Getter du Profil du UserSimple 
	 * (administrateur, modérateur, ...).<br/>
	 * <br/>
	 *
	 * @return profil : String.<br/>
	 */
	String getProfil();
	
	

	/**
	* method setProfil(
	* String pProfil) :<br/>
	* Setter du Profil du UserSimple 
	* (administrateur, modérateur, ...).<br/>
	* <br/>
	*
	* @param pProfil : String : valeur à passer à profil.<br/>
	*/
	void setProfil(String pProfil);
	
	

} // FIN DE L'INTERFACE IUserSimple.-----------------------------------------