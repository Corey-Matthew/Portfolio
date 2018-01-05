<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import> 
<body>
	<c:choose>
		<c:when test="${ not sessionScope.user.role.roleName eq 'admin' }">
			<p>You need to login to see this page.</p>
		</c:when>
		<c:otherwise>
			<c:forEach var='user' items='${ requestScope.users }'>
				<div class="user" style='background: #669999;'>
					<p>
						User ID:
						<c:out value='${ user.userId }' />
					</p>
					<p>
						Department:
						<c:out value='${ user.department.departmentName }' />
					</p><p>
						Username:
						<c:out value='${ user.username }' />
					</p><p>
						Email:
						<c:out value='${ user.email }' />
					</p>
					<p>
						Role:
						<c:out value='${ user.role.roleName }' />
					</p>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>