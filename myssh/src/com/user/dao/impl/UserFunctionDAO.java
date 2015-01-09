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

import com.user.entity.UserFunction;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserFunction entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.user.entity.UserFunction
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserFunctionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserFunctionDAO.class);
	// property constants
	public static final String FUNCTION_NAME = "functionName";
	public static final String FUNCTION_DESC = "functionDesc";
	public static final String FUNCTION_URL = "functionUrl";
	public static final String FUNCTION_POWER = "functionPower";

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

	public void save(UserFunction transientInstance) {
		log.debug("saving UserFunction instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserFunction persistentInstance) {
		log.debug("deleting UserFunction instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserFunction findById(java.lang.Integer id) {
		log.debug("getting UserFunction instance with id: " + id);
		try {
			UserFunction instance = (UserFunction) getCurrentSession().get(
					"com.user.entity.UserFunction", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserFunction instance) {
		log.debug("finding UserFunction instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.user.entity.UserFunction")
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
		log.debug("finding UserFunction instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserFunction as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFunctionName(Object functionName) {
		return findByProperty(FUNCTION_NAME, functionName);
	}

	public List findByFunctionDesc(Object functionDesc) {
		return findByProperty(FUNCTION_DESC, functionDesc);
	}

	public List findByFunctionUrl(Object functionUrl) {
		return findByProperty(FUNCTION_URL, functionUrl);
	}

	public List findByFunctionPower(Object functionPower) {
		return findByProperty(FUNCTION_POWER, functionPower);
	}

	public List findAll() {
		log.debug("finding all UserFunction instances");
		try {
			String queryString = "from UserFunction";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserFunction merge(UserFunction detachedInstance) {
		log.debug("merging UserFunction instance");
		try {
			UserFunction result = (UserFunction) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserFunction instance) {
		log.debug("attaching dirty UserFunction instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserFunction instance) {
		log.debug("attaching clean UserFunction instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserFunctionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserFunctionDAO) ctx.getBean("UserFunctionDAO");
	}
}