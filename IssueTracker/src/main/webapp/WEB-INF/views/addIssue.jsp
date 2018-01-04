<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:if test="${ addIssueFailed }">
		<h4>Adding issue failed.. Check valid inputs.</h4>
	</c:if>
	<div id="add-user" class="options">
		<c:choose>
			<c:when test="${ not empty sessionScope.user }">
				<sf:form action="addIssueProc" method="POST" modelAttribute="issue">
					<table style="margin: 0 auto;">
						<tr>
							<td>Title </td>
							<td><sf:input path="title" placeholder="Title: what is your issue about?" required="required" /></td>
						</tr>
						<tr>
							<td>Description </td>
							<td><sf:textarea path="userDescription" placeholder="Please type in description of the problem..." rows="8" cols="30" required="required"  /></td>
						</tr>
						<tr>
						<tr>
							<td></td>
							<td><sf:button>Submit</sf:button></td>
						</tr>
					</table>
				</sf:form>
			</c:when>
			<c:otherwise>
				<p>You're not already logged in. </p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>