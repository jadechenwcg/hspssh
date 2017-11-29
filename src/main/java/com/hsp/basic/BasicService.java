package com.hsp.basic;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;









import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BasicService implements BasicServiceInter {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Object findById(Class clazz, Serializable id) {
		return this.sessionFactory.getCurrentSession().get(clazz, id);
	}

	//search all
	@Override
	public List executeQuery(String hql, Object[] parameters) {
		Query query =this.sessionFactory.getCurrentSession().createQuery(hql);
		// inject the ?
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length ; i++){
				query.setParameter(i, parameters[i]);
			}
		}

		return query.list();
		
	}

	@Override
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pageSize) {
		Query query =this.sessionFactory.getCurrentSession().createQuery(hql);
		// inject the ?
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length ; i++){
				query.setParameter(i, parameters[i]);
			}
		}

		// show page
		return query.setFirstResult((pageNow-1) * pageSize).setMaxResults(pageSize).list();
	}

	@Override
	public void add(Object obj) {
		this.sessionFactory.getCurrentSession().save(obj);

	}

	@Override
	public List executeUpdate(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object uniqueQuery(String hql, Object[] parameters){
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for (int i = 0; i < parameters.length ; i++){
				query.setParameter(i, parameters[i]);
			}
		}
		
		return query.uniqueResult();
	};
	
	//get total pages
	@Override
	public int queryPageCount(String hql, Object[] parameters, int pageSize) {
		// get row count
		Object obj=this.uniqueQuery(hql, parameters);
		System.out.println("****obj = " + obj);
		int rowCount = Integer.parseInt(obj.toString());
		
		return (rowCount -1) /pageSize + 1;
	}
}
