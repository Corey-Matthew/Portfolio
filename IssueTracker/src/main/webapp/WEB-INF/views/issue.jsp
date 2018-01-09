<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:import url="/WEB-INF/views/head.jsp"></c:import>
<c:import url="/WEB-INF/views/navbar.jsp"></c:import>
<body>
	<c:choose>
		<c:when test="${ empty issue }">
			<p>No issue associated with that ID.
			<p>
		</c:when>
		<c:otherwise>
			<div class="row">
				<div class="issue col-md-4">
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
						<b>Assigned to </b>
						<c:out value='${ requestScope.deptName }' />
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
				</div>
				<c:if test="${ not empty requestScope.issue.issueUpdates }">
					<div class="issue-update-cards col-md-4">
						<h2>Issue updates</h2>
						<c:forEach var='issueUpdate'
							items='${ requestScope.issue.issueUpdates }'>
							<div class="issue-updates user-card" style="width: 90%;">
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
					</div>
				</c:if>
				<div class="issue-update-form col-md-4">
					<c:if
						test="${ requestScope.issue.assignedTo == user.department.departmentId && user.role.roleName == 'department_admin' }">
						<div class="login-button">
							<form method="POST" action="rejectIssue">
								<button type="submit" class="btn btn-danger btn-pill">Reject
									issue</button>
							</form>
						</div>
					</c:if>
					<c:if
						test="${ issue.submittedBy == sessionScope.user.userId && issue.status == 'RESOLVED' }">
						<div class="login-button">
							<form method="POST" action="approveIssue">
								<button type="submit" class="btn btn-success btn-pill">Approve
									issue</button>
							</form>
						</div>
					</c:if>
					<c:if
						test="${ sessionScope.user.role.roleName eq 'department_admin' or sessionScope.user.role.roleName eq 'user' }">
						<c:if
							test="${ requestScope.issue.assignedTo == user.department.departmentId or requestScope.issue.submittedBy == sessionScope.user.userId }">
							<form method="POST" action="addIssueUpdate">
								<input type="hidden" name="issueId" value="${ issue.issueId }" />
								<div class="form-group" style="padding: 0 20%;">
									<span class="input-group-addon"> <i
										class="fa fa-info-circle"> Update on Issue: </i>
									</span>
									<textarea class="form-control" name="issueComment"
										placeholder="Enter any updates on the issue" required></textarea>
								</div>
								<div class="login-button">
									<button type="submit" class="btn btn-primary btn-pill">Submit
										Update</button>
								</div>
							</form>
						</c:if>
					</c:if>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>