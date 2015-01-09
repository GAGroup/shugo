package com.video.entity;

// default package

import java.sql.Timestamp;
import java.util.Set;

/**
 * VideoInfo entity. @author MyEclipse Persistence Tools
 */
public class VideoInfo extends AbstractVideoInfo implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VideoInfo() {
	}

	/** full constructor */
	public VideoInfo(VideoType videoType, String videoName,
			Integer videoUplodUser, String savePath, Long size,
			Timestamp uploadTime, String saveName, Integer visitedTimes,
			Integer visitPower, Integer visitValue, String videoDesc,
			Integer videoState, String visitPath, String ex, Set videoExValues){
		super(videoType, videoName, videoUplodUser, savePath, size, uploadTime, saveName,
				visitedTimes, visitPower, visitValue, videoDesc, videoState, visitPath, 
				ex, videoExValues);

	}

}
