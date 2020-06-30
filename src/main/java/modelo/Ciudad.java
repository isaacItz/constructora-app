package modelo;

public class Ciudad {
	private Integer cve;
	private String munic;
	private String nombre;
	private int cveEst;
	public Ciudad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ciudad(Integer clave) {
		super();
		this.cve=clave;
		// TODO Auto-generated constructor stub
	}
	public Ciudad(Integer cve, String munic, String nombre, int cveEst) {
		super();
		this.cve = cve;
		this.munic = munic;
		this.nombre = nombre;
		this.cveEst = cveEst;
	}
	public Integer getCve() {
		return cve;
	}
	public void setCve(Integer cve) {
		this.cve = cve;
	}
	public String getMunic() {
		return munic;
	}
	public void setMunic(String munic) {
		this.munic = munic;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCveEst() {
		return cveEst;
	}
	public void setCveEst(int cveEst) {
		this.cveEst = cveEst;
	}
	@Override
	public String toString() {
		return "Ciudad [cve=" + cve + ", munic=" + munic + ", nombre=" + nombre + ", cveEst=" + cveEst + "]";
	}
	
	
}
