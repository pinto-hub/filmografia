<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Gestion de Peliculas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<style type="text/css">
		body {
		background-color: lightyellow;
		}
		a {
		border-radius: 3px;
		box-shadow: 7px 7px 10px 0 rgba(0, 0, 0, 0.3);
		}
	</style>
</head>
<body>

	<div class="container bg-dark text-light p-4 col-12 d-flex justify-content-between align-items-center">
		<h2>Cine</h2>
	</div>
	<div class="d-flex justify-content-center align-items-center mt-5">
		<a class="btn btn-primary text-light btn-lg mt-4" href="paginaInfo">Info</a>
		<a class="btn btn-secondary text-light btn-lg mt-4 ml-5" href="paginaConsulta">Consultar directores</a>
		<a class="btn btn-success text-light btn-lg mt-4 ml-5" href="paginaLogin">Login</a>
		
	</div> 


	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
