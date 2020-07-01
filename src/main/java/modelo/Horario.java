package modelo;

import java.time.LocalDate;

public class Horario {
	private Integer cve;
	private LocalDate fecha;
	private String tipo;
	private int cveTracon;

	public Horario() {
	}

	public Horario(Integer clave) {
		super();
		this.cve = clave;

	}

	public Horario(Integer cve, LocalDate fecha, String tipo, int cveTracon) {
		super();
		this.cve = cve;
		this.fecha = fecha;
		this.tipo = tipo;
		this.cveTracon = cveTracon;
	}

	public Integer getCve() {
		return cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCveTracon() {
		return cveTracon;
	}

	public void setCveTracon(int cveTracon) {
		this.cveTracon = cveTracon;
	}

	@Override
	public String toString() {
		return "Horario [cve=" + cve + ", fecha=" + fecha + ", tipo=" + tipo + ", cveTracon=" + cveTracon + "]";
	}

}
