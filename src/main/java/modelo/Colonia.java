package modelo;

public class Colonia {
private Integer cve;
private String nombre;
private String tipoAsen;
private String zona;
private int cpCP;

public Colonia() {
	super();
	// TODO Auto-generated constructor stub
}
public Colonia(Integer clave) {
	super();
	this.cve=clave;
	// TODO Auto-generated constructor stub
}
public Colonia(Integer cve, String nombre, String tipoAsen, String zona) {
	super();
	this.cve = cve;
	this.nombre = nombre;
	this.tipoAsen = tipoAsen;
	this.zona = zona;
	this.cpCP=cpCP;
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
public String getTipoAsen() {
	return tipoAsen;
}
public void setTipoAsen(String tipoAsen) {
	this.tipoAsen = tipoAsen;
}
public String getZona() {
	return zona;
}
public void setZona(String zona) {
	this.zona = zona;
}

public int getCpCP() {
	return cpCP;
}
public void setCpCP(int cpCP) {
	this.cpCP = cpCP;
}
@Override
public String toString() {
	return "Colonia [cve=" + cve + ", nombre=" + nombre + ", tipoAsen=" + tipoAsen + ", zona=" + zona + ", cpCP=" + cpCP
			+ "]";
}

}
