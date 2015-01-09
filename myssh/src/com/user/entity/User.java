package com.user.entity;

import java.sql.Timestamp;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPwd;
	private Integer userTag;
	private Integer userTypeId;
	private Integer userHuiyuanId;
	private Timestamp registDate;
	private Timestamp lastLoginData;
	private String userDesc;
	private Integer userState;
	private Integer hasMessage;
	private Integer hasMail;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String userName, String userPwd, Integer userTag,
			Integer userTypeId, Integer userHuiyuanId, Timestamp registDate,
			Timestamp lastLoginData, String userDesc, Integer userState,
			Integer hasMessage, Integer hasMail) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTag = userTag;
		this.userTypeId = userTypeId;
		this.userHuiyuanId = userHuiyuanId;
		this.registDate = registDate;
		this.lastLoginData = lastLoginData;
		this.userDesc = userDesc;
		this.userState = userState;
		this.hasMessage = hasMessage;
		this.hasMail = hasMail;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserTag() {
		return this.userTag;
	}

	public void setUserTag(Integer userTag) {
		this.userTag = userTag;
	}

	public Integer getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Integer getUserHuiyuanId() {
		return this.userHuiyuanId;
	}

	public void setUserHuiyuanId(Integer userHuiyuanId) {
		this.userHuiyuanId = userHuiyuanId;
	}

	public Timestamp getRegistDate() {
		return this.registDate;
	}

	public void setRegistDate(Timestamp registDate) {
		this.registDate = registDate;
	}

	public Timestamp getLastLoginData() {
		return this.lastLoginData;
	}

	public void setLastLoginData(Timestamp lastLoginData) {
		this.lastLoginData = lastLoginData;
	}

	public String getUserDesc() {
		return this.userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public Integer getHasMessage() {
		return this.hasMessage;
	}

	public void setHasMessage(Integer hasMessage) {
		this.hasMessage = hasMessage;
	}

	public Integer getHasMail() {
		return this.hasMail;
	}

	public void setHasMail(Integer hasMail) {
		this.hasMail = hasMail;
	}

}