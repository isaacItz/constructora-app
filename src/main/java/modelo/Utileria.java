package modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Utileria {

	private static SimpleDateFormat sdt;

	public static LocalDate getLocalDate(java.util.Date fecha) {
		if (sdt == null)
			sdt = new SimpleDateFormat("yyyy-MM-dd");
		return LocalDate.parse(sdt.format(fecha));

	}

	public static boolean tieneDouble(JTextField caja) {
		try {
			Double.parseDouble(caja.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void error(String m) {
		JOptionPane.showMessageDialog(null, m, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m, "Informacion", JOptionPane.INFORMATION_MESSAGE);
	}

	public static LocalDate getLocalDate(Date fecha) {
		return LocalDate.parse(fecha.toString());
	}

	public static LocalDate getLocalDate(Long time) {
		Date fecha = new Date(time);
		return LocalDate.parse(fecha.toString());
	}

	public static Date getDate(LocalDate fecha) {
		return Date.valueOf(fecha);
	}

	public static LocalTime getLocalTime(Time time) {
		return LocalTime.parse(time.toString());
	}

	public static Time getTime(LocalTime time) {
		return Time.valueOf(time);
	}

	public static Long getLong(JTextField caja) {
		try {
			return Long.parseLong(caja.getText());
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer getInteger(JTextField caja) {
		try {
			return Integer.parseInt(caja.getText());
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean validarDateChooser(JDateChooser c) {
		if (c.getDate() == null)
			return false;
		return true;
	}

	public static boolean esAntes(JDateChooser d1, JDateChooser d2) {
		LocalDate f1 = getLocalDate(d1.getDate());
		LocalDate f2 = null;
		if (d2 != null)
			f2 = getLocalDate(d2.getDate());
		else
			f2 = LocalDate.now();

		return f1.isBefore(f2);
	}

	public static boolean esDespues(JDateChooser d1, JDateChooser d2) {
		LocalDate f1 = null;
		LocalDate f2 = getLocalDate(d2.getDate());
		;
		if (d1 != null)
			f1 = getLocalDate(d2.getDate());
		else
			f1 = LocalDate.now();

		return f2.isAfter(f1);
	}

	public static boolean esMayorAHoy(JDateChooser d2) {
		LocalDate f2 = getLocalDate(d2.getDate());
		return f2.isAfter(LocalDate.now().minusDays(1));
	}

	public static boolean validarNumero(JTextField numero) {
		return getInteger(numero) == null ? false : true;
	}

	public static double getDouble(String text) {
		try {
			return Double.parseDouble(text);
		} catch (Exception e) {
		}
		return 0;
	}

}
