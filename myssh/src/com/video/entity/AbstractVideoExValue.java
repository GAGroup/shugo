package com.video.entity;

/**
 * AbstractVideoExValue entity provides the base persistence definition of the
 * VideoExValue entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVideoExValue implements java.io.Serializable {

	// Fields

	private Integer valueId;
	private VideoInfo videoInfo;
	private VideoExProperty videoExProperty;
	private String value;

	// Constructors

	/** default constructor */
	public AbstractVideoExValue() {
	}

	/** full constructor */
	public AbstractVideoExValue(VideoInfo videoInfo,
			VideoExProperty videoExProperty, String value) {
		this.videoInfo = videoInfo;
		this.videoExProperty = videoExProperty;
		this.value = value;
	}

	// Property accessors

	public Integer getValueId() {
		return this.valueId;
	}

	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	public VideoInfo getVideoInfo() {
		return this.videoInfo;
	}

	public void setVideoInfo(VideoInfo videoInfo) {
		this.videoInfo = videoInfo;
	}

	public VideoExProperty getVideoExProperty() {
		return this.videoExProperty;
	}

	public void setVideoExProperty(VideoExProperty videoExProperty) {
		this.videoExProperty = videoExProperty;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}