package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class BaseDatos {

	private Connection conexion;
	private final String DEFAULT_URL = "jdbc:mysql://lughub.duckdns.org:3306/consC?serverTimezone=UTC";

	public BaseDatos(String user, char[] password, String host, String port)
			throws SQLException, CommunicationsException {
		if (user != null || password != null) {

			if (host == null || port == null)
				conexion = DriverManager.getConnection(DEFAULT_URL, user, String.valueOf(password));
			else
				conexion = DriverManager.getConnection("jdbc:mysql://" + host + port + "/consC?serverTimezone=UTC",
						user, String.valueOf(password));
			System.out.println("conexion creada");
			JOptionPane.showMessageDialog(null, "bienvenido" + getRoll());
		}

		else {
			throw new SQLException("No Username or Password provided");
		}

	}

	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		return conexion;
	}

	public String getRoll() {
		String[] roles = { "secretaria", "administrador", "albañil", "jefe obra", "cliente" };

		for (String string : roles) {
			if (probarRol(string))
				return string;
		}
		return null;
	}

	private boolean probarRol(String rol) {
		Statement st;
		try {
			st = conexion.createStatement();
			return st.execute("show grants for current_user() USING " + rol);
		} catch (SQLException e) {
			return false;
		}

	}

}
