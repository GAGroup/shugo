package com.user.dao;


/*   
 * Copyright (c) 2010-2013 Sencenet Ltd. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Sencenet. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Sencenet.   
 *   
 */  


import java.io.Serializable;
import java.util.List;



/** 
* 文 件 名 :BaseDao.java 
* CopyRright (c) 2010-2013 Sencenet:  
* 创 建 人： Aren
* 日    期： 2012-11-8 上午01:26:52
* 修 改 人： Aren
* 日   期： 2013-3-28 上午01:26:52
* 版 本 号： @version 1.0
*/ 


public interface BaseDao {

	Object loadObject(String hql);								//加载指定的持久化对象
	
	int countQuery(String hql);									//计算指定的持久化对象的查询结果
	
	Object loadById(Class clazz,Serializable id);				//加载指定ID的持久化对象
	
	List queryListAll(String hql);								//查询指定的持久化对象
	
	List queryListAll(String hql,int pageNo,int pageSize);		//分页查询指定的持久化对象
	
	List loadListAll(String clazz);								//加载指定类的持久化对象
	
	List loadListAll(String clazz,int pageNo,int pageSize);		//分页加载指定类的持久化对象
	
	int countAll(String clazz);									//计算指定类的所有持久化对象的数量
	
	void createOrUpdate(Object obj);							//添加或者更新数据
	
	int update(String hql);										//更新指定的持久化对象
		
	int update(Class clazz,Serializable id);					//更新指定ID的持久化对象
		
	void deleteById(Class clazz,Serializable id);				//删除指定ID的持久化对象
	
	void deleteByHql(String hql);								//通过HQL语句删除数据

}
