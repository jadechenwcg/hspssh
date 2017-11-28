package com.hsp.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsp.domain.Department;
import com.hsp.domain.Employee;
import com.hsp.service.interfaces.DepartmentServiceInter;
import com.hsp.service.interfaces.ImployeeServiceInter;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DepartmentServiceInter ds= (DepartmentServiceInter) ac.getBean("departmentService");
		
		ImployeeServiceInter es= (ImployeeServiceInter) ac.getBean("employeeService");
		
		//public Employee(String name, String email, Date hiredate, Float salary,		String pwd, Integer grade) {	this.name = name;
		Employee e = new Employee("jade", "aa@gmail.com", new Date(), 234.4f,"123",1);
		Employee e2 = new Employee("jade3", "aa@gmail.com", new Date(), 234.4f,"123",1);
		Employee e3 = new Employee("jade5", "aa@gmail.com", new Date(), 234.4f,"123",1);
		
		es.addEmployee(e);
		es.addEmployee(e2);
		es.addEmployee(e3);
		
		Department d = new Department();
		d.setName("finance");
		
		Set<Employee> set = new HashSet<Employee>();
		set.add(e);
		set.add(e2);
		set.add(e3);
		
		d.setEmps(set);
		
		// add department
		ds.addDepartment(d);
	}

}
