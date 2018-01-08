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
						<c:forEach var='dept' items='${requestScope.depts }'>
							<c:if test="${dept.departmentId == issue.assignedTo }">
								<c:out value='${ dept.departmentName }' />
							
							</c:if>
						</c:forEach>
					</p>
					<p>
						Status:
						<c:out value='${ issue.status }' />
						
						
					</p>
				</div>
			</c:forEach>
			<c:if test="${ sessionScope.user.role.roleName eq 'admin' }">
				
				
				
				<form method="POST" action="assign">
					<ul>
						<li><select name="issueId" size="1">
								<c:forEach var='issue' items='${ requestScope.issues }'>
									<option value="${issue.issueId}" >${issue.issueId} </option>
								</c:forEach>
							</select></li><br/> 
						<li><select name="deptId" size="1">
								<c:forEach var='dept' items='${ requestScope.depts}'>
									<option value="${dept.departmentId}" > ${ dept.departmentName }</option>
								</c:forEach>
							</select></li><br/> 
						<li><input type="submit" value="Assign" class="register-button"> <br></li>
						<br/>
					</ul>
				</form>
			</c:if>
			<c:if test="${requestScope.notfound}">
				<label> Issue not found!</label>
			</c:if>
			
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>


