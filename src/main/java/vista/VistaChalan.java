package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.DiaHora;
import modelo.Direccion;
import modelo.Horario;
import modelo.Main;
import modelo.Persona;
import modelo.PuedoHacer;
import modelo.TrabajadorCon;

import javax.swing.JTextPane;

public class VistaChalan extends JDialog {

	private static final long serialVersionUID = 4599772755531587173L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			VistaChalan dialog = new VistaChalan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VistaChalan() {
		String user = Main.user;
		String mostrar = "";
		Direccion dir = null;
		Persona per = null;
		TrabajadorCon tra = new TrabajadorCon();
		tra.setUser(user);
		try {
			tra = Main.baseDatos.getTrabajadorConDAO().buscar(tra);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PuedoHacer[] puedoHacer = null;
		Horario hor = null;
		DiaHora[] diasHora = null;

		mostrar += tra.toString();

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JTextPane textPane = new JTextPane();
			contentPanel.add(textPane);
			textPane.setText(mostrar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				Main.baseDatos.cerrarConexion();
			}
		});
	}

}
