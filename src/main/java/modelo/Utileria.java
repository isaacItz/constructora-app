package modelo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JTextField;

public class Utileria {

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
		System.out.println(time);
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

}
