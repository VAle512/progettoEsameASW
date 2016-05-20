<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>Catalogues</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<f:view>
		<h:form>
			<div class="container">
				<h1>Our Catalog</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Genre</th>
							<th>Date Last Update</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="catalogue" items="#{catalogueController.catalogues}">
							<tr>
								<td><h:commandLink
										action="#{movieController.findMoviesByCatalogue}"
										value="#{catalogue.genre}">
										<f:param name="id" value="#{catalogue.id}" />
									</h:commandLink></td>
								<td><fmt:formatDate type="both" dateStyle="full" value="${catalogue.lastUpdate.time}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input type="button" value="Back" onclick="history.back()" />
			</div>
		</h:form>
	</f:view>
</body>
</html>
