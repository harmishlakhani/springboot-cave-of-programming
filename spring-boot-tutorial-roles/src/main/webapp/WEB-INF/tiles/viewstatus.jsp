<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="hcl"%>

<c:url var="url" value="/viewstatus"/>

<div class="row">
	<div class="col-md-8 col-md-offset-2">
	
		<hcl:pagination page="${page}" url="${url}" size="10" />
		
		<c:forEach var="statusUpdate" items="${page.content}">
		
			<c:url var="editLink" value="/editstatus?id=${statusUpdate.id}" />
			<c:url var="deleteLink" value="/deletestatus?id=${statusUpdate.id}" />
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						Status Update added on
						<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
							value="${statusUpdate.added}"></fmt:formatDate>
					</div>
				</div>
				<div class="panel-body">
					<div>${statusUpdate.text}</div>
					<div class="edit-links pull-right">
						<a href="${editLink}">edit</a> | <a href="${deleteLink}" onclick="return confirm('Do you really want to delete this status?')">delete</a>
					</div>
				</div>
			</div>
		</c:forEach>

	</div>
</div>