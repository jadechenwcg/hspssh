<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Add employee now</h1>
 <form action="${pageContext.request.contextPath}/employee.do?flag=addEmployee" method="post">
 	<table>
 		<tr><td>name</td><td><input type="text" name="name"/></td></tr>
 		<tr><td>email</td><td><input type="text" name="email"/></td></tr>
 		<tr><td>grade</td><td><input type="text" name="grade"/></td></tr>
 		<tr><td>password</td><td><input type="text" name="pwd"/></td></tr>
 		<tr><td>department</td>
 		<td>
 		<select name="departmentId">
 			<option value="1">finance</option>
 			<option value="2">hr</option>
 		</select>
 		</td></tr>
 		<tr><td><input type="submit" value="submit now"/></td><td><input type="reset" value="reset now"/></td></tr>
 	</table>
 </form>
</body>
</html>