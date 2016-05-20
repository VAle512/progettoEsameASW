<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="./css/bootstrap.min.css" rel="stylesheet" />
<title>Movies</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
	<f:view>
		<h:form>
			<div class="container-fluid">
				<!-- Navigation -->
				<nav class="navbar navbar-inverse navbar-fixed-top"
					role="navigation">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="homepage.jsp">Home</a>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li><a href="newCatalogue.jsp">Add a Catalogue</a></li>
							<li><a href="newMovie.jsp">Add a Movie</a></li>
							<li><h:commandLink action="#{catalogueController.getAllCatalogues}"
									value="Our Catalogues" /></li>
						</ul>
					</div>

					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container --> </nav>
			</div>
			</h:form>
			<h:form>
			<br>
			<br>
			<br>
			<br>
			<!-- Page Content -->
			<div class="container">
				<div class="col-md-9">

					<div class="row carousel-holder">

						<div class="col-md-12">
							<div id="carousel-example-generic" class="carousel slide"
								data-ride="carousel">
								<ol class="carousel-indicators">
									<li data-target="#carousel-example-generic" data-slide-to="0"
										class="active"></li>
									<li data-target="#carousel-example-generic" data-slide-to="1"></li>
									<li data-target="#carousel-example-generic" data-slide-to="2"></li>
								</ol>
								<div class="carousel-inner">
									<div class="item active">
										<img class="slide-image"
											src="http://www.smartworld.it/wp-content/uploads/2016/01/Breaking-Bad-Copertina.jpg"
											alt="">
									</div>
									<div class="item">
										<img class="slide-image"
											src="http://www.serialminds.com/wp-content/uploads/2016/04/game-of-thrones.jpg"
											alt="">
									</div>
									<div class="item">
										<img class="slide-image"
											src="http://signorponza.com/wp-content/uploads/2015/06/MadMaxFuryRoadPosterByDCDesigns.png"
											alt="">
									</div>
								</div>
								<a class="left carousel-control"
									href="#carousel-example-generic" data-slide="prev"> <span
									class="glyphicon glyphicon-chevron-left"></span>
								</a> <a class="right carousel-control"
									href="#carousel-example-generic" data-slide="next"> <span
									class="glyphicon glyphicon-chevron-right"></span>
								</a>
							</div>
						</div>

					</div>


				</div>

			</div>

			<!-- /.container -->

			<div class="container">

				<hr>
			</div>
			<!-- /.container -->

			<!-- jQuery -->
			<script src="js/jquery.js"></script>

			<!-- Bootstrap Core JavaScript -->
			<script src="js/bootstrap.min.js"></script>
		</h:form>
	</f:view>
</body>
</html>
