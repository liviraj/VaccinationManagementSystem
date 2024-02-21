<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<style type="text/css">
h1{
		background-color: floralwhite;
	}
	form{
		align:"center";
	}
</style>
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>
</head>
<body>
<form action="LoginHomeController" method="post">
<center><h1>Vaccination Management System</h1></center>
	
	<center><h2>Login</h2>
	<center><span style="color: red">${msg}</span></center>
	<div style="padding-left: 539px; padding-right: 539px;">
    <label style="display: inline-block; width: 100px; margin-right: 10px;">UserId</label>
    <input class="form-control" type="text" name="uname" placeholder="enter user name" required autofocus></input>
    <br>
    <label style="display: inline-block; width: 100px; margin-right: 10px;">Password</label>
    <input class="form-control" type="password" name="psw" placeholder="enter password" required></input>
    <br>
    <input type="submit" value="submit" name="submit"></input>
    <a href="LoginHomeController?action=cancel"><button>Cancel</button></a>
</div>
	</center>
</form>
</body>
</html>