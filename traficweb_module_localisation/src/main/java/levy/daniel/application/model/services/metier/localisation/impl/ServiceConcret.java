package levy.daniel.application.model.services.metier.localisation.impl;

import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.localisation.impl.DaoLocalisationBasePur;
import levy.daniel.application.model.metier.localisation.AbstractLocalisationBasePur;

/**
 * class ServiceConcret :<br/>
 * .<br/>
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
 * @since 7 nov. 2017
 *
 */
@Service
public class ServiceConcret {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * daoLocalisationBasePur : DaoLocalisationBasePur :<br/>
	 * DAO pour le ServiceLocalisationBasePur.<br/>
	 */
	@Autowired
	@Qualifier("DaoLocalisationBasePur")
	protected transient DaoLocalisationBasePur daoLocalisationBasePur;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ServiceConcret.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ServiceConcret() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	public ServiceConcret() {
		super();
	}
	
	

	/**
	 * method create() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pObject
	 * @return :  :  .<br/>
	 * @throws AbstractDaoException 
	 */
	@Transactional(propagation = Propagation.REQUIRED
			, readOnly = false, noRollbackFor = AbstractDaoException.class)
	public AbstractLocalisationBasePur create(
			final AbstractLocalisationBasePur pObject) throws AbstractDaoException {
		
		if (pObject == null) {
			return null;
		}
		
		try {
			return this.daoLocalisationBasePur.create(pObject);
		}
		catch (JpaSystemException jpaExc) {
			System.out.println("SERVICE - JPA SYSTEM EXCEPTION : " + jpaExc.toString());
		}
		catch (TransactionException transacExc) {
			System.out.println("SERVICE - TRANSACTION EXCEPTION : " + transacExc.toString());
		}
		catch (PersistenceException persistenceExc) {
			System.out.println("SERVICE - PERSISTENCE EXCEPTION : " + persistenceExc.toString());
		}
		catch (AbstractDaoException daoExc) {
			System.out.println("SERVICE - DOUBLON : " + daoExc.getMessageUtilisateur());
//			throw daoExc;
		}
		catch (Exception e) {
			System.out.println("SERVICE - EXCEPTION CATCHEE : " + e.toString());
		}
		
		return null;
		
	} // Fin de create(...)._______________________________________________



	
	/**
	 * method getDaoLocalisationBasePur() :<br/>
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return daoLocalisationBasePur : DaoLocalisationBasePur.<br/>
	 */
	public DaoLocalisationBasePur getDaoLocalisationBasePur() {
	
		return this.daoLocalisationBasePur;
	}



	
	/**
	* method setDaoLocalisationBasePur(
	* DaoLocalisationBasePur pDaoLocalisationBasePur) :<br/>
	* .<br/>
	* <br/>
	*
	* @param pDaoLocalisationBasePur : DaoLocalisationBasePur : valeur à passer à daoLocalisationBasePur.<br/>
	*/
	public void setDaoLocalisationBasePur(
			final DaoLocalisationBasePur pDaoLocalisationBasePur) {
	
		this.daoLocalisationBasePur = pDaoLocalisationBasePur;
	}


	
	
	
}
