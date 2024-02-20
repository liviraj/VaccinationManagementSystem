<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view</title>
<style type="text/css">
h1 {
	background-color: gray;
}
</style>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>
<script>
	function msg1(id){
		var idValue = id;
		var c=confirm("Are You Sure");
		if(c==true)
			{
				location.href="BabyController?action=delete&id="+idValue; 
			}/* else{
				location.reload();
			} */
		
	}
</script>
</head>
<body>
	<div class="container">
		<center>
			<h1>Vaccination Management System</h1>
		</center>

		<center>
			<p>
				<font size="5">View Baby Information</font>
			</p>
		</center>
		<center>
			<span style="color: red">${msg} </span>
		</center>
		<form action="LogoutController">
			<input type="submit" name="submit" value="logout"
				style="position: relative; left: 1000px" class="btn btn-danger">
		</form>
		<input type="hidden" name="confirm" id="confirm" value=""></input>
		<center>
			<table border="3" class="table">
				<tr class="danger">
					<th>Id</th>
					<th>Baby Name</th>
					<th>DOB</th>
					<th>Gender</th>
					<th>Father Name</th>
					<th>Mother Name</th>
					<th>Place Of Birth</th>
					<th colspan="1"><a href="BabyController?action=add">Add
							New</a></th>
				</tr>
				<c:forEach items="${details}" var="detail">
					<tr>
						<td><c:out value="${detail.babyId}"></c:out></td>
						<td><c:out value="${detail.name}"></c:out></td>
						<td><c:out value="${detail.dob}"></c:out></td>
						<td><c:out value="${detail.gender}"></c:out></td>
						<td><c:out value="${detail.fatherName}"></c:out></td>
						<td><c:out value="${detail.motherName}"></c:out></td>
						<td><c:out value="${detail.placeOfBirth}"></c:out></td>
						<td><a
							href="BabyController?action=update&id=<c:out value="${detail.babyId}"/>"><button>Update</button></a>
							<a><button onclick="msg1(${detail.babyId})">Delete</button></a></td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</div>
</body>
</body>
</html>
