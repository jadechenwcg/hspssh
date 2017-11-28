package com.hsp.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hsp.web.forms.EmployeeForm;


public class EmployeeAction extends DispatchAction {
	
	// act to login
	public ActionForward addEmployeeUi(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return mapping.findForward("goAddEmployeeUi");
	}

// add emp request
	
	public ActionForward addEmployee(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//test if data can get
		EmployeeForm employeeForm = (EmployeeForm) form;
		System.out.println(employeeForm.getName() + " " + employeeForm.getDepartmentId());
		return null;
	}
}
