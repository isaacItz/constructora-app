package modelo;

public class PuedoHacer {
	private Integer cve;
	private String status;
	private int cveAct;
	private int cveTracom;
	
public PuedoHacer(){
		super();
	}

public PuedoHacer(Integer clave) {
	super();
	this.cve=clave;
}

public PuedoHacer(Integer cve, String status, int cveAct, int cveTracom) {
	super();
	this.cve = cve;
	this.status = status;
	this.cveAct = cveAct;
	this.cveTracom = cveTracom;
}

public Integer getCve() {
	return cve;
}

public void setCve(Integer cve) {
	this.cve = cve;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getCveAct() {
	return cveAct;
}

public void setCveAct(int cveAct) {
	this.cveAct = cveAct;
}

public int getCveTracom() {
	return cveTracom;
}

public void setCveTracom(int cveTracom) {
	this.cveTracom = cveTracom;
}

@Override
public String toString() {
	return "PuedoHacer [cve=" + cve + ", status=" + status + ", cveAct=" + cveAct + ", cveTracom=" + cveTracom + "]";
}

}
