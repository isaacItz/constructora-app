package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Horario;
import modelo.Utileria;

public class HorarioDAO extends DAO<Horario, Integer> {

	private final String INSERT = "INSERT INTO horario (fecha_hor, tipo_hor, cve_tracon) VALUES (?, ?, ?)";
	private final String MODIFICAR = "UPDATE horario SET fecha_hor= ?, tipo_hor= ? WHERE cve_tracon = ?";
	private final String OBTENER_TODOS = "SELECT * FROM horario";
	private final String OBTENER_UNO = "SELECT * FROM horario WHERE cve_hor = ?";
	private final String BUSCAR = "SELECT * FROM horario WHERE fecha_hor = ? AND tipo_hor = ? ";
	private final String ELIMINAR = "DELETE FROM horario WHERE cve_hor = ?";

	HorarioDAO(Connection con) {
		super(con);
	}

	@Override
	public void insertar(Horario t) throws SQLException {
		// TODO Auto-generated method stub
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stat.setDate(1, Utileria.getDate(t.getFecha()));
			stat.setString(2, t.getTipo());
			stat.setInt(3, t.getCveTracon());

			if (stat.executeUpdate() == 0) {
				throw new SQLException("Horario ya Registrado");
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
	public void modificar(Horario t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setDate(1, Utileria.getDate(t.getFecha()));
			stat.setString(2, t.getTipo());

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
	public void eliminar(Horario t) throws SQLException {
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
	public Horario obtener(Integer clave) throws SQLException {
		Horario hr = null;
		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
			set = stat.executeQuery();
			if (set.next()) {
				hr = convertir(set);
			} else {
				throw new SQLException("No Existe el Contrato");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return hr;
	}

	@Override
	public Horario buscar(Horario objeto) throws SQLException {
		Horario hr = null;

		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setDate(1, Utileria.getDate(objeto.getFecha()));
			stat.setString(2, objeto.getTipo());
			set = stat.executeQuery();
			if (set.next()) {
				hr = convertir(set);
			} else {
				throw new SQLException("No Existe el Contrato");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return hr;
	}

	@Override
	public List<Horario> obtenerTodos() {
		List<Horario> hr = new ArrayList<>();

		try {
			stat = con.prepareStatement(OBTENER_TODOS);
			set = stat.executeQuery();
			while (set.next()) {
				hr.add(convertir(set));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return hr;
	}

	@Override
	protected Horario convertir(ResultSet set) throws SQLException {
		Horario hr = new Horario();
		hr.setCve(set.getInt(1));
		hr.setFecha(Utileria.getLocalDate(set.getDate("fecha_hor")));
		hr.setTipo(set.getString("tipo_hor"));
		hr.setCveTracon(set.getInt("cve_tracon"));

		return hr;
	}

}
