package com.video.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.video.entity.VideoExProperty;

public interface VideoExPropertyDAOInter {

	// property constants
	public static final String PROPERTY_NAME = "propertyName";
	public static final String PROPERTY_DESC = "propertyDesc";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(VideoExProperty transientInstance);

	public abstract void delete(VideoExProperty persistentInstance);

	public abstract VideoExProperty findById(java.lang.Integer id);

	public abstract List findByExample(VideoExProperty instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPropertyName(Object propertyName);

	public abstract List findByPropertyDesc(Object propertyDesc);

	public abstract List findAll();

	public abstract VideoExProperty merge(VideoExProperty detachedInstance);

	public abstract void attachDirty(VideoExProperty instance);

	public abstract void attachClean(VideoExProperty instance);

}