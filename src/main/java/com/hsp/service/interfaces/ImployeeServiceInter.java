package com.hsp.service.interfaces;

import java.util.List;

import com.hsp.basic.BasicServiceInter;
import com.hsp.domain.Employee;

public interface ImployeeServiceInter extends BasicServiceInter {
	
	public List showEmployeeList(int pagenow, int pagesize);

	public Employee checkEmployee(Employee e);
	
	public int getPageCount(int pageSize);
}
