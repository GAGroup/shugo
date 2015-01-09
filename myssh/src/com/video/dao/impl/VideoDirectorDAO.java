package com.video.dao.impl;

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

import com.video.dao.VideoDirectorDAOInter;
import com.video.entity.VideoDirector;

/**
 * A data access object (DAO) providing persistence and search support for
 * VideoDirector entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.video.entity.VideoDirector
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class VideoDirectorDAO implements VideoDirectorDAOInter {
	private static final Logger log = LoggerFactory
			.getLogger(VideoDirectorDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#save(com.video.entity.VideoDirector)
	 */
	@Override
	public void save(VideoDirector transientInstance) {
		log.debug("saving VideoDirector instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#delete(com.video.entity.VideoDirector)
	 */
	@Override
	public void delete(VideoDirector persistentInstance) {
		log.debug("deleting VideoDirector instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findById(java.lang.Integer)
	 */
	@Override
	public VideoDirector findById(java.lang.Integer id) {
		log.debug("getting VideoDirector instance with id: " + id);
		try {
			VideoDirector instance = (VideoDirector) getCurrentSession().get(
					"com.video.entity.VideoDirector", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findByExample(com.video.entity.VideoDirector)
	 */
	@Override
	public List findByExample(VideoDirector instance) {
		log.debug("finding VideoDirector instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.video.entity.VideoDirector")
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
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding VideoDirector instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VideoDirector as model where model."
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
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findByUser(java.lang.Object)
	 */
	@Override
	public List findByUser(Object user) {
		return findByProperty(USER, user);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findByPath(java.lang.Object)
	 */
	@Override
	public List findByPath(Object path) {
		return findByProperty(PATH, path);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findByDirName(java.lang.Object)
	 */
	@Override
	public List findByDirName(Object dirName) {
		return findByProperty(DIR_NAME, dirName);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findByFatherDir(java.lang.Object)
	 */
	@Override
	public List findByFatherDir(Object fatherDir) {
		return findByProperty(FATHER_DIR, fatherDir);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findByDirLayer(java.lang.Object)
	 */
	@Override
	public List findByDirLayer(Object dirLayer) {
		return findByProperty(DIR_LAYER, dirLayer);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all VideoDirector instances");
		try {
			String queryString = "from VideoDirector";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#merge(com.video.entity.VideoDirector)
	 */
	@Override
	public VideoDirector merge(VideoDirector detachedInstance) {
		log.debug("merging VideoDirector instance");
		try {
			VideoDirector result = (VideoDirector) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#attachDirty(com.video.entity.VideoDirector)
	 */
	@Override
	public void attachDirty(VideoDirector instance) {
		log.debug("attaching dirty VideoDirector instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoDirectorDAOInter#attachClean(com.video.entity.VideoDirector)
	 */
	@Override
	public void attachClean(VideoDirector instance) {
		log.debug("attaching clean VideoDirector instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VideoDirectorDAOInter getFromApplicationContext(
			ApplicationContext ctx) {
		return (VideoDirectorDAOInter) ctx.getBean("VideoDirectorDAO");
	}
}