<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<!-- 顶部导航 -->
	<div id="header">
		<ul class="nav nav-tabs ">
			<li><a href="<c:url value='/jobList'/>">Jobs</a></li>
			<li><a href="<c:url value='/jobs/searchJobs'/>">Search for
					Job</a></li>
			<sec:authorize access="hasAuthority('employer')">
				<li><a href="<c:url value='/jobs/publish'/>">Publish Jobs</a></li>
			</sec:authorize>
			<sec:authorize access="hasAuthority('employee')">
				<li><a href="<c:url value='/application/viewAll'/>">My
						Application</a></li>
			</sec:authorize>
			<sec:authorize access="hasAuthority('employer')">
				<li><a href="<c:url value='/jobs/viewPublished'/>">Published
						Job Offer</a></li>
			</sec:authorize>
			<li class="active"><a href="<c:url value='/userInfo'/>">Person Information</a></li>
			<li><a href="<c:url value='/message/myMessages'/>">My
					Message</a></li>
			<li><a href="<c:url value='/logout'/>">Log Out</a></li>
		</ul>
	</div>
	<!-- 轮播 -->
	<div id="slidershow" class="carousel slide upper" data-ride="carousel"
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
		<form:form id="form" role="form" commandName="user"
			action="/myapp/userInfo/editUser" method="post"
			enctype="multipart/form-data">
			<fieldset style="width: 200px">
				<legend>User Fields</legend>
				<form:input type="hidden" path="id" name="id" />
				<form:input type="hidden" path="password" name="password" />
				<form:input type="hidden" path="authority" name="authority" />
				<form:input type="hidden" path="photoBytes" name="photoBytes" />
				<form:input type="hidden" path="photoContentType"
					name="photoContentType" />
				<form:input type="hidden" path="photoFilename" name="photoFilename" />
				<div class="form-group">
					<p>
						<img src="<c:url value='users/${user.id}/photo'/>" height="150"
							width="150" class="img-circle"/>
						<form:input type="file" name="photoChange" path="photoChange" />
					</p>
				</div>
				<div class="form-group">
					<p>
						<form:label for="username" path="username" cssErrorClass="error">User Name:</form:label>
						<br />
						<form:input class="form-control"
							placeholder="Please enter your name." path="username" />
						<form:errors path="username" />
					</p>
				</div>
				<div class="form-group">
					<p>
						<form:label for="email" path="email" cssErrorClass="error">Email:</form:label>
						<br />
						<form:input class="form-control"
							placeholder="Please enter an oftenly used email." path="email" />
						<form:errors path="email" />
					</p>
				</div>
				<div class="form-group">
					<p>
						<form:label for="age" path="age" cssErrorClass="error">Age:</form:label>
						<br />
						<form:input class="form-control"
							placeholder="Please enter your real age." path="age" />
						<form:errors path="age" />
					</p>
				</div>
				<div class="form-group">
					<p>
						<form:label for="education" path="education" cssErrorClass="error">Education:</form:label>
						<br />
						<form:textarea class="form-control"
							placeholder="Your former education." path="education" />
						<form:errors path="education" />
					</p>
				</div>
				<div class="form-group">
					<p>
						<form:label for="workExperience" path="workExperience"
							cssErrorClass="error">Working Experience:</form:label>
						<br />
						<form:textarea class="form-control"
							placeholder="Your working Experience." path="workExperience" />
						<form:errors path="workExperience" />
					</p>
				</div>
				<div class="form-group">
					<p>
						<form:label for="introduction" path="introduction"
							cssErrorClass="error">Introduction:</form:label>
						<br />
						<form:textarea class="form-control"
							placeholder="Say something about you." path="introduction" />
						<form:errors path="introduction" />
					</p>
				</div>
				<div class="form-group">
					<p>
						<input type="submit" class="btn btn-info" value="Submit Change" />
					</p>
				</div>
			</fieldset>
		</form:form>
	</center>
	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<footer>
	<p class="pull-right">
		<a href="#top">Back to Top</a>
	</p>

	<p>&copy; 2016 Xiajie Zhang</p>
	</footer>
</body>
</html>


