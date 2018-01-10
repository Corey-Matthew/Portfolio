<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import>
<c:import url="navbar.jsp"></c:import>
<body class="homepage">
	<h1>Welcome to Issue Tracker System!</h1>
	<div class="mainpic"><img src="resources/trackingsystem.png"/>
	</div>
	<c:choose>
		<c:when test="${ not empty sessionScope.user }">
			<h2 style="color: red;">Welcome back, ${
				sessionScope.user.username }</h2>
			<h2 style="color: red;">Access level: ${
				sessionScope.user.role.roleName }</h2>
		</c:when>
		<c:otherwise>
			<c:if test="${requestScope.notfound}">
				<p>User not found!</p>
			</c:if>
			<c:if test="${requestScope.invalidUser}">
				<p>Invalid username.</p>
			</c:if>
			<c:if test="${requestScope.notmatch}">
				<p>Incorrect Password!</p>
			</c:if>
			<div class="login-div ">
				<h3>Login</h3>
				<form method="POST" action="LoginServlet">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"> <i class="fa fa-user"></i></span>
							</div>
							<input class="form-control" name="username"
								placeholder="Username" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fa fa-lock"></i></span> 
							</div>
							 <input class="form-control" name="password"
								placeholder="Password" type="password" required />
						</div>
					</div>
					<div class="login-button">
						<button type="submit" class="btn btn-primary btn-pill">Login</button>
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="footer.jsp"></c:import>
</html>