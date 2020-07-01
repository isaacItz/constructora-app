package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Actividad;
import modelo.DiaHora;
import modelo.Direccion;
import modelo.Horario;
import modelo.Main;
import modelo.Persona;
import modelo.PuedoHacer;
import modelo.TrabajadorCon;

public class DialogRegistrarTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private PanelDatosPersona panelPersona;
	private PanelDatosDireccion panelDireccion;
	private PanelHorario panelHorario;
	private PanelTipoTrabajador panelTipoTra;
	private PanelPuedoHacer panelPuedoHacer;
	private String[] actividades;
	private JComboBox<String> roles;

	public DialogRegistrarTrabajador() {
		setModal(true);
		setBounds(100, 100, 740, 659);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(5);
		borderLayout.setHgap(10);
		getContentPane().setLayout(borderLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		panelPersona = new PanelDatosPersona();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPanel.add(panelPersona, gbc_panel);

		panelDireccion = new PanelDatosDireccion();
		GridBagConstraints gbc_panelD = new GridBagConstraints();
		gbc_panelD.insets = new Insets(0, 0, 5, 0);
		gbc_panelD.fill = GridBagConstraints.BOTH;
		gbc_panelD.gridx = 1;
		gbc_panelD.gridy = 0;
		contentPanel.add(panelDireccion, gbc_panelD);

		panelHorario = new PanelHorario();
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.insets = new Insets(0, 0, 5, 0);
		gbc_panel1.gridwidth = 2;
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.gridx = 0;
		gbc_panel1.gridy = 1;
		contentPanel.add(panelHorario, gbc_panel1);

		panelTipoTra = new PanelTipoTrabajador();
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.insets = new Insets(0, 0, 0, 5);
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 2;
		contentPanel.add(panelTipoTra, gbc_panel2);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("Guardar");
		okButton.setActionCommand("OK");
		okButton.addActionListener(x -> registrarPersona());
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		addWindowListener(new OyenteSalida());

		roles = panelTipoTra.getRoles();

		roles.addActionListener(z -> agregarPuedoHacer());
		setActividaes();
		validate();
	}

	class OyenteSalida extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			Main.baseDatos.cerrarConexion();
		}
	}

	private void agregarPuedoHacer() {
		int index = roles.getSelectedIndex();
		if (index > -1) {
			String rol = roles.getSelectedItem().toString();
			if (rol.equals("Chalan") || rol.equals("Maestro de obra")) {
				GridBagConstraints gbc_panel = new GridBagConstraints();
				if (panelPuedoHacer == null) {
					panelPuedoHacer = new PanelPuedoHacer(actividades);
					gbc_panel.fill = GridBagConstraints.BOTH;
					gbc_panel.gridx = 1;
					gbc_panel.gridy = 2;

				}
				contentPanel.add(panelPuedoHacer, gbc_panel);
				validate();
			} else {
				if (panelPuedoHacer != null) {
					remove(panelPuedoHacer);
				}
			}
		}
	}

	private void registrarPersona() {
		Direccion dir = panelDireccion.getDireccion();
		Persona per = panelPersona.getPersona();
		TrabajadorCon tra = panelTipoTra.getTrabajador();
		PuedoHacer[] puedoHacer = panelPuedoHacer.getPuedoHacer();
		Horario hor = panelHorario.getHorario();
		DiaHora[] diasHora = panelHorario.getDiaHora();
		System.out.println(dir);
		System.out.println(per);
		System.out.println(tra);
		for (PuedoHacer puedo : puedoHacer) {
			System.out.println(puedo);
		}
		System.out.println(hor);
		for (DiaHora diaHora : diasHora) {
			System.out.println(diaHora);
		}
////////////////////////////////
		try {
			Main.baseDatos.getDireccionDAO().insertar(dir);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		per.setDireccion(dir.getCve());
		try {
			Main.baseDatos.getPersonaDAO().insertar(per);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		tra.setCvePer(per.getCve());
		try {
			Main.baseDatos.getTrabajadorConDAO().insertar(tra);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (PuedoHacer puedo : puedoHacer) {
			puedo.setCveTracom(tra.getCve());
			try {
				Main.baseDatos.getPuedoHacerDAO().insertar(puedo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		hor.setCveTracon(tra.getCve());

		try {
			Main.baseDatos.getHorarioDAO().insertar(hor);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (DiaHora diaHor : diasHora) {
			diaHor.setCveHor(hor.getCve());
			try {
				Main.baseDatos.getDiaHoraDAO().insertar(diaHor);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(dir);
		System.out.println(per);
		System.out.println(tra);
		for (PuedoHacer puedo : puedoHacer) {
			System.out.println(puedo);
		}
		System.out.println(hor);
		for (DiaHora diaHora : diasHora) {
			System.out.println(diaHora);
		}
	}

	private boolean validarEmpleado() {
		return panelPersona.validar();
	}

	private void setActividaes() {
		List<Actividad> lista = Main.baseDatos.getActividadesDAO().obtenerTodos();
		actividades = lista.stream().map(x -> x.getNombre()).collect(Collectors.toList())
				.toArray(new String[lista.size()]);
	}

}
