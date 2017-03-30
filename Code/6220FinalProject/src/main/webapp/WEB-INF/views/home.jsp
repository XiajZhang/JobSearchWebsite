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
	<!-- 轮播 -->
	<div id="slidershow" class="carousel slide" data-ride="carousel"
		data-wrap="true" data-interval="2000">
		<ol class="carousel-indicators">
			<li class="active" data-target="#slidershow" data-slide-to="0">1</li>
			<li data-target="#slidershow" data-slide-to="1">2</li>
			<li data-target="#slidershow" data-slide-to="2">3</li>
		</ol>
		<div class="carousel-inner">
			<div class="item active">
				<a href="##"><img src="<c:url value="/resources/css/book.jpg"/>"
					alt=""></a>
				<div class="carousel-caption">
					<h3>Skillful</h3>
					<p>Learning something new is always a good choice.</p>
				</div>
			</div>
			<div class="item">
				<a href="##"><img src="<c:url value="/resources/css/road.jpg"/>"
					alt=""></a>
				<div class="carousel-caption">
					<h3>Adventurous</h3>
					<p>Let's hit the road.</p>
				</div>
			</div>
			<div class="item">
				<a href="##"><img
					src="<c:url value="/resources/css/laptop.jpg"/>" alt=""></a>
				<div class="carousel-caption">
					<h3>Conscientious</h3>
					<p>Find a better you in a new Job.</p>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#slidershow" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span>
		</a> <a class="right carousel-control" href="#slidershow" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>
	<!-- content -->
	<center>
		<div class="content">
			<div class="header">
				<div class="headerP">
					<p>Welcome to WorkSpring</p>
				</div>
				<div class="panel panel-default headP2" style="width: 70%;">
					<div class="panel-body">Work Spring is a web application
						dedicated to easy the way people find their job. Everyday around
						the world, there will be some people starts to hit the road with a
						new career, yet not everyone can end up with a job they
						deserves.For making job search not complex anymore, we devote our
						energy to design this simply web application for your better
						choice.</div>
				</div>
				<div align=center class="form-group">
					<form action="<c:url value='/jobs/home/searchJobs'/>" method=GET>
						<p class="enter">Start searching jobs:</p>
						<input type=text class="form-control"
							style="width: 400px; margin: 10px; padding: 10px"
							name="searchString" placeholder="What kind of job you are looking for?"/> <input type=submit class="btn btn-info"
							name="Search" value="Search">
					</form>
				</div>
				<div align=center class="searchResult">
					<c:if test="${!empty jobs}">
						<fieldset style="width: 400px">
							<legend>Search Result</legend>
							<div class="container" style="width: 800px">

								<c:forEach var="jobInfo" items="${jobs}">
									<div class="row">
										<div class="col-md-7">
											<a href="<c:url value='/jobs/${jobInfo.id}/showDetail'/>"><c:out
													value="${jobInfo.title}"></c:out></a>
										</div>

										<div class="col-md-1">
											<a
												href="<c:url value='/message/${jobInfo.user.id}/messageForm'/>"><c:out
													value="${jobInfo.user.username}"></c:out></a>
										</div>

										<div class="col-md-4">
											<c:out value="${jobInfo.publishDate}"></c:out>
										</div>
									</div>
								</c:forEach>
							</div>
						</fieldset>
					</c:if>
				</div>
				<div class="divided"></div>
				<sec:authorize access="!isAuthenticated()">
					<div class="text-center login">
						<%-- <a href="<c:url value='/jobList'/>">Log In</a> --%>
						<a data-toggle="modal" href="#mymodal" class="login" >Login</a>
					</div>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<div class="text-center login">
						<a href="<c:url value='/logout'/>">Log Out</a>
					</div>
				</sec:authorize>
				<!-- 		<p><a href="jobList">Job Offers</a></p> -->
			</div>
		</div>
	</center>
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

	<footer>
	<p class="pull-right">
		<a href="#top">Back to Top</a>
	</p>

	<p>&copy; 2016 Xiajie Zhang</p>
	</footer>
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<script
		src="http://cdn.bootcss.com/bootstrap/2.3.1/js/bootstrap-modal.js"></script>


</body>
</html>