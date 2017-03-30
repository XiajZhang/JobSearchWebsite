<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.username.focus();'>
	<div align = center>
	<h2>Welcome to WorkSpring</h2>
	
	<h3>Login with Username and Password</h3>
	
	<c:if test="${param.error != null }">
	<p>Login failed. Please check your username and password.</p>
	</c:if>
	
	<form name='f' role="form" action='/myapp/login' method='POST'>
		<fieldset style="width:200px">		
			<legend>User Login</legend>
				<div class="form-group text-center">
					<table>
						<tr>
						<td>User:</td>
						<td><input class="form-control" type='text' name='username' value=''></td>
						</tr>
						<tr>
						<td>Password:</td>
						<td><input class="form-control" type='password' name='password' /></td>
						</tr>
						<tr>
						<td colspan='2'><input class="form-control" name="submit" type="submit" value="Sign In" /></td>
						</tr>
					</table>
				</div>
			</fieldset>
	</form>
	<p><a href="<c:url value="users"/>">Register a New Account</a></p>
	</div>
</body>
</html>