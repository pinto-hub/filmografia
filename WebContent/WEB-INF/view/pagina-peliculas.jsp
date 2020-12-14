<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de peliculas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<style type="text/css">
		body {
		background-color: lightyellow;
		}
		
		h3, a {
		border-radius: 3px;
		box-shadow: 7px 7px 10px 0 rgba(0, 0, 0, 0.3);
		}
	</style>
</head>
<body>
	<div class="container bg-dark text-light p-4 col-12 d-flex justify-content-between align-items-center">
		<h2>Admin: ${admin.name}</h2>
		<a class="btn btn-primary" href="paginaAdmin">Volver</a>
	</div>

	<div class="container pt-3">
	<a href="formularioPelicula" class="btn btn-success btn-lg mt-5 mb-3">Insertar</a>	

	
		<table class="table table-striped table-dark overflow-auto">
			<thead class="thead-light text-dark modal-body">
				<tr class="lead text-center">
					<th>Director</th>
					<th>Titulo</th>
					<th>Fecha</th>
					<th>Actualizar</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pelicula" items="${peliculas}">

					<c:url var="actualizar" value="actualizarPelicula">
						<c:param name="peliculaId" value="${pelicula.id}"></c:param>
					</c:url>

					<c:url var="eliminar" value="eliminarPelicula">
						<c:param name="peliculaId" value="${pelicula.id}"></c:param>
					</c:url>

					<tr class="lead text-center">
						<td>${pelicula.director}</td>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.fecha}</td>
						<td><a href="${actualizar}" class="btn btn-warning">Actualizar</a></td>
						<td><a href="${eliminar}" class="btn btn-danger" onclick="if (!(confirm('¿Seguro que quieres eliminar la pelicula ${pelicula.titulo}?'))) return false">Eliminar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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