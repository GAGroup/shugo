package com.user.entity;

/**
 * UserFunction entity. @author MyEclipse Persistence Tools
 */

public class UserFunction implements java.io.Serializable {

	// Fields

	private Integer functionId;
	private String functionName;
	private String functionDesc;
	private String functionUrl;
	private Integer functionPower;

	// Constructors

	/** default constructor */
	public UserFunction() {
	}

	/** full constructor */
	public UserFunction(String functionName, String functionDesc,
			String functionUrl, Integer functionPower) {
		this.functionName = functionName;
		this.functionDesc = functionDesc;
		this.functionUrl = functionUrl;
		this.functionPower = functionPower;
	}

	// Property accessors

	public Integer getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionDesc() {
		return this.functionDesc;
	}

	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	public String getFunctionUrl() {
		return this.functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public Integer getFunctionPower() {
		return this.functionPower;
	}

	public void setFunctionPower(Integer functionPower) {
		this.functionPower = functionPower;
	}

}