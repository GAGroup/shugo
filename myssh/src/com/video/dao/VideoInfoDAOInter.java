package com.video.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.video.entity.VideoInfo;

public interface VideoInfoDAOInter {

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

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(VideoInfo transientInstance);

	public abstract void delete(VideoInfo persistentInstance);

	public abstract VideoInfo findById(java.lang.Integer id);

	public abstract List findByExample(VideoInfo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByVideoName(Object videoName);

	public abstract List findByVideoUplodUser(Object videoUplodUser);

	public abstract List findBySavePath(Object savePath);

	public abstract List findBySize(Object size);

	public abstract List findBySaveName(Object saveName);

	public abstract List findByVisitedTimes(Object visitedTimes);

	public abstract List findByVisitPower(Object visitPower);

	public abstract List findByVisitValue(Object visitValue);

	public abstract List findByVideoDesc(Object videoDesc);

	public abstract List findByVideoState(Object videoState);

	public abstract List findByVisitPath(Object visitPath);

	public abstract List findByEx(Object ex);

	public abstract List findAll();

	public abstract VideoInfo merge(VideoInfo detachedInstance);

	public abstract void attachDirty(VideoInfo instance);

	public abstract void attachClean(VideoInfo instance);

}