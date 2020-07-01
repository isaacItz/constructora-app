package vista;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import modelo.Persona;
import modelo.Utileria;

public class PanelDatosPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField paterno;
	private JTextField materno;
	private JTextField curp;
	private JTextField mail;
	private JTextField tel;
	private JDateChooser fechaNac;
	private ButtonGroup grupo;
	private JRadioButton femenino;
	private JRadioButton masculino;
	private JComboBox<String> estadoCivil;

	public PanelDatosPersona() {
		setLayout(new GridLayout(0, 2, 0, 0));

		grupo = new ButtonGroup();

		JLabel lblNombre = new JLabel("Nombre del Empleado");
		add(lblNombre);

		nombre = new JTextField();
		add(nombre);
		nombre.setColumns(10);

		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno");
		add(lblApellidoPaterno);

		paterno = new JTextField();
		paterno.setColumns(10);
		add(paterno);

		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		add(lblApellidoMaterno);

		materno = new JTextField();
		materno.setColumns(10);
		add(materno);

		JLabel lblNombre_3_1 = new JLabel("Sexo");
		add(lblNombre_3_1);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		femenino = new JRadioButton("Femenino");
		panel.add(femenino);
		grupo.add(femenino);

		masculino = new JRadioButton("Masculino");
		panel.add(masculino);
		grupo.add(masculino);

		JLabel lblNombre_3_2 = new JLabel("Fecha de Nacimiento");
		add(lblNombre_3_2);

		fechaNac = new JDateChooser();
		add(fechaNac);

		JLabel lblNombre_3_3 = new JLabel("Estado Civil");
		add(lblNombre_3_3);

		estadoCivil = new JComboBox<>();
		estadoCivil.setModel(new DefaultComboBoxModel<String>(new String[] { "Casado", "Soltero", "Separado" }));
		add(estadoCivil);

		JLabel lblNombre_3 = new JLabel("CURP");
		add(lblNombre_3);

		curp = new JTextField();
		curp.setColumns(10);
		add(curp);

		JLabel lblNombre_1_1 = new JLabel("E-MAIL");
		add(lblNombre_1_1);

		mail = new JTextField();
		mail.setColumns(10);
		add(mail);

		JLabel lblNombre_2_1 = new JLabel("Telefono");
		add(lblNombre_2_1);

		tel = new JTextField();
		tel.setColumns(10);
		add(tel);

	}

	public Persona getPersona() {
		Persona per = new Persona();
		per.setNombre(nombre.getText());
		per.setApMaterno(materno.getText());
		per.setApPaterno(paterno.getText());
		if (femenino.isSelected())
			per.setGenero("Femenino");
		else
			per.setGenero("Masculino");
		per.setFechaNac(Utileria.getLocalDate(fechaNac.getDate().getTime()));
		per.setEdoCivil(estadoCivil.getSelectedItem().toString());
		per.setCurp(curp.getText());
		per.setMail(mail.getText());
		per.setTelefono(Utileria.getLong(tel));
		return per;
	}

}
