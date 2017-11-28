<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome ${loginuser.name} The department is ${loginuser.dept.name} Choose Your Action:</h1>
	<a href="${pageContext.request.contextPath}/employee.do?flag=addEmployeeUi">Add     Employee</a></br>
	<a href="${pageContext.request.contextPath}/employee.do?flag=displayEmployee">Show    Employee</a></br>
	<a href="#">Update  Employee</a></br>
	<a href="#">Delete  Employee</a></br>
	<a href="#">Exit    System</a>
</body>
</html>