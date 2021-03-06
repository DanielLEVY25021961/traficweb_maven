package levy.daniel.application.apptechnic.configurationmanagers;

import java.io.File;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.ConfigurationApplicationManager;
import levy.daniel.application.apptechnic.exceptions.technical.impl.FichierInexistantRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.FichierNullRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.FichierRepertoireRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.FichierVideRunTimeException;

/**
 * class ConfigurationNomenclaturesHistoF07Manager :<br/>
 * Classe UTILITAIRE 
 * chargée de gérer la configuration des 
 * NOMENCLATURES DES CHAMPS A NOMENCLATURE DU FICHIER HISTO_F07.<br/>
 * Met à disposition de l'ensemble de l'application 
 * des Singletons.<br/>
 * <br/>
 * <ul>
 * <li>La méthode getCheminNomenclaturesHistoF07Utf8 fournit un Singleton 
 * du chemin vers les nomenclatures encodées en UTF-8 
 * des champs à nomenclature 
 * du fichier HISTO_F07.</li><br/>
 * <li>Les méthodes getNomNomenclatureXXX fournissent un singleton  
 * du nom du fichier de nomenclature du champXXX 
 * encodé en UTF-8 dans le HISTO_F07.</li><br/>
 * <li>Les méthodes getFichierNomenclatureXXX fournissent un singleton  
 * du fichier de nomenclature du champXXX 
 * encodé en UTF-8 dans le HISTO_F07.</li><br/>
 * </ul>
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
 * @since 16 avr. 2016
 *
 */
public final class ConfigurationNomenclaturesHistoF07Manager {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CLASSE_CONFIGURATIONNOMENCLATURESHISTO_F07 : String :<br/>
	 * "Classe ConfigurationNomenclaturesHistoF07Manager".<br/>
	 */
	public static final String CLASSE_CONFIGURATIONNOMENCLATURESHISTO_F07 
		= "Classe ConfigurationNomenclaturesHistoF07Manager";
	
	
	/**
	 * METHODE_GET_CHEMINNOMENCLATURES_HISTO_F07 : String :<br/>
	 * "Méthode getCheminNomenclaturesHistoF07Utf8".<br/>
	 */
	public static final String METHODE_GET_CHEMINNOMENCLATURES_HISTO_F07 
		= "Méthode getCheminNomenclaturesHistoF07Utf8";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_SENS : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07Sens()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_SENS 
		= "Méthode getNomNomenclatureHistoF07Sens()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_NATURE : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07Nature()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_NATURE 
		= "Méthode getNomNomenclatureHistoF07Nature()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CATADMINROUTE : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07CatAdminRoute()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CATADMINROUTE 
		= "Méthode getNomNomenclatureHistoF07CatAdminRoute()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPECOMPTAGE : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07TypeComptage()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPECOMPTAGE 
		= "Méthode getNomNomenclatureHistoF07TypeComptage()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSEMENTROUTE : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07ClassementRoute()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSEMENTROUTE 
		= "Méthode getNomNomenclatureHistoF07ClassementRoute()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEEU : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07ClasseLargeurChausseeU()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEEU 
		= "Méthode getNomNomenclatureHistoF07ClasseLargeurChausseeU()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEESS : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07ClasseLargeurChausseesS()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEESS 
		= "Méthode getNomNomenclatureHistoF07ClasseLargeurChausseesS()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPERESEAU : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07TypeReseau()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPERESEAU 
		= "Méthode getNomNomenclatureHistoF07TypeReseau()";

	
	/**
	 * METHODE_GET_NOMNOMENCLATURE_HISTO_F07_PRPK : String :<br/>
	 * "Méthode getNomNomenclatureHistoF07PrPk()".<br/>
	 */
	public static final String METHODE_GET_NOMNOMENCLATURE_HISTO_F07_PRPK 
		= "Méthode getNomNomenclatureHistoF07PrPk()";
	

	
	//*****************************************************************/
	//**************************** BOM_UTF-8 **************************/
	//*****************************************************************/
	/**
	 * BOM_UTF : char :<br/>
	 * BOM UTF-8 pour forcer Excel 2010 à lire en UTF-8.<br/>
	 */
	public static final char BOM_UTF_8 = '\uFEFF';

	
	//*****************************************************************/
	//**************************** SEPARATEURS ************************/
	//*****************************************************************/
	/**
	 * SEP_PV : String :<br/>
	 * Séparateur pour les CSV ";".<br/>
	 */
	public static final String SEP_PV = ";";

    
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";
	
	
	/**
	 * UNDERSCORE : String :<br/>
	 * "_".<br/>
	 */
	public static final String UNDERSCORE = "_";


	//*****************************************************************/
	//**************************** SAUTS ******************************/
	//*****************************************************************/	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");

	
	//*****************************************************************/
	//**************************** LOCALE *****************************/
	//*****************************************************************/
	/**
	 * LOCALE_FR : Locale : <br/>
	 * Locale France.<br/>
	 */
	public static final Locale LOCALE_FR = new Locale("fr", "FR");

	
	// ******************************************************************
	// NOMENCLATURES.****************************************************
	// ******************************************************************
		
	// HISTO_F07.*********************
	
	/**
	 * cheminNomenclaturesHistoF07Utf8 : String :<br/>
	 * Chemin des nomenclatures en UTF-8 des champs pour les HISTO_F07
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.chemin.histof07.utf8".<br/>
	 */
	private static transient String cheminNomenclaturesHistoF07Utf8;
	
	
	/**
	 * nomNomenclatureHistoF07Sens : String :<br/>
	 * Nom du fichier de nomenclature du sens pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.sens.histof07".<br/>
	 */
	private static transient String nomNomenclatureHistoF07Sens;

	
	/**
	 * fichierNomenclatureHistoF07SensUtf8 : File :<br/>
	 * Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le SENS
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\
	 * 2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 */
	private static transient File fichierNomenclatureHistoF07SensUtf8;

	
	/**
	 * nomNomenclatureHistoF07Nature : String :<br/>
	 * Nom du fichier de nomenclature de la nature pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.nature.histof07".<br/>
	 */
	private static transient String nomNomenclatureHistoF07Nature;

	
	/**
	 * fichierNomenclatureHistoF07NatureUtf8 : File :<br/>
	 * Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la NATURE du comptage 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 */
	private static transient File fichierNomenclatureHistoF07NatureUtf8;
	

	/**
	 * nomNomenclatureHistoF07TypeComptage : String :<br/>
	 * Nom du fichier de nomenclature du type de comptage 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.typecomptage.histof07"<br/>
	 */
	private static transient String nomNomenclatureHistoF07TypeComptage;

		
	/**
	 * fichierNomenclatureHistoF07TypeComptageUtf8 : File :<br/>
	 * Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE COMPTAGE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 */
	private static transient File fichierNomenclatureHistoF07TypeComptageUtf8;
	

	/**
	 * nomNomenclatureHistoF07ClassementRoute : String :<br/>
	 * Nom du fichier de nomenclature du classement de la route 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.classementroute.histof07"<br/>
	 */
	private static transient String nomNomenclatureHistoF07ClassementRoute;

		
	/**
	 * fichierNomenclatureHistoF07ClassementRouteUtf8 : File :<br/>
	 * Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le CLASSEMENT DE LA ROUTE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 */
	private static transient File fichierNomenclatureHistoF07ClassementRouteUtf8;
	

	/**
	 * nomNomenclatureHistoF07ClasseLargeurChausseeU : String :<br/>
	 * Nom du fichier de nomenclature 
	 * de la classe de largeur de chaussée unique
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.classelargeurchausseeu.histof07"<br/>
	 */
	private static transient String nomNomenclatureHistoF07ClasseLargeurChausseeU;
	
		
	/**
	 * fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8 : File :<br/>
	 * Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 */
	private static transient File fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8;
	

	/**
	 * nomNomenclatureHistoF07ClasseLargeurChausseesS : String :<br/>
	 * Nom du fichier de nomenclature 
	 * de la classe de largeur de chaussées séparées
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chaussees_Separees_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.classelargeurchausseess.histof07"<br/>
	 */
	private static transient String nomNomenclatureHistoF07ClasseLargeurChausseesS;
	
		
	/**
	 * fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8 : File :<br/>
	 * Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausses_Séparées_HistoF07_Utf8.csv".<br/>
	 */
	private static transient File fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8;
	

	/**
	 * nomNomenclatureHistoF07TypeReseau : String :<br/>
	 * Nom du fichier de nomenclature du type de réseau
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.typereseau.histof07"<br/>
	 */
	private static transient String nomNomenclatureHistoF07TypeReseau;
	
		
	/**
	 * fichierNomenclatureHistoF07TypeReseauUtf8 : File :<br/>
	 * Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE RESEAU 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 */
	private static transient File fichierNomenclatureHistoF07TypeReseauUtf8;
	

	/**
	 * rapportConfigurationCsv : String :<br/>
	 * Rapport du chargement de la configuration au format csv.<br/>
	 * Le rapport est null si il n'y a eu aucun 
	 * problème d'initialisation de l'application.<br/>
	 */
	private static transient String rapportConfigurationCsv;

	
	/**
	 * messageIndividuelRapport : String :<br/>
	 * Message pour le Rapport du chargement de la configuration au format csv 
	 * généré par chaque méthode individuellement.<br/>
	 */
	private static transient String messageIndividuelRapport;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(ConfigurationNomenclaturesHistoF07Manager.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationNomenclaturesHistoF07Manager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour interdire l'instanciation.<br/>
	 * <br/>
	 */
	private ConfigurationNomenclaturesHistoF07Manager() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	

	/**
	 * method getCheminNomenclaturesHistoF07Utf8() :<br/>
	 * Getter du Chemin des nomenclatures en UTF-8 des champs pour les HISTO_F07
	 * stocké dans application.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirCheminNomenclaturesHistoF07Utf8EnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.chemin.histof07.utf8".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesHistoF07Utf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirCheminNomenclaturesHistoF07Utf8EnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return cheminNomenclaturesHistoF07Utf8 : String.<br/>
	 */
	public static String getCheminNomenclaturesHistoF07Utf8() {

		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (cheminNomenclaturesHistoF07Utf8 == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleCheminNomenclaturesHistoF07Utf8());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_CHEMINNOMENCLATURES_HISTO_F07,
								fournirCleCheminNomenclaturesHistoF07Utf8(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							cheminNomenclaturesHistoF07Utf8 
								= fournirCheminNomenclaturesHistoF07Utf8EnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							cheminNomenclaturesHistoF07Utf8 = valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_CHEMINNOMENCLATURES_HISTO_F07,
								fournirCleCheminNomenclaturesHistoF07Utf8(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						cheminNomenclaturesHistoF07Utf8 
							= fournirCheminNomenclaturesHistoF07Utf8EnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					cheminNomenclaturesHistoF07Utf8 
						= fournirCheminNomenclaturesHistoF07Utf8EnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (cheminNomenclaturesHistoF07Utf8 == null)._________

			return cheminNomenclaturesHistoF07Utf8;

		} // Fin de synchronized.________________________________________

	} // Fin de getCheminNomenclaturesHistoF07Utf8().___________________________

	
	
	/**
	 * method fournirCleCheminNomenclaturesHistoF07Utf8() :<br/>
	 * clé du chemin des chemins des nomenclatures en UTF-8 
	 * des HISTO_F07 dans 
	 * application_fr_FR.properties.<br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.chemin.histof07.utf8".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.chemin.histof07.utf8".<br/>
	 */
	private static String fournirCleCheminNomenclaturesHistoF07Utf8() {
		return "application.repertoire.ressources.nomenclatures.chemin.histof07.utf8";
	} // Fin de fournirCleCheminNomenclaturesHistoF07Utf8().____________________
	

	
	/**
	 * method fournirCheminNomenclaturesHistoF07Utf8EnDur() :<br/>
	 * Fournit une valeur stockée en dur 
	 * dans la classe pour chemins des nomenclatures en UTF-8 
	 * des HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\".<br/>
	 */
	private static String fournirCheminNomenclaturesHistoF07Utf8EnDur() {
		return ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\";
	} // Fin de fournirCheminNomenclaturesHistoF07Utf8EnDur().__________________
	


	/**
	 * method getNomNomenclatureHistoF07Sens() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du SENS 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07SensEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.sens.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07SensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07SensEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07Sens : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07Sens() {

		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (nomNomenclatureHistoF07Sens == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleNomNomenclatureHistoF07Sens());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_SENS,
								fournirCleNomNomenclatureHistoF07Sens(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							nomNomenclatureHistoF07Sens 
								= fournirNomNomenclatureHistoF07SensEnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							nomNomenclatureHistoF07Sens = valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_SENS,
								fournirCleNomNomenclatureHistoF07Sens(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						nomNomenclatureHistoF07Sens 
							= fournirNomNomenclatureHistoF07SensEnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					nomNomenclatureHistoF07Sens 
						= fournirNomNomenclatureHistoF07SensEnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (nomNomenclatureHistoF07Sens == null)._________

			return nomNomenclatureHistoF07Sens;

		} // Fin de synchronized.________________________________________

	} // Fin de getNomNomenclatureHistoF07Sens()._______________________________


	
	/**
	 * method fournirCleNomNomenclatureHistoF07Sens() :<br/>
	 * clé du nom de la nomenclature en UTF-8 
	 * du SENS 
	 * dans le HISTO_F07 
	 * stockée dans application_fr_FR.properties.<br/>
	 * "2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.sens.histof07".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.sens.histof07".<br/>
	 */
	private static String fournirCleNomNomenclatureHistoF07Sens() {
		return "application.repertoire.ressources.nomenclatures.sens.histof07";
	} // Fin de fournirCleNomNomenclatureHistoF07Sens().________________________
	

	
	/**
	 * method fournirNomNomenclatureHistoF07SensEnDur() :<br/>
	 * Fournit une valeur stockée en dur dans la classe 
	 * pour le Nom du fichier de nomenclature en UTF-8 
	 * concernant le SENS 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 *
	 * @return : String : "2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 */
	private static String fournirNomNomenclatureHistoF07SensEnDur() {
		return "2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv";
	} // Fin de fournirNomNomenclatureHistoF07SensEnDur().______________________

	
	
	/**
	 * method getFichierNomenclatureHistoF07SensUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le SENS
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8\\
	 * 2014-07-15_Nomenclature_Sens_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07SensUtf8.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	public static File getFichierNomenclatureHistoF07SensUtf8() {
				
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Instanciation du Singleton. */
			if (fichierNomenclatureHistoF07SensUtf8 == null) {
								
				fichierNomenclatureHistoF07SensUtf8 
				= new File(getCheminNomenclaturesHistoF07Utf8() 
						+ getNomNomenclatureHistoF07Sens());
				
				/* LOG.FATAL, rapporte 
				 * et jette une RunTimeException 
				 * si pFile est null, inexistant, répertoire ou vide.*/
				traiterFichier(fichierNomenclatureHistoF07SensUtf8
						, "Méthode getFichierNomenclatureHistoF07SensUtf8()");
			}
			
			return fichierNomenclatureHistoF07SensUtf8;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getFichierNomenclatureHistoF07SensUtf8()._______________________
	

	
	/**
	 * method getNomNomenclatureHistoF07Nature() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la NATURE du comptage 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07NatureEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.nature.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07NatureEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07NatureEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07Nature : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07Nature() {

		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (nomNomenclatureHistoF07Nature == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleNomNomenclatureHistoF07Nature());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_NATURE,
								fournirCleNomNomenclatureHistoF07Nature(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							nomNomenclatureHistoF07Nature 
								= fournirNomNomenclatureHistoF07NatureEnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							nomNomenclatureHistoF07Nature = valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_NATURE,
								fournirCleNomNomenclatureHistoF07Nature(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						nomNomenclatureHistoF07Nature 
							= fournirNomNomenclatureHistoF07NatureEnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					nomNomenclatureHistoF07Nature 
						= fournirNomNomenclatureHistoF07NatureEnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (nomNomenclatureHistoF07Nature == null)._________

			return nomNomenclatureHistoF07Nature;

		} // Fin de synchronized.________________________________________

	} // Fin de getNomNomenclatureHistoF07Nature()._____________________________


	
	/**
	 * method fournirCleNomNomenclatureHistoF07Nature() :<br/>
	 * clé du nom de la nomenclature en UTF-8 
	 * de NATURE du comptage 
	 * dans le HISTO_F07 
	 * stockée dans application_fr_FR.properties.<br/>
	 * "2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.nature.histof07".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.nature.histof07".<br/>
	 */
	private static String fournirCleNomNomenclatureHistoF07Nature() {
		return "application.repertoire.ressources.nomenclatures.nature.histof07";
	} // Fin de fournirCleNomNomenclatureHistoF07Nature().______________________
	

	
	/**
	 * method fournirNomNomenclatureHistoF07NatureEnDur() :<br/>
	 * Fournit une valeur stockée en dur dans la classe 
	 * pour le Nom du fichier de nomenclature en UTF-8 
	 * concernant la NATURE du comptage
	 * dans un HISTO_F07.<br/>
	 *
	 * @return : String : 
	 * "2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 */
	private static String fournirNomNomenclatureHistoF07NatureEnDur() {
		return "2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv";
	} // Fin de fournirNomNomenclatureHistoF07NatureEnDur().____________________
	
	
	
	/**
	 * method getFichierNomenclatureHistoF07NatureUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la NATURE du comptage 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Nature_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07NatureUtf8.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	public static File getFichierNomenclatureHistoF07NatureUtf8() {
				
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Instanciation du Singleton. */
			if (fichierNomenclatureHistoF07NatureUtf8 == null) {
								
				fichierNomenclatureHistoF07NatureUtf8 
				= new File(getCheminNomenclaturesHistoF07Utf8() 
						+ getNomNomenclatureHistoF07Nature());
				
				/* LOG.FATAL, rapporte 
				 * et jette une RunTimeException 
				 * si pFile est null, inexistant, répertoire ou vide.*/
				traiterFichier(fichierNomenclatureHistoF07NatureUtf8
						, "Méthode getFichierNomenclatureHistoF07NatureUtf8()");
			}
			
			return fichierNomenclatureHistoF07NatureUtf8;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getFichierNomenclatureHistoF07NatureUtf8()._______________________
	

	
	/**
	 * method getNomNomenclatureHistoF07TypeComptage() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du TYPE DE COMPTAGE 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07TypeComptageEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.typecomptage.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeComptageEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeComptageEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07TypeComptage : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07TypeComptage() {

		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (nomNomenclatureHistoF07TypeComptage == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleNomNomenclatureHistoF07TypeComptage());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPECOMPTAGE,
								fournirCleNomNomenclatureHistoF07TypeComptage(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							nomNomenclatureHistoF07TypeComptage 
								= fournirNomNomenclatureHistoF07TypeComptageEnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							nomNomenclatureHistoF07TypeComptage = valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPECOMPTAGE,
								fournirCleNomNomenclatureHistoF07TypeComptage(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						nomNomenclatureHistoF07TypeComptage 
							= fournirNomNomenclatureHistoF07TypeComptageEnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					nomNomenclatureHistoF07TypeComptage 
						= fournirNomNomenclatureHistoF07TypeComptageEnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (nomNomenclatureHistoF07TypeComptage == null)._________

			return nomNomenclatureHistoF07TypeComptage;

		} // Fin de synchronized.________________________________________

	} // Fin de getNomNomenclatureHistoF07TypeComptage()._______________________


	
	/**
	 * method fournirCleNomNomenclatureHistoF07TypeComptage() :<br/>
	 * clé du nom de la nomenclature en UTF-8 
	 * de TYPE DE COMPTAGE 
	 * dans le HISTO_F07 
	 * stockée dans application_fr_FR.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.typecomptage.histof07".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.typecomptage.histof07".<br/>
	 */
	private static String fournirCleNomNomenclatureHistoF07TypeComptage() {
		return "application.repertoire.ressources.nomenclatures.typecomptage.histof07";
	} // Fin de fournirCleNomNomenclatureHistoF07TypeComptage().________________
	

	
	/**
	 * method fournirNomNomenclatureHistoF07TypeComptageEnDur() :<br/>
	 * Fournit une valeur stockée en dur dans la classe 
	 * pour le Nom du fichier de nomenclature en UTF-8 
	 * concernant le TYPE DE COMPTAGE
	 * dans un HISTO_F07.<br/>
	 *
	 * @return : String : 
	 * "2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 */
	private static String fournirNomNomenclatureHistoF07TypeComptageEnDur() {
		return "2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv";
	} // Fin de fournirNomNomenclatureHistoF07TypeComptageEnDur().______________


	
	/**
	 * method getFichierNomenclatureHistoF07TypeComptageUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE COMPTAGE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Comptage_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07TypeComptageUtf8.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	public static File getFichierNomenclatureHistoF07TypeComptageUtf8() {
				
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Instanciation du Singleton. */
			if (fichierNomenclatureHistoF07TypeComptageUtf8 == null) {
								
				fichierNomenclatureHistoF07TypeComptageUtf8 
				= new File(getCheminNomenclaturesHistoF07Utf8() 
						+ getNomNomenclatureHistoF07TypeComptage());
				
				/* LOG.FATAL, rapporte 
				 * et jette une RunTimeException 
				 * si pFile est null, inexistant, répertoire ou vide.*/
				traiterFichier(fichierNomenclatureHistoF07TypeComptageUtf8
						, "Méthode getFichierNomenclatureHistoF07TypeComptageUtf8()");
			}
			
			return fichierNomenclatureHistoF07TypeComptageUtf8;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getFichierNomenclatureHistoF07TypeComptageUtf8()._______________
	

	
	/**
	 * method getNomNomenclatureHistoF07ClassementRoute() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du CLASSEMENT DE LA ROUTE 
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07ClassementRouteEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classementroute.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClassementRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClassementRouteEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07ClassementRoute : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07ClassementRoute() {

		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (nomNomenclatureHistoF07ClassementRoute == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleNomNomenclatureHistoF07ClassementRoute());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSEMENTROUTE,
								fournirCleNomNomenclatureHistoF07ClassementRoute(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							nomNomenclatureHistoF07ClassementRoute 
								= fournirNomNomenclatureHistoF07ClassementRouteEnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							nomNomenclatureHistoF07ClassementRoute = valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSEMENTROUTE,
								fournirCleNomNomenclatureHistoF07ClassementRoute(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						nomNomenclatureHistoF07ClassementRoute 
							= fournirNomNomenclatureHistoF07ClassementRouteEnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					nomNomenclatureHistoF07ClassementRoute 
						= fournirNomNomenclatureHistoF07ClassementRouteEnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (nomNomenclatureHistoF07ClassementRoute == null)._________

			return nomNomenclatureHistoF07ClassementRoute;

		} // Fin de synchronized.________________________________________

	} // Fin de getNomNomenclatureHistoF07ClassementRoute().____________________



	/**
	 * method fournirCleNomNomenclatureHistoF07ClassementRoute() :<br/>
	 * clé du nom de la nomenclature en UTF-8 
	 * du CLASSEMENT DE LA ROUTE
	 * dans le HISTO_F07 
	 * stockée dans application_fr_FR.properties.<br/>
	 * "2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.classementroute.histof07".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.typecomptage.histof07".<br/>
	 */
	private static String fournirCleNomNomenclatureHistoF07ClassementRoute() {
		return "application.repertoire.ressources.nomenclatures.classementroute.histof07";
	} // Fin de fournirCleNomNomenclatureHistoF07ClassementRoute()._____________
	

	
	/**
	 * method fournirNomNomenclatureHistoF07ClassementRouteEnDur() :<br/>
	 * Fournit une valeur stockée en dur dans la classe 
	 * pour le Nom du fichier de nomenclature en UTF-8 
	 * concernant le CLASSEMENT DE LA ROUTE
	 * dans un HISTO_F07.<br/>
	 *
	 * @return : String : 
	 * "2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 */
	private static String fournirNomNomenclatureHistoF07ClassementRouteEnDur() {
		return "2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv";
	} // Fin de fournirNomNomenclatureHistoF07ClassementRouteEnDur().___________


	
	/**
	 * method getFichierNomenclatureHistoF07ClassementRouteUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le CLASSEMENT DE LA ROUTE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classement_Route_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07ClassementRouteUtf8.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	public static File getFichierNomenclatureHistoF07ClassementRouteUtf8() {
				
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Instanciation du Singleton. */
			if (fichierNomenclatureHistoF07ClassementRouteUtf8 == null) {
								
				fichierNomenclatureHistoF07ClassementRouteUtf8 
				= new File(getCheminNomenclaturesHistoF07Utf8() 
						+ getNomNomenclatureHistoF07ClassementRoute());
				
				/* LOG.FATAL, rapporte 
				 * et jette une RunTimeException 
				 * si pFile est null, inexistant, répertoire ou vide.*/
				traiterFichier(fichierNomenclatureHistoF07ClassementRouteUtf8
						, "Méthode getFichierNomenclatureHistoF07ClassementRouteUtf8()");
			}
			
			return fichierNomenclatureHistoF07ClassementRouteUtf8;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getFichierNomenclatureHistoF07ClassementRouteUtf8()._______________
	

	
	/**
	 * method getNomNomenclatureHistoF07ClasseLargeurChausseeU() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classelargeurchausseeu.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07ClasseLargeurChausseeU : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07ClasseLargeurChausseeU() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (nomNomenclatureHistoF07ClasseLargeurChausseeU == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleNomNomenclatureHistoF07ClasseLargeurChausseeU());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEEU,
								fournirCleNomNomenclatureHistoF07ClasseLargeurChausseeU(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							nomNomenclatureHistoF07ClasseLargeurChausseeU 
								= fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							nomNomenclatureHistoF07ClasseLargeurChausseeU 
								= valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEEU,
								fournirCleNomNomenclatureHistoF07ClasseLargeurChausseeU(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						nomNomenclatureHistoF07ClasseLargeurChausseeU 
							= fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					nomNomenclatureHistoF07ClasseLargeurChausseeU 
						= fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (nomNomenclatureHistoF07ClasseLargeurChausseeU == null)._________

			return nomNomenclatureHistoF07ClasseLargeurChausseeU;

		} // Fin de synchronized.________________________________________

	} // Fin de getNomNomenclatureHistoF07ClasseLargeurChausseeU()._____________



	/**
	 * method fournirCleNomNomenclatureHistoF07ClasseLargeurChausseeU() :<br/>
	 * clé du nom de la nomenclature en UTF-8 
	 * de la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE
	 * dans le HISTO_F07 
	 * stockée dans application_fr_FR.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.classelargeurchausseeu.histof07".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.classelargeurchausseeu.histof07".<br/>
	 */
	private static String fournirCleNomNomenclatureHistoF07ClasseLargeurChausseeU() {
		return "application.repertoire.ressources.nomenclatures.classelargeurchausseeu.histof07";
	} // Fin de fournirCleNomNomenclatureHistoF07ClasseLargeurChausseeU().______
	
	
	
	/**
	 * method fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur() :<br/>
	 * Fournit une valeur stockée en dur dans la classe 
	 * pour le Nom du fichier de nomenclature en UTF-8 
	 * concernant la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE
	 * dans un HISTO_F07.<br/>
	 *
	 * @return : String : 
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 */
	private static String fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur() {
		return "2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv";
	} // Fin de fournirNomNomenclatureHistoF07ClasseLargeurChausseeUEnDur().____
	
	
	
	/**
	 * method getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEE UNIQUE 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausse_Unique_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	public static File getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8() {
				
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Instanciation du Singleton. */
			if (fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8 == null) {
								
				fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8 
				= new File(getCheminNomenclaturesHistoF07Utf8() 
						+ getNomNomenclatureHistoF07ClasseLargeurChausseeU());
				
				/* LOG.FATAL, rapporte 
				 * et jette une RunTimeException 
				 * si pFile est null, inexistant, répertoire ou vide.*/
				traiterFichier(fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8
						, "Méthode getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8()");
			}
			
			return fichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getFichierNomenclatureHistoF07ClasseLargeurChausseeUUtf8()._______________
	


	/**
	 * method getNomNomenclatureHistoF07ClasseLargeurChausseesS() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * de la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chaussees_Separees_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.classelargeurchausseess.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07ClasseLargeurChausseesS : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07ClasseLargeurChausseesS() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (nomNomenclatureHistoF07ClasseLargeurChausseesS == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleNomNomenclatureHistoF07ClasseLargeurChausseesS());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEESS,
								fournirCleNomNomenclatureHistoF07ClasseLargeurChausseesS(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							nomNomenclatureHistoF07ClasseLargeurChausseesS 
								= fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							nomNomenclatureHistoF07ClasseLargeurChausseesS 
								= valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_CLASSELARGEURCHAUSSEESS,
								fournirCleNomNomenclatureHistoF07ClasseLargeurChausseesS(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						nomNomenclatureHistoF07ClasseLargeurChausseesS 
							= fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					nomNomenclatureHistoF07ClasseLargeurChausseesS 
						= fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (nomNomenclatureHistoF07ClasseLargeurChausseesS == null)._________

			return nomNomenclatureHistoF07ClasseLargeurChausseesS;

		} // Fin de synchronized.________________________________________

	} // Fin de getNomNomenclatureHistoF07ClasseLargeurChausseesS().____________


	
	/**
	 * method fournirCleNomNomenclatureHistoF07ClasseLargeurChausseesS() :<br/>
	 * clé du nom de la nomenclature en UTF-8 
	 * de la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES
	 * dans le HISTO_F07 
	 * stockée dans application_fr_FR.properties.<br/>
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chaussees_Separees_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.classelargeurchausseess.histof07".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.classelargeurchausseess.histof07".<br/>
	 */
	private static String fournirCleNomNomenclatureHistoF07ClasseLargeurChausseesS() {
		return "application.repertoire.ressources.nomenclatures.classelargeurchausseess.histof07";
	} // Fin de fournirCleNomNomenclatureHistoF07ClasseLargeurChausseesS()._____
	

	
	/**
	 * method fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur() :<br/>
	 * Fournit une valeur stockée en dur dans la classe 
	 * pour le Nom du fichier de nomenclature en UTF-8 
	 * concernant la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES
	 * dans un HISTO_F07.<br/>
	 *
	 * @return : String : 
	 * "2014-07-15_Nomenclature_Classe_Largeur_Chaussees_Separees_HistoF07_Utf8.csv".<br/>
	 */
	private static String fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur() {
		return "2014-07-15_Nomenclature_Classe_Largeur_Chaussees_Separees_HistoF07_Utf8.csv";
	} // Fin de fournirNomNomenclatureHistoF07ClasseLargeurChausseesSEnDur().___


	
	/**
	 * method getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * la CLASSE DE LARGEUR DE CHAUSSEES SEPAREES 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Classe_Largeur_Chausses_Séparées_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	public static File getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8() {
				
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Instanciation du Singleton. */
			if (fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8 == null) {
								
				fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8 
				= new File(getCheminNomenclaturesHistoF07Utf8() 
						+ getNomNomenclatureHistoF07ClasseLargeurChausseesS());
				
				/* LOG.FATAL, rapporte 
				 * et jette une RunTimeException 
				 * si pFile est null, inexistant, répertoire ou vide.*/
				traiterFichier(fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8
						, "Méthode getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8()");
			}
			
			return fichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getFichierNomenclatureHistoF07ClasseLargeurChausseesSUtf8().____
	


	/**
	 * method getNomNomenclatureHistoF07TypeReseau() :<br/>
	 * Getter du Nom du fichier de nomenclature 
	 * du TYPE DE RESEAU
	 * pour les HISTO_F07 en UTF-8
	 * stocké dans application.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * <ul>
	 * <li>Essaie de fournir la valeur stockée dans 
	 * application_fr_FR.properties.</li><br/>
	 * <li>Sinon, retourne la valeur stockée en dur 
	 * fournie par fournirNomNomenclatureHistoF07TypeReseauEnDur().</li><br/>
	 * <li>Nettoie la valeur lue dans le .properties avec trim().</li><br/>
	 * </ul>
	 * Clé : "application.repertoire.ressources.nomenclatures.typereseau.histof07".<br/>
	 * <br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeReseauEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la clé n'existe pas dans le properties.<br/>
	 * - retourne la valeur en dur fournie par 
	 * fournirNomNomenclatureHistoF07TypeReseauEnDur()
	 * , LOG.ERROR et rapporte 
	 * si la valeur associée à la clé n'existe pas dans le properties.<br/>
	 * <br/>
	 *
	 * @return nomNomenclatureHistoF07TypeReseau : String.<br/>
	 */
	public static String getNomNomenclatureHistoF07TypeReseau() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {

			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			if (nomNomenclatureHistoF07TypeReseau == null) {

				if (ConfigurationApplicationManager
						.getBundleApplication() != null) {

					try {

						/*
						 * Essaie de récupérer la valeur dans le properties.
						 */
						final String valeur 
							= ConfigurationApplicationManager
								.getBundleApplication()
									.getString(
										fournirCleNomNomenclatureHistoF07TypeReseau());

						/* Si la valeur est blank. */
						if (StringUtils.isBlank(valeur)) {

							/* Création du message. */
							messageIndividuelRapport 
							= creerMessageManqueValeur(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPERESEAU,
								fournirCleNomNomenclatureHistoF07TypeReseau(),
								ConfigurationApplicationManager
										.getBundleApplication());

							/* LOG.ERROR. */
							if (LOG.isErrorEnabled()) {
								LOG.error(messageIndividuelRapport);
							}

							/* Rapport. */
							ajouterMessageAuRapportConfigurationCsv(
									messageIndividuelRapport);

							/* utilise la valeur fournie en dur. */
							nomNomenclatureHistoF07TypeReseau 
								= fournirNomNomenclatureHistoF07TypeReseauEnDur();

						} // Fin de Si la valeur est blank._________

						/* Valeur remplie dans le properties. */
						else {

							/*
							 * Nettoie la valeur lue dans le .properties avec
							 * trim().
							 */
							final String valeurNettoyee 
								= StringUtils
									.trim(valeur);

							nomNomenclatureHistoF07TypeReseau 
								= valeurNettoyee;

						} // Fin de Valeur remplie dans le properties.____

					} catch (MissingResourceException mre) {

						/* Création du message. */
						messageIndividuelRapport 
							= creerMessageManqueCle(
								METHODE_GET_NOMNOMENCLATURE_HISTO_F07_TYPERESEAU,
								fournirCleNomNomenclatureHistoF07TypeReseau(),
								ConfigurationApplicationManager
										.getBundleApplication());

						/* LOG.ERROR. */
						if (LOG.isErrorEnabled()) {
							LOG.error(messageIndividuelRapport, mre);
						}

						/* Rapport. */
						ajouterMessageAuRapportConfigurationCsv(
								messageIndividuelRapport);

						/* utilise la valeur fournie en dur. */
						nomNomenclatureHistoF07TypeReseau 
							= fournirNomNomenclatureHistoF07TypeReseauEnDur();

					} // Fin de catch (MissingResourceException mre)._____

				} // Fin de if (getBundleApplication() != null)._____

				/* if (getBundleApplication() == null). */
				else {

					/* utilise la valeur fournie en dur. */
					nomNomenclatureHistoF07TypeReseau 
						= fournirNomNomenclatureHistoF07TypeReseauEnDur();

				} // Fin de if (getBundleApplication() == null).___

			} // Fin de if (nomNomenclatureHistoF07TypeReseau == null)._________

			return nomNomenclatureHistoF07TypeReseau;

		} // Fin de synchronized.________________________________________

	} // Fin de getNomNomenclatureHistoF07TypeReseau().__________________________


	
	/**
	 * method fournirCleNomNomenclatureHistoF07TypeReseau() :<br/>
	 * clé du nom de la nomenclature en UTF-8 
	 * du TYPE DE RESEAU
	 * dans le HISTO_F07 
	 * stockée dans application_fr_FR.properties.<br/>
	 * "2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 * Clé = "application.repertoire.ressources.nomenclatures.typereseau.histof07".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "application.repertoire.ressources.nomenclatures.typereseau.histof07".<br/>
	 */
	private static String fournirCleNomNomenclatureHistoF07TypeReseau() {
		return "application.repertoire.ressources.nomenclatures.typereseau.histof07";
	} // Fin de fournirCleNomNomenclatureHistoF07TypeReseau().__________________
	

	
	/**
	 * method fournirNomNomenclatureHistoF07TypeReseauEnDur() :<br/>
	 * Fournit une valeur stockée en dur dans la classe 
	 * pour le Nom du fichier de nomenclature en UTF-8 
	 * concernant le TYPE DE RESEAU
	 * dans un HISTO_F07.<br/>
	 *
	 * @return : String : 
	 * "2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 */
	private static String fournirNomNomenclatureHistoF07TypeReseauEnDur() {
		return "2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv";
	} // Fin de fournirNomNomenclatureHistoF07TypeReseauEnDur().________________


	
	/**
	 * method getFichierNomenclatureHistoF07TypeReseauUtf8() :<br/>
	 * Fournit le Fichier sur disque encodé en UTF-8 contenant la 
	 * Nomenclature pour 
	 * le TYPE DE RESEAU 
	 * dans un HISTO_F07.<br/>
	 * <br/>
	 * ".\\ressources\\Nomenclatures\\HistoF07\\Nomenclatures en UTF-8
	 * \\2014-07-15_Nomenclature_Type_Reseau_HistoF07_Utf8.csv".<br/>
	 * <br/>
	 * - LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 *
	 * @return : File : fichierNomenclatureHistoF07TypeReseauUtf8.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	public static File getFichierNomenclatureHistoF07TypeReseauUtf8() {
				
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Instanciation du Singleton. */
			if (fichierNomenclatureHistoF07TypeReseauUtf8 == null) {
								
				fichierNomenclatureHistoF07TypeReseauUtf8 
				= new File(getCheminNomenclaturesHistoF07Utf8() 
						+ getNomNomenclatureHistoF07TypeReseau());
				
				/* LOG.FATAL, rapporte 
				 * et jette une RunTimeException 
				 * si pFile est null, inexistant, répertoire ou vide.*/
				traiterFichier(fichierNomenclatureHistoF07TypeReseauUtf8
						, "Méthode getFichierNomenclatureHistoF07TypeReseauUtf8()");
			}
			
			return fichierNomenclatureHistoF07TypeReseauUtf8;
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de getFichierNomenclatureHistoF07TypeReseauUtf8()._______________
	


	/**
	 * method getRapportConfigurationCsv() :<br/>
	 * Getter du Rapport du chargement de la configuration au format csv.<br/>
	 * <br/>
	 * - Le rapport est null si il n'y a eu aucun 
	 * problème d'initialisation de l'application.<br/>
	 * <br/>
	 *
	 * @return rapportConfigurationCsv : String.<br/>
	 */
	public static String getRapportConfigurationCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			return rapportConfigurationCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getRapportConfigurationCsv().______________________________


	
	/**
	 * method getMessageIndividuelRapport() :<br/>
	 * Getter du Message pour le 
	 * Rapport du chargement de la configuration au format csv 
	 * généré par chaque méthode individuellement.<br/>
	 * <br/>
	 *
	 * @return messageIndividuelRapport : String.<br/>
	 */
	public static String getMessageIndividuelRapport() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			return messageIndividuelRapport;
		} // Fin de synchronized.________________________________________
		
	} // Fin de getMessageIndividuelRapport()._____________________________


	
	/**
	 * method creerMessageManqueCle(
	 * String pMethode
	 * , String pCle
	 * , ResourceBundle pBundle) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si une clé est absente dans un ResourceBundle.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getStatsActivees() 
	 * - La clé 'abstractdao.statsactivees' 
	 * n'existe pas dans messagestechniquesfr_FR.properties".<br/>
	 * <br/>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pCle : String : Clé dans le ResourceBundle.<br/>
	 * @param pBundle : ResourceBundle.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessageManqueCle(
			final String pMethode
			 	, final String pCle
			 		, final ResourceBundle pBundle) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONNOMENCLATURESHISTO_F07);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("La clé '");
			stb.append(pCle);
			stb.append("' n'existe pas dans ");
			stb.append(pBundle.getBaseBundleName());
			stb.append("fr_FR.properties");
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessageManqueCle(
	 // String pMethode
	 // , String pCle
	 // , ResourceBundle pBundle)._________________________________________
	

	
	/**
	 * method creerMessageManqueValeur(
	 * String pMethode
	 * , String pCle
	 * , ResourceBundle pBundle) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si une valeur en face d'une clé est absente 
	 * dans un ResourceBundle.<br/>
	 * <br/>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pCle : String : Clé dans le ResourceBundle.<br/>
	 * @param pBundle : ResourceBundle.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessageManqueValeur(
			final String pMethode
			 	, final String pCle
			 		, final ResourceBundle pBundle) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONNOMENCLATURESHISTO_F07);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("La valeur associée à la clé '");
			stb.append(pCle);
			stb.append("' n'existe pas (null ou vide) dans ");
			stb.append(pBundle.getBaseBundleName());
			stb.append("fr_FR.properties");
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessageManqueValeur(
	 // String pMethode
	 // , String pCle
	 // , ResourceBundle pBundle)._________________________________________


	
	/**
	 * method ajouterMessageAuRapportConfigurationCsv(
	 * String pMessage) :<br/>
	 * Rajoute le message pMessage au rapport 
	 * de chargement de la configuration au format csv (à la ligne).<br/>
	 * <br/>
	 * - Ne fait rien si pMessage est blank.<br/>
	 * - Ne Rajoute PAS l'en-tête (avec BOM_UTF-8) 
	 * pour le rapport de chargement de la configuration si nécessaire.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à rajouter 
	 * au rapport de chargement de la configuration.<br/>
	 */
	private static void ajouterMessageAuRapportConfigurationCsv(
			final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Ne fait rien si pMessage est blank. */
			if (StringUtils.isBlank(pMessage)) {
				return;
			}
			
			final StringBuilder stb = new StringBuilder();
						
			/* Rajoute le message au rapport de 
			 * chargement de la configuration au format csv (à la ligne). */
			if (!StringUtils.isBlank(rapportConfigurationCsv)) {
				stb.append(rapportConfigurationCsv);
				stb.append(NEWLINE);
			}
			
			stb.append(pMessage);
			stb.append(SEP_PV);
			
			rapportConfigurationCsv = stb.toString();
			
		} // Fin de synchronized.________________________________________
			
	} // Fin de ajouterMessageAuRapportConfigurationCsv(
	 // String pMessage).__________________________________________________
	

	
	/**
	 * method traiterFichier(
	 * File pFile
	 * , String pMethode) :<br/>
	 * LOG.FATAL, rapporte 
	 * et jette une RunTimeException 
	 * si pFile est null, inexistant, répertoire ou vide.<br/>
	 * <br/>
	 * <ul>
	 * <li>LOG.FATAL, rapporte et jette 
	 * une FichierNullRunTimeException si pFile est null.</li><br/>
	 * <li>LOG.FATAL, rapporte et jette 
	 * une FichierInexistantRunTimeException si pFile est inexistant.</li><br/>
	 * <li>LOG.FATAL, rapporte et jette 
	 * une FichierRepertoireRunTimeException si pFile est un répertoire.</li><br/>
	 * <li>LOG.FATAL, rapporte et jette 
	 * une FichierVideRunTimeException si pFile est vide.</li><br/>
	 * </ul>
	 *
	 * @param pFile : File.<br/>
	 * @param pMethode : String : Nom de la méthode appelante.<br/>
	 * 
	 * @throws FichierNullRunTimeException si pFile est null.<br/>
	 * @throws FichierInexistantRunTimeException si pFile est inexistant.<br/>
	 * @throws FichierRepertoireRunTimeException si pFile est un répertoire.<br/>
	 * @throws FichierVideRunTimeException si pFile est vide.<br/>
	 */
	private static void traiterFichier(
			final File pFile
				, final String pMethode) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;
			
			/* si pFile est null.*******/
			if (pFile == null) {
				
				messageIndividuelRapport 
				= creerMessageMauvaisFichier(
						pMethode
						, "Le Fichier passé en paramètre est null"); 

				/* LOG.FATAL. */
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageIndividuelRapport);
				}
				
				/* Rapport. */
				ajouterMessageAuRapportConfigurationCsv(
						messageIndividuelRapport);
				
				/* Jette une FichierNullRunTimeException. */
				throw new FichierNullRunTimeException(
						messageIndividuelRapport);
				
			} // Fin de if (pFile == null).__________

			
			/* si pFile est inexistant. *******************/
			if (!pFile.exists()) {
				
				messageIndividuelRapport 
				= creerMessageMauvaisFichier(
						pMethode
						, "Le Fichier passé en paramètre est inexistant : " 
						+ pFile.getAbsolutePath() 
						+ " - Ce fichier est INDISPENSABLE à l'application");
				
				/* LOG.FATAL. */
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageIndividuelRapport);
				}
				
				/* Rapport. */
				ajouterMessageAuRapportConfigurationCsv(
						messageIndividuelRapport);
				
				/* Jette une FichierInexistantRunTimeException. */
				throw new FichierInexistantRunTimeException(
						messageIndividuelRapport);
				
			} // Fin de if (!pFile.exists()).____________

			
			/* si pFile est un répertoire. *******************/
			if (pFile.isDirectory()) {
				
				messageIndividuelRapport 
				= creerMessageMauvaisFichier(
						pMethode
						, "Le Fichier passé en paramètre est un répertoire : " 
						+ pFile.getAbsolutePath() 
						+ " - Ce fichier est INDISPENSABLE à l'application");
				
				/* LOG.FATAL. */
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageIndividuelRapport);
				}
				
				/* Rapport. */
				ajouterMessageAuRapportConfigurationCsv(
						messageIndividuelRapport);
				
				/* Jette une FichierRepertoireRunTimeException. */
				throw new FichierRepertoireRunTimeException(
						messageIndividuelRapport);
				
			} // Fin de if (pFile.isDirectory()).__________

			
			/* si pFile est vide. ***********************/
			if (pFile.length() == 0) {
				
				messageIndividuelRapport 
				= creerMessageMauvaisFichier(
						pMethode
						, "Le Fichier passé en paramètre est vide : " 
						+ pFile.getAbsolutePath() 
						+ " - Ce fichier est INDISPENSABLE à l'application");
				
				/* LOG.FATAL. */
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageIndividuelRapport);
				}
				
				/* Rapport. */
				ajouterMessageAuRapportConfigurationCsv(
						messageIndividuelRapport);
				
				/* Jette une FichierVideRunTimeException. */
				throw new FichierVideRunTimeException(
						messageIndividuelRapport);
				
			} // Fin de if (pFile.length() == 0)._________________
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de traiterFichier(
	 // File pFile
	 // , String pMethode).________________________________________________
	

	
	/**
	 * method creerMessageMauvaisFichier(
	 * String pMethode
	 * , String pMessage) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si un Fichier de ressources (Description de fichier, nomenclature, ...) 
	 * est introuvable.<br/>
	 * <br/>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pMessage : String : message ciconstancié 
	 * de la méthode appelante.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessageMauvaisFichier(
				final String pMethode
					, final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationNomenclaturesHistoF07Manager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONNOMENCLATURESHISTO_F07);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMessage);
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessageMauvaisFichier(
	 // String pMethode
	// , String pMessage)._________________________________________________
	

	
} // FIN DE LA CLASSE ConfigurationNomenclaturesHistoF07Manager.-------------
