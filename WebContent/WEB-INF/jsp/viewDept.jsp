<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:CRIMSON"> All Dept Records</h1>
	<table border="5px" >
		<tr style="background:CORAL">
			<th>Dept Id</th>
			<th>Dept Name</th>
			<th>Strength</th>
			<th>Placement</th>
			<th>College ID</th>

		<c:forEach items="${deptList}" var="dept">
			<tr style="background:GOLD">
				<td>${dept.deptId }</td>
				<td>${dept.deptName }</td>
				<td>${dept.strength }</td>
				<td>${dept.placement }</td>
				<td>${dept.collegeId }</td>
				
				
			</tr>
		</c:forEach>

	</table>
	
	<a href="http://localhost:8081/CollegeManagement"><h1>Home </h1></a>


</body>
</html>