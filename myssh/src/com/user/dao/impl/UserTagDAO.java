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

import com.user.entity.UserTag;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserTag entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.user.entity.UserTag
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserTagDAO {
	private static final Logger log = LoggerFactory.getLogger(UserTagDAO.class);
	// property constants
	public static final String USER_TAG_NAME = "userTagName";
	public static final String USER_TAG_PIC = "userTagPic";
	public static final String USER_TAG_DESC = "userTagDesc";

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

	public void save(UserTag transientInstance) {
		log.debug("saving UserTag instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserTag persistentInstance) {
		log.debug("deleting UserTag instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserTag findById(java.lang.Integer id) {
		log.debug("getting UserTag instance with id: " + id);
		try {
			UserTag instance = (UserTag) getCurrentSession().get(
					"com.user.entity.UserTag", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserTag instance) {
		log.debug("finding UserTag instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.user.entity.UserTag")
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
		log.debug("finding UserTag instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserTag as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserTagName(Object userTagName) {
		return findByProperty(USER_TAG_NAME, userTagName);
	}

	public List findByUserTagPic(Object userTagPic) {
		return findByProperty(USER_TAG_PIC, userTagPic);
	}

	public List findByUserTagDesc(Object userTagDesc) {
		return findByProperty(USER_TAG_DESC, userTagDesc);
	}

	public List findAll() {
		log.debug("finding all UserTag instances");
		try {
			String queryString = "from UserTag";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserTag merge(UserTag detachedInstance) {
		log.debug("merging UserTag instance");
		try {
			UserTag result = (UserTag) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserTag instance) {
		log.debug("attaching dirty UserTag instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserTag instance) {
		log.debug("attaching clean UserTag instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserTagDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserTagDAO) ctx.getBean("UserTagDAO");
	}
}