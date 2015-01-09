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

import com.user.entity.UserGroup;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserGroup entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.user.entity.UserGroup
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserGroupDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserGroupDAO.class);
	// property constants
	public static final String GROUP_NAME = "groupName";
	public static final String GROUP_FUNCTION = "groupFunction";
	public static final String GROUP_POWER = "groupPower";
	public static final String GROUP_FATHER = "groupFather";
	public static final String GROUP_LAYER = "groupLayer";

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

	public void save(UserGroup transientInstance) {
		log.debug("saving UserGroup instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserGroup persistentInstance) {
		log.debug("deleting UserGroup instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserGroup findById(java.lang.Integer id) {
		log.debug("getting UserGroup instance with id: " + id);
		try {
			UserGroup instance = (UserGroup) getCurrentSession().get(
					"com.user.entity.UserGroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserGroup instance) {
		log.debug("finding UserGroup instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.user.entity.UserGroup")
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
		log.debug("finding UserGroup instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserGroup as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGroupName(Object groupName) {
		return findByProperty(GROUP_NAME, groupName);
	}

	public List findByGroupFunction(Object groupFunction) {
		return findByProperty(GROUP_FUNCTION, groupFunction);
	}

	public List findByGroupPower(Object groupPower) {
		return findByProperty(GROUP_POWER, groupPower);
	}

	public List findByGroupFather(Object groupFather) {
		return findByProperty(GROUP_FATHER, groupFather);
	}

	public List findByGroupLayer(Object groupLayer) {
		return findByProperty(GROUP_LAYER, groupLayer);
	}

	public List findAll() {
		log.debug("finding all UserGroup instances");
		try {
			String queryString = "from UserGroup";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserGroup merge(UserGroup detachedInstance) {
		log.debug("merging UserGroup instance");
		try {
			UserGroup result = (UserGroup) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserGroup instance) {
		log.debug("attaching dirty UserGroup instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserGroup instance) {
		log.debug("attaching clean UserGroup instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserGroupDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserGroupDAO) ctx.getBean("UserGroupDAO");
	}
}