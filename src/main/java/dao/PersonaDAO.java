package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import modelo.BaseDatos;
import modelo.Persona;
import modelo.Utileria;

public class PersonaDAO extends DAO<Persona, Integer> {

	final String INSERT = "INSERT INTO persona (cve_per, nom_per, ap_per, am_per, genero_per, fnac_per, edocivil_per, curp, "
			+ "mail_per, tel_per) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	final String MODIFICAR = "UPDATE persona set cve_per = ?, nom_per = ?, ap_per = ?, am_per = ?, genero_per = ?, fnac_per = ?, "
			+ "edocivil_per = ?, curp = ?, mail_per = ?, tel_per = ? where cve_per = ?";
	final String OBTENER_TODOS = "SELECT * FROM persona";
	final String OBTENER_UNO = "select * FROM perosna WHERE cve_per = ?";
	final String BUSCAR = "SELECT * FROM persona WHERE nom_per = ?, ap_per = ?, am_per = ?, curp = ?";
	final String ELIMINAR = "DELETE FROM persona WHERE cve_per = ?";

	public PersonaDAO(Connection con) {
		super(con);
	}

	@Override
	public void insertar(Persona t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT);
			stat.setInt(1, t.getCve());
			stat.setString(2, t.getNombre());
			stat.setString(3, t.getApPaterno());
			stat.setString(4, t.getApMaterno());
			stat.setString(5, t.getGenero());
			stat.setDate(6, Utileria.getDate(t.getFechaNac()));
			stat.setString(7, t.getEdoCivil());
			stat.setString(8, t.getCurp());
			stat.setString(9, t.getMail());
			stat.setLong(10, t.getTelefono());
			if (stat.executeUpdate() == 0) {
				throw new SQLException("Usuario ya Registrado");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
		}
	}

	@Override
	public void modificar(Persona t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setInt(1, t.getCve());
			stat.setString(2, t.getNombre());
			stat.setString(3, t.getApPaterno());
			stat.setString(4, t.getApMaterno());
			stat.setString(5, t.getGenero());
			stat.setDate(6, Utileria.getDate(t.getFechaNac()));
			stat.setString(7, t.getEdoCivil());
			stat.setString(8, t.getCurp());
			stat.setString(9, t.getMail());
			stat.setLong(10, t.getTelefono());
			if (stat.executeUpdate() == 0) {
				throw new SQLException("Usuario ya Registrado");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
		}
	}

	@Override
	public void eliminar(Persona t) throws SQLException {
		try {
			stat = con.prepareStatement(ELIMINAR);
			stat.setInt(1, t.getCve());
			if (stat.executeUpdate() == 0) {
				throw new SQLException("no se ha eliminado verificar clave");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarSt();
		}

	}

	@Override
	public Persona obtener(Integer clave) throws SQLException {
		Persona per = null;
		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
			set = stat.executeQuery();
			if (set.next()) {
				per = convertir(set);
			} else {
				throw new SQLException("No Existe la Persona");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return per;
	}

	@Override
	public Persona buscar(Persona objeto) throws SQLException {

		Persona per = null;
		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setString(1, objeto.getNombre());
			stat.setString(2, objeto.getApPaterno());
			stat.setString(3, objeto.getApMaterno());
			stat.setString(4, objeto.getCurp());
			set = stat.executeQuery();
			if (set.next()) {
				per = convertir(set);
			} else {
				throw new SQLException("No Existe la Persona");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return per;
	}

	@Override
	public List<Persona> obtenerTodos() {
		List<Persona> personas = new ArrayList<>();
		try {
			stat = con.prepareStatement(OBTENER_TODOS);
			set = stat.executeQuery();
			while (set.next()) {
				personas.add(convertir(set));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return personas;
	}

	@Override
	protected Persona convertir(ResultSet set) throws SQLException {
		Persona persona = new Persona();
		persona.setCve(set.getInt(1));
		persona.setNombre(set.getString("nom_per"));
		persona.setApPaterno(set.getString("ap_per"));
		persona.setApMaterno(set.getString("am_per"));
		persona.setGenero(set.getString("genero_per"));
		persona.setFechaNac(Utileria.getLocalDate(set.getDate("fnac_per")));
		persona.setEdoCivil(set.getString("edocivil_per"));
		persona.setCurp(set.getString("curp"));
		persona.setMail(set.getString("mail_per"));
		persona.setTelefono(set.getLong("tel_per"));

		return persona;
	}

	public static void main(String[] args) throws CommunicationsException, SQLException {

		BaseDatos bd = new BaseDatos("daniel", "TorresD21".toCharArray(), null, null);
		PersonaDAO per = new PersonaDAO(bd.getConnection());
		per.obtenerTodos().stream().forEach(x -> System.out.println(x));
	}
}
