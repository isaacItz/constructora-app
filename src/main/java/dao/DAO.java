package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T, K> {

	protected PreparedStatement stat;
	protected ResultSet set;
	protected String sql;
	protected Connection con;

	protected DAO(Connection con) {
		this.con = con;
	}

	public abstract void insertar(T t) throws SQLException;

	public abstract void modificar(T t) throws SQLException;

	public abstract void eliminar(T t) throws SQLException;

	public abstract T obtener(K clave) throws SQLException;

	public abstract T buscar(T objeto) throws SQLException;

	public abstract List<T> obtenerTodos();

	protected abstract T convertir(ResultSet set) throws SQLException;

	public void cerrarSt() {
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void cerrarRs() {
		if (set != null) {
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
