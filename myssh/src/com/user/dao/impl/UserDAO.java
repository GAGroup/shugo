package com.user.dao.impl;

import java.sql.Timestamp;
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

import com.user.dao.UerDAOInter;
import com.user.entity.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.user.entity.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserDAO implements UerDAOInter {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#save(com.user.entity.User)
	 */
	@Override
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#delete(com.user.entity.User)
	 */
	@Override
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findById(java.lang.Integer)
	 */
	@Override
	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get(
					"com.user.entity.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByExample(com.user.entity.User)
	 */
	@Override
	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.user.entity.User")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByUserName(java.lang.Object)
	 */
	@Override
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByUserPwd(java.lang.Object)
	 */
	@Override
	public List findByUserPwd(Object userPwd) {
		return findByProperty(USER_PWD, userPwd);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByUserTag(java.lang.Object)
	 */
	@Override
	public List findByUserTag(Object userTag) {
		return findByProperty(USER_TAG, userTag);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByUserTypeId(java.lang.Object)
	 */
	@Override
	public List findByUserTypeId(Object userTypeId) {
		return findByProperty(USER_TYPE_ID, userTypeId);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByUserHuiyuanId(java.lang.Object)
	 */
	@Override
	public List findByUserHuiyuanId(Object userHuiyuanId) {
		return findByProperty(USER_HUIYUAN_ID, userHuiyuanId);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByUserDesc(java.lang.Object)
	 */
	@Override
	public List findByUserDesc(Object userDesc) {
		return findByProperty(USER_DESC, userDesc);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByUserState(java.lang.Object)
	 */
	@Override
	public List findByUserState(Object userState) {
		return findByProperty(USER_STATE, userState);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByHasMessage(java.lang.Object)
	 */
	@Override
	public List findByHasMessage(Object hasMessage) {
		return findByProperty(HAS_MESSAGE, hasMessage);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findByHasMail(java.lang.Object)
	 */
	@Override
	public List findByHasMail(Object hasMail) {
		return findByProperty(HAS_MAIL, hasMail);
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#merge(com.user.entity.User)
	 */
	@Override
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#attachDirty(com.user.entity.User)
	 */
	@Override
	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.user.dao.impl.UerDAOInter#attachClean(com.user.entity.User)
	 */
	@Override
	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UerDAOInter getFromApplicationContext(ApplicationContext ctx) {
		return (UerDAOInter) ctx.getBean("UserDAO");
	}
}