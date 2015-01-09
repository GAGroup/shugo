package com.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class WebUtils {
	/**
	 * 将request提交的数据封装成bean
	 * 没有使用，struts有自动封装了
	 * @param request
	 * @param beanClass
	 * @return
	 */
	public static <T> T request2Bean(HttpServletRequest request,Class <T> beanClass){
		try {
			T bean = beanClass.newInstance();
			Enumeration<String> e=request.getParameterNames();
			//ConvertUtils.register(new , Date.class);
			//BeanUtils.populate(bean,request.getParameterMap());
			//BeanUtilsBean bub = new BeanUtilsBean();
			while(e.hasMoreElements()){
				String name=(String)e.nextElement();
				Object value=request.getParameter(name);
				//注册转换器
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.setProperty(bean, name, value);//反射机制
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	/**
	 * md5加密
	 * @param password
	 * @return
	 */
	public static String md5COND(String password){
		MessageDigest m;
		String pwd = ""; 
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes("UTF8"));
			byte s[ ] = m.digest( );
			for (int i=0; i<s.length;i++){
				pwd += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return pwd;//加密后的密码
	}
	public static String generateID(){	
		return UUID.randomUUID().toString();
		}
	
}
