package pruebas;

import java.time.LocalDate;

public class Prueba {

	public static void main(String... args) {

		LocalDate fecha = LocalDate.now();
		System.out.println(fecha);
		LocalDate fecha2 = LocalDate.of(1998, 11, 17);
		System.out.println(fecha2);
	}
}
