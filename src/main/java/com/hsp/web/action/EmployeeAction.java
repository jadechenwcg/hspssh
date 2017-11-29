package com.hsp.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hsp.domain.Department;
import com.hsp.domain.Employee;
import com.hsp.service.interfaces.DepartmentServiceInter;
import com.hsp.service.interfaces.ImployeeServiceInter;
import com.hsp.web.forms.EmployeeForm;


public class EmployeeAction extends DispatchAction {
	
	private DepartmentServiceInter departmentService;
	private ImployeeServiceInter employeeService;
	
	public DepartmentServiceInter getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentServiceInter departmentService) {
		this.departmentService = departmentService;
	}

	
	public ImployeeServiceInter getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(ImployeeServiceInter employeeService) {
		this.employeeService = employeeService;
	}

	// act to login
	public ActionForward addEmployeeUi(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("goAddEmployeeUi");
	}

// add emp request
	
	public ActionForward addEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//test if data can get
		EmployeeForm employeeForm = (EmployeeForm) form;
		//System.out.println(employeeForm.getName() + " " + employeeForm.getDepartmentId());
		
		// construct a domain obj
		Employee e = new Employee();
		e.setEmail(employeeForm.getEmail());
		e.setGrade(Integer.parseInt(employeeForm.getGrade()));
		e.setHiredate(new Date());
		e.setName(employeeForm.getName());
		e.setPwd(employeeForm.getPwd());
		e.setSalary(Float.parseFloat(employeeForm.getSalary()));
		//which department
		
		//e.setDept(departmentService.getDepartmentById(Integer.parseInt(employeeForm.getDepartmentId())));
		e.setDept((Department)departmentService.findById(Department.class, Integer.parseInt(employeeForm.getId())));
		// save the Employee
		try {
			employeeService.add(e);
		} catch (Exception e1) {
			return mapping.findForward("operationerror");
		}
		
		return mapping.findForward("operationok");

	}
	
	// display employee
	
		public ActionForward goListEmp(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			String s_pageNow = request.getParameter("pageNow");
			int pageNow = 1;
			if (s_pageNow != null) {
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("emplist", employeeService.showEmployeeList(pageNow, 3));
			int pageCount = employeeService.getPageCount(3);
			request.setAttribute("pageCount", pageCount);
				return mapping.findForward("goListEmp");
			
			
		}
}
