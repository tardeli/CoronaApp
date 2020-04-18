package br.edu.unoesc.daw.coronapp.dao.impl.jdbc;

/**
 *
 * @author rober
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static Connection conn;

	public static void conectar(String url, String usuario, String senha, String driver) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna uma conexão JDBC
	 * 
	 * @return Connection Implementa pattern singleton
	 */
	public static Connection getConnection() {
		if (conn == null) {
			// this.conectar(url, usuario, senha, driver);
		}
		return conn;
	}

	public static void destroy() {
		try {
			conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
