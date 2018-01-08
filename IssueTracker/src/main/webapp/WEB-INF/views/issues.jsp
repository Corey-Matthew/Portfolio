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
		</form>
	</c:if>
	<c:if test="${ requestScope.issueAdded }">
		<h4>Successfully added your issue!</h4>
	</c:if>
	<c:choose>
		<c:when test="${ empty requestScope.issues }">
			<p>No issues.</p>
		</c:when>
		<c:otherwise>
			<c:forEach var='issue' items='${ requestScope.issues }'>
				<a href="viewissue?issueId=${ issue.issueId }">
					<div class="user-card">
						<p>
							Issue ID:
							<c:out value='${ issue.issueId }' />
						</p>
						<p>
							Assigned to:
							<c:out value='${ issue.assignedTo }' />
						</p>
						<p>
							Status:
							<c:out value='${ issue.status }' />
						</p>
					</div>
				</a>
			</c:forEach>
			<c:if test="${ sessionScope.user.role.roleName eq 'admin' }">
				<div class="user-card">
					<form method="POST" action="assign">
						<ul>
							<div>
								Issue ID: <select name="issueId" size="1">
									<c:forEach var='issue' items='${ requestScope.issues }'>
										<option value="${issue.issueId}">${issue.issueId}</option>
									</c:forEach>
								</select>
							</div>
							<div>
								Assign to: <select name="deptId" size="1">
									<c:forEach var='dept' items='${ requestScope.depts}'>
										<option value="${dept.departmentId}">${ dept.departmentName }</option>
									</c:forEach>
								</select> <input type="submit" value="Assign" class="register-button">
								<br>
								<br />
							</div>
						</ul>
					</form>
				</div>
			</c:if>
			<c:if test="${requestScope.notfound}">
				<label> Issue not found!</label>
			</c:if>

		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>


