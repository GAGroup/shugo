package com.user.entity;

/**
 * UserTag entity. @author MyEclipse Persistence Tools
 */

public class UserTag implements java.io.Serializable {

	// Fields

	private Integer userTagId;
	private String userTagName;
	private String userTagPic;
	private String userTagDesc;

	// Constructors

	/** default constructor */
	public UserTag() {
	}

	/** full constructor */
	public UserTag(String userTagName, String userTagPic, String userTagDesc) {
		this.userTagName = userTagName;
		this.userTagPic = userTagPic;
		this.userTagDesc = userTagDesc;
	}

	// Property accessors

	public Integer getUserTagId() {
		return this.userTagId;
	}

	public void setUserTagId(Integer userTagId) {
		this.userTagId = userTagId;
	}

	public String getUserTagName() {
		return this.userTagName;
	}

	public void setUserTagName(String userTagName) {
		this.userTagName = userTagName;
	}

	public String getUserTagPic() {
		return this.userTagPic;
	}

	public void setUserTagPic(String userTagPic) {
		this.userTagPic = userTagPic;
	}

	public String getUserTagDesc() {
		return this.userTagDesc;
	}

	public void setUserTagDesc(String userTagDesc) {
		this.userTagDesc = userTagDesc;
	}

}