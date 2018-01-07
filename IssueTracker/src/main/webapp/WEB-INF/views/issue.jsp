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
		<div class="issue-updates">
			<c:forEach var='issueUpdate' items='${ requestScope.issueUpdates }'>
			<p> Update date: <c:out value='${ issueUpdate.updateDate}' /></p>
			<p> Update comment: <c:out value='${ issueUpdate.updateComment}' /></p>
			</c:forEach>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</html>