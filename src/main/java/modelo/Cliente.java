package modelo;

import java.time.LocalDate;

public class Cliente {
	private Integer cve;
	private LocalDate fechaIni;
	private int cvePer;
	
	public Cliente() {
		super();
	
	}

	public Cliente(Integer clave) {
		super();
		this.cve=clave;
	}

	public Cliente(Integer cve, LocalDate fechaIni, int cvePer) {
		super();
		this.cve = cve;
		this.fechaIni = fechaIni;
		this.cvePer = cvePer;
	}

	public Integer getCve() {
		return cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public int getCvePer() {
		return cvePer;
	}

	public void setCvePer(int cvePer) {
		this.cvePer = cvePer;
	}

	@Override
	public String toString() {
		return "Cliente [cve=" + cve + ", fechaIni=" + fechaIni + ", cvePer=" + cvePer + "]";
	}
	
}
