package modelo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Utileria {

	public static LocalDate getLocalDate(Date fecha) {
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

}
