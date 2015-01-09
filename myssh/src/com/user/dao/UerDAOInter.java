package com.user.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.user.entity.User;

public interface UerDAOInter {

	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PWD = "userPwd";
	public static final String USER_TAG = "userTag";
	public static final String USER_TYPE_ID = "userTypeId";
	public static final String USER_HUIYUAN_ID = "userHuiyuanId";
	public static final String USER_DESC = "userDesc";
	public static final String USER_STATE = "userState";
	public static final String HAS_MESSAGE = "hasMessage";
	public static final String HAS_MAIL = "hasMail";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByUserName(Object userName);

	public abstract List findByUserPwd(Object userPwd);

	public abstract List findByUserTag(Object userTag);

	public abstract List findByUserTypeId(Object userTypeId);

	public abstract List findByUserHuiyuanId(Object userHuiyuanId);

	public abstract List findByUserDesc(Object userDesc);

	public abstract List findByUserState(Object userState);

	public abstract List findByHasMessage(Object hasMessage);

	public abstract List findByHasMail(Object hasMail);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

}