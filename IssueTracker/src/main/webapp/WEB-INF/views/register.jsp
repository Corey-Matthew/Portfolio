

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import> 
<body>
	<c:choose>
		<c:when test="${ sessionScope.userLogged }">
			<p>Whoopsie, you wound up on our registration page, but you're
				already logged in!</p>
			<form method="POST" action="LogoutUserServlet">
				<input type="submit" value="Logout" class="register-button">
				<span class="welcome-register"><a href="./">Get Me Out of
						Here!</a></span>
			</form>
		</c:when>
		<c:otherwise>
			<h3>Register</h3>
			<span id="error-messages">${errormessage}</span>
			<form method="POST" action="registerUser">
				
				<c:if test="${requestScope.userexist}">
				<br>
					<p>Sorry, but that Username is not Available</p>
				</c:if>
				
				<c:if test="${requestScope.passwordNoMatch}">
				<br>
					<p>Passwords DO NOT Match!</p>
				</c:if>
				<c:if test="${requestScope.emptyField}">
				<br>
					<p>Please fill in all the fields</p>
				</c:if>
				
				<input
					type="text" name="username" class="fa long-input"
					placeholder="Enter Username..." required><br /> <input
					type="email" name="email" class="fa long-input"
					placeholder="Enter Email..." required><br /> <input
					type="password" name="password" class="fa long-input"
					placeholder="Enter password..." required><br /> <input
					type="password" name="confirmedPassword" class="fa long-input"
					placeholder="Confirm password..." required><br /> 
					<select name="userType" size="1">
 					<option value="user">User</option>
  					<option value="departmentAdmin">Depatment Admin</option>
  					<option value="admin">God Admin</option>
					</select><br /> 
					<select name="department" size="1">
 					<option value="BossDepartment">Baws</option>
  					<option value="Fixers">Fixers</option>
  					<option value="Sales">Sales</option>
					</select><br /> 
					
					<input
					type="submit" value="Register" class="register-button"> <br>
				<span class="welcome-register"> <br> <span class="welcome-register"><a
					href="./">Go Back Home</a></span>
			</form>
		</c:otherwise>
	</c:choose>

</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>