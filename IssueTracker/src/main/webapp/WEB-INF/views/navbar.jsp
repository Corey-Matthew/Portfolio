<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="./">Issue Tracker</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${ not empty sessionScope.user }">
						<li class="nav-item"><a class="nav-link" href="issues">Issues</a></li>
						<c:if test="${ sessionScope.user.role.roleName == 'admin' }">
							<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
							<li class="nav-item"><a class="nav-link" href="listusers">Users</a></li>
							<li class="nav-item"><a class="nav-link" href="./">Admin:${sessionScope.user.username}</a></li>
						</c:if>
						<c:if
							test="${ sessionScope.user.role.roleName == 'department_admin' }">
							<li class="nav-item"><a class="nav-link" href="./">Department_Admin:${sessionScope.user.username}</a></li>
						</c:if>
						<c:if test="${ sessionScope.user.role.roleName == 'user' }">
							<li class="nav-item"><a class="nav-link" href="./">User:${sessionScope.user.username}</a></li>
						</c:if>
						<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0" action="viewissue"
				method="GET">
				<input type="number" name="issueId" class="form-control mr-sm-2 "
					placeholder="Search by issue ID" style="width: 59%;">
				<button type="submit" class="btn btn-default my-2 my-sm-0">Search</button>
			</form>

			</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>


		</div>
	</nav>
</header>