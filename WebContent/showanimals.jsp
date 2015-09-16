
<%@page import="java.util.ArrayList"%>
<%@page import="com.mobilab.code.Dog"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MobiLab Code Challenge</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>

	<%
		ArrayList<Dog> animals = (ArrayList<Dog>) request.getAttribute("animalsList");
		pageContext.setAttribute("animals", animals);

		String error = (String) request.getAttribute("error");
	%>
	
	<c:if test="${not empty error }">
		<p class="bg-danger">No Animals has been submitted, try again</p>
	</c:if>
	
	<c:choose>
		<c:when test="${fn:length(animals) gt 0}">
			<h2 class="sub-header">Current Animals:</h2>
			<div class="table-responsive">
				<table class="table table-striped">

					<thead>
						<tr>
							<th>Age</th>
							<th>Breed</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dog" items="${animals}">
							<tr>
								<td><c:out value="${dog.age}" /></td>
								<td><c:out value="${dog.breed}" /></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<p class="bg-warning">No Animals has been submitted</p>
		</c:otherwise>

	</c:choose>

	<div class="bs-example" data-example-id="simple-form-inline">
		<form method="post" action="animalServletPath" class="form-inline">

			<div class="form-group">
				<label for="exampleInputName2">Age</label> <input type="text"
					class="form-control" name="age" placeholder="10">
			</div>

			<div class="form-group">
				<label for="exampleInputEmail1">Breed</label> <input type="text"
					class="form-control" name="breed"
					placeholder="type the breed of the dog...">
			</div>

			<input class="btn btn-default" type="submit" value="New Animal"
				name="newanimal" />

		</form>
	</div>
</body>
</html>