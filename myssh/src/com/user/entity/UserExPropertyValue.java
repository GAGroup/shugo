package com.user.entity;

/**
 * UserExPropertyValue entity. @author MyEclipse Persistence Tools
 */

public class UserExPropertyValue implements java.io.Serializable {

	// Fields

	private Integer propertyId;
	private String propertyValue;
	private Integer userId;

	// Constructors

	/** default constructor */
	public UserExPropertyValue() {
	}

	/** minimal constructor */
	public UserExPropertyValue(Integer propertyId) {
		this.propertyId = propertyId;
	}

	/** full constructor */
	public UserExPropertyValue(Integer propertyId, String propertyValue,
			Integer userId) {
		this.propertyId = propertyId;
		this.propertyValue = propertyValue;
		this.userId = userId;
	}

	// Property accessors

	public Integer getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyValue() {
		return this.propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}