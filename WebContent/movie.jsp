<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Movie</title>
</head>
<body>
	<f:view>
	    <h1>Movie inserted into the database correctly </h1>
		<h2>Movie Details</h2>
		<div>Title: ${movieController.title}</div>
		<div>Director: ${movieController.director}</div>
		<div>Year: ${movieController.year}</div>
		<div>Length: ${movieController.length}</div>
		<div>Genre: ${movieController.genre}</div>
		<br>
		<br>
		<br>
		<br>
	</f:view>
	<a href="homepage.jsp" class="button">Go to Homepage</a>
</body>
</html>