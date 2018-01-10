<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:import url="head.jsp"></c:import>
<c:import url="navbar.jsp"></c:import>
<body>

	
	<c:choose>
		<c:when test="${ not empty sessionScope.user }">
			<p>Already logged in.</p>
			<div class="login-button">
				<form method="POST" action="logout">
					<button type="submit" class="btn btn-primary btn-pill">Logout</button>
				</form>
			</div>
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
						<div class="input-group with-addon-icon-left">
							<span class="input-group-addon"> <i class="fa fa-user fa-fw"></i>
							</span> <input class="form-control" name="username"
								placeholder="Username" type="text" required />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group with-addon-icon-left">
							<span class="input-group-addon"><i class="fa fa-lock fa-fw"></i>
							</span> <input class="form-control" name="password"
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
	<br />
	<br />
</body>
<c:import url="footer.jsp"></c:import>
</html>