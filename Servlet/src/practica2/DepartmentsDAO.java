package practica2;

import java.util.List;

import main.dto_hibernate.Departments;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 * DEPARTAMENTOS DAO.
 * 
 * @author Alexander Acanda
 *
 */
public class DepartmentsDAO extends SuperClassDAO implements CRUD {

	private SesionManager sm;

	@Override
	public Object create(Object c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object read(Object Id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return lista de departamentos dada su id.
	 * 
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public List<Departments> readAll() {
		// TODO Auto-generated method stub
		List<Departments> ls = null;
		SQLQuery ls1 = null;

		Session conex = sm.obtenerSesionNueva();

		ls1 = conex
				.createSQLQuery(InstruccionesSQL.CONSULTAR_DEPARTAMENTO_X_ID);
		// ls =
		// this.getSesion().createSQLQuery(InstruccionesSQL.CONSULTAR_DEPARTAMENTO_X_ID);

		return ls;
	}

	public DepartmentsDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
