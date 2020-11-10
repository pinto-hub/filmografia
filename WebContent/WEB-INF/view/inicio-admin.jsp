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
	<div class="container col-12 mt-5">
	<h4>Bienvenido: ${nombre}</h4>
	<a class="btn btn-danger mt-3 ml-3" href="index.jsp">Salir</a>
	<a class="btn btn-success mt-3 ml-3" href="${pageContext.request.contextPath}/peliculaControlador?accion=mantenimiento">Mantenimiento de peliculas</a>
	<a class="btn btn-primary text-light mt-3 ml-3" data-toggle="modal" data-target="#insertarAdmin">Insertar Administrador</a>
	<p class="mt-3" style="color: red;">${error}</p>
	<p class="mt-3" style="color: blue;">${correcto}</p>
	</div>
	
	
	<jsp:include page="/WEB-INF/view/insertar-admin.jsp" />
	
	
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