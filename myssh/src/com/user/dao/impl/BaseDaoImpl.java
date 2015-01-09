package com.user.dao.impl;


/*   
 * Copyright (c) 2010-2013 Sencenet Ltd. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Sencenet. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Sencenet.   
 *   
 */  



import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.user.dao.BaseDao;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.lang.Long;


/** 
* 文 件 名 :BaseDaoImpl.java 
* CopyRright (c) 2010-2013 Sencenet:  
* 创 建 人： Aren
* 日    期： 2012-11-8 上午01:27:47
* 修 改 人： Aren
* 日   期： 2013-3-28 上午01:27:47
* 版 本 号： @version 1.0
*/ 
public class BaseDaoImpl implements BaseDao{
	
	protected SessionFactory sessionFactory;
	
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	//加载指定的持久化对象
	public Object loadObject(String hql){
		final String hqlL = hql;
		Object obj = null;
		List list = new ArrayList();
		try{
			Query query = getSession().createQuery(hqlL);
			list = query.list();
			if(list.size()>0)
				obj = list.get(0);
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return obj;
	}
	
	//计算指定的持久化对象的查询结果
	public int countQuery(String hql){
		final String hqlC = hql;
		int count = 0;
		try{
			Long countL = (Long)getSession().createQuery(hqlC).setMaxResults(1).uniqueResult();
			count = countL.intValue();
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return count;
	}
	
	//加载指定ID的持久化对象
	public Object loadById(Class clazz,Serializable id){
		return getSession().get(clazz,id);
	}
	
	//查询指定的持久化对象
	public List queryListAll(String hql){
		return getSession().createQuery(hql).list();
	}

	//分页查询指定的持久化对象
	public List queryListAll(String hql,int pageNo,int pageSize){
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hqlQ = hql;
		List list = new ArrayList();
		try{
			Query query = getSession().createQuery(hqlQ);
			query.setMaxResults(pSize);
			query.setFirstResult((pNo-1)*pSize);
			List list2 = query.list();
			if(!Hibernate.isInitialized(list2))
				Hibernate.initialize(list2);
			list = list2;
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	//加载指定类的持久对象
	public List loadListAll(String clazz){
		String hql = "from "+clazz+" as a order by a.id desc";
		return getSession().createQuery(hql).list();
	}
	
	//分页加载指定类的持久化对象
	public List loadListAll(String clazz,int pageNo,int pageSize){
		final int pNo = pageNo;
		final int pSize = pageSize;
		final String hql = "from "+clazz+" as a order by a.id desc";
		List list = new ArrayList();
		try{
			Query query = getSession().createQuery(hql);
			query.setMaxResults(pSize);
			query.setFirstResult((pNo-1)*pSize);
			List list2 = query.list();
			if(!Hibernate.isInitialized(list2))
				Hibernate.initialize(list2);
			list = list2;
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return list;
	}		
	
	//计算指定类的所有持久化对象的数量
	public int countAll(String clazz){
		final String hql = "select count(*) from "+clazz+" as a";
		int count = 0;
		try{
			Long countL = (Long)getSession().createQuery(hql).setMaxResults(1).uniqueResult();
			count = countL.intValue();
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return count;
	}
	
	
	
	//添加和更新数据	
	public void createOrUpdate(Object obj){
		getSession().saveOrUpdate(obj);
	}
	
	//更新指定的持久化对象
	public int update(String hql){									
		final String hqlU = hql;
		int result = 0;
		try{
			result = ((Integer)getSession().createQuery(hqlU).executeUpdate()).intValue();
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	//更新指定ID的持久化对象
	public int update(Class clazz,Serializable id){
		final String hql="from "+clazz+" as a where a.id="+id;
		return update(hql);
	}					
	
	//根据条件删除数据
	public void deleteById(Class clazz,Serializable id){
		getSession().delete(getSession().load(clazz,id));
	}
	
	//通过HQL语句删除数据
	public void deleteByHql(String hql){
		getSession().createQuery(hql).executeUpdate();
	}								
	
	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}	
	
}
