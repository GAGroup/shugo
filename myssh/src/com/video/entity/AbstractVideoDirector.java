package com.video.entity;

import java.sql.Timestamp;

/**
 * AbstractVideoDirector entity provides the base persistence definition of the
 * VideoDirector entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractVideoDirector implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer user;
	private String path;
	private String dirName;
	private Timestamp createTime;
	private Integer fatherDir;
	private String dirLayer;

	// Constructors

	/** default constructor */
	public AbstractVideoDirector() {
	}

	/** full constructor */
	public AbstractVideoDirector(Integer user, String path, String dirName,
			Timestamp createTime, Integer fatherDir, String dirLayer) {
		this.user = user;
		this.path = path;
		this.dirName = dirName;
		this.createTime = createTime;
		this.fatherDir = fatherDir;
		this.dirLayer = dirLayer;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser() {
		return this.user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDirName() {
		return this.dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getFatherDir() {
		return this.fatherDir;
	}

	public void setFatherDir(Integer fatherDir) {
		this.fatherDir = fatherDir;
	}

	public String getDirLayer() {
		return this.dirLayer;
	}

	public void setDirLayer(String dirLayer) {
		this.dirLayer = dirLayer;
	}

}