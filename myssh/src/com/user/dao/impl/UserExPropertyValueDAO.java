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

import com.user.entity.UserExPropertyValue;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserExPropertyValue entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.user.entity.UserExPropertyValue
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserExPropertyValueDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserExPropertyValueDAO.class);
	// property constants
	public static final String PROPERTY_VALUE = "propertyValue";
	public static final String USER_ID = "userId";

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

	public void save(UserExPropertyValue transientInstance) {
		log.debug("saving UserExPropertyValue instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserExPropertyValue persistentInstance) {
		log.debug("deleting UserExPropertyValue instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserExPropertyValue findById(java.lang.Integer id) {
		log.debug("getting UserExPropertyValue instance with id: " + id);
		try {
			UserExPropertyValue instance = (UserExPropertyValue) getCurrentSession()
					.get("com.user.entity.UserExPropertyValue", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserExPropertyValue instance) {
		log.debug("finding UserExPropertyValue instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.user.entity.UserExPropertyValue")
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
		log.debug("finding UserExPropertyValue instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserExPropertyValue as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPropertyValue(Object propertyValue) {
		return findByProperty(PROPERTY_VALUE, propertyValue);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findAll() {
		log.debug("finding all UserExPropertyValue instances");
		try {
			String queryString = "from UserExPropertyValue";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserExPropertyValue merge(UserExPropertyValue detachedInstance) {
		log.debug("merging UserExPropertyValue instance");
		try {
			UserExPropertyValue result = (UserExPropertyValue) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserExPropertyValue instance) {
		log.debug("attaching dirty UserExPropertyValue instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserExPropertyValue instance) {
		log.debug("attaching clean UserExPropertyValue instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserExPropertyValueDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserExPropertyValueDAO) ctx.getBean("UserExPropertyValueDAO");
	}
}