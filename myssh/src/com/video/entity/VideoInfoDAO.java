package com.video.entity;

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

import com.video.entity.VideoInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * VideoInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.video.entity.VideoInfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class VideoInfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(VideoInfoDAO.class);
	// property constants
	public static final String VIDEO_NAME = "videoName";
	public static final String VIDEO_UPLOD_USER = "videoUplodUser";
	public static final String SAVE_PATH = "savePath";
	public static final String SIZE = "size";
	public static final String SAVE_NAME = "saveName";
	public static final String VISITED_TIMES = "visitedTimes";
	public static final String VISIT_POWER = "visitPower";
	public static final String VISIT_VALUE = "visitValue";
	public static final String VIDEO_DESC = "videoDesc";
	public static final String VIDEO_STATE = "videoState";
	public static final String VISIT_PATH = "visitPath";
	public static final String EX = "ex";

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

	public void save(VideoInfo transientInstance) {
		log.debug("saving VideoInfo instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VideoInfo persistentInstance) {
		log.debug("deleting VideoInfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VideoInfo findById(java.lang.Integer id) {
		log.debug("getting VideoInfo instance with id: " + id);
		try {
			VideoInfo instance = (VideoInfo) getCurrentSession().get(
					"com.video.entity.VideoInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VideoInfo instance) {
		log.debug("finding VideoInfo instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.video.entity.VideoInfo")
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
		log.debug("finding VideoInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from VideoInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByVideoName(Object videoName) {
		return findByProperty(VIDEO_NAME, videoName);
	}

	public List findByVideoUplodUser(Object videoUplodUser) {
		return findByProperty(VIDEO_UPLOD_USER, videoUplodUser);
	}

	public List findBySavePath(Object savePath) {
		return findByProperty(SAVE_PATH, savePath);
	}

	public List findBySize(Object size) {
		return findByProperty(SIZE, size);
	}

	public List findBySaveName(Object saveName) {
		return findByProperty(SAVE_NAME, saveName);
	}

	public List findByVisitedTimes(Object visitedTimes) {
		return findByProperty(VISITED_TIMES, visitedTimes);
	}

	public List findByVisitPower(Object visitPower) {
		return findByProperty(VISIT_POWER, visitPower);
	}

	public List findByVisitValue(Object visitValue) {
		return findByProperty(VISIT_VALUE, visitValue);
	}

	public List findByVideoDesc(Object videoDesc) {
		return findByProperty(VIDEO_DESC, videoDesc);
	}

	public List findByVideoState(Object videoState) {
		return findByProperty(VIDEO_STATE, videoState);
	}

	public List findByVisitPath(Object visitPath) {
		return findByProperty(VISIT_PATH, visitPath);
	}

	public List findByEx(Object ex) {
		return findByProperty(EX, ex);
	}

	public List findAll() {
		log.debug("finding all VideoInfo instances");
		try {
			String queryString = "from VideoInfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VideoInfo merge(VideoInfo detachedInstance) {
		log.debug("merging VideoInfo instance");
		try {
			VideoInfo result = (VideoInfo) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VideoInfo instance) {
		log.debug("attaching dirty VideoInfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VideoInfo instance) {
		log.debug("attaching clean VideoInfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static VideoInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (VideoInfoDAO) ctx.getBean("VideoInfoDAO");
	}
}