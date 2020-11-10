<div class="modal fade" id="insertar" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header bg-dark text-light">
				<h5 class="modal-title">Insertar Pelicula</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true" class="text-light">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form
					action="${pageContext.request.contextPath}/peliculaControlador?accion=insertar"
					method="post">
					<div class="form-group">
						<label for="director" class="text-dark lead font-weight-bold">Director:</label>
						<div class="block">
							<input type="text" name="director" maxlength="128" placeholder="Fulanito"
								class="form-control" required> <small
								id="passwordHelpBlock" class="form-text text-muted">
								Nombre del director</small>
						</div>
					</div>
					<div class="form-group">
						<label for="titulo" class="text-dark lead font-weight-bold">Titulo:</label>
						<div class="block">
							<input type="text" name="titulo" maxlength="128" placeholder="Salvar al soldado fulanito" 
							class="form-control" required> <small
							id="passwordHelpBlock" class="form-text text-muted">
								Titulo de la pelicula</small>
						</div>
					</div>
					
					<div class="form-group">
						<label for="fecha" class="text-dark lead font-weight-bold">Fecha:</label>
						<div class="block">
							<input type="text" name="fecha" pattern="^(?:3[01]|[12][0-9]|0?[1-9])([\-/.])(0?[1-9]|1[1-2])\1\d{4}$"
							placeholder="25-05-1994" class="form-control" required> <small
							id="passwordHelpBlock" class="form-text text-muted">
								Fecha de lanzamiento de la pelicula</small>
						</div>
					</div>
					
					
					<div class="modal-footer bg-dark">
						<button type="submit" class="btn btn-success">Insertar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>