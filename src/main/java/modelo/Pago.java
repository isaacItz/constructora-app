package modelo;

import java.time.LocalDate;

public class Pago {
	private Integer cve;
	private double monto;
	private LocalDate fechaPag;
	private int cveCon;
	
	public Pago() {
		super();
	}

	public Pago(Integer clave) {
		super();
		this.cve=clave;
	}

	public Pago(Integer cve, double monto, LocalDate fechaPag, int cveCon) {
		super();
		this.cve = cve;
		this.monto = monto;
		this.fechaPag = fechaPag;
		this.cveCon = cveCon;
	}

	public Integer getCve() {
		return cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public LocalDate getFechaPag() {
		return fechaPag;
	}

	public void setFechaPag(LocalDate fechaPag) {
		this.fechaPag = fechaPag;
	}

	public int getCveCon() {
		return cveCon;
	}

	public void setCveCon(int cveCon) {
		this.cveCon = cveCon;
	}

	@Override
	public String toString() {
		return "Pago [cve=" + cve + ", monto=" + monto + ", fechaPag=" + fechaPag + ", cveCon=" + cveCon + "]";
	}
}
