package com.hsp.service.imp;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.hsp.domain.Department;
import com.hsp.service.interfaces.DepartmentServiceInter;

@Transactional
public class DepartmentService implements DepartmentServiceInter {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("**sessionFactory");
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addDepartment(Department d) {

		sessionFactory.getCurrentSession().save(d);
		
	}

}