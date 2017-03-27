<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">

	<div class="col-md-8 col-md-offset-2">
	
		<div class = "panel panel-default">
			<div class = "panel-heading">
				<div class = "panel-title">Add a Status Update!!!</div>
			</div>
			<div class = "panel-body">
				<form:form commandName="statusUpdate">
					<div class="form-group">
						<form:textarea path="text" rows="10" cols="50"></form:textarea>
					</div>
					<input type="submit" name="submit" value="Add Status" />
				</form:form>
			</div>
		</div>
		
		<div class = "panel panel-default">
			<div class = "panel-heading">
				<div class = "panel-title"><c:out value="${latestStatusUpdate.added}"></c:out></div>
			</div>
			<div class = "panel-body">
				<c:out value="${latestStatusUpdate.text}"></c:out>
			</div>
		</div>
		
	</div>
</div>
