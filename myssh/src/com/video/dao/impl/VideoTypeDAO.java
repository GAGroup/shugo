package com.video.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.video.dao.VideoTypeDAOInter;
import com.video.entity.VideoType;

/**
 * A data access object (DAO) providing persistence and search support for
 * VideoType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.video.entity.VideoType
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class VideoTypeDAO implements VideoTypeDAOInter {
	private static final Logger log = LoggerFactory
			.getLogger(VideoTypeDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.video.dao.impl.VideoTypeDAOInter#save(com.video.entity.VideoType)
	 */
	@Override
	public void save(VideoType transientInstance) {
		log.debug("saving VideoType instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#delete(com.video.entity.VideoType)
	 */
	@Override
	public void delete(VideoType persistentInstance) {
		log.debug("deleting VideoType instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findById(java.lang.Integer)
	 */
	@Override
	public VideoType findById(java.lang.Integer id) {
		log.debug("getting VideoType instance with id: " + id);
		try {
			VideoType instance = (VideoType) getCurrentSession().get(
					"com.video.entity.VideoType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByExample(com.video.entity.VideoType)
	 */
	@Override
	public List findByExample(VideoType instance) {
		log.debug("finding VideoType instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.video.entity.VideoType")
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
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding VideoType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VideoType as model where model."
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
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByVideoTypeName(java.lang.Object)
	 */
	@Override
	public List findByVideoTypeName(Object videoTypeName) {
		return findByProperty(VIDEO_TYPE_NAME, videoTypeName);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByVideoTypeDesc(java.lang.Object)
	 */
	@Override
	public List findByVideoTypeDesc(Object videoTypeDesc) {
		return findByProperty(VIDEO_TYPE_DESC, videoTypeDesc);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByVideoTypeFather(java.lang.Object)
	 */
	@Override
	public List findByVideoTypeFather(Object videoTypeFather) {
		return findByProperty(VIDEO_TYPE_FATHER, videoTypeFather);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByVideoTypeLayer(java.lang.Object)
	 */
	@Override
	public List findByVideoTypeLayer(Object videoTypeLayer) {
		return findByProperty(VIDEO_TYPE_LAYER, videoTypeLayer);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByVideoTypePic(java.lang.Object)
	 */
	@Override
	public List findByVideoTypePic(Object videoTypePic) {
		return findByProperty(VIDEO_TYPE_PIC, videoTypePic);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findByEx(java.lang.Object)
	 */
	@Override
	public List findByEx(Object ex) {
		return findByProperty(EX, ex);
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all VideoType instances");
		try {
			String queryString = "from VideoType";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#merge(com.video.entity.VideoType)
	 */
	@Override
	public VideoType merge(VideoType detachedInstance) {
		log.debug("merging VideoType instance");
		try {
			VideoType result = (VideoType) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#attachDirty(com.video.entity.VideoType)
	 */
	@Override
	public void attachDirty(VideoType instance) {
		log.debug("attaching dirty VideoType instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.video.dao.impl.VideoTypeDAOInter#attachClean(com.video.entity.VideoType)
	 */
	@Override
	public void attachClean(VideoType instance) {
		log.debug("attaching clean VideoType instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VideoTypeDAOInter getFromApplicationContext(ApplicationContext ctx) {
		return (VideoTypeDAOInter) ctx.getBean("VideoTypeDAO");
	}
}