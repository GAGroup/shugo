package com.user.entity;

/**
 * UserGroup entity. @author MyEclipse Persistence Tools
 */

public class UserGroup implements java.io.Serializable {

	// Fields

	private Integer groupId;
	private String groupName;
	private String groupFunction;
	private Integer groupPower;
	private Integer groupFather;
	private String groupLayer;

	// Constructors

	/** default constructor */
	public UserGroup() {
	}

	/** full constructor */
	public UserGroup(String groupName, String groupFunction,
			Integer groupPower, Integer groupFather, String groupLayer) {
		this.groupName = groupName;
		this.groupFunction = groupFunction;
		this.groupPower = groupPower;
		this.groupFather = groupFather;
		this.groupLayer = groupLayer;
	}

	// Property accessors

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupFunction() {
		return this.groupFunction;
	}

	public void setGroupFunction(String groupFunction) {
		this.groupFunction = groupFunction;
	}

	public Integer getGroupPower() {
		return this.groupPower;
	}

	public void setGroupPower(Integer groupPower) {
		this.groupPower = groupPower;
	}

	public Integer getGroupFather() {
		return this.groupFather;
	}

	public void setGroupFather(Integer groupFather) {
		this.groupFather = groupFather;
	}

	public String getGroupLayer() {
		return this.groupLayer;
	}

	public void setGroupLayer(String groupLayer) {
		this.groupLayer = groupLayer;
	}

}