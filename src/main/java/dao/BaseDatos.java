package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

public class BaseDatos {

	private Connection conexion;
	private final String DEFAULT_URL = "jdbc:mysql://lughub.duckdns.org:3306/consC?serverTimezone=UTC";

	private TrabajadorConDAO trabajadorConDAO;
	private PersonaDAO personaDAO;
	private ActividadesDAO actividadesDAO;
	private HorarioDAO horarioDAO;
	private DiaHoraDAO diaHoraDAO;
	private EstadoDAO estadoDAO;
	private CiudadDAO ciudadDAO;
	private ColoniaDAO coloniaDAO;
	private DireccionDao direccionDAO;
	private PuedoHacerDAO puedoHacerDAO;

	public static final String ROLES[] = { "Secretaria", "Chalan" };

	public BaseDatos(String user, char[] password, String host, Integer port)
			throws SQLException, CommunicationsException {
		if (user != null || password != null) {

			if (host == null || port == null)
				conexion = DriverManager.getConnection(DEFAULT_URL, user, String.valueOf(password));
			else
				conexion = DriverManager.getConnection("jdbc:mysql://" + host + port + "/consC?serverTimezone=UTC",
						user, String.valueOf(password));
			System.out.println("conexion creada");
			System.out.println("rol: " + getRoll());
			conexion.setAutoCommit(false);
		}

		else {
			throw new SQLException("No Username or Password Provided");
		}

	}

	public DireccionDao getDireccionDAO() {
		if (direccionDAO == null)
			direccionDAO = new DireccionDao(conexion);
		return direccionDAO;
	}

	public ActividadesDAO getActividadesDAO() {
		if (actividadesDAO == null)
			actividadesDAO = new ActividadesDAO(conexion);
		return actividadesDAO;
	}

	public PuedoHacerDAO getPuedoHacerDAO() {
		if (puedoHacerDAO == null)
			puedoHacerDAO = new PuedoHacerDAO(conexion);

		return puedoHacerDAO;
	}

	public ColoniaDAO getColoniaDAO() {
		if (coloniaDAO == null)
			coloniaDAO = new ColoniaDAO(conexion);
		return coloniaDAO;
	}

	public HorarioDAO getHorarioDAO() {
		if (horarioDAO == null)
			horarioDAO = new HorarioDAO(conexion);
		return horarioDAO;
	}

	public DiaHoraDAO getDiaHoraDAO() {
		if (diaHoraDAO == null) {
			diaHoraDAO = new DiaHoraDAO(conexion);
		}
		return diaHoraDAO;
	}

	public EstadoDAO getEstadoDAO() {
		if (estadoDAO == null)
			estadoDAO = new EstadoDAO(conexion);
		return estadoDAO;
	}

	public CiudadDAO getCiudadDAO() {
		if (ciudadDAO == null)
			ciudadDAO = new CiudadDAO(conexion);

		return ciudadDAO;
	}

	public TrabajadorConDAO getTrabajadorConDAO() {
		if (trabajadorConDAO == null) {
			trabajadorConDAO = new TrabajadorConDAO(conexion);
		}
		return trabajadorConDAO;
	}

	public PersonaDAO getPersonaDAO() {
		if (personaDAO == null) {
			personaDAO = new PersonaDAO(conexion);
		}
		return personaDAO;
	}

	public void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getConnection() {
		return conexion;
	}

	public String getRoll() {
		String[] roles = { "secretaria", "administrador", "albañil", "jefe obra", "cliente" };

		for (String string : roles) {
			if (probarRol(string))
				return string;
		}
		return null;
	}

	private boolean probarRol(String rol) {
		Statement st;
		try {
			st = conexion.createStatement();
			return st.execute("show grants for current_user() USING " + rol);
		} catch (SQLException e) {
			return false;
		}

	}

}
