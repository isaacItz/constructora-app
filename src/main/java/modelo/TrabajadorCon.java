package modelo;

import java.time.LocalDate;

public class TrabajadorCon {

	private Integer cve;
	private LocalDate fechIniCon;
	private LocalDate fechFinCon;
	private String puesto;
	private double salario;
	private int NSS;
	private int cvePer;
	
	public TrabajadorCon() {
		// TODO Auto-generated constructor stub
	}
	public TrabajadorCon(Integer clave) {
		super();
		this.cve=clave;
	
	}
	public TrabajadorCon(Integer cve, LocalDate fechIniCon, LocalDate fechFinCon, String puesto, double salario,
			int nSS, int cvePer) {
		super();
		this.cve = cve;
		this.fechIniCon = fechIniCon;
		this.fechFinCon = fechFinCon;
		this.puesto = puesto;
		this.salario = salario;
		NSS = nSS;
		this.cvePer = cvePer;
	}
	public Integer getCve() {
		return cve;
	}
	public void setCve(Integer cve) {
		this.cve = cve;
	}
	public LocalDate getFechIniCon() {
		return fechIniCon;
	}
	public void setFechIniCon(LocalDate fechIniCon) {
		this.fechIniCon = fechIniCon;
	}
	public LocalDate getFechFinCon() {
		return fechFinCon;
	}
	public void setFechFinCon(LocalDate fechFinCon) {
		this.fechFinCon = fechFinCon;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getNSS() {
		return NSS;
	}
	public void setNSS(int nSS) {
		NSS = nSS;
	}
	public int getCvePer() {
		return cvePer;
	}
	public void setCvePer(int cvePer) {
		this.cvePer = cvePer;
	}
	@Override
	public String toString() {
		return "TrabajadorCon [cve=" + cve + ", fechIniCon=" + fechIniCon + ", fechFinCon=" + fechFinCon + ", puesto="
				+ puesto + ", salario=" + salario + ", NSS=" + NSS + ", cvePer=" + cvePer + "]";
	}
	
	
	
}
