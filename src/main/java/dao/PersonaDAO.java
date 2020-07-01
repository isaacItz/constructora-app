package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import modelo.Persona;
import modelo.Utileria;

public class PersonaDAO extends DAO<Persona, Integer> {

	private final String INSERT = "INSERT INTO persona (nom_per, ap_per, am_per, genero_per, fnac_per, edocivil_per, curp, "
			+ "mail_per, tel_per) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String MODIFICAR = "UPDATE persona set nom_per = ?, ap_per = ?, am_per = ?, genero_per = ?, fnac_per = ?, "
			+ "edocivil_per = ?, curp = ?, mail_per = ?, tel_per = ? where cve_per = ?";
	private final String OBTENER_TODOS = "SELECT * FROM persona";
	private final String OBTENER_UNO = "select * FROM persona WHERE cve_per = ?";
	private final String BUSCAR = "SELECT * FROM persona WHERE nom_per = ?, ap_per = ?, am_per = ?, curp = ?";
	private final String ELIMINAR = "DELETE FROM persona WHERE cve_per = ?";

	PersonaDAO(Connection con) {
		super(con);
	}

	@Override
	public void insertar(Persona t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, t.getNombre());
			stat.setString(2, t.getApPaterno());
			stat.setString(3, t.getApMaterno());
			stat.setString(4, t.getGenero());
			stat.setDate(5, Utileria.getDate(t.getFechaNac()));
			stat.setString(6, t.getEdoCivil());
			stat.setString(7, t.getCurp());
			stat.setString(8, t.getMail());
			if (t.getTelefono() != null)
				stat.setLong(9, t.getTelefono());
			else
				stat.setNull(9, Types.INTEGER);
			if (stat.executeUpdate() == 0) {
				throw new SQLException("Usuario ya Registrado");
			} else {
				set = stat.getGeneratedKeys();
				if (set.next()) {
					t.setCve(set.getInt(1));
				} else {
					throw new SQLException("No se ha Podico Asignar la PK");
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
			cerrarRs();
		}
	}

	@Override
	public void modificar(Persona t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setString(1, t.getNombre());
			stat.setString(2, t.getApPaterno());
			stat.setString(3, t.getApMaterno());
			stat.setString(4, t.getGenero());
			stat.setDate(5, Utileria.getDate(t.getFechaNac()));
			stat.setString(6, t.getEdoCivil());
			stat.setString(7, t.getCurp());
			stat.setString(8, t.getMail());
			stat.setLong(9, t.getTelefono());
			stat.setInt(10, t.getCve());
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
			e.printStackTrace();
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

		BaseDatos bd = new BaseDatos("isaac", "holadocker".toCharArray(), null, null);
		PersonaDAO per = new PersonaDAO(bd.getConnection());
		Persona yo = per.obtener(1);
		yo.setNombre("Ronaldo");
		yo.setApMaterno("perez");
		yo.setMail("yoMero@myMail.com");
		yo.setCurp("micurpaquiva");
		yo.setTelefono(null);
		yo.setCve(null);
		per.insertar(yo);
		per.obtenerTodos().forEach(x -> System.out.println(x));
		System.out.println("adios");
	}

	@Override
	public List<Persona> buscarPatron(Persona Objeto) {
		// TODO Auto-generated method stub
		return null;
	}
}
