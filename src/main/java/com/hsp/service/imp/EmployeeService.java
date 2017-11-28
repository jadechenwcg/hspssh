package com.hsp.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.hsp.domain.Department;
import com.hsp.domain.Employee;
import com.hsp.service.interfaces.ImployeeServiceInter;

//After configuring @Transaction, then spring TransactionManager will take over this service's all transactions
//If just let TransactionManager just manage one method, put @Transactional before the method.

@Transactional
public class EmployeeService implements ImployeeServiceInter{
	
	// when we add @Resource to an attibute, the spring will auto launch byName to insert the attribute
	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("**sessionFactory");
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(Employee e) {
		sessionFactory.getCurrentSession().save(e);
	}

	@Override
	public void showEmployee() {
		Session s = sessionFactory.getCurrentSession();
		String query = "from Employee";
		List<Employee> list = s.createQuery(query).list();
		for (Employee e: list){
			System.out.println(e.toString());
		}		
	}

	@Override
	public void updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee checkEmployee(Employee e) {
		String sql = "from Employee where id = ? and pwd = ?";
				List<Employee> list = sessionFactory.getCurrentSession().createQuery(sql).setString(0, e.getId().toString()).setString(1,e.getPwd()).list();
				
				//initailazing lazy loading
				/*Hibernate.initialize(Department.class);//select pre-check
*/				if (list.size() == 1) {
					//System.out.println(((Employee)list.get(0)).getDept().getName());
					return list.get(0);
					
				} else {
					return null;
				}
				
	}

}
