package modelo;

public class Permiso {
private Integer cve;
private String nombre;
private String desc;
private String tipo;

public Permiso() {
	
	super();
	// TODO Auto-generated constructor stub
}

public Permiso(Integer clave) {
	super();
	this.cve=clave;
}


public Permiso(Integer cve, String nombre, String desc, String tipo) {
	super();
	this.cve = cve;
	this.nombre = nombre;
	this.desc = desc;
	this.tipo = tipo;
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

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

@Override
public String toString() {
	return "Permiso [cve=" + cve + ", nombre=" + nombre + ", desc=" + desc + ", tipo=" + tipo + "]";
}


}
