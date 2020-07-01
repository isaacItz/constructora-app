package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class VistaEmpleados extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VistaEmpleados() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 3, 0, 25));
		
		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel label_3 = new JLabel("");
		panel_1.add(label_3);
		
		JLabel label_5 = new JLabel("");
		panel_1.add(label_5);
		
		JLabel label_27 = new JLabel("");
		panel_1.add(label_27);
		
		JLabel label_28 = new JLabel("");
		panel_1.add(label_28);
		
		JLabel label_24 = new JLabel("");
		panel_1.add(label_24);
		
		JLabel lblBuscar = new JLabel("Buscar   ");
		lblBuscar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBuscar.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 30));
		panel_1.add(lblBuscar);
		
		textField = new JTextField();
		textField.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 30));
		textField.setColumns(10);
		textField.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 255), new Color(0, 0, 139), new Color(65, 105, 225), new Color(0, 191, 255)));
		panel_1.add(textField);
		
		JLabel label_18 = new JLabel("");
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("");
		panel_1.add(label_19);
		
		JLabel label_20 = new JLabel("");
		panel_1.add(label_20);
		
		JLabel label_22 = new JLabel("");
		panel_1.add(label_22);
		
		JLabel label_23 = new JLabel("");
		panel_1.add(label_23);
		
		JLabel label_16 = new JLabel("");
		panel_1.add(label_16);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblObras = new JLabel("OBRAS");
		lblObras.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 30));
		panel_2.add(lblObras, BorderLayout.NORTH);
		
		JLabel label_7 = new JLabel("     ");
		label_7.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 15));
		panel_2.add(label_7, BorderLayout.SOUTH);
		
		JLabel label_8 = new JLabel("     ");
		label_8.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 15));
		panel_2.add(label_8, BorderLayout.WEST);
		
		JLabel label_9 = new JLabel("                  ");
		label_9.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 15));
		panel_2.add(label_9, BorderLayout.EAST);
		
		JScrollPane scrollSeleccion = new JScrollPane();
		scrollSeleccion.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 30));
		panel_2.add(scrollSeleccion, BorderLayout.CENTER);
		
		JList listSel = new JList();
		listSel.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 25));
		listSel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 255), new Color(0, 0, 139), new Color(65, 105, 225), new Color(0, 191, 255)));
		panel_2.add(listSel);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPagos = new JLabel("PAGOS");
		lblPagos.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 30));
		panel_4.add(lblPagos, BorderLayout.NORTH);
		
		JLabel label_7_1 = new JLabel("     ");
		label_7_1.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 15));
		panel_4.add(label_7_1, BorderLayout.SOUTH);
		
		JLabel label_8_1 = new JLabel("     ");
		label_8_1.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 15));
		panel_4.add(label_8_1, BorderLayout.WEST);
		
		JLabel label_9_1 = new JLabel("                  ");
		label_9_1.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 15));
		panel_4.add(label_9_1, BorderLayout.EAST);
		
		JScrollPane scrollSeleccion_1 = new JScrollPane();
		scrollSeleccion_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 30));
		panel_4.add(scrollSeleccion_1, BorderLayout.CENTER);
		
		JList listSel_1 = new JList();
		listSel_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 25));
		listSel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 255), new Color(0, 0, 139), new Color(65, 105, 225), new Color(0, 191, 255)));
		panel_4.add(listSel_1);

	}

}
