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
 * Orderdishes entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hibernate.dao.Orderdishes
 * @author MyEclipse Persistence Tools
 */
public class OrderdishesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderdishesDAO.class);
	// property constants
	public static final String NUM = "num";
	public static final String DISH_NAME = "dishName";

	public void save(Orderdishes transientInstance) {
		log.debug("saving Orderdishes instance");
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

	public void delete(Orderdishes persistentInstance) {
		log.debug("deleting Orderdishes instance");
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

	public Orderdishes findById(com.hibernate.dao.OrderdishesId id) {
		log.debug("getting Orderdishes instance with id: " + id);
		try {
			Orderdishes instance = (Orderdishes) getSession().get(
					"com.hibernate.dao.Orderdishes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Orderdishes instance) {
		log.debug("finding Orderdishes instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hibernate.dao.Orderdishes")
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
		log.debug("finding Orderdishes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderdishes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNum(Object num) {
		return findByProperty(NUM, num);
	}

	public List findByDishName(Object dishName) {
		return findByProperty(DISH_NAME, dishName);
	}

	public List findAll() {
		log.debug("finding all Orderdishes instances");
		try {
			String queryString = "from Orderdishes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderdishes merge(Orderdishes detachedInstance) {
		log.debug("merging Orderdishes instance");
		try {
			Orderdishes result = (Orderdishes) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderdishes instance) {
		log.debug("attaching dirty Orderdishes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderdishes instance) {
		log.debug("attaching clean Orderdishes instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}