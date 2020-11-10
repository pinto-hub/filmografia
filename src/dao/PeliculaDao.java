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
	private static final String SELECT_ALL = "SELECT * FROM pelicula";
	private static final String SQL_INSERT = "INSERT INTO pelicula (director, titulo, fecha) VALUES (?,?,?)";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM pelicula WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM pelicula WHERE id = ?";

	public List<Pelicula> buscarPeliculas(String nombre) {
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

	public List<Pelicula> lista() {
		Pelicula pelicula;
		List<Pelicula> peliculas = new ArrayList<>();

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(SELECT_ALL);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String director = resultSet.getString("director");
				String titulo = resultSet.getString("titulo");
				String fecha = resultSet.getString("fecha");

				pelicula = new Pelicula(id, director, titulo, fecha);
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

	public void insertarPelicula(Pelicula pelicula) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(SQL_INSERT);
			preparedStatement.setString(1, pelicula.getDirector());
			preparedStatement.setString(2, pelicula.getTitulo());
			preparedStatement.setString(3, pelicula.getFecha());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if (preparedStatement != null) {
				Conexion.close(preparedStatement);
			}
			if (conn != null) {
				Conexion.close(conn);
			}
		}
	}

	public Pelicula seleccionarPelicula(int id) {
		Pelicula pelicula = null;

		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(SQL_SELECT_BY_ID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.absolute(1) == true) {				
				int idPelicula = resultSet.getInt("id");
				String director = resultSet.getString("director");
				String titulo = resultSet.getString("titulo");
				String fecha = resultSet.getString("fecha");
				
				pelicula = new Pelicula(idPelicula, director, titulo, fecha);
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
		return pelicula;
	}
	
	public void editarPelicula(Pelicula pelicula) {
		String sqlUpdate = "UPDATE pelicula SET director=?, titulo=?, fecha=? WHERE id=?";

		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, pelicula.getDirector());
			preparedStatement.setString(2, pelicula.getTitulo());
			preparedStatement.setString(3, pelicula.getFecha());
			preparedStatement.setInt(4, pelicula.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if (preparedStatement != null) {
				Conexion.close(preparedStatement);
			}
			if (conn != null) {
				Conexion.close(conn);
			}
		}
	}
	
	public void eliminarPelicula(int id) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(SQL_DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			if (preparedStatement != null) {
				Conexion.close(preparedStatement);
			}
			if (conn != null) {
				Conexion.close(conn);
			}
		}
	}

}
