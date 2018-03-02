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
<h1 style="color:CRIMSON"> All College Records</h1>
	<table border="5px" >
		<tr style="background:CORAL">
			<th>College Id</th>
			<th>College Name</th>
			<th>Estd</th>
			<th>Zip</th>
			<th>District Id</th>
			<th>State Id</th>
		</tr>

		<c:forEach items="${collegeList}" var="college">
			<tr style="background:GOLD">
				<td>${college.collegeId }</td>
				<td>${college.collegeName}</td>
				<td>${college.estd }</td>
				<td>${college.zip}</td>
				<td>${college.distId }</td>
				<td>${college.stateId}</td>
				
			</tr>
		</c:forEach>

	</table>
	
	<a href="http://localhost:8081/CollegeManagement"><h1>Home </h1></a>
</body>
</html>