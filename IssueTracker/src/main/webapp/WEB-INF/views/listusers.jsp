<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:choose>
		<c:when test="${ sessionScope.user.role.roleName != 'admin' }">
			<p>You need to login to see this page.</p>
		</c:when>
		<c:otherwise>
		<div class="iter-cards">
		<h1>User List</h1>
			<c:forEach var='user' items='${ requestScope.users }'>
				<div class="user-card col-sm-4">
						<p>
							User ID:
							<c:out value='${ user.userId }' />
						</p>
						<p>
							Department:
							<c:out value='${ user.department.departmentName }' />
						</p>
						<p>
							Username:
							<c:out value='${ user.username }' />
						</p>
						<p>
							Email:
							<c:out value='${ user.email }' />
						</p>
						<p>
							Role:
							<c:out value='${ user.role.roleName }' />
						</p>
						<c:if test="${ user.role.roleName == 'user' }">
						<a href="viewUserIssues?userId=${ user.userId }" class="btn btn-primary">See User Issues</a>
						</c:if>
						<c:if test="${ user.role.roleName == 'department_admin' }">
						<a href="viewDeptIssues?deptId=${ user.department.departmentId }" class="btn btn-primary">See Department Issues</a>
						</c:if>
						<c:if test="${ user.role.roleName == 'admin' }">
						<a href="issues" class="btn btn-primary">See All Issues</a>
						</c:if>
				</div>
			</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>
	<br />
	<br />
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>