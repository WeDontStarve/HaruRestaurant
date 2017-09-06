package com.DAO;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vipinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.DAO.Vipinfo
 * @author MyEclipse Persistence Tools
 */
public class VipinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(VipinfoDAO.class);
	// property constants
	public static final String VIPACCOUNT = "vipaccount";
	public static final String VIPPASSWORD = "vippassword";
	public static final String VIPFACEING = "vipfaceing";
	public static final String VIPPHONE = "vipphone";

	public void save(Vipinfo transientInstance) {
		log.debug("saving Vipinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Vipinfo persistentInstance) {
		log.debug("deleting Vipinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Vipinfo findById(java.lang.Integer id) {
		log.debug("getting Vipinfo instance with id: " + id);
		try {
			Vipinfo instance = (Vipinfo) getSession()
					.get("com.DAO.Vipinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Vipinfo instance) {
		log.debug("finding Vipinfo instance by example");
		try {
			List results = getSession().createCriteria("com.DAO.Vipinfo")
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
		log.debug("finding Vipinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Vipinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVipaccount(Object vipaccount) {
		return findByProperty(VIPACCOUNT, vipaccount);
	}

	public List findByVippassword(Object vippassword) {
		return findByProperty(VIPPASSWORD, vippassword);
	}

	public List findByVipfaceing(Object vipfaceing) {
		return findByProperty(VIPFACEING, vipfaceing);
	}

	public List findByVipphone(Object vipphone) {
		return findByProperty(VIPPHONE, vipphone);
	}

	public List findAll() {
		log.debug("finding all Vipinfo instances");
		try {
			String queryString = "from Vipinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Vipinfo merge(Vipinfo detachedInstance) {
		log.debug("merging Vipinfo instance");
		try {
			Vipinfo result = (Vipinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Vipinfo instance) {
		log.debug("attaching dirty Vipinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Vipinfo instance) {
		log.debug("attaching clean Vipinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}