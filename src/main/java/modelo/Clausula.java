package modelo;

import java.time.LocalDate;

public class Clausula {
	private Integer cve;
	private String nombre;
	private LocalDate fechaCla;
	private String descrip;
	
	public Clausula() {
		super();
	}
	
	public Clausula(Integer clave) {
		super();
		this.cve=clave;
	}

	public Clausula(Integer cve, String nombre, LocalDate fechaCla, String descrip) {
		super();
		this.cve = cve;
		this.nombre = nombre;
		this.fechaCla = fechaCla;
		this.descrip = descrip;
	}

	public Integer getCve() {
		return cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaCla() {
		return fechaCla;
	}

	public void setFechaCla(LocalDate fechaCla) {
		this.fechaCla = fechaCla;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	@Override
	public String toString() {
		return "Clausula [cve=" + cve + ", nombre=" + nombre + ", fechaCla=" + fechaCla + ", descrip=" + descrip + "]";
	}
	
}
