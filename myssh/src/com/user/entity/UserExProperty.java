package com.user.entity;

/**
 * UserExProperty entity. @author MyEclipse Persistence Tools
 */

public class UserExProperty implements java.io.Serializable {

	// Fields

	private Integer propertyId;
	private String propertyName;
	private String propertyDesc;

	// Constructors

	/** default constructor */
	public UserExProperty() {
	}

	/** minimal constructor */
	public UserExProperty(Integer propertyId) {
		this.propertyId = propertyId;
	}

	/** full constructor */
	public UserExProperty(Integer propertyId, String propertyName,
			String propertyDesc) {
		this.propertyId = propertyId;
		this.propertyName = propertyName;
		this.propertyDesc = propertyDesc;
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

}