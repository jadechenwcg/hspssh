package com.hsp.web.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hsp.domain.Employee;
import com.hsp.service.interfaces.ImployeeServiceInter;
import com.hsp.web.forms.EmployeeForm;

public class LoginAction extends DispatchAction {
	
	//get bean from spring container
	@Resource
	private ImployeeServiceInter employeeService;
	private int a = 0;
	
	public ImployeeServiceInter getImployeeServiceInter() {
		return employeeService;
	}
	public void setImployeeServiceInter(ImployeeServiceInter imployeeServiceInter) {
		System.out.println("***setImployeeServiceInter is called***");
		this.employeeService = imployeeServiceInter;
	}

	// act to login
	public ActionForward login(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("**the reuest is responded in the new way***");
		System.out.println("***a = " +  a++);
		//get spring container obj
		/*WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(this.getServlet().getServletContext());*/
		//ImployeeServiceInter imployeeServiceInter = (ImployeeServiceInter) ctx.getBean("employeeService");
		
		//get out the form to prove the connection
		EmployeeForm employeeForm=(EmployeeForm)form;
		
		
		// construct an employee
		Employee e = new Employee();
		e.setId(Integer.parseInt(employeeForm.getId()));
		e.setPwd(employeeForm.getPwd());
		e=employeeService.checkEmployee(e);

		//if(imployeeServiceInter.equals(employeeForm.getPwd())){
		if (e != null) {
			request.getSession().setAttribute("loginuser", e);
			return mapping.findForward("ok");
		} else {
			return mapping.findForward("err");
		}
	}

	// act to logout
	/*public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return super.execute(mapping, form, request, response);
	}
*/
}
