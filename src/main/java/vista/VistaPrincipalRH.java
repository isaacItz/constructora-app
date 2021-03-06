package vista;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Main;

public class VistaPrincipalRH extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar barra;
	private JDialog dialogRegistro;

	public VistaPrincipalRH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		setTitle("Constructora");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		barra = new JMenuBar();
		setJMenuBar(barra);
		JMenu trabajadores = new JMenu("Trabajadores");
		barra.add(trabajadores);
		JMenuItem agregar = new JMenuItem("Agregar");
		trabajadores.add(agregar);
		agregar.addActionListener(z -> {
			dialogRegistro = new DialogRegistrarTrabajador();
			dialogRegistro.setLocationRelativeTo(null);
			dialogRegistro.setVisible(true);

		});

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
