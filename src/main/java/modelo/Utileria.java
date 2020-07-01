package modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Utileria {

	private static SimpleDateFormat sdt;

	public static LocalDate getLocalDate(java.util.Date fecha) {
		if (sdt == null)
			sdt = new SimpleDateFormat("yyyy-MM-dd");
		return LocalDate.parse(sdt.format(fecha));

	}

	public static Double getDouble(String num) {
		try {
			return Double.parseDouble(num);
		} catch (Exception e) {
			return 0.0;
		}
	}

	public static void error(String m) {
		JOptionPane.showMessageDialog(null, m, "Error", JOptionPane.ERROR_MESSAGE);
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

	public static boolean validarNumero(JTextField numero) {
		return getInteger(numero) == null ? false : true;
	}

}
