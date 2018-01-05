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
				<form action="addIssueProc" method="POST">
					<table style="margin: 0 auto;">
						<tr>
							<td>Title </td>
							<td><input type="text" name="title" placeholder="What issue are you having?" required /></td>
						</tr>
						<tr>
							<td>Description </td>
							<td><textarea name="userDescription" placeholder="Please type in description of the problem..." rows="8" cols="30" required></textarea></td>
						</tr>
						<tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Add Issue"></td>
						</tr>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<p>You're not already logged in. </p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>