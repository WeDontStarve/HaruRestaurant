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
 * Dishinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.hibernate.dao.Dishinfo
 * @author MyEclipse Persistence Tools
 */
public class DishinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DishinfoDAO.class);
	// property constants
	public static final String DISH_NAME = "dishName";
	public static final String DISH_DISCRIPT = "dishDiscript";
	public static final String DISH_IMG = "dishImg";
	public static final String DISH_PRICE = "dishPrice";
	public static final String RECOMMEND = "recommend";

	public void save(Dishinfo transientInstance) {
		log.debug("saving Dishinfo instance");
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

	public void delete(Dishinfo persistentInstance) {
		log.debug("deleting Dishinfo instance");
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

	public Dishinfo findById(java.lang.Integer id) {
		log.debug("getting Dishinfo instance with id: " + id);
		try {
			Dishinfo instance = (Dishinfo) getSession().get(
					"com.hibernate.dao.Dishinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dishinfo instance) {
		log.debug("finding Dishinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hibernate.dao.Dishinfo")
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
		log.debug("finding Dishinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dishinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDishName(Object dishName) {
		return findByProperty(DISH_NAME, dishName);
	}

	public List findByDishDiscript(Object dishDiscript) {
		return findByProperty(DISH_DISCRIPT, dishDiscript);
	}

	public List findByDishImg(Object dishImg) {
		return findByProperty(DISH_IMG, dishImg);
	}

	public List findByDishPrice(Object dishPrice) {
		return findByProperty(DISH_PRICE, dishPrice);
	}

	public List findByRecommend(Object recommend) {
		return findByProperty(RECOMMEND, recommend);
	}

	public List findAll() {
		log.debug("finding all Dishinfo instances");
		try {
			String queryString = "from Dishinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dishinfo merge(Dishinfo detachedInstance) {
		log.debug("merging Dishinfo instance");
		try {
			Dishinfo result = (Dishinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dishinfo instance) {
		log.debug("attaching dirty Dishinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dishinfo instance) {
		log.debug("attaching clean Dishinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findAllId(){
		log.debug("find all ID from dishInfo");
		try{
			String hql="select dishId from Dishinfo";
			Query queryObject=getSession().createQuery(hql);
			return queryObject.list();
		}catch(RuntimeException re){
			log.error("find id failed",re);
			throw re;
		}
	}
}