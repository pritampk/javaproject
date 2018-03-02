<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
 <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src="jquery-3.2.1.js"></script>
</head>
<body>

 	<script src="bootstrap.js"></script>
	<script src="jquery-3.2.1.js"></script>

 <div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-6">
  <h1 style="color:Green">Records are:</h1>
  <form action="http://localhost:8081/CollegeManagement/manage" method="post">
	<table>		
			<tr>
				<th>College Id :</th>
				<td><input type="text" id="txtId" value="${college.collegeId}"
					name="collegeId" readonly="readonly"></input></td>
			</tr>
			<tr>
				<th>College Name :</th>
				<td><input type="text" id="txtName" value="${college.collegeName}"
					name="collegeName" readonly="readonly"></input></td>
			</tr>
			<tr>
				<th>Estd :</th>
				<td><input type="text" id="txtESTD" value="${college.estd}"
					name="estd" readonly="readonly"></input></td>
			</tr>
			<tr>
				<th>Zip :</th>
				<td><input type="text" id="txtZip" value="${college.zip}"
					name="zipCode" readonly="readonly"></input> <input type="hidden"
					name="choice" value="3"></td>
			</tr>
			<tr>
				<td>
					<button id="btnUpdate" type="btnUpdate" class="btn btn-primary btn-sm">Update</button>
				<td />
			</tr>
		
	</table>
</form>
  
  </div>
  <div class="col-sm-3"></div>
</div> 
		<tr>
		
		 <div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-6">
  <button id="btnEdit" value="button" class="btn btn-primary btn-sm">Edit</button>
  </div>
  <div class="col-sm-3"></div>
</div> 
		</tr>
		<a href="http://localhost:8081/CollegeManagement"><h1>Home </h1></h1></a>
		

	<script>
	$(document).ready(function() {
			$('#btnUpdate').hide();
		})
		$('#btnEdit').click(function() {
			$('#txtName').attr("readonly", false);
			$('#txtZip').attr("readonly", false);
			$('#btnEdit').hide();
			$('#btnUpdate').show();
		})
		


		/* $('#btnUpdate').click(function() {
			var choice = '3';
			$.ajax({
				type : "POST",
				data : {
					collegeId : $('#txtId').val(),
					collegeName : $('#txtName').val(),
					estd : $('#txtESTD').val(),
					zipCode : $('#txtZip').val(),
					choice : choice
				},
				url : "http://localhost:8081/CollegeManagement/manage",
				success : function(result) {
				},
				error : function(error) {
				}
			
		}) */
	</script>
</body>
</html>