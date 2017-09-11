package com.DAO;

import com.DAO.BaseHibernateDAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Waiter entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Waiter
  * @author MyEclipse Persistence Tools 
 */
public class WaiterDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WaiterDAO.class);
		//property constants
	public static final String WAITER_ACCOUNT = "waiterAccount";
	public static final String WAITER_PASSWORD = "waiterPassword";
	public static final String WAITER_FACEING = "waiterFaceing";
	public static final String WAITER_PHONE = "waiterPhone";
	public static final String WAITER_SALARY = "waiterSalary";
	public static final String WAITER_BONUS = "waiterBonus";
	public static final String ADMIN_ID="adminId";



    
    public void save(Waiter transientInstance) {
        log.debug("saving Waiter instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Waiter persistentInstance) {
        log.debug("deleting Waiter instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Waiter findById( java.lang.Integer id) {
        log.debug("getting Waiter instance with id: " + id);
        try {
            Waiter instance = (Waiter) getSession()
                    .get("Waiter", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Waiter instance) {
        log.debug("finding Waiter instance by example");
        try {
            List results = getSession()
                    .createCriteria("Waiter")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Waiter instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Waiter as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByWaiterAccount(Object waiterAccount
	) {
		return findByProperty(WAITER_ACCOUNT, waiterAccount
		);
	}
	
	public List findByWaiterPassword(Object waiterPassword
	) {
		return findByProperty(WAITER_PASSWORD, waiterPassword
		);
	}
	
	public List findByWaiterFaceing(Object waiterFaceing
	) {
		return findByProperty(WAITER_FACEING, waiterFaceing
		);
	}
	
	public List findByWaiterPhone(Object waiterPhone
	) {
		return findByProperty(WAITER_PHONE, waiterPhone
		);
	}
	
	public List findByWaiterSalary(Object waiterSalary
	) {
		return findByProperty(WAITER_SALARY, waiterSalary
		);
	}
	
	public List findByWaiterBonus(Object waiterBonus
	) {
		return findByProperty(WAITER_BONUS, waiterBonus
		);
	}
	
	public List findByAdminId(Object adminId){
		return findByProperty(ADMIN_ID,adminId);
	}
	
	public List findAll() {
		log.debug("finding all Waiter instances");
		try {
			String queryString = "from Waiter";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Waiter merge(Waiter detachedInstance) {
        log.debug("merging Waiter instance");
        try {
            Waiter result = (Waiter) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Waiter instance) {
        log.debug("attaching dirty Waiter instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Waiter instance) {
        log.debug("attaching clean Waiter instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public List findAllId(){
		log.debug("find all ID from waiterInfo");
		try{
			String hql="select tableId from Waiter";
			Query queryObject=getSession().createQuery(hql);
			return queryObject.list();
		}catch(RuntimeException re){
			log.error("find id failed",re);
			throw re;
		}
	}
}