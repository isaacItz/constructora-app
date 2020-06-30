package modelo;

import java.time.LocalDate;
import java.util.Date;

public class PermisoObra {
private Integer cve;
private LocalDate fechapermob;
private LocalDate fechaIni;
private LocalDate fecaFin;
private double costopermob;
private int cvePer;
private int cveObr;
  public PermisoObra() {
	  super();
}

  public PermisoObra(Integer clave) {
	  super();
	  this.cve=clave;
  }

public PermisoObra(Integer cve, LocalDate fechapermob, LocalDate fechaIni, LocalDate fecaFin, double costopermob, Integer cvePer,
		Integer cveObr) {
	super();
	this.cve = cve;
	this.fechapermob = fechapermob;
	this.fechaIni = fechaIni;
	this.fecaFin = fecaFin;
	this.costopermob = costopermob;
	this.cvePer = cvePer;
	this.cveObr = cveObr;
}

public Integer getCve() {
	return cve;
}

public void setCve(Integer cve) {
	this.cve = cve;
}

public LocalDate getFechapermob() {
	return fechapermob;
}

public void setFechapermob(LocalDate fechapermob) {
	this.fechapermob = fechapermob;
}

public LocalDate getFechaIni() {
	return fechaIni;
}

public void setFechaIni(LocalDate fechaIni) {
	this.fechaIni = fechaIni;
}

public LocalDate getFecaFin() {
	return fecaFin;
}

public void setFecaFin(LocalDate fecaFin) {
	this.fecaFin = fecaFin;
}

public double getCostopermob() {
	return costopermob;
}

public void setCostopermob(double costopermob) {
	this.costopermob = costopermob;
}

public Integer getCvePer() {
	return cvePer;
}

public void setCvePer(Integer cvePer) {
	this.cvePer = cvePer;
}

public Integer getCveObr() {
	return cveObr;
}

public void setCveObr(Integer cveObr) {
	this.cveObr = cveObr;
}

@Override
public String toString() {
	return "PermisoObra [cve=" + cve + ", costopermob=" + costopermob + ", cvePer=" + cvePer + ", cveObr=" + cveObr
			+ "]";
}
  
}
