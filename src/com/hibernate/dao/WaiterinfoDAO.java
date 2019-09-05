package com.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Waiterinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.dao.Waiterinfo
 * @author MyEclipse Persistence Tools
 */
public class WaiterinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(WaiterinfoDAO.class);
	// property constants
	public static final String WAITER_ACCOUNT = "waiterAccount";
	public static final String WAITER_PASSWORD = "waiterPassword";
	public static final String WAITER_FACEING = "waiterFaceing";
	public static final String WAITER_PHONE = "waiterPhone";

	public void save(Waiterinfo transientInstance) {
		log.debug("saving Waiterinfo instance");
		Transaction tx = getSession().beginTransaction(); 
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
			tx.commit();
			getSession().close();
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		//tx.commit();
	}

	public void delete(Waiterinfo persistentInstance) {
		log.debug("deleting Waiterinfo instance");
		Transaction tx = getSession().beginTransaction(); 
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
			tx.commit();
			getSession().close();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		//tx.commit();
	}

	public Waiterinfo findById(java.lang.Integer id) {
		log.debug("getting Waiterinfo instance with id: " + id);
		try {
			Waiterinfo instance = (Waiterinfo) getSession().get(
					"com.hibernate.dao.Waiterinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Waiterinfo instance) {
		log.debug("finding Waiterinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hibernate.dao.Waiterinfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Waiterinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Waiterinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWaiterAccount(Object waiterAccount) {
		return findByProperty(WAITER_ACCOUNT, waiterAccount);
	}

	public List findByWaiterPassword(Object waiterPassword) {
		return findByProperty(WAITER_PASSWORD, waiterPassword);
	}

	public List findByWaiterFaceing(Object waiterFaceing) {
		return findByProperty(WAITER_FACEING, waiterFaceing);
	}

	public List findByWaiterPhone(Object waiterPhone) {
		return findByProperty(WAITER_PHONE, waiterPhone);
	}

	public List findAll() {
		log.debug("finding all Waiterinfo instances");
		try {
			String queryString = "from Waiterinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Waiterinfo merge(Waiterinfo detachedInstance) {
		log.debug("merging Waiterinfo instance");
		try {
			Waiterinfo result = (Waiterinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Waiterinfo instance) {
		log.debug("attaching dirty Waiterinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Waiterinfo instance) {
		log.debug("attaching clean Waiterinfo instance");
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
				String hql="select waiterId from Waiter";
				Query queryObject=getSession().createQuery(hql);
				return queryObject.list();
			}catch(RuntimeException re){
				log.error("find id failed",re);
				throw re;
			}
		}
}