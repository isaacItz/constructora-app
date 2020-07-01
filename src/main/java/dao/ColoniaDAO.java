package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Colonia;

public class ColoniaDAO extends DAO<Colonia, Integer> {

	private final String OBTENER_TODOS = "SELECT * FROM colonia";
	private final String OBTENER_UNO = "SELECT * FROM colonia WHERE cve_col = ?";
	private final String BUSCAR = "SELECT * FROM colonia WHERE cp_cp = ? ";

	ColoniaDAO(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(Colonia t) throws SQLException {

	}

	@Override
	public void modificar(Colonia t) throws SQLException {
	}

	@Override
	public void eliminar(Colonia t) throws SQLException {

	}

	@Override
	public Colonia obtener(Integer clave) throws SQLException {
		Colonia c = null;
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
	public Colonia buscar(Colonia objeto) throws SQLException {
		Colonia c = null;
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
	public List<Colonia> obtenerTodos() {
		List<Colonia> c = new ArrayList<>();
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
	protected Colonia convertir(ResultSet set) throws SQLException {
		Colonia c = new Colonia();
		c.setCve(set.getInt(1));
		c.setNombre(set.getString("nom_col"));
		c.setTipoAsen(set.getString("tipoasen_col"));
		c.setZona(set.getString("zona_col"));
		c.setCpCP(set.getInt("cp_cp"));
		c.setCveCiu(set.getInt("cve_ciu"));
		return c;
	}

	public List<Colonia> getColoniasCP(int cp) {
		List<Colonia> c = new ArrayList<>();
		try {
			stat = con.prepareStatement(BUSCAR);
			stat.setInt(1, cp);
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

}
