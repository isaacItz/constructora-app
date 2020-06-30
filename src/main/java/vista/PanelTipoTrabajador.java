package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class PanelTipoTrabajador extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JComboBox<String> roles;
	private JDateChooser dateChooser_1;
	private PanelPuedoHacer panelPuedoHacer;
	private String[] actividades;

	public PanelTipoTrabajador() {

		panelPuedoHacer = null;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("Tipo de trabajador:");
		panel_1.add(lblNewLabel);

		roles = new JComboBox<>();
		roles.addActionListener(x -> {
			agregarPuedoHacer();
		});
		panel_1.add(roles);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JLabel lblInicioDelContrato = new JLabel("Inicio del Contrato:");
		panel_3.add(lblInicioDelContrato);

		JDateChooser dateChooser = new JDateChooser();
		panel_3.add(dateChooser);

		JPanel panel_3_1 = new JPanel();
		panel.add(panel_3_1);

		JLabel lblFinDelContrato = new JLabel("Fin del Contrato:");
		panel_3_1.add(lblFinDelContrato);

		dateChooser_1 = new JDateChooser();
		panel_3_1.add(dateChooser_1);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JLabel lblSueldo = new JLabel("Sueldo:");
		panel_2.add(lblSueldo);

		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);

		JCheckBox chckbxVariable = new JCheckBox("Variable");
		panel_2.add(chckbxVariable);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

	}

	private void agregarPuedoHacer() {
		int index = roles.getSelectedIndex();
		if (index > -1) {
			String rol = roles.getSelectedItem().toString();
			if (rol.equals("Chalan") || rol.equals("Maestro de obra")) {
				if (panelPuedoHacer == null) {
					panelPuedoHacer = new PanelPuedoHacer(actividades);
				}
				add(panelPuedoHacer, BorderLayout.CENTER);
			} else {
				if (panelPuedoHacer != null) {
					remove(panelPuedoHacer);
				}
			}
		}
	}

}
