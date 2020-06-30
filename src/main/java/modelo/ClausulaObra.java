package modelo;

public class ClausulaObra {
	private Integer cve;
	private int cveObrc;
	private int cveCla;
	
	public ClausulaObra() {
	super();
		// TODO Auto-generated constructor stub
	}
	public  ClausulaObra(Integer clave) {
		super();
		this.cve=clave;
	}
	public ClausulaObra(Integer cve, int cveObrc, int cveCla) {
		super();
		this.cve = cve;
		this.cveObrc = cveObrc;
		this.cveCla = cveCla;
	}
	public Integer getCve() {
		return cve;
	}
	public void setCve(Integer cve) {
		this.cve = cve;
	}
	public int getCveObrc() {
		return cveObrc;
	}
	public void setCveObrc(int cveObrc) {
		this.cveObrc = cveObrc;
	}
	public int getCveCla() {
		return cveCla;
	}
	public void setCveCla(int cveCla) {
		this.cveCla = cveCla;
	}
	@Override
	public String toString() {
		return "ClausulaObra [cve=" + cve + ", cveObrc=" + cveObrc + ", cveCla=" + cveCla + "]";
	}
	
	
}
