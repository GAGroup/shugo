package com.video.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractVideoInfo entity provides the base persistence definition of the
 * VideoInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVideoInfo implements java.io.Serializable {

	// Fields

	private Integer videoId;
	private VideoType videoType;
	private String videoName;
	private Integer videoUplodUser;
	private String savePath;
	private Long size;
	private Timestamp uploadTime;
	private String saveName;
	private Integer visitedTimes;
	private Integer visitPower;
	private Integer visitValue;
	private String videoDesc;
	private Integer videoState;
	private String visitPath;
	private String ex;
	private Set videoExValues = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractVideoInfo() {
	}

	/** full constructor */
	public AbstractVideoInfo(VideoType videoType, String videoName,
			Integer videoUplodUser, String savePath, Long size,
			Timestamp uploadTime, String saveName, Integer visitedTimes,
			Integer visitPower, Integer visitValue, String videoDesc,
			Integer videoState, String visitPath, String ex, Set videoExValues) {
		this.videoType = videoType;
		this.videoName = videoName;
		this.videoUplodUser = videoUplodUser;
		this.savePath = savePath;
		this.size = size;
		this.uploadTime = uploadTime;
		this.saveName = saveName;
		this.visitedTimes = visitedTimes;
		this.visitPower = visitPower;
		this.visitValue = visitValue;
		this.videoDesc = videoDesc;
		this.videoState = videoState;
		this.visitPath = visitPath;
		this.ex = ex;
		this.videoExValues = videoExValues;
	}

	// Property accessors

	public Integer getVideoId() {
		return this.videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public VideoType getVideoType() {
		return this.videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	public String getVideoName() {
		return this.videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public Integer getVideoUplodUser() {
		return this.videoUplodUser;
	}

	public void setVideoUplodUser(Integer videoUplodUser) {
		this.videoUplodUser = videoUplodUser;
	}

	public String getSavePath() {
		return this.savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public Long getSize() {
		return this.size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getSaveName() {
		return this.saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public Integer getVisitedTimes() {
		return this.visitedTimes;
	}

	public void setVisitedTimes(Integer visitedTimes) {
		this.visitedTimes = visitedTimes;
	}

	public Integer getVisitPower() {
		return this.visitPower;
	}

	public void setVisitPower(Integer visitPower) {
		this.visitPower = visitPower;
	}

	public Integer getVisitValue() {
		return this.visitValue;
	}

	public void setVisitValue(Integer visitValue) {
		this.visitValue = visitValue;
	}

	public String getVideoDesc() {
		return this.videoDesc;
	}

	public void setVideoDesc(String videoDesc) {
		this.videoDesc = videoDesc;
	}

	public Integer getVideoState() {
		return this.videoState;
	}

	public void setVideoState(Integer videoState) {
		this.videoState = videoState;
	}

	public String getVisitPath() {
		return this.visitPath;
	}

	public void setVisitPath(String visitPath) {
		this.visitPath = visitPath;
	}

	public String getEx() {
		return this.ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	public Set getVideoExValues() {
		return this.videoExValues;
	}

	public void setVideoExValues(Set videoExValues) {
		this.videoExValues = videoExValues;
	}

}