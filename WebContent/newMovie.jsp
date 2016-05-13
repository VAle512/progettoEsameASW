<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>New Movie</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<f:view>
		<h:form>
			<h2>Movie Details</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Director</th>
						<th>Year</th>
						<th>Length</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><h:inputText value="#{movieController.title}"
								required="true" requiredMessage="Title is mandatory" id="title" />
							<h:message for="title" /></td>
						<td><h:inputText value="#{movieController.director}"
								required="true" requiredMessage="Director is mandatory"
								id="director" /> <h:message for="director" /></td>
						<td><h:inputText value="#{movieController.year}"
								required="true" requiredMessage="Year is mandatory"
								converterMessage="Year must be a number" id="year" /> <h:message
								for="year" /></td>
						<td><h:inputText value="#{movieController.length}"
								required="true" requiredMessage="Length is mandatory"
								converterMessage="Length must be a number" id="length" /> <h:message
								for="length" /></td>
						<td><h:inputText value="#{movieController.gen}"
								required="true" requiredMessage="Genre is mandatory"
								id="genre" /> <h:message for="genre" /></td>
					</tr>
				</tbody>
			</table>
			<div>
				<h:commandButton value="Submit"
					action="#{movieController.createMovie}" />
			</div>
		</h:form>
	</f:view>
</body>
</html>