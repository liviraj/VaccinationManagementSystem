<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login-register</title>
<style type="text/css">
h1{
		background-color: floralwhite;
	}
	
</style>
<script type="text/javascript">
function validation() {
	var uname1=document.registerform.psw.value;
	var uname2=document.registerform.psw1.value;
	
	if(uname1==uname2)
		{
			return true;
		}
	
	else{
		document.write("Enter correct password");
		return false;
	}
	
}
</script>

<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
<script src="jquery.min.js"></script>

</head>

<body>

<form name="registerform" action="LoginRegisterController" method="post" >
<center><h1>Vaccination Management System</h1></center>
<div class="container">
	<center><h2>Register</h2></center>
		<div style="padding-left: 415px; padding-right: 374px;">
		<div class="form-group">
		<label>UserId</label>
		<input class="form-control" type="text" name="uname" placeholder="enter user name" required ></input>
		<br><label>Password</label>
		<input class="form-control" type="password" name="psw" placeholder="enter password" required></input>
		<br><label>Re-enter password</label><br><span style="color: red">${msg}</span>
		<input type="password" class="form-control" name="psw1" placeholder="re-enter password" required></input>
		
		<br><div class="col-xs-2">
		<input  type="submit" value="Register" name="register" class="btn btn-info"></input>
		</div>
		<a href="LoginRegisterController?action=cancel"><button style="position: relative; left: 40px" class="btn btn-info" class="btn btn-info">Cancel</button></a>
		</div>
		</div>
</div>
</form>

</body>
</html>