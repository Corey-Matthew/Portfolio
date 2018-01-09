<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:import url="head.jsp"></c:import>
<c:import url="navbar.jsp"></c:import>
<body>

	<h3>Login</h3>

	<c:choose>

		<c:when test="${ not empty sessionScope.user }">
			<p>Already logged in.</p>
			<form method="POST" action="logout">
				<input type="submit" value="Logout" class="register-button">
			</form>
		</c:when>
		<c:otherwise>

			<c:if test="${requestScope.notfound}">
				<label> User not found!</label>
			</c:if>
			<c:if test="${requestScope.notmatch}">
				<label> Incorrect Password! </label>

			</c:if>
			<div class="login-div">
				<form method="POST" action="LoginServlet">
					<div class="form-group">
						<div class="input-group with-addon-icon-left">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> 
							<input class="form-control" name="username"
								placeholder="Username" type="text">
						</div>
					</div>
					<div class="form-group">
						<div class="input-group with-addon-icon-left">
						<span class="input-group-addon"><i class="fa fa-lock"></i> </span>
						<input class="form-control" name="password" placeholder="Password" type="password">
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-pill">Login</button>
				</form>
			</div>

		</c:otherwise>
	</c:choose>
	<br />
	<br />
</body>
<c:import url="footer.jsp"></c:import>
</html>