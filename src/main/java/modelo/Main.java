package modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.InicioSesion;

public class Main {
	private static InicioSesion login;
	private static BaseDatos baseDatos;

	public static void main(String... argumentos) {
		login = new InicioSesion();
		login.setVisible(true);
		if (login.acepto()) {
			String user;
			char[] password;
			user = login.getUser();
			password = login.getPassword();
			try {
				baseDatos = new BaseDatos(user, password, null, null);
				Connection con = baseDatos.getConnection();
				DatabaseMetaData db = con.getMetaData();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecto");
			}

		}
	}

}
