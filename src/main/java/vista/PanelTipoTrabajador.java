package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import dao.BaseDatos;
import modelo.TrabajadorCon;
import modelo.Utileria;

public class PanelTipoTrabajador extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField sueldo;
	private JComboBox<String> roles;
	private JDateChooser finContrato;
	private JDateChooser inicioContrato;
	private JCheckBox chckbxVariable;

	public PanelTipoTrabajador() {

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("Tipo de trabajador:");
		panel.add(lblNewLabel);

		roles = new JComboBox<>();
		roles = new JComboBox<>(BaseDatos.ROLES);

		panel.add(roles);

		JLabel lblInicioDelContrato = new JLabel("Inicio del Contrato:");
		panel.add(lblInicioDelContrato);
		inicioContrato = new JDateChooser();
		panel.add(inicioContrato);

		JLabel lblFinDelContrato = new JLabel("Fin del Contrato:");
		panel.add(lblFinDelContrato);

		finContrato = new JDateChooser();
		panel.add(finContrato);

		JLabel lblSueldo = new JLabel("Sueldo:");
		panel.add(lblSueldo);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		chckbxVariable = new JCheckBox("Variable");
		chckbxVariable.addActionListener(x -> desabilitarSueldo());
		panel_1.add(chckbxVariable, BorderLayout.EAST);

		sueldo = new JTextField();
		panel_1.add(sueldo, BorderLayout.CENTER);
		sueldo.setColumns(10);
		inicioContrato.setDate(new Date());

	}

	public TrabajadorCon getTrabajador() {
		TrabajadorCon trabajador = new TrabajadorCon();
		trabajador.setFechIniCon(Utileria.getLocalDate(inicioContrato.getDate()));
		trabajador.setFechFinCon(Utileria.getLocalDate(finContrato.getDate()));
		trabajador.setPuesto(roles.getSelectedItem().toString());
		trabajador.setSalario(Utileria.getDouble(sueldo.getText()));

		return trabajador;

	}

	public boolean validar() {
		if (!Utileria.validarDateChooser(inicioContrato)) {
			Utileria.error("Fecha de Inicio no Valida");
			return false;
		}
		if (!Utileria.esMayorAHoy(inicioContrato)) {
			Utileria.error("Selecciona fecha de Inicio de Contrato Valida");
			return false;
		}

		if (!Utileria.validarDateChooser(finContrato)) {
			Utileria.error("Fecha de Fin de Contrato no Valida");
			return false;
		}
		if (!Utileria.esDespues(null, finContrato)) {
			Utileria.error("Selecciona fecha de Fin de Contrato Valida");
			return false;
		}

		if (!Utileria.esAntes(inicioContrato, finContrato)) {
			Utileria.error("La Fecha de Inicio no Puede ser Mayor a la de Fin del Contrato");
			return false;
		}

		if (!chckbxVariable.isSelected()) {
			if (!Utileria.tieneDouble(sueldo)) {
				Utileria.error("Ingrese un Sueldo Valido");
				sueldo.requestFocus();
				return false;
			}
		}

		return true;
	}

	private void desabilitarSueldo() {
		if (chckbxVariable.isSelected()) {
			sueldo.setText(null);
		}
		sueldo.setEnabled(!chckbxVariable.isSelected());
	}

	public JComboBox<String> getRoles() {
		return roles;
	}

}
