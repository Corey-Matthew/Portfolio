<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<!-- Add check that the issue belongs to the user -->
	<div class="issue">
		<p>
			<b>Issue ID:</b>
			<c:out value='${ issue.issueId }' />
		</p>
		<p>
			<b>Title:</b>
			<c:out value='${ issue.title }' />
		</p>
		<p>
			<b>Description:</b>
			<c:out value='${ issue.userDescription }' />
		</p>
		<p>
			<b>Assigned to:</b>
			<c:out value='${ issue.assignedTo }' />
		</p>
		<p>
			<b>Date Submitted:</b>
			<c:out value='${ issue.dateSubmitted }' />
		</p>
		<p>
			<b>Date Resolved:</b>
			<c:out value='${ issue.dateResolved }' />
		</p>
		<p>
			<b>Admin Comment:</b>
			<c:out value='${ issue.adminComment }' />
		</p>
		<c:if test="${ not empty requestScope.issue.issueUpdates }">
		<br/><br/>
		<h4>Issue updates</h4>
		<c:forEach var='issueUpdate'
			items='${ requestScope.issue.issueUpdates }'>
			<div class="issue-updates">
				<p>
					Update date:
					<c:out value='${ issueUpdate.updateDate}' />
				</p>
				<p>
					Update comment:
					<c:out value='${ issueUpdate.updateComment}' />
				</p>
			</div>
		
		</c:forEach>
		</c:if>
		<div class="issue-update-form">
			<c:if test="${ sessionScope.user.role.roleName eq 'department_admin' }">
				<c:if test="${ requestScope.issue.assignedTo == user.department.departmentId }">
					<form method="POST" action="addIssueUpdate" >
					<input type="hidden" name="issueId" value="${ issue.issueId }" />
						<table style="margin: 0 auto;">
							<tr>
								<td>Comment</td>
								<td><textarea name="issueComment"
										placeholder="Enter update text..." rows="8" cols="30" required></textarea>
								</td>
							</tr>
							<tr>
							<tr>
								<td></td>
								<td><input type="submit" value="Submit Update"></td>
							</tr>
						</table>
					</form>
				</c:if>
			</c:if>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>