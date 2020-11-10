<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejercicio cine</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<div class="container bg-dark text-light pt-4 pb-4 col-12">
		<h2>Gestion de Peliculas</h2>
	</div>

	<div class="container">
	<div class=" d-flex justify-content-between">
	<a class="btn btn-success mt-5 mb-3 text-light" data-toggle="modal" data-target="#insertar">Insertar</a>
	<a href="index.jsp" class="btn btn-primary mt-5 mb-3">Salir</a>
	</div>
		<table class="table table-striped table-dark overflow-auto">
			<thead class="thead-light text-dark modal-body">
				<tr class="lead text-center">
					<th>#</th>
					<th>Director</th>
					<th>Titulo</th>
					<th>Lanzamiento</th>
					<th>Actualizar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pelicula" items="${peliculas}">

					<tr class="lead text-center">
						<td>${pelicula.id}</td>
						<td>${pelicula.director}</td>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.fecha}</td>
						<td><a href="${pageContext.request.contextPath}/peliculaControlador?accion=editar&id=${pelicula.id}" class="btn btn-warning">Actualizar</a></td>
						<td><a href="${pageContext.request.contextPath}/peliculaControlador?accion=eliminar&id=${pelicula.id}" class="btn btn-danger" onclick="if (!(confirm('¿Estas seguro?'))) return false">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="mt-3" style="color: red;">${error}</p>
	</div>
	
	<jsp:include page="/WEB-INF/view/insertar.jsp" />
	
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