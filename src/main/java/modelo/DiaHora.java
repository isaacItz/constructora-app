package modelo;

import java.time.LocalDateTime;

public class DiaHora {
	private Integer cve;
	private int dia;
	private LocalDateTime horen;
	private LocalDateTime horsal;
	private int cveHor;
	
	public DiaHora() {
		// TODO Auto-generated constructor stub
	}

	public DiaHora(Integer cve) {
		super();
		this.cve = cve;
	}

	public DiaHora(Integer cve, int dia, LocalDateTime horen, LocalDateTime horsal, int cveHor) {
		super();
		this.cve = cve;
		this.dia = dia;
		this.horen = horen;
		this.horsal = horsal;
		this.cveHor = cveHor;
	}

	public Integer getCve() {
		return cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public LocalDateTime getHoren() {
		return horen;
	}

	public void setHoren(LocalDateTime horen) {
		this.horen = horen;
	}

	public LocalDateTime getHorsal() {
		return horsal;
	}

	public void setHorsal(LocalDateTime horsal) {
		this.horsal = horsal;
	}

	public int getCveHor() {
		return cveHor;
	}

	public void setCveHor(int cveHor) {
		this.cveHor = cveHor;
	}

	@Override
	public String toString() {
		return "DiaHora [cve=" + cve + ", dia=" + dia + ", horen=" + horen + ", horsal=" + horsal + ", cveHor=" + cveHor
				+ "]";
	}
	
}
