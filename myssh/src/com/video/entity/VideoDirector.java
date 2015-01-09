package com.video.entity;

import java.sql.Timestamp;

/**
 * VideoDirector entity. @author MyEclipse Persistence Tools
 */
public class VideoDirector extends AbstractVideoDirector implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VideoDirector() {
	}

	/** full constructor */
	public VideoDirector(Integer user, String path, String dirName,
			Timestamp createTime, Integer fatherDir, String dirLayer) {
		super(user, path, dirName, createTime, fatherDir, dirLayer);
	}

}
