<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MHP Online Shop - ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Bootstrap theme -->
<link href="${css}/bootstrap.min.theme.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/styles.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="${contextRoot}/home">MHP Online
					Shop</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li id="home" class="nav-item"><a class="nav-link"
							href="${contextRoot}/home">Home</a></li>
					</ul>
				</div>
			</div>
		</nav>
		
		<div class="content">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<div class="jumbotron">
							<h1>${errorTitle}</h1>
							<hr/>
							<blockquote style="word-wrap:break-word">${errorDescription}</blockquote>
							<a href="${contextRoot}/home" class="btn btn-primary">Back to home</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
	</div>

</body>
</html>
