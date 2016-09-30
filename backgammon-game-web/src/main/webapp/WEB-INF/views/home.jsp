<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Arad's Backgammon Game</title>
		<link rel="stylesheet" href='<spring:url value="/resources/bootstrap/bootstrap.min.css"/>' type="text/css" />
		<link rel="stylesheet" href='<spring:url value="/resources/css/home.css"/>' type="text/css" />
		<script src="<spring:url value="/resources/bootstrap/jquery-3.1.0.min.js" />"></script>
		<script src="<spring:url value="/resources/bootstrap/bootstrap.min.js" />" /></script>
		<script src="<spring:url value="/resources/js/registerUser.js" />" /></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="row">
				
					<div class="col-lg-5">
						<div class="navbar-header"><h1>Arad's Backgammon Game</h1></div>
					</div>
					
					<div class="col-lg-7">
						<c:url value="/login" var="loginVar"/>
						<form id="loginForm" class="navbar-form navbar-right" method="POST" action="${loginVar}">
							
							<div class="form-group">
								<label for="userNameLogin">User Name:</label>
								<br/>
								<input type="text" class="form-control" name="userNameLogin" placeholder="User Name">
							</div>
							
							<span>&nbsp;&nbsp;&nbsp;</span>
							
							<div class="form-group">
								<label for="password">Password:</label>
								<br/>
								<input type="password" class="form-control" name="passwordLogin" placeholder="Password">
							</div>
							
							<span>&nbsp;&nbsp;&nbsp;</span>
							
							<div class="form-group">
								<br/>
								<button type="submit" class="btn btn-primary">Log In</button>
							</div>
							
							<c:if test="${param.error != null}">
								<p>Invalid Username or Password.</p>
							</c:if>
							
							<c:if test="${param.logout != null}">
								<p>You have successfully logged out.</p>
							</c:if>
							<sec:csrfInput/>
						</form>
						
					</div>
					
				</div>
			</div>
		</nav>
		
		<div class="container">
			<div class="row">
				<div class="col-lg-7">
					<div class="jumbotron">
						<h1>Hello & Welocme to Arad's Arcade Games.</h1>
						<p>This is an demo project, 
						which gives you the ability to play backgammon against 
						other players online.</p>
						<p>Go write a head and register. If you're already familiar with
				 		this demo project click start play button.</p>
				 		<h3>Enjoy!!! ;-)</h3>
				 		<br/>
					</div>
				</div>
				<div class="col-lg-4">
					<h1>Sign Up.</h1>
					<br/>
					
					<c:url value="/register" var="registerVar"/>
					<form id="registerForm" method="POST" action="${registerVar}">
						<div class="form-group">
							<label for="firstName">First Name:</label>
							<input type="text" class="form-control" id="firstName" 
								placeholder="Your First Name" name="firstName">							
						</div>
						
						<p id="invalidFirstName" class="hidden text-danger">Invalid first name, use letters and spaces only.</p>
						
						<div class="form-group">
							<label for="lastName">Last Name:</label>
							<input type="text" class="form-control" id="lastName" 
								placeholder="Your Last Name" name="lastName">
						</div>
					
						<p id="invalidLastName" class="hidden text-danger">Invalid last name, use letters and spaces only.</p>
						
						<!-- JQuery email validation -->
						<div class="form-group">
							<label for="email">Email:</label>
							<input type="email" class="form-control" id="email" 
								placeholder="Your Email" name="email" >
						</div>
						
						<a id="emailUrl" href="<spring:url value="/email" />"></a>
						<p id="invalidEmail" class="hidden text-danger">Invalid email.</p>
						
						<!-- JQuery make sure available user name -->
						<div class="form-group">
							<label for="userName">User Name:</label>
							<input type="text" class="form-control" id="userName" 
								placeholder="User Name" name="userName">
						</div>
						
						<p id="invalidUserName" class="hidden text-danger"></p>
						<a id="userNameUrl" href="<spring:url value="/user_name/" />"></a>
						
						<div class="form-group">
							<label for="password">Password:</label>
							<input type="password" class="form-control" id="password" 
								placeholder="Password" name="password" >
						</div>
						<p id="invalidPassword" class="hidden text-danger"></p>
						
						<div class="form-group">
							<label for="confirmPassword">Confirm Password:</label>
							<input type="password" class="form-control" id="confirmPassword" 
								placeholder="Confirm Password" >
						</div>
						<p id="invalidConfirmPassword" class="hidden text-danger">Passwords does not match.</p>
						<sec:csrfInput/>
						<button id="registerBtn" type="submit" class="btn btn-success">Register</button>
					</form>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
	</body>
</html>