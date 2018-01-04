<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<form method="POST" action="addIssue">
		<input type="submit" value="Add Issue">
	</form>
	<c:if test="${ requestScope.issueAdded }">
		<h4> Successfully added your issue! </h4>
	</c:if>
	<c:choose>
		<c:when test="${ empty requestScope.issues }">
			<p>No issues. Why don't you try creating one?</p>
		</c:when>
		<c:otherwise>
			<c:forEach var='issue' items='${ requestScope.issue }'>
				<div class="issue" style='background: #669999;'>
					<p>
						Issue ID:
						<c:out value='${ issue.issueId }' />
					</p>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>