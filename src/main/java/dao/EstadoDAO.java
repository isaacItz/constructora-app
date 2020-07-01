package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Estado;

public class EstadoDAO extends DAO<Estado,Integer> {
	private final String INSERT = "INSERT INTO estado (nom_est) VALUES (?)";
	private final String MODIFICAR = "UPDATE estado SET nom_est= ?";
	private final String OBTENER_TODOS = "SELECT * FROM estado";
	private final String OBTENER_UNO = "SELECT * FROM estado WHERE nom_est = ?";
	private final String BUSCAR = "SELECT * FROM estado WHERE nom_est = ? ";
	private final String ELIMINAR = "DELETE FROM estado WHERE nom_est = ?";

	protected EstadoDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(Estado t) throws SQLException {
		try {
			stat = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			
			stat.setString(1,t.getNombre());
			
			
			if (stat.executeUpdate() == 0) {
				throw new SQLException("estado ya Registrada");
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
	public void modificar(Estado t) throws SQLException {
		// TODO Auto-generated method stub
		try {
			stat = con.prepareStatement(MODIFICAR);
			stat.setString(1,t.getNombre());
			
			if (stat.executeUpdate() == 0) {
				throw new SQLException("estado ya Registrado");
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			cerrarSt();
		}		
	}

	@Override
	public void eliminar(Estado t) throws SQLException {
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
	public Estado obtener(Integer clave) throws SQLException {
		// TODO Auto-generated method stub
		Estado es=null;
		try {
			stat = con.prepareStatement(OBTENER_UNO);
			stat.setInt(1, clave);
			set = stat.executeQuery();
			if (set.next()) {
				es = convertir(set);
			} else {
				throw new SQLException("No Existe el estado");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return es;
	}

	@Override
	public Estado buscar(Estado objeto) throws SQLException {
		Estado es=null;
		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setInt(1, objeto.getCve());
			set =stat.executeQuery();
			if (set.next()) {
				es = convertir(set);
			} else {
				throw new SQLException("No Existe el estado");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return es;
	}

	@Override
	public List<Estado> obtenerTodos() {
		// TODO Auto-generated method stub
		List<Estado> es= new ArrayList<>();
		try {
			stat = con.prepareStatement(OBTENER_TODOS);
			set = stat.executeQuery();
			while (set.next()) {
				es.add(convertir(set));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRs();
			cerrarSt();
		}
		return es;
	}

	@Override
	protected Estado convertir(ResultSet set) throws SQLException {
		// TODO Auto-generated method stub
		Estado es = new Estado();
		es.setCve(set.getInt(1));
		es.setNombre(set.getString("nom_est"));
		return null;
	}

}
