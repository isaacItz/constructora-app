package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.BaseDatos;
import vista.InicioSesion;
import vista.VistaChalan;
import vista.VistaPrincipalRH;

public class Main {
	private static InicioSesion login;
	public static BaseDatos baseDatos;
	public static String user;

	public static void main(String... argumentos) {
		login = new InicioSesion();
		login.setVisible(true);
		if (login.acepto()) {
			String user;
			char[] password;
			user = login.getUser();
			password = login.getPassword();
			try {
				baseDatos = new BaseDatos(user, password, "localhost", 3308);
				if (baseDatos.getRoll().equals("Recursos Humanos")) {
					VistaPrincipalRH vistaP = new VistaPrincipalRH();
					vistaP.setVisible(true);
				} else {
					VistaChalan vistaC = new VistaChalan();
					vistaC.setVisible(true);
				}

			} catch (SQLException e) {
//				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecto");
			}

		}
	}

}
