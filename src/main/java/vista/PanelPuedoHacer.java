package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

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

		modeloAgregados = new DefaultListModel<>();
		modeloAgregados.copyInto(actividades);

		modeloDisponibles = new DefaultListModel<>();

		JPanel panel = new JPanel();
//		add(panel, BorderLayout.NORTH);

		JLabel lblBuscar = new JLabel("Buscar:");
		panel.add(lblBuscar);

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

		JPanel lblNewLabel = new JPanel();
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setLayout(new BorderLayout(0, 0));

		disponibles = new JList<>();
		lblNewLabel.add(disponibles, BorderLayout.NORTH);

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

		JPanel lblNewLabel_2 = new JPanel();
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setLayout(new BorderLayout(0, 0));

		agregados = new JList<>();
		lblNewLabel_2.add(agregados, BorderLayout.NORTH);
		disponibles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		agregados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
