package modelo;

public class Colonia {
	private Integer cve;
	private String nombre;
	private String tipoAsen;
	private String zona;
	private int cpCP;
	private int cveCiu;

	public Colonia() {
		super();
	}

	public Colonia(Integer clave) {
		super();
		this.cve = clave;
	}

	public Colonia(Integer cve, String nombre, String tipoAsen, String zona, int cpCP, int cveCiu) {
		super();
		this.cve = cve;
		this.nombre = nombre;
		this.tipoAsen = tipoAsen;
		this.zona = zona;
		this.cpCP = cpCP;
		this.cveCiu = cveCiu;
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

	public int getCveCiu() {
		return cveCiu;
	}

	public void setCveCiu(int cveCiu) {
		this.cveCiu = cveCiu;
	}

	@Override
	public String toString() {
		return "Colonia [cve=" + cve + ", nombre=" + nombre + ", tipoAsen=" + tipoAsen + ", zona=" + zona + ", cpCP="
				+ cpCP + ", cveCiu=" + cveCiu + "]";
	}

}
