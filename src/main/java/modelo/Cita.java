package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cita {
	private Integer cve;
	private LocalDateTime horaIn;
	private LocalDateTime horaFn;
	private LocalDate fecha;
	private int cveDirec;
	private int cveCli;
	private int cveTra;

	public Cita() {
		super();

	}

	public Cita(Integer clave) {
		super();
		this.cve = clave;
	}

	public Cita(Integer cve, LocalDateTime horaIn, LocalDateTime horaFn, LocalDate fecha, int cveDirec, int cveCli,
			int cveTra) {
		super();
		this.cve = cve;
		this.horaIn = horaIn;
		this.horaFn = horaFn;
		this.fecha = fecha;
		this.cveDirec = cveDirec;
		this.cveCli = cveCli;
		this.cveTra = cveTra;
	}

	public Integer getCve() {
		return cve;
	}

	public void setCve(Integer cve) {
		this.cve = cve;
	}

	public LocalDateTime getHoraIn() {
		return horaIn;
	}

	public void setHoraIn(LocalDateTime horaIn) {
		this.horaIn = horaIn;
	}

	public LocalDateTime getHoraFn() {
		return horaFn;
	}

	public void setHoraFn(LocalDateTime horaFn) {
		this.horaFn = horaFn;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCveDirec() {
		return cveDirec;
	}

	public void setCveDirec(int cveDirec) {
		this.cveDirec = cveDirec;
	}

	public int getCveCli() {
		return cveCli;
	}

	public void setCveCli(int cveCli) {
		this.cveCli = cveCli;
	}

	public int getCveTra() {
		return cveTra;
	}

	public void setCveTra(int cveTra) {
		this.cveTra = cveTra;
	}

	@Override
	public String toString() {
		return "Cita [cve=" + cve + ", horaIn=" + horaIn + ", horaFn=" + horaFn + ", fecha=" + fecha + ", cveDirec="
				+ cveDirec + ", cveCli=" + cveCli + ", cveTra=" + cveTra + "]";
	}

}
