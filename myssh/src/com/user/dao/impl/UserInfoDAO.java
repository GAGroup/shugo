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

import com.user.entity.UserInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.user.entity.UserInfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserInfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserInfoDAO.class);
	// property constants
	public static final String PASSWORD_TIP = "passwordTip";
	public static final String PASSWORD_TIP_ANSWER = "passwordTipAnswer";
	public static final String USER_MAIL = "userMail";
	public static final String USER_PHONE = "userPhone";
	public static final String USER_ADDRESS1 = "userAddress1";
	public static final String USER_ADDRESS2_SET = "userAddress2Set";
	public static final String USER_REAL_NAME = "userRealName";
	public static final String USER_CARD_ID = "userCardId";
	public static final String POST_CODE = "postCode";

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

	public void save(UserInfo transientInstance) {
		log.debug("saving UserInfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserInfo persistentInstance) {
		log.debug("deleting UserInfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserInfo findById(java.lang.Integer id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = (UserInfo) getCurrentSession().get(
					"com.user.entity.UserInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserInfo instance) {
		log.debug("finding UserInfo instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.user.entity.UserInfo")
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
		log.debug("finding UserInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPasswordTip(Object passwordTip) {
		return findByProperty(PASSWORD_TIP, passwordTip);
	}

	public List findByPasswordTipAnswer(Object passwordTipAnswer) {
		return findByProperty(PASSWORD_TIP_ANSWER, passwordTipAnswer);
	}

	public List findByUserMail(Object userMail) {
		return findByProperty(USER_MAIL, userMail);
	}

	public List findByUserPhone(Object userPhone) {
		return findByProperty(USER_PHONE, userPhone);
	}

	public List findByUserAddress1(Object userAddress1) {
		return findByProperty(USER_ADDRESS1, userAddress1);
	}

	public List findByUserAddress2Set(Object userAddress2Set) {
		return findByProperty(USER_ADDRESS2_SET, userAddress2Set);
	}

	public List findByUserRealName(Object userRealName) {
		return findByProperty(USER_REAL_NAME, userRealName);
	}

	public List findByUserCardId(Object userCardId) {
		return findByProperty(USER_CARD_ID, userCardId);
	}

	public List findByPostCode(Object postCode) {
		return findByProperty(POST_CODE, postCode);
	}

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = (UserInfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserInfo instance) {
		log.debug("attaching dirty UserInfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserInfo instance) {
		log.debug("attaching clean UserInfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserInfoDAO) ctx.getBean("UserInfoDAO");
	}
}