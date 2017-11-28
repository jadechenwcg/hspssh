package com.hsp.service.interfaces;

import com.hsp.domain.Employee;

public interface ImployeeServiceInter {
	public void addEmployee(Employee e);
	public void showEmployee();
	public void updateEmployee(Employee e);
	public void deleteEmployee(java.io.Serializable id);
	
	public Employee checkEmployee(Employee e);
}
