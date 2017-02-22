<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<div class="col-sm-9 col-sm-offset-2">
	<h1 class="page-header">Pages Management</h1>
	<div class="col-xs-6">
		<form class="form-horizontal">
			<div class="input-group">
				<select class="form-control">
					<option value="all">All</option>
					<option value="">Root - /</option>
					<option value="">Products - /Products</option>
				</select> <span class="input-group-btn">
					<button class="btn btn-default" type="button">
						<i class="glyphicon glyphicon-filter"></i>Filter
					</button>
				</span>
			</div>
		</form>
	</div>
	<div class="col-xs-6">
		<div class="pull-right">
			<a class="btn btn-info" href="./AddPage.html">Add Page</a>
		</div>
	</div>
	<div class="col-xs-12">
		<table class="table table-striped table-hover">
			<thead>
				<th>Page Title</th>
				<th>Page URI</th>
				<th>Site</th>
				<th>Is Landing</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${pages}" var="page">
					<tr>
						<td>${page.title}</td>
						<td>${page.uri}</td>
						<c:choose>
							<c:when test="${empty page.site}">
								<td>none</td>
								<td>No</td>
							</c:when>
							<c:otherwise>
								<td>${page.site.name}-${page.site.uri}</td>
								<td>No</td>
							</c:otherwise>
						</c:choose>
						<td><a class="btn btn-primary"
							href="./edit-page?uri=${page.uri}">Edit</a> &nbsp;<a
							class="btn btn-danger" href="./EditPage.html">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
