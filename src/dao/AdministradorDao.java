package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import modelo.Administrador;

public class AdministradorDao {
	
	private static final String SELECT_BY_NAME = "SELECT * FROM administrador WHERE nombre = ?";
	private static final String SQL_INSERT = "INSERT INTO administrador (nombre, pass) VALUES (?,?)";
	
	
	public Administrador selectAdmin(String user) {
		Administrador admin = null;
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(SELECT_BY_NAME);
			preparedStatement.setString(1, user);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.absolute(1) == true) {
				String nombre = resultSet.getString("nombre");
				String pass = resultSet.getString("pass");
				
				admin = new Administrador(nombre, pass);				
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
		return admin;
	}
	
	public void insertarAdministrador(Administrador admin) {

		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = Conexion.getconnection();
			preparedStatement = conn.prepareStatement(SQL_INSERT);
			preparedStatement.setString(1, admin.getNombre());
			preparedStatement.setString(2, admin.getPass());
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
