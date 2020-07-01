package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.DiaHora;
import modelo.Utileria;

public class DiaHoraDAO extends DAO<DiaHora, Integer> {

	private final String INSERT = "INSERT INTO diahora (dia_diahor ,he_diahor ,hs_diahor,cve_hor ) VALUES (?, ?, ?, ?)";
	private final String MODIFICAR = "UPDATE diahora SET dia_diahor= ?, heo_diahor= ? WHERE cve_hor = ?";
	private final String OBTENER_TODOS = "SELECT * FROM diahora";
	private final String OBTENER_UNO = "SELECT * FROM diahora WHERE cve_hor = ?";
	private final String BUSCAR = "SELECT * FROM diahora WHERE cve_hor = ? ";
	private final String ELIMINAR = "DELETE FROM trabajadorcon WHERE cve_hor = ?";

	protected DiaHoraDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(DiaHora t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stat.setInt(1, t.getDia());
			stat.setTime(2, Utileria.getTime(t.getHoren()));
			stat.setTime(3, Utileria.getTime(t.getHorsal()));
			stat.setInt(4, t.getCveHor());

			if (stat.executeUpdate() == 0) {
				throw new SQLException("horario ya Registrado");
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
	public void modificar(DiaHora t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setInt(1, t.getDia());
			stat.setTime(2, Utileria.getTime(t.getHoren()));
			stat.setTime(3, Utileria.getTime(t.getHorsal()));

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
	public void eliminar(DiaHora t) throws SQLException {
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
	public DiaHora obtener(Integer clave) throws SQLException {
		DiaHora dh = null;

		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
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
	public DiaHora buscar(DiaHora objeto) throws SQLException {
		DiaHora dh = null;

		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setInt(1, objeto.getCveHor());
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
	public List<DiaHora> obtenerTodos() {
		List<DiaHora> dh = new ArrayList<>();
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

	// cve_diahor dia_diahor he_diahor hs_diahor cve_hor
	@Override
	protected DiaHora convertir(ResultSet set) throws SQLException {
		DiaHora dh = new DiaHora();
		dh.setCve(set.getInt(1));
		dh.setDia(set.getInt("dia_diahor"));
		dh.setHoren(Utileria.getLocalTime(set.getTime("he_diahor")));
		dh.setHorsal(Utileria.getLocalTime(set.getTime("hs_diahor")));
		dh.setCveHor(set.getInt("cve_hor"));

		return dh;
	}

	@Override
	public List<DiaHora> buscarPatron(DiaHora Objeto) {
		// TODO Auto-generated method stub
		return null;
	}

}
