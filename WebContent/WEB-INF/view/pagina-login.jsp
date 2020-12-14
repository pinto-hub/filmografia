 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Pagina de login</title>

</head>
<body style="background-color: lightyellow;">

	<div
		class="container bg-dark text-light p-4 col-12 d-flex justify-content-between align-items-center">
		<h2>Login</h2>
		<a class="btn btn-primary" href="paginaPrincipal">Volver</a>
	</div>

	<div class="container pt-5">
		<f:form action="login" method="POST">

			<c:if test="${error != null}">
				<h4 class="text-danger">${error}</h4>
			</c:if>

			<c:if test="${logout != null}">
				<h4 class="text-success">${logout}</h4>
			</c:if>

			<div class="form-group d-flex flex-column">
				<label for="user">Usuario:</label>
				<div class="d-flex align-items-center">
					<input id="user" class="ml-3 mr-3" type="text" name="name" />
				</div>
			</div>
			<div class="form-group d-flex flex-column">
				<label for="pass">Contraseña:</label>
				<div class="d-flex align-items-center">
					<input id="pass" class="ml-3 mr-3" type="text" name="password" />
				</div>
			</div>

			<input class="btn btn-success mt-3" type="submit" value="Entrar" />
		</f:form>
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