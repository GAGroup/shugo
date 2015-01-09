package com.video.action;

import java.io.File;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class browersVideo extends ActionSupport implements ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletResponse response;
	private HttpServletRequest request;
	//从request中得到id或path
	
	@Override
	public String execute() throws Exception {
		File file = new File("C:\\developer_tool\\Apache Software Foundation\\Tomcat 7.0\\webapps\\myssh\\inages\\uploadList","Linux.mp4");
		byte[] b = FileUtils.readFileToByteArray(file);
		
		OutputStream out = response.getOutputStream();
		out.write(b);
		out.close();
		return super.execute();//return success;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
