<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<title>Insert Dept</title>
</head>
<body>
	<h1 style="color: NavyBlue">Insert Department Details</h1>

	<div class="container">


		<form action="http://localhost:8081/CollegeManagement/dept" method="post">
			<div class="col-md-12">
				<label class="col-md-2">Department Id :</label> <input
					style="width: 326px;" class="form-control col-md-7" type="text"
					name="deptId" />
			</div>
			<br/>

			<div class="col-md-12">
				<label class="col-md-2">Department Name :</label> <input
					style="width: 326px;" class="form-control col-md-7" type="text"
					name="deptName" />
			</div>
			<br/>

			<div class="col-md-12">
				<label class="col-md-2">Strength :</label> <input
					style="width: 326px;" class="form-control col-md-7" type="text"
					name="strength" />
			</div>
			<br>
			<br />

			<div class="col-md-12">
				<label class="col-md-2">Placement :</label> <input
					style="width: 326px;" class="form-control col-md-7" type="text"
					name="placement" />
			</div>
			<br />

					<label class="col-md-2">College Name :</label> <select name="collegeId">
					<c:forEach items="${cllgList}" var="cllg">
					<option value="${cllg.collegeId}">${cllg.collegeName} </option>
					 </c:forEach>

			<br />
			
			<input type="text" value="1" name="choice" hidden="true" />
		<input type="submit" value="Insert"> 
		</form>

	</div>

</body>
</html>