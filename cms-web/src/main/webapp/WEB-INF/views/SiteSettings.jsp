<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Site Settings</title>

<!-- Bootstrap core CSS -->
<link href="../html/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../html/main.css" rel="stylesheet">
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Content Management System</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"><i class="glyphicon glyphicon-user"></i>Admin<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="./ChangePassword.html"><i
								class="glyphicon glyphicon-pencil"></i>Change Password</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-log-out"></i>Logout</a></li>
					</ul></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="./siteSettings.html">Site Settings</a></li>
					<li><a href="./UserManagement.html">Users Management</a></li>
					<li><a href="./sites.html">Sites Management</a></li>
					<li><a href="./PagesManagement.html">Page Management</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-2">
				<h1 class="page-header">Site Settings</h1>
				<form class="form-horizontal">
					<div class="col-xs-12 col-sm-8">
						<div class="row form-group">
							<div class="col-xs-12 col-sm-2">Web site name</div>
							<div class="col-xs-12 col-sm-6">
								<input type="text" id="name" class="form-control"
									placeholder="Name" required autofocus>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-xs-12 col-sm-2">Site Logo</div>
							<div class="col-xs-12 col-sm-6">
								<input type="file" id="username" class="form-control"
									placeholder="Username" required autofocus>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-xs-12 col-sm-2">Delivery site URL</div>
							<div class="col-xs-12 col-sm-6">
								<input type="name" id="username" class="form-control"
									placeholder="Username" required autofocus>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-xs-12 col-sm-8">
								<input type="submit" value="Save"
									class="btn btn-primary pull-right" />
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /container -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../html/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
