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
					<table style="margin: 0 auto;">
						<tr>
							<td>Username: </td>
							<td><input type="text" name="username" class="fa long-input"
								placeholder="Enter your username..." required /><br /></td>
						</tr>
						<tr>
							<td>Password: </td>
							<td><input type="password" name="password"
								class="fa long-input" placeholder="Enter your password..."
								required><br /></td>
						</tr>
						<tr>
					</table>
					<input type="submit" value="Login">
				</form>
			</div>

		</c:otherwise>
	</c:choose>

</body>
<c:import url="footer.jsp"></c:import>
</html>