

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:choose>
		<c:when
			test="${ empty sessionScope.user  || sessionScope.user.role.roleName != 'admin'}">
			<p>You shall not pass!</p>
			<span class="welcome-register"><a href="./">Get Me Out of
					Here!</a></span>
		</c:when>
		<c:otherwise>
			<h3>Register</h3>
			<c:if test="${ requestScope.registered }">
				<h4>Successfully registered: ${ requestScope.user.username }</h4>
			</c:if>

			<c:if test="${ requestScope.selectUserTypeDepartment }">
				<h4>Please select a User Type & Department in Dropdowns</h4>
			</c:if>

			<c:if test="${ requestScope.selectDepartment }">
				<h4>Please select a Department</h4>
			</c:if>

			<c:if test="${ requestScope.selectUserType }">
				<h4>Please select a User Type</h4>
			</c:if>

			<span id="error-messages">${errormessage}</span>
			<div class="login-div">
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
					<div class="form-group">
						<div class="input-group with-addon-icon-left">
							<span class="input-group-addon"> <i class="fa fa-user"></i>
							</span> <input class="form-control" name="username"
								placeholder="Username" type="text" required>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group with-addon-icon-left">
							<span class="input-group-addon"><i class="fa fa-lock"></i>
							</span> <input class="form-control" name="password"
								placeholder="Password" type="password" required />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group with-addon-icon-left">
							<span class="input-group-addon"><i class="fa fa-lock"></i>
							</span> <input class="form-control" name="confirmedPassword"
								placeholder="Confirm password" type="password" required />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group with-addon-icon-left">
							<span class="input-group-addon"> <i
								class="fa fa-envelope"></i>
							</span> <input class="form-control" name="email" placeholder="Email"
								type="text" required />
						</div>
					</div>
					<div class="form-group select">
						<select name="userType" size="1" required>
							<option value=''>Please select a User Type</option>
							<option value="user">User</option>
							<option value="departmentAdmin">Department Admin</option>
							<option value="admin">General Admin</option>
						</select>
					</div>
					<div class="form-group select">
						<select name="department" size="1" required>
							<option value=''>Please select a Department</option>
							<option value="HR">Human Resources</option>
							<option value="IT">IT</option>
							<option value="Sales">Sales</option>
						</select>
					</div>
					<div class="login-button">
						<button type="submit" class="btn btn-primary btn-pill">Register</button>
					</div>
				</form>
			</div>
		</c:otherwise>
	</c:choose>

</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>