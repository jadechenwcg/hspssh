package com.hsp.service.imp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import com.hsp.basic.BasicService;
import com.hsp.domain.Department;
import com.hsp.domain.Employee;
import com.hsp.service.interfaces.ImployeeServiceInter;

//After configuring @Transaction, then spring TransactionManager will take over this service's all transactions
//If just let TransactionManager just manage one method, put @Transactional before the method.


public class EmployeeService extends BasicService implements ImployeeServiceInter{
	
	@Override
	public List showEmployeeList(int pagenow, int pagesize) {
		String hql = "from Employee order by id";
		return this.executeQueryByPage(hql, null, pagenow, pagesize);
	}

	

	
// verify is use is exsting
	@Override
	public Employee checkEmployee(Employee e) {
		String hql = "from Employee where id = ? and pwd = ?";
		Object[] parameters = {e.getId(), e.getPwd()};
		List list = this.executeQuery(hql, parameters);
		if 	(list.size() == 0) {
			return null;
		} else {
			return (Employee) list.get(0);
		}
	}
	
	public int getPageCount(int pageSize){
		String hql = "select count(*) from Employee";
		return this.queryPageCount(hql, null, pageSize);
	}



}
