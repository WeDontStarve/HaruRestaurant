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
 * Cheifinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.dao.Cheifinfo
 * @author MyEclipse Persistence Tools
 */
public class CheifinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CheifinfoDAO.class);
	// property constants
	public static final String CHEIF_ACCOUNT = "cheifAccount";
	public static final String CHEIF_PASSWORD = "cheifPassword";
	public static final String CHEIF_FACEING = "cheifFaceing";
	public static final String CHEIF_PHONE = "cheifPhone";

	public void save(Cheifinfo transientInstance) {
		log.debug("saving Cheifinfo instance");
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

	public void delete(Cheifinfo persistentInstance) {
		log.debug("deleting Cheifinfo instance");
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

	public Cheifinfo findById(java.lang.Integer id) {
		log.debug("getting Cheifinfo instance with id: " + id);
		try {
			Cheifinfo instance = (Cheifinfo) getSession().get(
					"com.hibernate.dao.Cheifinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cheifinfo instance) {
		log.debug("finding Cheifinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hibernate.dao.Cheifinfo")
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
		log.debug("finding Cheifinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cheifinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCheifAccount(Object cheifAccount) {
		return findByProperty(CHEIF_ACCOUNT, cheifAccount);
	}

	public List findByCheifPassword(Object cheifPassword) {
		return findByProperty(CHEIF_PASSWORD, cheifPassword);
	}

	public List findByCheifFaceing(Object cheifFaceing) {
		return findByProperty(CHEIF_FACEING, cheifFaceing);
	}

	public List findByCheifPhone(Object cheifPhone) {
		return findByProperty(CHEIF_PHONE, cheifPhone);
	}

	public List findAll() {
		log.debug("finding all Cheifinfo instances");
		try {
			String queryString = "from Cheifinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cheifinfo merge(Cheifinfo detachedInstance) {
		log.debug("merging Cheifinfo instance");
		try {
			Cheifinfo result = (Cheifinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cheifinfo instance) {
		log.debug("attaching dirty Cheifinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cheifinfo instance) {
		log.debug("attaching clean Cheifinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findAllId(){
		log.debug("find all ID from cheifInfo");
		try{
			String hql="select cheifId from Cheifinfo";
			Query queryObject=getSession().createQuery(hql);
			return queryObject.list();
		}catch(RuntimeException re){
			log.error("find id failed",re);
			throw re;
		}
	}
}