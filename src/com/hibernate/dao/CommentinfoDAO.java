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
 * Commentinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.hibernate.dao.Commentinfo
 * @author MyEclipse Persistence Tools
 */
public class CommentinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CommentinfoDAO.class);

	// property constants

	public void save(Commentinfo transientInstance) {
		log.debug("saving Commentinfo instance");
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

	public void delete(Commentinfo persistentInstance) {
		log.debug("deleting Commentinfo instance");
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

	public Commentinfo findById(java.lang.String id) {
		log.debug("getting Commentinfo instance with id: " + id);
		try {
			Commentinfo instance = (Commentinfo) getSession().get(
					"com.hibernate.dao.Commentinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Commentinfo instance) {
		log.debug("finding Commentinfo instance by example");
		try {
			List results = getSession()
					.createCriteria("com.hibernate.dao.Commentinfo")
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
		log.debug("finding Commentinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Commentinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Commentinfo instances");
		try {
			String queryString = "from Commentinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Commentinfo merge(Commentinfo detachedInstance) {
		log.debug("merging Commentinfo instance");
		try {
			Commentinfo result = (Commentinfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Commentinfo instance) {
		log.debug("attaching dirty Commentinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Commentinfo instance) {
		log.debug("attaching clean Commentinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}