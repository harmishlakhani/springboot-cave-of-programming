<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="url" value="/viewstatus"/>

<div class="row">
	<div class="col-md-8 col-md-offset-2">
	
		<div class="pagination">
			<c:forEach var="pageNumber" begin="1" end="${page.totalPages}">
			
				<c:choose>
					<c:when test="${page.number != pageNumber - 1}">
						<a href="${url}?p=${pageNumber}"> <c:out value="${pageNumber}"></c:out> </a>
					</c:when>
					<c:otherwise>
						<strong><c:out value="${pageNumber}" /></strong>
					</c:otherwise>
				</c:choose>
				
				<c:if test="${pageNumber != page.totalPages}">
					|
				</c:if>
			</c:forEach>
		</div>
		<c:forEach var="statusUpdate" items="${page.content}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						Status Update added on
						<fmt:formatDate pattern="EEEE d MMMM y 'at' H:mm:s"
							value="${statusUpdate.added}"></fmt:formatDate>
					</div>
				</div>
				<div class="panel-body">
					<c:out value="${statusUpdate.text}"></c:out>
				</div>
			</div>
		</c:forEach>

	</div>
</div>