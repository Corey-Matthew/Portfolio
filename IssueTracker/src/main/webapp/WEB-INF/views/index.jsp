<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:import url="head.jsp"></c:import> 
<c:import url="navbar.jsp"></c:import> 
<body>
	<h1> Welcome to Issue Tracker System!</h1>
	<c:if test="${ not empty sessionScope.user }">
		<h2 style="color: red;"> Welcome back, ${ sessionScope.user.username } </h2>
	</c:if>
</body>
<c:import url="footer.jsp"></c:import> 
</html>