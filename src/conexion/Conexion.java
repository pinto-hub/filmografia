package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Conexion para la base de datos mysql workbench
 * @author Jepin
 *
 */
public class Conexion {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cine?useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "admin";
	
	/**
	 * Metodo para crear la conexion con la base de datos
	 * @return la conexion con mysql
	 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("Loading driver error");
			e.printStackTrace(System.out);
		} catch (SQLException e) {
			System.out.println("Connection error");
			e.printStackTrace(System.out);
		}
		return conn;
	}
	
	/**
	 * Metodo para cerrar la herramienta Resulset
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	/**
	 * Metodo para cerrar la herramienta PreparedStatement
	 * @param preparedStatement
	 */
	public static void close(PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	/**
	 * Metodo para cerrar la conexion con la base de datos
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
}
