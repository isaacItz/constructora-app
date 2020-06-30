package modelo;

import java.time.LocalDate;

public class Obra {
private Integer cve;
private LocalDate fechIn;
private LocalDate fechFn;
private String tipo;
private double costo;
private int metrosCua;
private double honorarios;
private int cveCita;

public Obra() {
	super();
	// TODO Auto-generated constructor stub
}

public Obra(Integer clave) {
	super();
	this.cve=clave;
}

public Obra(Integer cve, LocalDate fechIn, LocalDate fechFn, String tipo, double costo, int metrosCua,
		double honorarios, int cveCita) {
	super();
	this.cve = cve;
	this.fechIn = fechIn;
	this.fechFn = fechFn;
	this.tipo = tipo;
	this.costo = costo;
	this.metrosCua = metrosCua;
	this.honorarios = honorarios;
	this.cveCita = cveCita;
}

public Integer getCve() {
	return cve;
}

public void setCve(Integer cve) {
	this.cve = cve;
}

public LocalDate getFechIn() {
	return fechIn;
}

public void setFechIn(LocalDate fechIn) {
	this.fechIn = fechIn;
}

public LocalDate getFechFn() {
	return fechFn;
}

public void setFechFn(LocalDate fechFn) {
	this.fechFn = fechFn;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public double getCosto() {
	return costo;
}

public void setCosto(double costo) {
	this.costo = costo;
}

public int getMetrosCua() {
	return metrosCua;
}

public void setMetrosCua(int metrosCua) {
	this.metrosCua = metrosCua;
}

public double getHonorarios() {
	return honorarios;
}

public void setHonorarios(double honorarios) {
	this.honorarios = honorarios;
}

public int getCveCita() {
	return cveCita;
}

public void setCveCita(int cveCita) {
	this.cveCita = cveCita;
}

@Override
public String toString() {
	return "Obra [cve=" + cve + ", fechIn=" + fechIn + ", fechFn=" + fechFn + ", tipo=" + tipo + ", costo=" + costo
			+ ", metrosCua=" + metrosCua + ", honorarios=" + honorarios + ", cveCita=" + cveCita + "]";
}


}
