package com.video.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractVideoType entity provides the base persistence definition of the
 * VideoType entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVideoType implements java.io.Serializable {

	// Fields

	private Integer videoTypeId;
	private String videoTypeName;
	private String videoTypeDesc;
	private Integer videoTypeFather;
	private String videoTypeLayer;
	private String videoTypePic;
	private Timestamp createDate;
	private String ex;
	private Set videoInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractVideoType() {
	}

	/** minimal constructor */
	public AbstractVideoType(String videoTypeName) {
		this.videoTypeName = videoTypeName;
	}

	/** full constructor */
	public AbstractVideoType(String videoTypeName, String videoTypeDesc,
			Integer videoTypeFather, String videoTypeLayer,
			String videoTypePic, Timestamp createDate, String ex, Set videoInfos) {
		this.videoTypeName = videoTypeName;
		this.videoTypeDesc = videoTypeDesc;
		this.videoTypeFather = videoTypeFather;
		this.videoTypeLayer = videoTypeLayer;
		this.videoTypePic = videoTypePic;
		this.createDate = createDate;
		this.ex = ex;
		this.videoInfos = videoInfos;
	}

	// Property accessors

	public Integer getVideoTypeId() {
		return this.videoTypeId;
	}

	public void setVideoTypeId(Integer videoTypeId) {
		this.videoTypeId = videoTypeId;
	}

	public String getVideoTypeName() {
		return this.videoTypeName;
	}

	public void setVideoTypeName(String videoTypeName) {
		this.videoTypeName = videoTypeName;
	}

	public String getVideoTypeDesc() {
		return this.videoTypeDesc;
	}

	public void setVideoTypeDesc(String videoTypeDesc) {
		this.videoTypeDesc = videoTypeDesc;
	}

	public Integer getVideoTypeFather() {
		return this.videoTypeFather;
	}

	public void setVideoTypeFather(Integer videoTypeFather) {
		this.videoTypeFather = videoTypeFather;
	}

	public String getVideoTypeLayer() {
		return this.videoTypeLayer;
	}

	public void setVideoTypeLayer(String videoTypeLayer) {
		this.videoTypeLayer = videoTypeLayer;
	}

	public String getVideoTypePic() {
		return this.videoTypePic;
	}

	public void setVideoTypePic(String videoTypePic) {
		this.videoTypePic = videoTypePic;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getEx() {
		return this.ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	public Set getVideoInfos() {
		return this.videoInfos;
	}

	public void setVideoInfos(Set videoInfos) {
		this.videoInfos = videoInfos;
	}

}