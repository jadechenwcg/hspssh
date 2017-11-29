<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
<!-- <script type="text/javascript" language="javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" language="javascript">
$(document).ready(fucntion() {
	window.alert("ok");

})

</script> -->

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
//             window.alert("happy");
// test

//class = deleteId binding
	$(".deleteId").click(function(){
		return window.confirm("Are you sure to delete this user? ");
	})

        });
    </script>
</head>
<body>
 <h1>Users List</h1>
 <table>
 <tr><td>id</td><td>name</td><td>email</td><td>grade</td><td>salary</td><td>edit</td><td>reset</td></tr>
 <c:forEach items="${emplist}" var="emp" >
 	<tr><td>${emp.id}</td><td>${emp.name}</td><td>${emp.email}</td><td>${emp.grade}</td><td>${emp.salary}</td><td><a href="${pageContext.request.contextPath}/employee.do?flag=goUpdateEmployeeUi&id=${emp.id}">edit</a></td><td><a class="deleteId" href="${pageContext.request.contextPath}/employee.do?flag=deleteEmployee&id=${emp.id}">delete</a></td></tr>
 </c:forEach>
 </table>
 
 <c:forEach var="i" begin="1" end="${pageCount}">
 	<a href="${pageContext.request.contextPath}/employee.do?flag=goListEmp&pageNow=${i}">${i }</a>
 </c:forEach>
</body>
</html>