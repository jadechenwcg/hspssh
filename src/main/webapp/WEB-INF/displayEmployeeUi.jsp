<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Display Which Employee here</h1>
	
	<form action="${pageContext.request.contextPath}/employee.do?flag=displayEmployee" method="post">
 	<table>
 		<tr><td>name</td><td><input type="text" name="name" value="${displayEmployee.name}"/></td></tr>
 	</table>
 </form>

</body>
</html>