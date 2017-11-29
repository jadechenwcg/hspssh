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
		
		// deleteEmployee
		public ActionForward deleteEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
			// get the id o fthe emp
			String id = request.getParameter("id");
			try {
				employeeService.deletById(Employee.class, Integer.parseInt(id));
			} catch (Exception e){
				e.printStackTrace();
				return mapping.findForward("operationerror");
			}
			
			System.out.println("The deleted emp id = " + id);
			
			return mapping.findForward("operationok");
		}
		
		//goUpdateEmployeeUi
		public ActionForward goUpdateEmployeeUi(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
			// get the id o fthe emp
			String id = request.getParameter("id");
			Employee e= (Employee) employeeService.findById(Employee.class, Integer.parseInt(id));
			
			// show the uer info in next page
			request.setAttribute("emp", e);
			
			return mapping.findForward("goUpdateEmployeeUi");	
			
		}
		
		//update emp
		public ActionForward updateEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
			// get form
			EmployeeForm employyeForm = (EmployeeForm) form;
			//employyeForm to a domain obj
			Employee e = new Employee();
			e.setId(Integer.parseInt(employyeForm.getId()));
			e.setName(employyeForm.getName());
			e.setEmail(employyeForm.getEmail());
			e.setGrade(Integer.parseInt(employyeForm.getGrade()));
			e.setPwd(employyeForm.getPwd());
			e.setSalary(Float.parseFloat(employyeForm.getSalary()));
			e.setDept((Department)departmentService.findById(Department.class, Integer.parseInt(employyeForm.getDepartmentId())));
			
			try {
				employeeService.update(e);
			} catch (Exception e1) {
				e1.printStackTrace();
				return mapping.findForward("operationerror");
			}
			
			
			return mapping.findForward("operationok");

		}
		
		
}
