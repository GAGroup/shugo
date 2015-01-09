package com.video.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.video.entity.VideoType;

public interface VideoTypeDAOInter {

	// property constants
	public static final String VIDEO_TYPE_NAME = "videoTypeName";
	public static final String VIDEO_TYPE_DESC = "videoTypeDesc";
	public static final String VIDEO_TYPE_FATHER = "videoTypeFather";
	public static final String VIDEO_TYPE_LAYER = "videoTypeLayer";
	public static final String VIDEO_TYPE_PIC = "videoTypePic";
	public static final String EX = "ex";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(VideoType transientInstance);

	public abstract void delete(VideoType persistentInstance);

	public abstract VideoType findById(java.lang.Integer id);

	public abstract List findByExample(VideoType instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByVideoTypeName(Object videoTypeName);

	public abstract List findByVideoTypeDesc(Object videoTypeDesc);

	public abstract List findByVideoTypeFather(Object videoTypeFather);

	public abstract List findByVideoTypeLayer(Object videoTypeLayer);

	public abstract List findByVideoTypePic(Object videoTypePic);

	public abstract List findByEx(Object ex);

	public abstract List findAll();

	public abstract VideoType merge(VideoType detachedInstance);

	public abstract void attachDirty(VideoType instance);

	public abstract void attachClean(VideoType instance);

}