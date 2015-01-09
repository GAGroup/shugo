/*package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DaoUtils {
	private static DataSource datasource = null;
	*//**
	 * 静态代码块，配置文件只要加载一次,不需要每次都加载
	 *//*
	static{
		InputStream inStream = DaoUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
		Properties prop = new Properties();
		try {
			prop.load(inStream);
		} catch (IOException e) {
			throw new RuntimeException("load properties wrong!",e);
		}
		try {
			datasource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException("create datasource error!",e);
		}
	}
	*//**
	 * 获取连接池
	 * @return
	 *//*
	public static DataSource getDataSource(){
		return datasource;
	}
	*//**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 *//*
	public static Connection getConnection() throws SQLException{
		return datasource.getConnection();
	}
	*//**
	 * 根据sql更新数据,删除，修改，返回成功或失败
	 * @param SQL
	 * @return
	 *//*
	public static boolean update(String sql,Object[] params){
			try {
				QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
				qr.update(sql, params);
				return true;
			} catch (SQLException e) {
				throw new RuntimeException("update error!", e);
			}
	}
	*//**
	 * 根据sql语句和params查询的结果用bean处理返回
	 * @param sql
	 * @param params
	 * @param beanclass
	 * @return
	 *//*
	public static <T>T queryBean(String sql,Object []params,Class<T> beanclass) {
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		try {
			return qr.query(sql, new BeanHandler<T>(beanclass) ,params);
		} catch (SQLException e) {
			throw new RuntimeException("sql error",e);
		}
	}
	*//**
	 * 根据wheremap查找出keys属性的记录，用bean返回，不存在返回null
	 * @param table
	 * @param beanclass
	 * @param keys
	 * @param wheremap
	 * @return
	 *//*
	public static <T>T queryBean(String table,Class<T> beanclass,String[] keys,Map<String,Object> wheremap){
		Object[] params = Map2StringArray(wheremap);
		String where = map2strings(wheremap,"and");
		String sql = "";
		String keystring = "";
		if(keys!=null&&keys.length>0){
			int i=0;
			for(String s:keys){
				keystring +=s;
				if(++i!=keys.length) keystring +=",";
			}
			keystring.substring(0,keystring.length()-1);
			sql = "select ( "+keystring+" ) from "+table+" where "+where;
		}else{
			sql = "select * from "+table+" where "+where;
		}
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		try {
			return qr.query(sql, new BeanHandler<T>(beanclass),params );
		} catch (SQLException e) {
			throw new RuntimeException("sql error",e);
		}
	}
	*//**
	 * 根据sql语句和params查询的结果用Listbean处理返回
	 * @param sql
	 * @param params
	 * @param beanclass
	 * @return
	 *//*
	public static <T> List<T> queryBeans (String sql,Object []params,Class<T> beanclass){
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		try {
			return qr.query(sql, new BeanListHandler<T>(beanclass),params );
		} catch (SQLException e) {
			throw new RuntimeException("sql error",e);
		}
	}
	*//**
	 * 根据sql语句和params查询的结果用beanlist处理返回,pagesize=0不分页,keys=null查询全部
	 * @param table
	 * @param beanclass
	 * @param keys
	 * @param wheremap
	 * @return
	 *//*
	public static <T> List<T> queryBeans(String table,Class<T> beanclass,String[] keys,Map<String, Object> wheremap,int start,int pageSize){
		Object[] params = Map2StringArray(wheremap);
		String where = map2strings(wheremap," and ");
		String sql = "";
		String keystring = "";
		if(keys!=null&&keys.length>0){
			int i=0;
			for(String s:keys){
				keystring +=s;
				if(++i!=keys.length) keystring +=",";
			}
			keystring.substring(0,keystring.length()-1);
			sql = "select ( "+keystring+" ) from "+table+" where  "+where;
		}else{
			sql = "select * from "+table+"  where "+where;
		}
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		try {
			if(pageSize!=0){
				sql += "limit ? ,?";
				return qr.query(sql, new BeanListHandler<T>(beanclass),params,start,pageSize );
			}
			return qr.query(sql,new BeanListHandler<T>(beanclass), params );
		} catch (SQLException e) {
			System.out.println(sql);
			throw new RuntimeException("sql error",e);
		}
	}
	操作表，操作（查询，删除）
	public static boolean delete(String table,String operat，Map setmap,Map wheremap,Map insertmap){
	if("select".equalsIgnoreCase(operate)){}
	 	else if("update".equalsIgnoreCase(operate)){}
		else if("delete".equalsIgnoreCase(operate)){}
		else if("insert".equalsIgnoreCase(operate)){}
		}	
	模糊查询
	String sql = "select * from item_advice_form  where adviceOrder like '"+itemKind+"__'";
		return DaoUtils.queryBeans(sql, null, Form.class);
	
	*//**
	 * 根据mapwhere的条件，更新mapset的值
	 * @param table
	 * @param mapset
	 * @param mapwhere
	 * @return
	 *//*
	public static boolean update(String table,Map<String,Object> mapset,Map<String,Object> mapwhere){
		Object[] setV = new Object[mapset.size()];
				setV = DaoUtils.Map2StringArray( mapset);
		Object[] whereV = new Object[mapwhere.size()]; 
				whereV = DaoUtils.Map2StringArray( mapwhere); 
		Object[] params = new Object[mapwhere.size()+mapset.size()];
		for(int i=0;i<mapset.size();i++){
			params[i] = setV[i];
		}
		for(int i=0;i<mapwhere.size();i++){
			params[mapset.size()+i] = whereV[i];
		}
		//代换字符串
		String where = map2strings(mapwhere,"and");
		String set = map2strings(mapset,",");
		String sql = "update "+table+" set "+set+" where "+where;
		//DaoUtils.update(sql, params);		
		QueryRunner qr = new QueryRunner(datasource);
		try {
			qr.update(sql, params);
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("sql error",e);
		}
	}
	*//**
	 * 根据insertmap插入，符合wheremap的记录，必须包含主键
	 * @param table
	 * @param list
	 * @param wheremap
	 * @return
	 *//*
	public static boolean insert(String table,Map<String,Object> insertmap){
		String keys = "";
		Object[] values = new Object[insertmap.size()];
		String replace = "";
		int i = 0;
		for(Object o:insertmap.keySet()){
			keys +=o;
			values[i] = insertmap.get(o);
			replace +="?";
			if(++i!=insertmap.size()){
				keys +=",";
				replace +=",";
			}
		}
		String sql = "insert into "+table+"( "+keys+" ) values( "+replace+" ) ";where "+where;		
		QueryRunner qr = new QueryRunner(datasource);
		try {
			System.out.println(sql);
			qr.update(sql, values);
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("sql error",e);
		}
	}
	*//**
	 * 根据wheremap删除记录
	 * @param table
	 * @param wheremap
	 * @return
	 *//*
	public static boolean delete(String table,Map<String,Object> wheremap){
		Object[] params =  Map2StringArray(wheremap);
		String where = map2strings(wheremap,"and");
		String sql = "delete from "+table+" where "+where;
		QueryRunner qr = new QueryRunner(DaoUtils.getDataSource());
		try {
			System.out.println(sql);
			qr.update(sql, params);
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("sql error",e);
		}
	}
	*//**
	 * 将Map处理成value数组，通过传递数组可防治sql注入
	 * @param map
	 * @return
	 *//*
	private static Object[] Map2StringArray(Map<String,Object> map){
		Object[] params = new String[map.size()];
		int i = 0;
		for(Object o:map.keySet()){//map.entryset !=keyset
			params[i++] = map.get(o);
		}
		return params;
	}
	*//**
	 * 将map解释为?=? spit ?=?
	 * @param mapset
	 * @return
	 *//*
	private static String map2strings(Map<String, Object> map,String spit) {
		String set = "";
		int i=0;
		for(String o:map.keySet()){
			set+= o+"=? ";
			if(++i!=map.size()) set+=" "+spit+" ";
		}
		return set;
	}
	
	
	*//**
	 * 批处理
	 * @param sql
	 * @param paramss
	 * @return
	 *//*
	public static boolean batch(String sql, Object[][] paramss) {
		Connection conn = null;
		try {
			conn = DaoUtils.getConnection();
			//开启事务处理
			conn.setAutoCommit(false);
			QueryRunner qr = new QueryRunner();
			qr.batch(conn,sql, paramss);
			conn.commit();
		} catch (SQLException e) {
			if(conn!=null){
				try {
					conn.rollback();
					System.out.println("回滚了");
					return false;
				} catch (SQLException e1) {
					throw new RuntimeException("回滚出错",e);
				}
			}
			throw new RuntimeException("batch error",e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
		
	}
	
}
*/