package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioSesion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cajaUser;
	private JPasswordField cajaPassword;
	private JButton btnIngresar;
	private boolean acepto;

	public InicioSesion() {
		super((javax.swing.JFrame) null, true);
		setSize(400, 500);
		setTitle("Inicio de Sesion");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(9, 1, 0, 0));

		JLabel label = new JLabel("");
		contentPane.add(label);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNombreDeUsuario);

		cajaUser = new JTextField();
		contentPane.add(cajaUser);
		cajaUser.setColumns(10);

		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);

		JLabel lblContrasea = new JLabel("Contraseña:");
		contentPane.add(lblContrasea);

		cajaPassword = new JPasswordField();
		contentPane.add(cajaPassword);

		JLabel label_2 = new JLabel("");
		contentPane.add(label_2);

		JPanel panel = new JPanel();
		contentPane.add(panel);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acepto = true;
				dispose();
			}
		});
		panel.add(btnIngresar);
		setLocationRelativeTo(null);

	}

	public String getUser() {
		return cajaUser.getText();
	}

	public char[] getPassword() {
		return cajaPassword.getPassword();
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public boolean acepto() {
		return acepto;
	}
}
