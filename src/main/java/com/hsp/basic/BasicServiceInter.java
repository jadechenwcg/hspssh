package com.hsp.basic;

import java.util.List;

public interface BasicServiceInter {
	//declare some often used method
	// 1. by id to get an obj
	public Object findById(Class clazz, java.io.Serializable id);
	// 2. check hql - HibernateUtil
	public List executeQuery(String hql, Object[] parameters);
	
	//3. page with check
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow, int pageSize);
	
	//4 add
	public void add(Object obj);
	//5 execute hql - delete, update
	public List executeUpdate(String hql, Object[] parameters);
	
	////6. return one obj
	public Object uniqueQuery(String hql, Object[] parameters);
	
	//7. get page count from hql
	//get total pages
	public int queryPageCount(String hql, Object[] parameters, int pageSize);
	
	//8. delete by id
	public void deletById(Class clazz, java.io.Serializable id);
	
	//9. update by obj
	public void update(Object obj);
}
