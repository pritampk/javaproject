<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>

	<form action="http://localhost:8081/CollegeManagement/manage"
		method="post">
		College Id <input type="text" name="collegeId"> </br> <input
			type="submit" value="SEARCH"> <input type="text"
			name="choice" value="3" hidden="true">
	</form>



	<table>
		<tr>
			<th>College Id</th>
			<th>:</th>
			<td><input type="text" value="${abc.collegeId}"
				readonly="readonly"></input></td>
		</tr>
	</table>

</body>
</html>