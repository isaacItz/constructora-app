package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import modelo.Direccion;

public class DireccionDao extends DAO<Direccion, Integer> {

	private final String INSERT = "INSERT INTO direccion (calle_dir, tipovia_dir, nume_dir, entrecalles, orient_dir, referen_dir, cve_col)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String MODIFICAR = "UPDATE direccion SET calle_dir = ?, tipovia_dir = ?, entrecalles = ?, orient_dir = ?, "
			+ "referen_dir = ?, cve_col = ?, nume_dir = ? WHERE cve_dir = ?";
	private final String OBTENER_TODOS = "SELECT * FROM direccion";
	private final String OBTENER_UNO = "select * FROM direccion WHERE cve_dir = ?";
	private final String BUSCAR = "SELECT * FROM direccion WHERE nume_dir = ?, calle_dir = ?";
	private final String ELIMINAR = "DELETE FROM direccion WHERE direccion = ?";

	DireccionDao(Connection con) {
		super(con);
	}

	@Override
	public void insertar(Direccion t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			stat.setString(1, t.getCalle());
			stat.setString(2, t.getTipovia());
			stat.setInt(3, t.getNumero());
			stat.setString(4, t.getEntrecalles());
			stat.setString(5, t.getOrientacion());
			stat.setInt(7, t.getCveCol());
			if (t.getReferencias() != null)
				stat.setString(6, t.getReferencias());
			else
				stat.setNull(6, Types.VARCHAR);
			if (stat.executeUpdate() == 0) {
				throw new SQLException("Direccion ya Registrada");
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
	public void modificar(Direccion t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setString(1, t.getCalle());
			stat.setString(2, t.getTipovia());
			stat.setString(3, t.getEntrecalles());
			stat.setString(4, t.getOrientacion());
			stat.setString(5, t.getReferencias());
			stat.setInt(6, t.getCveCol());
			stat.setInt(7, t.getNumero());
			stat.setInt(8, t.getCve());
			if (stat.executeUpdate() == 0) {
				throw new SQLException("Error al modificar");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
		}
	}

	@Override
	public void eliminar(Direccion t) throws SQLException {
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
	public Direccion obtener(Integer clave) throws SQLException {
		Direccion dir = null;
		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
			set = stat.executeQuery();
			if (set.next()) {
				dir = convertir(set);
			} else {
				throw new SQLException("No Existe la Persona");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return dir;
	}

	@Override
	public Direccion buscar(Direccion objeto) throws SQLException {

		Direccion per = null;
		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setInt(1, objeto.getNumero());
			stat.setString(2, objeto.getCalle());
			set = stat.executeQuery();
			if (set.next()) {
				per = convertir(set);
			} else {
				throw new SQLException("No Existe la Direccion");
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
	public List<Direccion> obtenerTodos() {
		List<Direccion> list = new ArrayList<>();
		try {
			stat = con.prepareStatement(OBTENER_TODOS);
			set = stat.executeQuery();
			while (set.next()) {
				list.add(convertir(set));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return list;
	}

	@Override
	protected Direccion convertir(ResultSet set) throws SQLException {
		Direccion dir = new Direccion();
		dir.setCve(set.getInt(1));
		dir.setCalle(set.getString("calle_dir"));
		dir.setNumero(set.getInt("nume_dir"));
		dir.setTipovia(set.getString("tipovia_dir"));
		dir.setEntrecalles(set.getString("entrecalles"));
		dir.setOrientacion(set.getString("orient_dir"));
		dir.setReferencias(set.getString("referen_dir"));
		dir.setCveCol(set.getInt("cve_col"));

		return dir;
	}

}
