<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>MHP Online Shop - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>

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
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- container -->
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<c:if test="${userClickItem == true}">
				<%@include file="singleItem.jsp"%>
			</c:if>
			
			<c:if test="${userClickManageItems == true}">
				<%@include file="manageItems.jsp"%>
			</c:if>
			
			<c:if test="${userClickAllItems == true or userClickCatalog == true}">
				<%@include file="listItems.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script src="${js}/bootbox.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/scripts.js"></script>
	</div>

</body>
</html>
