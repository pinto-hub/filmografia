<div class="modal fade" id="insertarAdmin" data-backdrop="static"
	data-keyboard="false">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header bg-dark text-light">
				<h5 class="modal-title">Insertar Administrador</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true" class="text-light">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form
					action="${pageContext.request.contextPath}/peliculaControlador?accion=insertarAdmin"
					method="post">
					<div class="form-group">
						<label for="admin" class="text-dark lead font-weight-bold">Administrador:</label>
						<div class="block">
							<input type="text" name="admin" maxlength="45" placeholder="Administrador"
								class="form-control" required> <small
								id="passwordHelpBlock" class="form-text text-muted">
								Usuario del administrador</small>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="text-dark lead font-weight-bold">Pass:</label>
						<div class="block">
							<input type="text" name="pass" maxlength="45" placeholder="Pass" 
							class="form-control" required> <small
							id="passwordHelpBlock" class="form-text text-muted">
								Pass del administrador</small>
						</div>
					</div>					
					<input hidden="true" name="usuarioActual" value="${nombre}"/>
					<div class="modal-footer bg-dark">
						<button type="submit" class="btn btn-success">Insertar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>