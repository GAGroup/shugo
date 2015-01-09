package com.user.entity;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String passwordTip;
	private String passwordTipAnswer;
	private String userMail;
	private String userPhone;
	private String userAddress1;
	private String userAddress2Set;
	private String userRealName;
	private String userCardId;
	private String postCode;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public UserInfo(Integer userId, String passwordTip,
			String passwordTipAnswer, String userMail, String userPhone,
			String userAddress1, String userAddress2Set, String userRealName,
			String userCardId, String postCode) {
		this.userId = userId;
		this.passwordTip = passwordTip;
		this.passwordTipAnswer = passwordTipAnswer;
		this.userMail = userMail;
		this.userPhone = userPhone;
		this.userAddress1 = userAddress1;
		this.userAddress2Set = userAddress2Set;
		this.userRealName = userRealName;
		this.userCardId = userCardId;
		this.postCode = postCode;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPasswordTip() {
		return this.passwordTip;
	}

	public void setPasswordTip(String passwordTip) {
		this.passwordTip = passwordTip;
	}

	public String getPasswordTipAnswer() {
		return this.passwordTipAnswer;
	}

	public void setPasswordTipAnswer(String passwordTipAnswer) {
		this.passwordTipAnswer = passwordTipAnswer;
	}

	public String getUserMail() {
		return this.userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress1() {
		return this.userAddress1;
	}

	public void setUserAddress1(String userAddress1) {
		this.userAddress1 = userAddress1;
	}

	public String getUserAddress2Set() {
		return this.userAddress2Set;
	}

	public void setUserAddress2Set(String userAddress2Set) {
		this.userAddress2Set = userAddress2Set;
	}

	public String getUserRealName() {
		return this.userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserCardId() {
		return this.userCardId;
	}

	public void setUserCardId(String userCardId) {
		this.userCardId = userCardId;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}