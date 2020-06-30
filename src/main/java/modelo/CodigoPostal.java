package modelo;

public class CodigoPostal {
private Integer cp;
private int cveCiu;
public CodigoPostal() {
	super();
	// TODO Auto-generated constructor stub
}
public CodigoPostal(Integer codigop) {
	super();
	this.cp=codigop;
	// TODO Auto-generated constructor stub
}
public CodigoPostal(Integer cp, int cveCiu) {
	super();
	this.cp = cp;
	this.cveCiu = cveCiu;
}
public Integer getCp() {
	return cp;
}
public void setCp(Integer cp) {
	this.cp = cp;
}
public int getCveCiu() {
	return cveCiu;
}
public void setCveCiu(int cveCiu) {
	this.cveCiu = cveCiu;
}
@Override
public String toString() {
	return "CodigoPostal [cp=" + cp + ", cveCiu=" + cveCiu + "]";
}

}
