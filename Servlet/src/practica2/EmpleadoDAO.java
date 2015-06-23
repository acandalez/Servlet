package practica2;

import java.util.List;

import org.hibernate.SQLQuery;

/**
 * EMPLEADO DAO.
 * 
 * @author Alexander Acanda
 *
 */
public class EmpleadoDAO extends SuperClassDAO implements Iemployees {

	private SesionManager sm;

	@Override
	/**
	 * Recibo un empleado.
	 */
	public Object create(Object c) {
		// TODO Auto-generated method stub
		boolean empleadoRecibido = false;

		return empleadoRecibido;
	}

	@Override
	/**
	 * Elimino un empleado.
	 */
	public boolean delete(Object Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Actualizo un empleado.
	 */
	public boolean update(Object c) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("static-access")
	@Override
	/**
	 * Leo un empleado.
	 */
	public Object read(Object Id) {
		// TODO Auto-generated method stub

		// creamos el objeto empleado.
		Employees em = new Employees();
		// Le asignamos una sesion y una sentencia que en este caso es leer
		// empleado dada su ID(cuando busque el empleado debe de darnos un unico
		// resultado).
		em = (Employees) sm.obtenerSesionNueva()
				.createSQLQuery(InstruccionesSQL.COSULTAR_EMPLEADO_X_ID)
				.addEntity(Employees.class).uniqueResult();

		return em;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	/**
	 * Leo todos los empleados.
	 */
	public List<Employees> readAll() {
		// TODO Auto-generated method stub
		List<Employees> ls = null;

		ls = ((SQLQuery) sm.obtenerSesionNueva().createQuery(
				InstruccionesSQL.CONSULTAR_TODOS)).addEntity(Employees.class)
				.list();// no creo que funcione, revisar

		return ls;
	}

	@Override
	/**
	 * Lista los empleados de un departamento dada su id y lo guardamos en department.
	 */
	public List<Employees> listadoPorDepartamento(Object department) {
		// TODO Auto-generated method stub
		List<Employees> ls = null;

		ls = ((SQLQuery) sm.obtenerSesionNueva().createQuery(
				InstruccionesSQL.CONSULTAR_EMPLEADOS_X_DEPARTAMENTOS
						+ department)).addEntity(Employees.class).list();

		return ls;
	}

}
