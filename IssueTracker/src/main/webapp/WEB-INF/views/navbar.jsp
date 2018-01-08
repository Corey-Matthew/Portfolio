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
							<c:if test="${ sessionScope.user.role.roleName == 'admin' }">
								<li><a href="register">Register</a></li>
								<li><a href="listusers">Users List</a></li>
								<li><a href="./">Admin: ${sessionScope.user.username}</a></li>
							</c:if>
							<c:if
								test="${ sessionScope.user.role.roleName == 'department_admin' }">
								<li><a href="./">Department Admin:
										${sessionScope.user.username}</a></li>
							</c:if>
							<c:if test="${ sessionScope.user.role.roleName == 'user' }">
								<li><a href="./">User: ${sessionScope.user.username}</a></li>
							</c:if>
						</c:when>
						<c:otherwise>
							<li><a href="login">Login<span class="sr-only">(current)</span></a></li>
						</c:otherwise>
					</c:choose>

				</ul>
				<form action="viewissue" method="GET"
					class="navbar-form navbar-right">
					<div class="form-group">
						<input type="number" name="issueId" class="form-control"
							placeholder="Search by issue ID..">
						<button type="submit" class="btn btn-default">Search</button>
					</div>
				</form>
			</div>
		</div>
	</nav>
</header>