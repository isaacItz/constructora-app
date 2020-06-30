package modelo;

public class Direccion {
	private Integer cve;
	private String calle;
	private String tipovia;
	private int numero;
	private String entrecalles;
	private String orientacion;
	private String referencias;
	private int cveCol;
	
	public Direccion() {
		super();
		
	}
public Direccion(Integer clave) {
	super();
	this.cve=clave;
	
}
public Direccion(Integer cve, String calle, String tipovia, int numero, String entrecalles, String orientacion,
		String referencias, int cveCol) {
	super();
	this.cve = cve;
	this.calle = calle;
	this.tipovia = tipovia;
	this.numero = numero;
	this.entrecalles = entrecalles;
	this.orientacion = orientacion;
	this.referencias = referencias;
	this.cveCol = cveCol;
}
public Integer getCve() {
	return cve;
}
public void setCve(Integer cve) {
	this.cve = cve;
}
public String getCalle() {
	return calle;
}
public void setCalle(String calle) {
	this.calle = calle;
}
public String getTipovia() {
	return tipovia;
}
public void setTipovia(String tipovia) {
	this.tipovia = tipovia;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getEntrecalles() {
	return entrecalles;
}
public void setEntrecalles(String entrecalles) {
	this.entrecalles = entrecalles;
}
public String getOrientacion() {
	return orientacion;
}
public void setOrientacion(String orientacion) {
	this.orientacion = orientacion;
}
public String getReferencias() {
	return referencias;
}
public void setReferencias(String referencias) {
	this.referencias = referencias;
}
public int getCveCol() {
	return cveCol;
}
public void setCveCol(int cveCol) {
	this.cveCol = cveCol;
}
@Override
public String toString() {
	return "Direccion [cve=" + cve + ", calle=" + calle + ", tipovia=" + tipovia + ", numero=" + numero
			+ ", entrecalles=" + entrecalles + ", orientacion=" + orientacion + ", referencias=" + referencias
			+ ", cveCol=" + cveCol + "]";
}

}
