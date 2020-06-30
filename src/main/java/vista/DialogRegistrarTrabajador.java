package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DialogRegistrarTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private PanelDatosPersona panelPersona;
	private PanelDatosDireccion panelDireccion;
	private PanelHorario panelHorario;
	private PanelTipoTrabajador panelTipoTra;

	public DialogRegistrarTrabajador() {
		setModal(true);
		setBounds(100, 100, 648, 474);
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
		gbc_panel2.gridwidth = 2;
		gbc_panel2.insets = new Insets(0, 0, 0, 5);
		gbc_panel2.fill = GridBagConstraints.VERTICAL;
		gbc_panel2.gridx = 0;
		gbc_panel2.gridy = 2;
		contentPanel.add(panelTipoTra, gbc_panel2);
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("Guardar");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		validate();
	}

}
