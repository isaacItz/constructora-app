package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.InicioSesion;
import vista.VistaPrincipal;

public class Main {
	private static InicioSesion login;
	public static BaseDatos baseDatos;

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
				VistaPrincipal vistaP = new VistaPrincipal();
				vistaP.setVisible(true);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecto");
			}

		}
	}

}
