<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script type="text/javascript"
	src="${pageContent.request.contextPath}/static/script/jquery.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script
	src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-carousel.min.js"></script>
<title>Home Page</title>
</head>
<body>
	<div class="text-center text-success congras">Your account has been
		created.</div>
	<div class="text-center login">
		<%-- <a href="<c:url value='/jobList'/>">Log In</a> --%>
		<a data-toggle="modal" href="#mymodal" class="congrasL">Login</a>
	</div>
	<div class="modal fade" id="mymodal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Login Page</h4>
				</div>
				<div class="modal-body">
					<center>
						<form name='f' role="form" action='/myapp/login' method='POST'>
							<fieldset style="width: 200px">
								<legend>User Login</legend>
								<div class="form-group text-center">
									<table>
										<tr>
											<td>User:</td>
											<td><input class="form-control" type='text'
												name='username' value=''></td>
										</tr>
										<tr>
											<td>Password:</td>
											<td><input class="form-control" type='password'
												name='password' /></td>
										</tr>
										<tr>
											<td colspan='2'><input class="btn btn-info"
												name="submit" type="submit" value="Sign In" /></td>
										</tr>
									</table>
								</div>
							</fieldset>
						</form>
						<p>
							<a href="<c:url value="users"/>">Register a New Account</a>
						</p>
					</center>
				</div>
				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button> -->
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script
		src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-modal.js"></script>


</body>
</html>