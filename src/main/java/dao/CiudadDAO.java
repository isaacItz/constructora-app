package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Ciudad;

public class CiudadDAO extends DAO<Ciudad,Integer>{
	
	private final String INSERT = "INSERT INTO ciudad (mun_ciu ,nom_ciu ,cve_est) VALUES (?, ?, ?)";
	private final String MODIFICAR = "UPDATE ciudad SET mun_ciu= ?, nom_ciu= ? WHERE cve_est = ?";
	private final String OBTENER_TODOS = "SELECT * FROM ciudad";
	private final String OBTENER_UNO = "SELECT * FROM ciudad WHERE cve_ciu = ?";
	private final String BUSCAR = "SELECT * FROM ciudad WHERE cve_ciu = ? ";
	private final String ELIMINAR = "DELETE FROM ciudad WHERE cve_ciu = ?";

	protected CiudadDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(Ciudad t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, t.getMunic());
			stat.setString(2,t.getNombre());
			stat.setInt(3,t.getCveEst() );
			
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
	public void modificar(Ciudad t) throws SQLException {
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setString(1, t.getMunic());
			stat.setString(2,t.getNombre());
			stat.setInt(3,t.getCveEst() );
			
			if (stat.executeUpdate() == 0) {
				throw new SQLException("ciudad ya Registrado");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
		}		
	}

	@Override
	public void eliminar(Ciudad t) throws SQLException {
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
	public Ciudad obtener(Integer clave) throws SQLException {
		Ciudad c=null;
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
	public Ciudad buscar(Ciudad objeto) throws SQLException {
		Ciudad c= null;
		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setInt(1, objeto.getCve());
			set =stat.executeQuery();
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
	public List<Ciudad> obtenerTodos() {
		List<Ciudad> c=new ArrayList<>();
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
	//cve_ciu  mun_ciu nom_ciu  cve_est
	@Override
	protected Ciudad convertir(ResultSet set) throws SQLException {
		Ciudad c = new Ciudad();
		c.setCve(set.getInt(1));
		c.setMunic(set.getString("mun_ciu"));
		c.setNombre(set.getString("nom_ciu"));
		c.setCveEst(set.getInt("cve_est"));
		return null;
	}

}
