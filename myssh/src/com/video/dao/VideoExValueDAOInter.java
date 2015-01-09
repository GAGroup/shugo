package com.video.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.video.entity.VideoExValue;

public interface VideoExValueDAOInter {

	// property constants
	public static final String VALUE = "value";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(VideoExValue transientInstance);

	public abstract void delete(VideoExValue persistentInstance);

	public abstract VideoExValue findById(java.lang.Integer id);

	public abstract List findByExample(VideoExValue instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByValue(Object value);

	public abstract List findAll();

	public abstract VideoExValue merge(VideoExValue detachedInstance);

	public abstract void attachDirty(VideoExValue instance);

	public abstract void attachClean(VideoExValue instance);

}