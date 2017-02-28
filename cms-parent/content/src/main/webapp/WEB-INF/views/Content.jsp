<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Content Management System</title>

<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/main.css" />" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<div class="navbar-header">
				<a class="navbar-brand" style="color: blue;">${websiteName}</a> <a
					class="navbar-brand"
					<c:if test="${not empty site.parentSite}">href="./delivery?site_uri=${site.parentSite.uri}"</c:if>>${site.name}</a>
			</div>
			<ul class="nav navbar-nav">
				<c:forEach items="${subSites}" var="subSite">
					<li><a href="./delivery?site_uri=${subSite.uri}">${subSite.name}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<c:forEach items="${pages}" var="page">
						<li><a href="./delivery?page_uri=${page.uri}">${page.title}</a></li>
					</c:forEach>
				</ul>
			</div>

		</div>
		<div class="row">
			<div class="col-sm-9 col-sm-offset-2">
				<img class="img-responsive" src="data:image/jpg;base64, ${image}" />
			</div>
		</div>
		<div class="row">
			<div class="col-sm-9 col-sm-offset-2">${selectedPage.content}</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>