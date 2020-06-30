package vista;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDatosDireccion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField numero;
	private JTextField orientacion;
	private JTextField ciudad;
	private JTextField codigoPostal;
	private JTextField Colonia;
	private JTextField referencias;
	private JTextField entreCalle1;
	private JTextField entreCalle2;

	public PanelDatosDireccion() {
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNombre = new JLabel("Nombre de la Calle");
		add(lblNombre);

		nombre = new JTextField();
		add(nombre);
		nombre.setColumns(10);

		JLabel lblApellidoPaterno = new JLabel("Numero");
		add(lblApellidoPaterno);

		numero = new JTextField();
		numero.setColumns(10);
		add(numero);

		JLabel lblApellidoMaterno = new JLabel("Entre Calles");
		add(lblApellidoMaterno);

		entreCalle1 = new JTextField();
		add(entreCalle1);
		entreCalle1.setColumns(10);

		JLabel label = new JLabel("");
		add(label);

		entreCalle2 = new JTextField();
		add(entreCalle2);
		entreCalle2.setColumns(10);

		JLabel lblNombre_3_1 = new JLabel("Orientacion");
		add(lblNombre_3_1);

		orientacion = new JTextField();
		orientacion.setColumns(10);
		add(orientacion);

		JLabel lblNombre_3_2 = new JLabel("Referencias");
		add(lblNombre_3_2);

		referencias = new JTextField();
		add(referencias);

		JLabel lblNombre_3_3 = new JLabel("Estado");
		add(lblNombre_3_3);

		JComboBox<String> estadoCivil = new JComboBox<>();
		estadoCivil.setModel(new DefaultComboBoxModel<String>(new String[] { "Casado", "Soltero", "Separado" }));
		add(estadoCivil);

		JLabel lblNombre_3 = new JLabel("Ciudad");
		add(lblNombre_3);

		ciudad = new JTextField();
		ciudad.setColumns(10);
		add(ciudad);

		JLabel lblNombre_1_1 = new JLabel("Codigo Postal");
		add(lblNombre_1_1);

		codigoPostal = new JTextField();
		codigoPostal.setColumns(10);
		add(codigoPostal);

		JLabel lblNombre_2_1 = new JLabel("Colonia");
		add(lblNombre_2_1);

		Colonia = new JTextField();
		Colonia.setColumns(10);
		add(Colonia);

	}

}
