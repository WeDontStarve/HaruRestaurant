package com.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Tableinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.DAO.Tableinfo
 * @author MyEclipse Persistence Tools
 */
public class TableinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TableinfoDAO.class);
	// property constants
	public static final String TABLE_SEAT = "tableSeat";
	public static final String TABLE_STATUS = "tableStatus";
	public static final String ADMIN_ID="adminId";
	
	public void save(Tableinfo transientInstance) {
		log.debug("saving Tableinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Tableinfo persistentInstance) {
		log.debug("deleting Tableinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Tableinfo findById(java.lang.Integer id) {
		log.debug("getting Tableinfo instance with id: " + id);
		try {
			Tableinfo instance = (Tableinfo) getSession().get(
					"com.DAO.Tableinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Tableinfo instance) {
		log.debug("finding Tableinfo instance by example");
		try {
			List results = getSession().createCriteria("com.DAO.Tableinfo")
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
		log.debug("finding Tableinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Tableinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTableSeat(Object tableSeat) {
		return findByProperty(TABLE_SEAT, tableSeat);
	}

	public List findByTableStatus(Object tableStatus) {
		return findByProperty(TABLE_STATUS, tableStatus);
	}

	public List findByAdminId(Object adminId){
		return findByProperty(ADMIN_ID,adminId);
	}
	
	public List findAll() {
		log.debug("finding all Tableinfo instances");
		try {
			String queryString = "from Tableinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Tableinfo merge(Tableinfo detachedInstance) {
		log.debug("merging Tableinfo instance");
		try {
			Tableinfo result = (Tableinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Tableinfo instance) {
		log.debug("attaching dirty Tableinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Tableinfo instance) {
		log.debug("attaching clean Tableinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findAllId(){
		log.debug("find all ID from tableInfo");
		try{
			String hql="select tableId from Tableinfo";
			Query queryObject=getSession().createQuery(hql);
			return queryObject.list();
		}catch(RuntimeException re){
			log.error("find id failed",re);
			throw re;
		}
	}
}