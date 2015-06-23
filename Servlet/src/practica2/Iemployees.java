/**
 * 
 */
package practica2;

import java.util.List;

/**
 * En esta interface se utilizará en concreto para el servicio de listar
 * empleados por departamentos.
 * 
 * @author Alexander acanda
 * @version Version 1.0
 *
 */
@SuppressWarnings("rawtypes")
public interface Iemployees extends CRUD {

	/**
	 * Devuelve un listado del departamento recibido por parámetro
	 * 
	 * @param department
	 *            tipo short (Object)
	 * @return
	 */
	public List<Employees> listadoPorDepartamento(Object department);

}
