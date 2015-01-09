package com.video.entity;

// default package

import java.sql.Timestamp;
import java.util.Set;

/**
 * VideoType entity. @author MyEclipse Persistence Tools
 */
public class VideoType extends AbstractVideoType implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VideoType() {
	}

	/** minimal constructor */
	public VideoType(String videoTypeName) {
		super(videoTypeName);
	}

	/** full constructor */
	public VideoType(String videoTypeName, String videoTypeDesc,
			Integer videoTypeFather, String videoTypeLayer,
			String videoTypePic, Timestamp createDate, String ex, Set videoInfos) {
		super(videoTypeName, videoTypeDesc, videoTypeFather, videoTypeLayer,
				videoTypePic, createDate, ex, videoInfos);
	}

}
