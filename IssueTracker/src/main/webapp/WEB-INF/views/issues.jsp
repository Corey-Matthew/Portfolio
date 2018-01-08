<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:if test="${ sessionScope.user.role.roleName == 'user' }">
		<form method="POST" action="addIssue">
		<input type="submit" value="Add Issue">
	</form></c:if>
	<c:if test="${ requestScope.issueAdded }">
		<h4>Successfully added your issue!</h4>
	</c:if>
	<c:choose>
		<c:when test="${ empty requestScope.issues }">
			<p>No issues.</p>
		</c:when>
		<c:otherwise>
			<c:forEach var='issue' items='${ requestScope.issues }'>
				<div class="issue">
					<p>
						<a href="viewissue?issueId=${ issue.issueId }">View issue ID:
						</a>
						<c:out value='${ issue.issueId }' />
					</p>
					<p>
						Assigned to:
						<c:out value='${ issue.assignedTo }' />
					</p>
				</div>
			</c:forEach>
			<c:if test="${ sessionScope.user.role.roleName eq 'admin' }">
				<form method="POST" action="assign">
					<ul>
						<li><input type="text" name="issueId" class="fa long-input"
							placeholder="Enter the issueId..." required><br /></li>
						<li><input type="text" name="assignedTo"
							class="fa long-input" placeholder="Enter the Dept.Id..." required><br />
						</li>
						<li><input type="text" name="Status" class="fa long-input"
							placeholder="Change Status..." required><br /> <input
							type="submit" value="Assign" class="register-button" /></li>
						<br>
					</ul>
				</form>
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>