package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import modelo.TrabajadorCon;
import modelo.Utileria;

public class TrabajadorConDAO extends DAO<TrabajadorCon, Integer> {

	private final String INSERT = "INSERT INTO trabajadorcon (fi_tracon, ff_tracon, puesto_tracon, sueldo_tracon, cve_per) VALUES (?, ?, ?, ?, ?)";
	private final String MODIFICAR = "UPDATE trabajadorcon SET fi_tracon = ?, ff_tracon = ?, puesto_tracon = ?, sueldo_tracon = ? WHERE cve_tracon = ?";
	private final String OBTENER_TODOS = "SELECT * FROM trabajadorcon";
	private final String OBTENER_UNO = "SELECT * FROM trabajadorcon WHERE cve_tracon = ?";
	private final String BUSCAR = "SELECT * FROM trabajadorcon WHERE fi_tracon = ? AND ff_tracon = ? AND puesto_tracon= ?";
	private final String ELIMINAR = "DELETE FROM trabajadorcon WHERE cve_tracon = ?";

	TrabajadorConDAO(Connection con) {
		super(con);
	}

	@Override
	public void insertar(TrabajadorCon t) throws SQLException {

		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stat.setDate(1, Utileria.getDate(t.getFechIniCon()));
			stat.setDate(2, Utileria.getDate(t.getFechFinCon()));
			stat.setString(3, t.getPuesto());
			stat.setDouble(4, t.getSalario());
			stat.setInt(5, t.getCvePer());

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
	public void modificar(TrabajadorCon t) throws SQLException {
		// TODO Auto-generated method stub
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setDate(1, Utileria.getDate(t.getFechIniCon()));
			stat.setDate(2, Utileria.getDate(t.getFechFinCon()));
			stat.setString(3, t.getPuesto());
			stat.setDouble(4, t.getSalario());
			stat.setInt(5, t.getCvePer());
			stat.setInt(6, t.getCve());
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
	public void eliminar(TrabajadorCon t) throws SQLException {
		// TODO Auto-generated method stub
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
	public TrabajadorCon obtener(Integer clave) throws SQLException {
		TrabajadorCon tc = null;
		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
			set = stat.executeQuery();
			if (set.next()) {
				tc = convertir(set);
			} else {
				throw new SQLException("No Existe el Contrato");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		// TODO Auto-generated method stub
		return tc;
	}

	@Override
	public TrabajadorCon buscar(TrabajadorCon objeto) throws SQLException {
		// TODO Auto-generated method stub
		TrabajadorCon tc = null;
		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setDate(1, Utileria.getDate(objeto.getFechIniCon()));
			stat.setDate(2, Utileria.getDate(objeto.getFechFinCon()));
			stat.setString(3, objeto.getPuesto());
			set = stat.executeQuery();
			if (set.next()) {
				tc = convertir(set);
			} else {
				throw new SQLException("No Existe el Contrato");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return tc;
	}

	@Override
	public List<TrabajadorCon> obtenerTodos() {
		List<TrabajadorCon> contra = new ArrayList<>();
		try {
			stat = con.prepareStatement(OBTENER_TODOS);
			set = stat.executeQuery();
			while (set.next()) {
				contra.add(convertir(set));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return contra;

	}

	@Override
	protected TrabajadorCon convertir(ResultSet set) throws SQLException { // cve_tracon, fi_tracon, ff_tracon,
																			// puesto_tracon, sueldo_tracon, cve_per
		TrabajadorCon tc = new TrabajadorCon();
		tc.setCve(set.getInt(1));
		tc.setFechIniCon(Utileria.getLocalDate(set.getDate("fi_tracon")));
		tc.setFechFinCon(Utileria.getLocalDate(set.getDate("ff_tracon")));
		tc.setPuesto(set.getString("puesto_tracon"));
		tc.setSalario(set.getDouble("sueldo_tracon"));
		return tc;
	}

	public static void main(String[] args) throws CommunicationsException, SQLException {
		BaseDatos bd = new BaseDatos("isaac", "holadocker".toCharArray(), null, null);
		TrabajadorConDAO dao = new TrabajadorConDAO(bd.getConnection());
		TrabajadorCon tra = new TrabajadorCon(null, LocalDate.now(), LocalDate.now().plusDays(1000), "Chalan", 8000.0,
				2);
		System.out.println(tra);
		tra = dao.buscar(tra);
		System.out.println(tra);

	}

}
