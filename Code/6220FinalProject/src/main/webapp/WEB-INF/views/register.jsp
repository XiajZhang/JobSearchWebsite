<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script type="text/javascript" src="${pageContent.request.contextPath}/static/script/jquery.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>

<script type="text/javascript">

function onload(){
	$("#password").keyup(checkPasswordsMatch);
	$("#confirmpass").keyup(checkPasswordsMatch); 

	$("#form").submit(canSubmit);
}
function canSubmit(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	if(password != confirmpass){
		alert("Passwords do not match!")
		return false;
	}else {
		return true;
	}
	
}

function checkPasswordsMatch(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	if(password.length > 3  || confirmpass.length > 3){
		if(password == confirmpass){
			$("#matchpass").text("Passwords match.");		
		}else {
			$("#matchpass").text("Passwords do not match.");
		}
	}
} 

$(document).ready(onload);
</script>

<title>user registration</title>
</head>
<body>
	<center>
	<h2>Welcome to WorkSpring!</h2>
	<form:form id="form" role="form" modelAttribute="user" action="/myapp/users/registration" method="post" enctype="multipart/form-data">
		<fieldset style="width:200px">		
			<legend>User Fields</legend>
				<div class="form-group">
					<form:label	for="username" path="username">User Name:</form:label><br/>
					<form:input class="form-control" placeholder="Please enter your name." path="username" /><div class="error"><form:errors path="username" /></div> 			
				</div>
				<div class="form-group">
					<form:label for="email" path="email">Email:</form:label><br/>
					<form:input class="form-control" placeholder="Please enter an oftenly used email." path="email" /><div class="error"><form:errors path="email" /></div> 	
				</div>
				<div class="form-group">
					<form:label for="age" path="age">Age:</form:label><br/>
					<form:input class="form-control" placeholder="Please enter your real age." path="age" /><div class="error"><form:errors path="age" /></div>
				</div>
				<div class="form-group">
					<form:label for="password" path="password">Password:</form:label><br/>
					<form:input class="form-control" placeholder="Please enter a password." id="password" path="password" type="password"/><div class="error"><form:errors path="password" /></div>
				</div>
				<div class="form-group">
					<label for="password">Confirm Password:</label><br/>
					<input class="form-control" id="confirmpass" placeholder="Please confirm your password." name="confirmpass" type="password"/><div id="matchpass"/>
				</div>
				<div class="form-group">
					<form:label for="authority" path="authority">Register as:</form:label><br/>
					<form:select class="form-control" path="authority">
						<form:option value=" ">Null</form:option>
    					<form:option value="employer">Employer</form:option>
                		<form:option value="employee">Employee</form:option>
 					</form:select>
 					<div class="error"><form:errors path="authority"/></div>
				</div>
				<div class="form-group">
					<form:label for="photo" path="photo">User Photo:</form:label><br/>
					<form:input  class="form-control" path="photo" type="file"/><div class="error"><form:errors path="photo" /></div>
				</div>
				<div class="form-group">
					<input class="btn btn-info" type="submit" value="Create Account" />
				</div>
			</fieldset>
		</form:form>
	</center>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-modal.js"></script>
</body>
</html>