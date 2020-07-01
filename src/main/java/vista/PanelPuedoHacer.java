package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import dao.ActividadesDAO;
import modelo.Actividad;
import modelo.Main;
import modelo.PuedoHacer;
import modelo.Utileria;

public class PanelPuedoHacer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField busqueda;
	private JList<String> agregados;
	private JList<String> disponibles;
	private DefaultListModel<String> modeloAgregados;
	private DefaultListModel<String> modeloDisponibles;

	public PanelPuedoHacer(String[] actividades) {

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
//		add(panel, BorderLayout.NORTH);

		JLabel lblBuscar = new JLabel("Buscar:");
		panel.add(lblBuscar);

		agregados = new JList<>();
		disponibles = new JList<>();
		busqueda = new JTextField();
		panel.add(busqueda);
		busqueda.setColumns(20);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JPanel panelIzq = new JPanel();
		GridBagConstraints gbc_panelIzq = new GridBagConstraints();
		gbc_panelIzq.fill = GridBagConstraints.BOTH;
		gbc_panelIzq.insets = new Insets(0, 0, 0, 5);
		gbc_panelIzq.gridx = 0;
		gbc_panelIzq.gridy = 0;
		panel_1.add(panelIzq, gbc_panelIzq);
		panelIzq.setLayout(new BorderLayout(0, 0));

		JPanel lblNewLabel_1 = new JPanel();
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setLayout(new GridLayout(0, 1, 0, 10));

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(x -> {
			moverDerecha();
		});
		lblNewLabel_1.add(btnAgregar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(x -> {
			moverIzquierda();
		});
		lblNewLabel_1.add(btnRemover);

		JPanel panelDer = new JPanel();
		GridBagConstraints gbc_panelDer = new GridBagConstraints();
		gbc_panelDer.fill = GridBagConstraints.BOTH;
		gbc_panelDer.gridx = 2;
		gbc_panelDer.gridy = 0;
		panel_1.add(panelDer, gbc_panelDer);
		panelDer.setLayout(new BorderLayout(0, 0));
		agregados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		modeloAgregados = new DefaultListModel<>();
//		modeloAgregados.copyInto(actividades);

		modeloDisponibles = new DefaultListModel<>();

		agregados.setModel(modeloAgregados);

		JScrollPane scrollIzq = new JScrollPane(disponibles);
		panelIzq.add(scrollIzq, BorderLayout.CENTER);

		JScrollPane scrollDer = new JScrollPane(agregados);
		panelDer.add(scrollDer, BorderLayout.CENTER);

		disponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		disponibles.setModel(modeloDisponibles);

		for (String string : actividades) {
			modeloDisponibles.addElement(string);
		}
		validate();

	}

	public PuedoHacer[] getPuedoHacer() {
		List<PuedoHacer> list = new ArrayList<>();
		Enumeration<String> listaAgregados = modeloAgregados.elements();
		while (listaAgregados.hasMoreElements()) {
			ActividadesDAO actDao = Main.baseDatos.getActividadesDAO();
			PuedoHacer puedo = new PuedoHacer();
			Actividad act = new Actividad();
			act.setNombre(listaAgregados.nextElement());
			try {
				puedo.setCveAct(actDao.buscar(act).getCve());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			puedo.setStatus("Activo");
			list.add(puedo);
		}
		return list.toArray(new PuedoHacer[list.size()]);
	}

	public boolean validar() {
		if (getPuedoHacer().length == 0) {
			Utileria.error("Seleccione Por lo Menus Una Actividad");
			return false;
		}
		return getPuedoHacer().length > 0;
	}

	private void moverDerecha() {
		int index = disponibles.getSelectedIndex();
		if (index > -1) {
			modeloAgregados.addElement(modeloDisponibles.get(index));
			modeloDisponibles.removeElement(disponibles.getSelectedValue());
		}
	}

	private void moverIzquierda() {
		int index = agregados.getSelectedIndex();
		if (index > -1) {
			modeloDisponibles.addElement(modeloAgregados.get(index));
			modeloAgregados.removeElement(agregados.getSelectedValue());
		}
	}

}
