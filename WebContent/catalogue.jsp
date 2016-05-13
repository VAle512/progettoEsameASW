<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>Catalogo</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<f:view>
		<h:form>
			<h1 class="description">Movies Catalogue</h1>
			<table class="table table-striped">
				<tr>
					<th>Title</th>
					<th>Director</th>
					<th>Year</th>
					<th>Length</th>
					<th>Genre</th>
				</tr>
				<c:forEach var="movie" items="#{movieController.movies}">
					<tr>
						<td><h:commandLink action="#{movieController.findMovie}"
								value="#{movie.title}">
								<f:param name="id" value="#{movie.id}" />
							</h:commandLink></td>
						<td>${movie.director}</td>
						<td>${movie.length}</td>
						<td>${movie.year} </td>
						<td>${movie.genre}</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<br>
			<br>
		</h:form>

	</f:view>
</body>
</html>