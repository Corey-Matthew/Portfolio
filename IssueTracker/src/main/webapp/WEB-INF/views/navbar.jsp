<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="./">Issue Tracker</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:choose>
						<c:when test="${ not empty sessionScope.user }">
							<li><a href="issues">Issues</a></li>
							<li><a href="logout">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="login">Login<span class="sr-only">(current)</span></a></li>
							<li><a href="register">Register</a></li>
						</c:otherwise>
					</c:choose>
					<c:if test="${ sessionScope.user.role.roleName == 'admin' }">
						<li><a href="./">Admin</a>
					</c:if>
					<c:if test="${ sessionScope.user.role.roleName == 'department_admin' }">
						<li><a href="./">Department Admin</a>
					</c:if>
					<li><a href="listusers">Users List</a></li>
				</ul>
				<form action="finduser" method="GET"
					class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" name="username" id="user" class="form-control"
							placeholder="Search for a username..">
						<button type="submit" class="btn btn-default">Search</button>
					</div>
				</form>
			</div>
		</div>
	</nav>
</header>