package modelo;

public class Actividad {

	private Integer cve;
	private String nombre;
	private String descripcion;
	private String uMedida;

	public Actividad() {
	}

	public Actividad(Integer cve, String nombre, String descripcion, String uMedida) {
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.uMedida = uMedida;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getuMedida() {
		return uMedida;
	}

	public void setuMedida(String uMedida) {
		this.uMedida = uMedida;
	}

	@Override
	public String toString() {
		return "Actividad [cve=" + cve + ", nombre=" + nombre + ", descripcion=" + descripcion + ", uMedida=" + uMedida
				+ "]";
	}

}
