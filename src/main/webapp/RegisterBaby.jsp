<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>

<title>baby registration</title>
<style type="text/css">
h1 {
	background-color: gray;
}
</style>
<script>
	var val1 = $("#sel1").val();
	if (val1 == '' || val1 == 0) {
		$(document).ready(function() {
			$('#sel1').val("---select---");
		});
	} else {
		$(document).ready(function() {
			$('#sel1').val('${details.gender}');
		});
	}
</script>
<script>
	/* function validate()	
	{
	  var name=$("#name").val();
	  var team=$("#sel1").val();
	  var place=$("#sel2").val();
	  var salary=$("#salary").val();
	  
	   if(name==null || name=='')
		  {
		   	$("#sname").html("Name Requried");
		  	$("#errname").show();
		  	$("#errteam").hide();
		  	$("#errplace").hide();
		  	$("#errsalary").hide();
			return false;
		  	
		  }
	  else if (team==null || team=='') {
		  $("#steam").html("Team Requried");
		  	$("#errname").hide();
		  	$("#errteam").show();
		  	$("#errplace").hide();
		  	$("#errsalary").hide();
		  	return false;
	}
	  else if(place==null || place==''){
		  $("#splace").html("place Requried");
		  $("#errname").hide();
		  	$("#errteam").hide();
		  	$("#errplace").show();
		  	$("#errsalary").hide();
		  	return false;
	  }
	  else if(salary==null || salary==''){
		  $("#ssalary").html("salary Requried");
		  $("#errname").hide();
		  	$("#errteam").hide();
		  	$("#errplace").hide();
		  	$("#errsalary").show();
		  	return false;
	  }
	   return true;
	} */
</script>
</head>

<body>
	<form action="BabyController" method="post" name="rform">
		<center>
			<h1>Vaccination Management System</h1>
		</center>
		<div class="container">
			<input type="hidden" name="id" value="${details.babyId}">
			<h2>Grocery Registration</h2>

			<div class="col-xs-4">
				<div>
					<label>Name<span style="color: red">*</span></label><br>
					<span style="color: red">${msg}</span>
					<div id="errname">
						<span style="color: red" id="sname"></span>
					</div>
					<input id="name" class="form-control" type="text" name="name"
						value="${details.name }" placeholder="Enter item name"> <br>
				</div>
				<label>Date of Birth<span style="color: red">*</span></label><br>
				<span style="color: red">${msg}</span>
				<div id="errname">
					<span style="color: red" id="sname"></span>
				</div>
				<input id="dob" class="form-control" type="date" path="dob"
					class="date" name="dob" pattern="dd-MM-yyyy" /> <br> <br>
				<br>
				<label>Gender<span style="color: red">*</span></label>
				<div class="form-group">
					<div id="errteam">
						<span style="color: red" id="steam"></span>
					</div>
					<select class="form-control" name="gender" id="sel1"
						value="${details.gender}">
						<option value="" hidden>---select---</option>
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
				<div>
					<label>Father Name<span style="color: red">*</span></label><br>
					<span style="color: red">${msg}</span>
					<div id="errname">
						<span style="color: red" id="fname"></span>
					</div>
					<input id="fatherName" class="form-control" type="text" name="fatherName"
						value="${details.fatherName}" placeholder="Enter father name"> <br>
				</div>
				
				<div>
					<label>Mother Name<span style="color: red">*</span></label><br>
					<span style="color: red">${msg}</span>
					<div id="errname">
						<span style="color: red" id="mname"></span>
					</div>
					<input id="motherName" class="form-control" type="text" name="motherName"
						value="${details.motherName}" placeholder="Enter mother name"> <br>
				</div>
				
				<div>
					<label>Place Of Birth<span style="color: red">*</span></label><br>
					<span style="color: red">${msg}</span>
					<div id="errname">
						<span style="color: red" id="pofBirth"></span>
					</div>
					<input id="placeOfBirth" class="form-control" type="text" name="placeOfBirth"
						value="${details.placeOfBirth}" placeholder="Enter place of birth"> <br>
				</div>
				
				<div class="col-xs-2">
					<input class="btn btn-info" type="submit" name="submit"
						value="${name}"></input>
				</div>
				<button class="btn btn-info" type="reset"
					style="position: relative; left: 40px">Reset</button>
				<button class="btn btn-info" style="position: relative; left: 50px"
					type="submit" value="Cancel" name="submit">Cancel</button>
			</div>
		</div>
		</div>
	</form>
</body>
</html>