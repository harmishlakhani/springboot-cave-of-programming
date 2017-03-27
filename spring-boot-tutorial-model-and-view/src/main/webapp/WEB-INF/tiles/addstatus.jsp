<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">

	<div class="col-md-8 col-md-offset-2">
	
		<div class = "panel panel-default">
		<c:out value="${statusUpdate}"></c:out>
			<div class = "panel-heading">
				<div class = "panel-title">Add a Status Update!!!</div>
			</div>
			
			<div class = "panel-body">
				<form>
					<div class="form-group">
						<textarea rows="10" cols="50"></textarea>
					</div>
					<input type="submit" name="submit" value="Add Status" />
				</form>
			</div>
			
		</div>
		
	</div>

	<!-- <div class="col-md-8 col-md-offset-2">
    	Second Col
    </div> -->

</div>
