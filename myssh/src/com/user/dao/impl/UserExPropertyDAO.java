package com.user.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.user.entity.UserExProperty;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserExProperty entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.user.entity.UserExProperty
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserExPropertyDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserExPropertyDAO.class);
	// property constants
	public static final String PROPERTY_NAME = "propertyName";
	public static final String PROPERTY_DESC = "propertyDesc";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(UserExProperty transientInstance) {
		log.debug("saving UserExProperty instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserExProperty persistentInstance) {
		log.debug("deleting UserExProperty instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserExProperty findById(java.lang.Integer id) {
		log.debug("getting UserExProperty instance with id: " + id);
		try {
			UserExProperty instance = (UserExProperty) getCurrentSession().get(
					"com.user.entity.UserExProperty", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserExProperty instance) {
		log.debug("finding UserExProperty instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.user.entity.UserExProperty")
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
		log.debug("finding UserExProperty instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserExProperty as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPropertyName(Object propertyName) {
		return findByProperty(PROPERTY_NAME, propertyName);
	}

	public List findByPropertyDesc(Object propertyDesc) {
		return findByProperty(PROPERTY_DESC, propertyDesc);
	}

	public List findAll() {
		log.debug("finding all UserExProperty instances");
		try {
			String queryString = "from UserExProperty";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserExProperty merge(UserExProperty detachedInstance) {
		log.debug("merging UserExProperty instance");
		try {
			UserExProperty result = (UserExProperty) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserExProperty instance) {
		log.debug("attaching dirty UserExProperty instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserExProperty instance) {
		log.debug("attaching clean UserExProperty instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserExPropertyDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserExPropertyDAO) ctx.getBean("UserExPropertyDAO");
	}
}