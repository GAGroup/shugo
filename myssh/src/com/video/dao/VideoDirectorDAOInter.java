package com.video.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.video.entity.VideoDirector;

public interface VideoDirectorDAOInter {

	// property constants
	public static final String USER = "user";
	public static final String PATH = "path";
	public static final String DIR_NAME = "dirName";
	public static final String FATHER_DIR = "fatherDir";
	public static final String DIR_LAYER = "dirLayer";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(VideoDirector transientInstance);

	public abstract void delete(VideoDirector persistentInstance);

	public abstract VideoDirector findById(java.lang.Integer id);

	public abstract List findByExample(VideoDirector instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUser(Object user);

	public abstract List findByPath(Object path);

	public abstract List findByDirName(Object dirName);

	public abstract List findByFatherDir(Object fatherDir);

	public abstract List findByDirLayer(Object dirLayer);

	public abstract List findAll();

	public abstract VideoDirector merge(VideoDirector detachedInstance);

	public abstract void attachDirty(VideoDirector instance);

	public abstract void attachClean(VideoDirector instance);

}