<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Arad's Backgammon Game</title>
		<link rel="stylesheet" href='<spring:url value="/resources/bootstrap/bootstrap.min.css"/>' type="text/css" />
		<link rel="stylesheet" href='<spring:url value="/resources/css/home.css"/>' type="text/css" />
		<link rel="stylesheet" href='<spring:url value="/resources/css/backgammon.css"/>' type="text/css" />
		<script src="<spring:url value="/resources/bootstrap/jquery-3.1.0.min.js" />"></script>
		<script src="<spring:url value="/resources/bootstrap/bootstrap.min.js" />" /></script>
		<script src="<spring:url value="/resources/js/logout.js" />"></script>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		
		<div class="container">
			<div class="row">
				<div class="col-lg-5"></div>
				<div class="col-lg-2"><h1>Board</h1></div>
				<div class="col-lg-5"></div>		
			</div>
		</div>
		
		<div class="container">
			<div class="row">	
				<table class="table">

					<tr class="board-edge-black"><td colspan="15">test</td></tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr>
						<td class="board-edge-brown">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						
						<td class="board-edge-brown">e</td>
						
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="text-center">e</td>
						<td class="board-edge-brown">e</td>
					</tr>
				
					<tr class="board-edge-black"><td colspan="15">test</td></tr>
				</table>
			</div>	
		</div>
	</body>
</html>