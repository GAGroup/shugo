package com.video.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractVideoExProperty entity provides the base persistence definition of
 * the VideoExProperty entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVideoExProperty implements java.io.Serializable {

	// Fields

	private Integer propertyId;
	private String propertyName;
	private String propertyDesc;
	private Set videoExValues = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractVideoExProperty() {
	}

	/** full constructor */
	public AbstractVideoExProperty(String propertyName, String propertyDesc,
			Set videoExValues) {
		this.propertyName = propertyName;
		this.propertyDesc = propertyDesc;
		this.videoExValues = videoExValues;
	}

	// Property accessors

	public Integer getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyDesc() {
		return this.propertyDesc;
	}

	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}

	public Set getVideoExValues() {
		return this.videoExValues;
	}

	public void setVideoExValues(Set videoExValues) {
		this.videoExValues = videoExValues;
	}

}