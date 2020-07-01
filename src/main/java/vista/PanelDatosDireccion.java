package vista;

import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.CiudadDAO;
import dao.ColoniaDAO;
import dao.EstadoDAO;
import modelo.Ciudad;
import modelo.Colonia;
import modelo.Direccion;
import modelo.Estado;
import modelo.Main;
import modelo.Utileria;

public class PanelDatosDireccion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField numero;
	private JComboBox<String> orientacion;
	private JComboBox<String> ciudad;
	private JTextField codigoPostal;
	private JComboBox<String> colonia;
	private JTextField referencias;
	private JTextField entreCalle1;
	private JTextField entreCalle2;
	private JComboBox<String> tipoVia;
	private JComboBox<String> estado;
	private List<Estado> estados;
	private List<Ciudad> ciudades;
	private List<Colonia> cols;
	private int cp;

	public PanelDatosDireccion() {
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNombre = new JLabel("Nombre de la Calle");
		add(lblNombre);

		nombre = new JTextField();
		add(nombre);
		nombre.setColumns(10);

		JLabel lblTipoDeVia = new JLabel("Tipo de Via");
		add(lblTipoDeVia);

		tipoVia = new JComboBox<>();
		add(tipoVia);

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

		orientacion = new JComboBox<>();
		add(orientacion);

		JLabel lblNombre_3_2 = new JLabel("Referencias");
		add(lblNombre_3_2);

		referencias = new JTextField();
		add(referencias);

		JLabel lblNombre_3_3 = new JLabel("Estado");
		add(lblNombre_3_3);

		estado = new JComboBox<>();
		add(estado);

		JLabel lblNombre_3 = new JLabel("Ciudad");
		add(lblNombre_3);

		ciudad = new JComboBox<>();
		add(ciudad);

		JLabel lblNombre_1_1 = new JLabel("Codigo Postal");
		add(lblNombre_1_1);

		codigoPostal = new JTextField();
		codigoPostal.setColumns(10);
		add(codigoPostal);

		JLabel lblNombre_2_1 = new JLabel("Colonia");
		add(lblNombre_2_1);

		colonia = new JComboBox<>();
		add(colonia);
		iniciar();
		estado.addActionListener(z -> getCiudades());
		codigoPostal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!codigoPostal.getText().isEmpty())
					getCols(Utileria.getInteger(codigoPostal));
			}
		});
		codigoPostal.addActionListener(z -> getCols(Utileria.getInteger(codigoPostal)));
		getCiudades();
	}

	private void iniciar() {
		EstadoDAO daoEstado = Main.baseDatos.getEstadoDAO();
		estados = daoEstado.obtenerTodos();
		for (Estado estado2 : estados) {
			estado.addItem(estado2.getNombre());
		}
		String tipoVia[] = { "Andador", "Avenida", "Boulevard", "Calle", "Callejón", "Calzada", "Cerrada", "Circuito",
				"Continuación", "Periférico", "Privada", "Prolongación", "Retorno", "Ninguna" };
		for (String s : tipoVia) {
			this.tipoVia.addItem(s);
		}

		String orientaciones[] = { "Norte", "Sur", "Poniente", "Oriente", "Ninguno" };
		for (String string : orientaciones) {
			orientacion.addItem(string);
		}

	}

	private void getCiudades() {
		CiudadDAO daoCiudad = Main.baseDatos.getCiudadDAO();
		ciudad.removeAllItems();
		ciudades = daoCiudad.ciudadesEstado(estados.get(estado.getSelectedIndex()));
		for (Ciudad ciu : ciudades) {
			ciudad.addItem(ciu.getMunic());
		}
	}

	private Ciudad getCiudadSeleccionada() {
		return ciudades.get(ciudad.getSelectedIndex());
	}

	private Colonia getColoniaSeleccionada() {
		return cols.get(colonia.getSelectedIndex());
	}

	private void getCols(int cp) {

		if (this.cp != cp) {
			ColoniaDAO daoCols = Main.baseDatos.getColoniaDAO();
			colonia.removeAllItems();
			cols = daoCols.getColoniasCP(cp);
			for (modelo.Colonia col : cols) {
				colonia.addItem(col.getNombre());
			}
		}

	}

	private boolean validarCP() {
		if (cols.size() > 0) {
			getCiudadSeleccionada();
			if (cols.get(0).getCveCiu() == getCiudadSeleccionada().getCve()) {
				return true;
			}
		}

		return false;

	}

	public boolean validar() {
		if (nombre.getText().isEmpty()) {
			Utileria.error("Ingrese la Calle");
			nombre.requestFocus();
			return false;
		}
		if (!Utileria.validarNumero(numero)) {
			Utileria.error("Ingrese un Numero de Casa");
			numero.requestFocus();
		}
		if (ciudad.getSelectedIndex() < 0) {
			Utileria.error("Seleccione una Ciudad");
			return false;
		}

		if (codigoPostal.getText().isEmpty()) {
			Utileria.error("Ingrese un Codigo Postal");
			codigoPostal.requestFocus();
			return false;
		}
		if (!validarCP()) {
			Utileria.error("Codigo Postal no Pertenece a la Ciudad");
			codigoPostal.requestFocus();
			return false;
		}

		return true;
	}

	public Direccion getDireccion() {
		Direccion dir = new Direccion();
		dir.setCalle(nombre.getText());
		dir.setTipovia(tipoVia.getSelectedItem().toString());
		dir.setEntrecalles(entreCalle1.getText().concat(":").concat(entreCalle2.getText()));
		dir.setOrientacion(orientacion.getSelectedItem().toString());
		dir.setReferencias(referencias.getText());
		dir.setCveCol(getColoniaSeleccionada().getCve());
		return dir;
	}

}
