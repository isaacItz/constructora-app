package modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Utileria {

	public static LocalDate getLocalDate(Date fecha) {
		return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date getDate(LocalDate fecha) {
		return new Date(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());
	}

}
