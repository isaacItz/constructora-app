package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Utileria {

	public static LocalDate getLocalDate(Date fecha) {
		return LocalDate.parse(fecha.toString());
	}

	public static Date getDate(LocalDate fecha) {
		return Date.valueOf(fecha);
	}

}
