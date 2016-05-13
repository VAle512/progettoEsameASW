<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="bootstrap-3.3.4-dist/css/bootstrap.min.css">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<link href="./css/custom.css" rel="stylesheet" />
<title>Ordine</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<f:view>
		<h1>New Catalogue</h1>
		<div class="container">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Title</th>
						<th>Director</th>
						<th>Year</th>
						<th>Length</th>
						<th>Confirm</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="movie" items="#{movieController.movies}">
						<h:form>
							<tr>
								<td><h:commandLink
										action="#{movieController.findMovie}"
										value="#{catalogueController.genre}">
										<f:param name="id" value="#{movie.id}" />
									</h:commandLink></td>
								<td>${movie.id}</td>
								<td>${movie.title}</td>
								<td>${movie.director}</td>
								<td>${movie.year}</td>
								<td>${movie.length}</td>
								<td><h:commandButton
										action="#{movieController.createMovie}"
										value="Add">

										<f:param name="id" value="#{product.id}" />
									</h:commandButton></td>
							</tr>
						</h:form>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<h:form>
			<div>
				<h:commandButton action="#{orderController.riepilogoOrder}"
					value="Conferma">
				</h:commandButton>
			</div>
			<div>
				<h:commandButton action="#{orderController.annullOrder}"
					value="Annulla">
				</h:commandButton>
			</div>
		</h:form>
	</f:view>
</body>
</html>