package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelo.Pelicula;

public class PeliculaDao {
	
	private static final String SELECT_BY_DIRECTOR = "SELECT * FROM pelicula WHERE director = ?";
	
	public List<Pelicula> list(String nombre) {
		Pelicula pelicula;
		List<Pelicula> peliculas = new ArrayList<>();

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(SELECT_BY_DIRECTOR);
			preparedStatement.setString(1, nombre);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String director = resultSet.getString("director");
				String titulo = resultSet.getString("titulo");
				String fecha = resultSet.getString("fecha");

				pelicula = new Pelicula(director, titulo, fecha);
				peliculas.add(pelicula);

			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if (resultSet != null) {
				Conexion.close(resultSet);
			}
			if (preparedStatement != null) {
				Conexion.close(preparedStatement);
			}
			if (conn != null) {
				Conexion.close(conn);
			}
		}
		return peliculas;
	}
	
	

}
