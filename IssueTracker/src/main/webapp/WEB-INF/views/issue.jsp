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
					<c:choose>
						<c:when test='${ user.role.roleName != "admin"}'>
							<c:if test='${ not empty issue.adminComment }'>
								<p>
									<b>Admin Comment:</b>
									<c:out value='${ issue.adminComment }' />
								</p>
							</c:if>
						</c:when>
						<c:otherwise>
							<form method="POST" action="updateIssueComment">
								<input type="hidden" name="issueId" value="${ issue.issueId }" />
								<div class="form-group center">
									<textarea name="adminComment" cols="30">${issue.adminComment}</textarea>
								</div>
								<div class="login-button">
									<button type="submit" class="btn btn-primary btn-pill">Submit
										Update</button>
								</div>
							</form>
						</c:otherwise>
					</c:choose>

				</div>
				<c:if test="${ not empty requestScope.issue.issueUpdates }">
					<div class="issue-update-cards col-md-4">
						<h2>Issue updates</h2>
						<c:forEach var='issueUpdate'
							items='${ requestScope.issue.issueUpdates }'>
							<table></table>
							<div class="issue-updates user-card" style="width: 90%;">
								<p>
									User${ issueUpdate.submittedBy }
									<c:out value='${ issueUpdate.updateComment}' />
								</p>
								<p>
									Update date:
									<c:out value='${ issueUpdate.updateDate}' />
								</p>
							</div>
						</c:forEach>
					</div>
				</c:if>
				<div class="issue-update-div col-md-4">
					<c:if
						test="${ sessionScope.user.role.roleName eq 'department_admin' or sessionScope.user.role.roleName eq 'user' }">
						<c:if
							test="${ requestScope.issue.assignedTo == user.department.departmentId or requestScope.issue.submittedBy == sessionScope.user.userId }">
							<div class="issue-update-form">
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
							</div>
						</c:if>
					</c:if>
					<c:if
						test="${ requestScope.issue.assignedTo == user.department.departmentId && user.role.roleName == 'department_admin' }">
						<h4>Update Issue Status</h4>
						<div>
							<form method="POST" action="updateIssueStatus">
								<div class="form-group select" style="text-align:center;">
								<input type="hidden" name="issueId" value="${ issue.issueId }" />
									<select name="status" size="1" required>
										<option value=''>Please select a status</option>
										<option value="ASSIGNED">Assigned</option>
										<option value="IN_PROCESS">In Process</option>
										<option value="RESOLVED">Resolved</option>
									</select>
								</div>
								<div class="login-button">
									<button type="submit" class="btn btn-primary btn-pill">Update Status</button>
								</div>
							</form>
						</div>
						<div class="login-button">
							<form method="POST" action="rejectIssue">
								<input type="hidden" name="issueId" value="${ issue.issueId }" />
								<button type="submit" class="btn btn-danger btn-pill">Reject
									issue</button>
							</form>
						</div>
					</c:if>
					<c:if
						test="${ issue.submittedBy == sessionScope.user.userId && issue.status == 'RESOLVED' }">
						<div class="login-button">
							<form method="POST" action="approveIssue">
								<input type="hidden" name="issueId" value="${ issue.issueId }" />
								<button type="submit" class="btn btn-success btn-pill">Approve
									issue</button>
							</form>
						</div>
					</c:if>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>