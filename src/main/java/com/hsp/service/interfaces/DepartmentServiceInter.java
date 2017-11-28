package com.hsp.service.interfaces;

import java.io.Serializable;

import com.hsp.domain.Department;

public interface DepartmentServiceInter {
	
	public void addDepartment(Department d);
	
	public Department getDepartmentById(Serializable id);

}
