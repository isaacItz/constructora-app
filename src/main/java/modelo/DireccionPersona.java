package modelo;

import java.time.LocalDate;

public class DireccionPersona {
		private Integer cve;
		private LocalDate fechaDir;
		private int cveDir;
		private int cvePer;
		
		public DireccionPersona() {
			super();
			// TODO Auto-generated constructor stub
		}
		public DireccionPersona(Integer clave) {
			super();
			this.cve=clave;
		}
		public DireccionPersona(Integer cve, LocalDate fechaDir, int cveDir, int cvePer) {
			super();
			this.cve = cve;
			this.fechaDir = fechaDir;
			this.cveDir = cveDir;
			this.cvePer = cvePer;
		}
		public Integer getCve() {
			return cve;
		}
		public void setCve(Integer cve) {
			this.cve = cve;
		}
		public LocalDate getFechaDir() {
			return fechaDir;
		}
		public void setFechaDir(LocalDate fechaDir) {
			this.fechaDir = fechaDir;
		}
		public int getCveDir() {
			return cveDir;
		}
		public void setCveDir(int cveDir) {
			this.cveDir = cveDir;
		}
		public int getCvePer() {
			return cvePer;
		}
		public void setCvePer(int cvePer) {
			this.cvePer = cvePer;
		}
		@Override
		public String toString() {
			return "DireccionPersona [cve=" + cve + ", fechaDir=" + fechaDir + ", cveDir=" + cveDir + ", cvePer="
					+ cvePer + "]";
		}
		
		
}
