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
 * Admininfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.dao.Admininfo
 * @author MyEclipse Persistence Tools
 */
public class AdmininfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdmininfoDAO.class);
	// property constants
	public static final String ADMIN_ACCOUNT = "adminAccount";
	public static final String ADMIN_PASSWORD = "adminPassword";
	public static final String ADMIN_FACEING = "adminFaceing";
	public static final String ADMIN_PERSONALLD = "adminPersonalld";
	public static final String ADMIN_PHONE = "adminPhone";
	public static final String RESTAURANT_NAME = "restaurantName";
	public static final String RESTAURANT_ADDRESS = "restaurantAddress";

	public void save(Admininfo transientInstance) {
		log.debug("saving Admininfo instance");
		Transaction tx = getSession().beginTransaction(); 
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		tx.commit();
	}

	public void delete(Admininfo persistentInstance) {
		log.debug("deleting Admininfo instance");
		Transaction tx = getSession().beginTransaction(); 
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		tx.commit();
	}

	public Admininfo findById(java.lang.Integer id) {
		log.debug("getting Admininfo instance with id: " + id);
		try {
			Admininfo instance = (Admininfo) getSession().get(
					"com.hibernate.dao.Admininfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Admininfo instance) {
		log.debug("finding Admininfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hibernate.dao.Admininfo")
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
		log.debug("finding Admininfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admininfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdminAccount(Object adminAccount) {
		return findByProperty(ADMIN_ACCOUNT, adminAccount);
	}

	public List findByAdminPassword(Object adminPassword) {
		return findByProperty(ADMIN_PASSWORD, adminPassword);
	}

	public List findByAdminFaceing(Object adminFaceing) {
		return findByProperty(ADMIN_FACEING, adminFaceing);
	}

	public List findByAdminPersonalld(Object adminPersonalld) {
		return findByProperty(ADMIN_PERSONALLD, adminPersonalld);
	}

	public List findByAdminPhone(Object adminPhone) {
		return findByProperty(ADMIN_PHONE, adminPhone);
	}

	public List findByRestaurantName(Object restaurantName) {
		return findByProperty(RESTAURANT_NAME, restaurantName);
	}

	public List findByRestaurantAddress(Object restaurantAddress) {
		return findByProperty(RESTAURANT_ADDRESS, restaurantAddress);
	}

	public List findAll() {
		log.debug("finding all Admininfo instances");
		try {
			String queryString = "from Admininfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admininfo merge(Admininfo detachedInstance) {
		log.debug("merging Admininfo instance");
		try {
			Admininfo result = (Admininfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admininfo instance) {
		log.debug("attaching dirty Admininfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admininfo instance) {
		log.debug("attaching clean Admininfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}