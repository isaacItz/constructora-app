package modelo;

import java.time.LocalDate;

public class Persona {

	private Integer cve;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String genero;
	private LocalDate fechaNac;
	private String edoCivil;
	private String curp;
	private String mail;
	private Long telefono;

	public Persona() {
		super();
	}

	public Persona(Integer cve) {
		super();
		this.cve = cve;
	}

	public Persona(Integer cve, String nombre, String apPaterno, String apMaterno, String genero, LocalDate fechaNac,
			String edoCivil, String curp, String mail, Long telefono) {
		super();
		this.cve = cve;
		this.nombre = nombre;
		this.edoCivil = edoCivil;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.genero = genero;
		this.fechaNac = fechaNac;
		this.curp = curp;
		this.mail = mail;
		this.telefono = telefono;
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

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEdoCivil() {
		return edoCivil;
	}

	public void setEdoCivil(String edoCivil) {
		this.edoCivil = edoCivil;
	}

	@Override
	public String toString() {
		return "Persona [cve=" + cve + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno
				+ ", genero=" + genero + ", fechaNac=" + fechaNac + ", edoCivil=" + edoCivil + ", curp=" + curp
				+ ", mail=" + mail + ", telefono=" + telefono + "]";
	}

}
