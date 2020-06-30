package vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelHorario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField entradaLunes;
	private JTextField entradaMartes;
	private JTextField entradaMiercoles;
	private JTextField salidaDomingo;
	private JTextField entradaJueves;
	private JTextField entradaViernes;
	private JTextField entradaSabado;
	private JTextField entradaDomingo;
	private JTextField salidaViernes;
	private JTextField salidaSabado;
	private JTextField salidaLunes;
	private JTextField salidaMartes;
	private JTextField salidaMiercoles;
	private JTextField salidaJueves;
	private boolean diario;
	private JCheckBox chckbxFijo;
	private JCheckBox chckbxVariable;
	private JButton btnLimpiar;
	private JCheckBox lunes;
	private JCheckBox martes;
	private JCheckBox miercoles;
	private JCheckBox jueves;
	private JCheckBox viernes;
	private JCheckBox sabado;
	private JCheckBox domingo;

	public PanelHorario() {
		diario = false;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblTipoDeHorario = new JLabel("Tipo de Horario: ");
		panel.add(lblTipoDeHorario);

		chckbxFijo = new JCheckBox("Fijo");
		chckbxFijo.addActionListener(x -> {
			diario = false;
			chckbxVariable.setSelected(false);
			validarCajas();
			limpiar();
		});
		chckbxFijo.setSelected(true);
		panel.add(chckbxFijo);

		chckbxVariable = new JCheckBox("Variable");
		chckbxVariable.addActionListener(x -> {
			diario = true;
			chckbxFijo.setSelected(false);
			validarCajas();
		});
		panel.add(chckbxVariable);

		btnLimpiar = new JButton("Limpiar");
		panel.add(btnLimpiar);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 66, 66, 66, 66, 66, 66, 66, 66, 0 };
		gbl_panel_1.rowHeights = new int[] { 54, 0, 54, 54, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblHora = new JLabel("Hora:");
		GridBagConstraints gbc_lblHora = new GridBagConstraints();
		gbc_lblHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblHora.gridx = 0;
		gbc_lblHora.gridy = 0;
		panel_1.add(lblHora, gbc_lblHora);

		JLabel lblLunes_1 = new JLabel("Lunes");
		GridBagConstraints gbc_lblLunes_1 = new GridBagConstraints();
		gbc_lblLunes_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLunes_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLunes_1.gridx = 1;
		gbc_lblLunes_1.gridy = 0;
		panel_1.add(lblLunes_1, gbc_lblLunes_1);

		JLabel lblSalida = new JLabel("Martes");
		GridBagConstraints gbc_lblSalida = new GridBagConstraints();
		gbc_lblSalida.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalida.gridx = 2;
		gbc_lblSalida.gridy = 0;
		panel_1.add(lblSalida, gbc_lblSalida);

		JLabel lblLunes = new JLabel("Miercoles");
		GridBagConstraints gbc_lblLunes = new GridBagConstraints();
		gbc_lblLunes.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLunes.insets = new Insets(0, 0, 5, 5);
		gbc_lblLunes.gridx = 3;
		gbc_lblLunes.gridy = 0;
		panel_1.add(lblLunes, gbc_lblLunes);

		JLabel lblNewLabel = new JLabel("Jueves");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblViernes = new JLabel("Viernes");
		GridBagConstraints gbc_lblViernes = new GridBagConstraints();
		gbc_lblViernes.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblViernes.insets = new Insets(0, 0, 5, 5);
		gbc_lblViernes.gridx = 5;
		gbc_lblViernes.gridy = 0;
		panel_1.add(lblViernes, gbc_lblViernes);

		JLabel lblSabado = new JLabel("Sabado");
		GridBagConstraints gbc_lblSabado = new GridBagConstraints();
		gbc_lblSabado.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSabado.insets = new Insets(0, 0, 5, 5);
		gbc_lblSabado.gridx = 6;
		gbc_lblSabado.gridy = 0;
		panel_1.add(lblSabado, gbc_lblSabado);

		JLabel lblEntrada = new JLabel("Domingo");
		GridBagConstraints gbc_lblEntrada = new GridBagConstraints();
		gbc_lblEntrada.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEntrada.insets = new Insets(0, 0, 5, 0);
		gbc_lblEntrada.gridx = 7;
		gbc_lblEntrada.gridy = 0;
		panel_1.add(lblEntrada, gbc_lblEntrada);

		lunes = new JCheckBox("");
		lunes.addActionListener(x -> setEnabled(entradaLunes, salidaLunes));
		GridBagConstraints gbc_lunes = new GridBagConstraints();
		gbc_lunes.insets = new Insets(0, 0, 5, 5);
		gbc_lunes.gridx = 1;
		gbc_lunes.gridy = 1;
		panel_1.add(lunes, gbc_lunes);

		martes = new JCheckBox("");
		martes.addActionListener(x -> setEnabled(entradaMartes, salidaMartes));
		GridBagConstraints gbc_martes = new GridBagConstraints();
		gbc_martes.insets = new Insets(0, 0, 5, 5);
		gbc_martes.gridx = 2;
		gbc_martes.gridy = 1;
		panel_1.add(martes, gbc_martes);

		miercoles = new JCheckBox("");
		miercoles.addActionListener(x -> setEnabled(entradaMiercoles, salidaMiercoles));
		GridBagConstraints gbc_miercoles = new GridBagConstraints();
		gbc_miercoles.insets = new Insets(0, 0, 5, 5);
		gbc_miercoles.gridx = 3;
		gbc_miercoles.gridy = 1;
		panel_1.add(miercoles, gbc_miercoles);

		jueves = new JCheckBox("");
		jueves.addActionListener(x -> setEnabled(entradaJueves, salidaJueves));
		GridBagConstraints gbc_jueves = new GridBagConstraints();
		gbc_jueves.insets = new Insets(0, 0, 5, 5);
		gbc_jueves.gridx = 4;
		gbc_jueves.gridy = 1;
		panel_1.add(jueves, gbc_jueves);

		viernes = new JCheckBox("");
		viernes.addActionListener(x -> setEnabled(entradaViernes, salidaViernes));
		GridBagConstraints gbc_viernes = new GridBagConstraints();
		gbc_viernes.insets = new Insets(0, 0, 5, 5);
		gbc_viernes.gridx = 5;
		gbc_viernes.gridy = 1;
		panel_1.add(viernes, gbc_viernes);

		sabado = new JCheckBox("");
		sabado.addActionListener(x -> setEnabled(entradaSabado, salidaSabado));
		GridBagConstraints gbc_sabado = new GridBagConstraints();
		gbc_sabado.insets = new Insets(0, 0, 5, 5);
		gbc_sabado.gridx = 6;
		gbc_sabado.gridy = 1;
		panel_1.add(sabado, gbc_sabado);

		domingo = new JCheckBox("");
		domingo.addActionListener(x -> setEnabled(entradaDomingo, salidaDomingo));
		GridBagConstraints gbc_domingo = new GridBagConstraints();
		gbc_domingo.insets = new Insets(0, 0, 5, 0);
		gbc_domingo.gridx = 7;
		gbc_domingo.gridy = 1;
		panel_1.add(domingo, gbc_domingo);

		JLabel lblEntrada_2 = new JLabel("Entrada:");
		GridBagConstraints gbc_lblEntrada_2 = new GridBagConstraints();
		gbc_lblEntrada_2.fill = GridBagConstraints.BOTH;
		gbc_lblEntrada_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblEntrada_2.gridx = 0;
		gbc_lblEntrada_2.gridy = 2;
		panel_1.add(lblEntrada_2, gbc_lblEntrada_2);

		entradaLunes = new JTextField();
		GridBagConstraints gbc_entradaLunes = new GridBagConstraints();
		gbc_entradaLunes.fill = GridBagConstraints.BOTH;
		gbc_entradaLunes.insets = new Insets(0, 0, 5, 5);
		gbc_entradaLunes.gridx = 1;
		gbc_entradaLunes.gridy = 2;
		panel_1.add(entradaLunes, gbc_entradaLunes);
		entradaLunes.setColumns(10);

		entradaMartes = new JTextField();
		entradaMartes.setColumns(10);
		GridBagConstraints gbc_entradaMartes = new GridBagConstraints();
		gbc_entradaMartes.fill = GridBagConstraints.BOTH;
		gbc_entradaMartes.insets = new Insets(0, 0, 5, 5);
		gbc_entradaMartes.gridx = 2;
		gbc_entradaMartes.gridy = 2;
		panel_1.add(entradaMartes, gbc_entradaMartes);

		entradaMiercoles = new JTextField();
		entradaMiercoles.setColumns(10);
		GridBagConstraints gbc_entradaMiercoles = new GridBagConstraints();
		gbc_entradaMiercoles.fill = GridBagConstraints.BOTH;
		gbc_entradaMiercoles.insets = new Insets(0, 0, 5, 5);
		gbc_entradaMiercoles.gridx = 3;
		gbc_entradaMiercoles.gridy = 2;
		panel_1.add(entradaMiercoles, gbc_entradaMiercoles);

		entradaJueves = new JTextField();
		entradaJueves.setColumns(10);
		GridBagConstraints gbc_entradaJueves = new GridBagConstraints();
		gbc_entradaJueves.fill = GridBagConstraints.BOTH;
		gbc_entradaJueves.insets = new Insets(0, 0, 5, 5);
		gbc_entradaJueves.gridx = 4;
		gbc_entradaJueves.gridy = 2;
		panel_1.add(entradaJueves, gbc_entradaJueves);

		entradaViernes = new JTextField();
		entradaViernes.setColumns(10);
		GridBagConstraints gbc_entradaViernes = new GridBagConstraints();
		gbc_entradaViernes.fill = GridBagConstraints.BOTH;
		gbc_entradaViernes.insets = new Insets(0, 0, 5, 5);
		gbc_entradaViernes.gridx = 5;
		gbc_entradaViernes.gridy = 2;
		panel_1.add(entradaViernes, gbc_entradaViernes);

		entradaSabado = new JTextField();
		entradaSabado.setColumns(10);
		GridBagConstraints gbc_entradaSabado = new GridBagConstraints();
		gbc_entradaSabado.fill = GridBagConstraints.BOTH;
		gbc_entradaSabado.insets = new Insets(0, 0, 5, 5);
		gbc_entradaSabado.gridx = 6;
		gbc_entradaSabado.gridy = 2;
		panel_1.add(entradaSabado, gbc_entradaSabado);

		entradaDomingo = new JTextField();
		entradaDomingo.setColumns(10);
		GridBagConstraints gbc_entradaDomingo = new GridBagConstraints();
		gbc_entradaDomingo.fill = GridBagConstraints.BOTH;
		gbc_entradaDomingo.insets = new Insets(0, 0, 5, 0);
		gbc_entradaDomingo.gridx = 7;
		gbc_entradaDomingo.gridy = 2;
		panel_1.add(entradaDomingo, gbc_entradaDomingo);

		JLabel lblSalida_1 = new JLabel("Salida:");
		GridBagConstraints gbc_lblSalida_1 = new GridBagConstraints();
		gbc_lblSalida_1.fill = GridBagConstraints.BOTH;
		gbc_lblSalida_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSalida_1.gridx = 0;
		gbc_lblSalida_1.gridy = 3;
		panel_1.add(lblSalida_1, gbc_lblSalida_1);

		salidaLunes = new JTextField();
		salidaLunes.setColumns(10);
		GridBagConstraints gbc_salidaLunes = new GridBagConstraints();
		gbc_salidaLunes.fill = GridBagConstraints.BOTH;
		gbc_salidaLunes.insets = new Insets(0, 0, 0, 5);
		gbc_salidaLunes.gridx = 1;
		gbc_salidaLunes.gridy = 3;
		panel_1.add(salidaLunes, gbc_salidaLunes);

		salidaMartes = new JTextField();
		salidaMartes.setColumns(10);
		GridBagConstraints gbc_salidaMartes = new GridBagConstraints();
		gbc_salidaMartes.fill = GridBagConstraints.BOTH;
		gbc_salidaMartes.insets = new Insets(0, 0, 0, 5);
		gbc_salidaMartes.gridx = 2;
		gbc_salidaMartes.gridy = 3;
		panel_1.add(salidaMartes, gbc_salidaMartes);

		salidaMiercoles = new JTextField();
		salidaMiercoles.setColumns(10);
		GridBagConstraints gbc_salidaMiercoles = new GridBagConstraints();
		gbc_salidaMiercoles.fill = GridBagConstraints.BOTH;
		gbc_salidaMiercoles.insets = new Insets(0, 0, 0, 5);
		gbc_salidaMiercoles.gridx = 3;
		gbc_salidaMiercoles.gridy = 3;
		panel_1.add(salidaMiercoles, gbc_salidaMiercoles);

		salidaJueves = new JTextField();
		salidaJueves.setColumns(10);
		GridBagConstraints gbc_salidaJueves = new GridBagConstraints();
		gbc_salidaJueves.fill = GridBagConstraints.BOTH;
		gbc_salidaJueves.insets = new Insets(0, 0, 0, 5);
		gbc_salidaJueves.gridx = 4;
		gbc_salidaJueves.gridy = 3;
		panel_1.add(salidaJueves, gbc_salidaJueves);

		salidaViernes = new JTextField();
		salidaViernes.setColumns(10);
		GridBagConstraints gbc_salidaViernes = new GridBagConstraints();
		gbc_salidaViernes.fill = GridBagConstraints.BOTH;
		gbc_salidaViernes.insets = new Insets(0, 0, 0, 5);
		gbc_salidaViernes.gridx = 5;
		gbc_salidaViernes.gridy = 3;
		panel_1.add(salidaViernes, gbc_salidaViernes);

		salidaSabado = new JTextField();
		salidaSabado.setColumns(10);
		GridBagConstraints gbc_salidaSabado = new GridBagConstraints();
		gbc_salidaSabado.fill = GridBagConstraints.BOTH;
		gbc_salidaSabado.insets = new Insets(0, 0, 0, 5);
		gbc_salidaSabado.gridx = 6;
		gbc_salidaSabado.gridy = 3;
		panel_1.add(salidaSabado, gbc_salidaSabado);

		salidaDomingo = new JTextField();
		salidaDomingo.setColumns(10);
		GridBagConstraints gbc_salidaDomingo = new GridBagConstraints();
		gbc_salidaDomingo.fill = GridBagConstraints.BOTH;
		gbc_salidaDomingo.gridx = 7;
		gbc_salidaDomingo.gridy = 3;
		panel_1.add(salidaDomingo, gbc_salidaDomingo);
		btnLimpiar.addActionListener(d -> limpiar());
		validarCajas();

	}

	private void validarCajas() {
		JTextField[] cajas = { entradaLunes, salidaLunes, entradaMartes, salidaMartes, entradaMiercoles,
				salidaMiercoles, entradaJueves, salidaJueves, entradaViernes, salidaViernes, entradaSabado,
				salidaSabado, entradaDomingo, salidaDomingo };
		for (JTextField caja : cajas) {
			caja.setEnabled(false);
		}

	}

	private void setEnabled(JTextField... cajas) {
		for (JTextField caja : cajas) {
			caja.setEnabled(!caja.isEnabled());
			caja.setText(null);
		}
	}

	private void limpiar() {
		JTextField[] cajas = { entradaLunes, salidaLunes, entradaMartes, salidaMartes, entradaMiercoles,
				salidaMiercoles, entradaJueves, salidaJueves, entradaViernes, salidaViernes, entradaSabado,
				salidaSabado, entradaDomingo, salidaDomingo };
		for (JTextField caja : cajas) {
			caja.setText(null);
		}
	}

}
