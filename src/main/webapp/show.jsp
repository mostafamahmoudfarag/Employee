<%@page import="io.task.employee.EmployeeDao,java.util.List,io.task.employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<style>
a{
margin: 50px;
margin-top:50px;
size: 30px
}

caption {
	font-size: 30px;
	color: blue;
	
}
td{
text-align: center}
th{
padding:15px
}
</style>

<body>
<%
List<Employee> list=new EmployeeDao().getAllEmployee();
session.setAttribute("list",list);
%>

<table border="1px" width="600px">
<caption>Employees</caption>
<tr>
<th>Name</th>
<th>Number</th>
<th>Actions</th>
</tr>
<c:forEach items="${list}" var="i">
<tr>
<td>${i.name }</td>
<td>${i.number}
 <td>
 <a href="update?name=${i.name }">update</a>
 <a href="delete?name=${i.name }">delete</a> 
 <td>
</tr>

</c:forEach>

</table>


</body>
</html>