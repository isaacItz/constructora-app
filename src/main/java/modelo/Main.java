package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.InicioSesion;

public class Main {
	private static InicioSesion login;
	private static BaseDatos baseDatos;
	private static JTextField cajaUser;
	private static JPasswordField cajaPassword;

	public static void main(String... argumentos) throws SQLException {
		login = new InicioSesion();
		cajaUser = login.getCajaUser();
		cajaPassword = login.getCajaPassword();
		login.getCajaPassword().addActionListener(new OyenteInicioSesion());
		login.getBtnIngresar().addActionListener(new OyenteInicioSesion());
		login.setVisible(true);
	}

	private static class OyenteInicioSesion implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String user;
				char[] password;
				user = cajaUser.getText();
				password = cajaPassword.getPassword();
				baseDatos = new BaseDatos(user, password, null, null);
				Connection con = baseDatos.getConnection();
				DatabaseMetaData db = con.getMetaData();
				System.out.println(baseDatos.getRoll());

			} catch (SQLException ex) {
				System.err.println(ex);
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecto");
			}
		}
	}

}
