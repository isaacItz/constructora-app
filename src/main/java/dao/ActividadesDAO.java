package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Actividad;

public class ActividadesDAO extends DAO<Actividad, Integer> {

	private final String INSERT = "INSERT INTO actividad (nom_act, desc_act, umedida_act) VALUES (?, ?, ?)";
	private final String MODIFICAR = "UPDATE actividad SET nom_act= ?, desc_act= ? WHERE cve_act= ?";
	private final String OBTENER_TODOS = "SELECT * FROM actividad";
	private final String OBTENER_UNO = "SELECT * FROM actividad WHERE cve_act = ?";
	private final String BUSCAR = "SELECT * FROM actividad WHERE nom_act = ?";
	private final String ELIMINAR = "DELETE FROM actividad WHERE cve_act = ?";

	ActividadesDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(Actividad t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			stat.setString(1, t.getNombre());
			stat.setString(2, t.getDescripcion());
			stat.setString(3, t.getuMedida());
			if (stat.executeUpdate() == 0) {
				throw new SQLException("Actividad ya Registrada");
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
	public void modificar(Actividad t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);

			if (stat.executeUpdate() == 0) {
				throw new SQLException("horario ya Registrado");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
		}
	}

	@Override
	public void eliminar(Actividad t) throws SQLException {
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
	// cve_diahor dia_diahor he_diahor hs_diahor cve_hor

	@Override
	public Actividad obtener(Integer clave) throws SQLException {
		Actividad dh = null;

		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
			set = stat.executeQuery();
			if (set.next()) {
				dh = convertir(set);
			} else {
				throw new SQLException("No Existe la actividad");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}

		return dh;
	}

	@Override
	public Actividad buscar(Actividad objeto) throws SQLException {
		Actividad dh = null;

		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setString(1, objeto.getNombre());
			set = stat.executeQuery();
			if (set.next()) {
				dh = convertir(set);
			} else {
				throw new SQLException("No Existe el horario");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}

		return dh;
	}

	@Override
	public List<Actividad> obtenerTodos() {
		List<Actividad> dh = new ArrayList<>();
		try {
			stat = con.prepareStatement(OBTENER_TODOS);
			set = stat.executeQuery();
			while (set.next()) {
				dh.add(convertir(set));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return dh;
	}

	@Override
	protected Actividad convertir(ResultSet set) throws SQLException {
		Actividad dh = new Actividad();
		dh.setCve(set.getInt(1));
		dh.setNombre(set.getString("nom_act"));
		dh.setDescripcion(set.getString("desc_act"));
		dh.setuMedida(set.getString("umedida_act"));

		return dh;
	}

}
