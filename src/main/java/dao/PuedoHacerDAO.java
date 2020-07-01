package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.PuedoHacer;

public class PuedoHacerDAO extends DAO<PuedoHacer, Integer> {

	private final String INSERT = "INSERT INTO puedohacer (status_pue, cve_act, cve_tracon) VALUES (?, ?, ?)";
	private final String MODIFICAR = "UPDATE puedohacer SET status_pue= ?, cve_act= ? WHERE cve_pue = ?";
	private final String OBTENER_TODOS = "SELECT * FROM puedohacer";
	private final String OBTENER_UNO = "SELECT * FROM puedohacer WHERE cve_pue= ?";
	private final String BUSCAR = "SELECT * FROM puedohacer WHERE cve_pue = ?";
	private final String ELIMINAR = "DELETE FROM puedohacer WHERE cve_ciu = ?";

	PuedoHacerDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(PuedoHacer t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, t.getStatus());
			stat.setInt(2, t.getCveAct());
			stat.setInt(3, t.getCveTracom());

			if (stat.executeUpdate() == 0) {
				throw new SQLException("ciudad ya Registrada");
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
	public void modificar(PuedoHacer t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setString(1, t.getStatus());
			stat.setInt(2, t.getCveTracom());

			if (stat.executeUpdate() == 0) {
				throw new SQLException("PuedoHacer ya Registrado");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
		}
	}

	@Override
	public void eliminar(PuedoHacer t) throws SQLException {
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
	public PuedoHacer obtener(Integer clave) throws SQLException {
		PuedoHacer c = null;
		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
			set = stat.executeQuery();
			if (set.next()) {
				c = convertir(set);
			} else {
				throw new SQLException("No Existe el horario");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return c;
	}

	@Override
	public PuedoHacer buscar(PuedoHacer objeto) throws SQLException {
		PuedoHacer c = null;
		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setInt(1, objeto.getCve());
			set = stat.executeQuery();
			if (set.next()) {
				c = convertir(set);
			} else {
				throw new SQLException("No Existe el horario");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return c;
	}

	@Override
	public List<PuedoHacer> obtenerTodos() {
		List<PuedoHacer> c = new ArrayList<>();
		try {
			stat = con.prepareStatement(OBTENER_TODOS);
			set = stat.executeQuery();
			while (set.next()) {
				c.add(convertir(set));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return c;
	}

	// cve_ciu mun_ciu nom_ciu cve_est
	@Override
	protected PuedoHacer convertir(ResultSet set) throws SQLException {
		PuedoHacer c = new PuedoHacer();
		c.setCve(set.getInt(1));
		c.setStatus(set.getString("status_pue"));
		c.setCveTracom(set.getInt("cve_tracon"));
		c.setCveAct(set.getInt("cve_act"));
		return c;
	}

}
