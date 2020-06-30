package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import com.mysql.cj.util.Util;

import modelo.BaseDatos;
import modelo.Persona;
import modelo.TrabajadorCon;
import modelo.Utileria;
public class TrabajadorConDAO extends DAO<TrabajadorCon, Integer> {
	private final String INSERT = "INSERT INTO trabajadorcon (cve_tracon, fi_tracon, ff_tracon, puesto_tracon, sueldo_tracon, cve_per) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String MODIFICAR = "UPDATE trabajadorcon set fi_tracon = ?, ff_tracon = ?, puesto_tracon = ?, sueldo_tracon = ? where cve_tracon = ?";
	private final String OBTENER_TODOS = "SELECT * FROM trabajadorcon";
	private final String OBTENER_UNO = "select * FROM trabajadorcon WHERE cve_tracon = ?";
	private final String BUSCAR = "SELECT * FROM trabajadorcon WHERE fi_tracon = ?, = ?, ff_tracon = ?, puesto_tracon= ?";
	private final String ELIMINAR = "DELETE FROM trabajadorcon WHERE cve_tracon = ?";
	
	
	protected TrabajadorConDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(TrabajadorCon t) throws SQLException {
	
		// TODO Auto-generated method stub
		
		try {
			stat = con.prepareStatement(INSERT);
			if (t.getCve() != null) {
				stat.setInt(1, t.getCve());
			} else {
				stat.setNull(1, java.sql.Types.INTEGER);
			}
			stat.setDate(2, Utileria.getDate(t.getFechIniCon()));
			stat.setDate(3, Utileria.getDate(t.getFechFinCon()));
			stat.setString(4, t.getPuesto());
			stat.setDouble(5, t.getSalario());
			stat.setInt(6, t.getCvePer());
		
			
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
	public void modificar(TrabajadorCon t) throws SQLException {
		// TODO Auto-generated method stub
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setDate(2, Utileria.getDate(t.getFechIniCon()));
			stat.setDate(3, Utileria.getDate(t.getFechFinCon()));
			stat.setString(4, t.getPuesto());
			stat.setDouble(5, t.getSalario());
			stat.setInt(6, t.getCvePer());
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
		TrabajadorCon tc =null;
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
		TrabajadorCon tc=null;
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
		List<TrabajadorCon> contra= new ArrayList<>();
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
	protected TrabajadorCon convertir(ResultSet set) throws SQLException { //cve_tracon, fi_tracon, ff_tracon, puesto_tracon, sueldo_tracon, cve_per
		TrabajadorCon tc = new TrabajadorCon();
		tc.setCve(set.getInt(1));
		tc.setFechIniCon(Utileria.getLocalDate(set.getDate("fi_tracon")));
		tc.setFechFinCon(Utileria.getLocalDate(set.getDate("ff_tracon")));
		tc.setPuesto(set.getString("puesto_tracon"));
		tc.setSalario(set.getDouble("sueldo_tracon"));
		return tc;
	}

	
}
