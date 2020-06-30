package modelo;

public class Estado {
	private Integer cve;
	private String nombre;
	public Estado() {
		// TODO Auto-generated constructor stub
	}
	public Estado(Integer clave) {
		super();
		this.cve=clave;
	}
	public Estado(Integer cve, String nombre) {
		super();
		this.cve = cve;
		this.nombre = nombre;
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
	@Override
	public String toString() {
		return "Estado [cve=" + cve + ", nombre=" + nombre + "]";
	}

	
}
