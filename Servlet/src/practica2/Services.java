package practica2;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dto.Departments;

/**
 * SERVICO INCREMENTAR SALARIO - OBTENER EMPLEADOS DE UN DEPARTAMENTO DADA SU ID
 * - OBTENER LOS EMPLEADOS MEJOR PAGADOS POR DEPARTAMENTO
 * 
 * @author Alexander Acanda
 *
 */

public class Services {

	private EmpleadoDAO empleadoDAO = null;// atributo de la clase empleadoDAO
	private DepartmentsDAO departmentsDAO = null;// atributo de la clase
													// departamentosDAO
	private SesionManager sm;
	private Session sesion;
	private Transaction transaction;

	// Creamos el constructor

	public Services() {
		// instanciamos los objetos de cada una de las clases atribuidas.
		empleadoDAO = new EmpleadoDAO();
		departmentsDAO = new DepartmentsDAO();

		// En entornos profesionales en este punto añadimos la interfas CRUD
		// para
		// hacerlo mas generico y compatible con todas las bases de datos pero
		// en esta
		// ocacion lo vamos a dejar pasar aunque en futuros proyectos
		// intentaremos
		// implementar la interfas generica y sus subinterfaces hijas.
	}

	/**
	 * Servicio incrementarSalario
	 * 
	 * @return salario de los empleados incrementado un 20%
	 */
	public boolean incrementarSalario() {
		boolean salarioincrementado = false;
		Transaction transaction = null;
		Session sesion = null;
		sesion = sm.obtenerSesionNueva();// asignamos la sesion del
											// sesionManager.
		List<Employees> lsEmDTO = null;// asignamos una array donde vamos a
										// almacenar los empleados.
		empleadoDAO.setSesion(sesion);// ?¿?********

		// Empieza la transaccion de incrementar salario
		try {
			transaction = empleadoDAO.getSesion().beginTransaction();
			lsEmDTO = empleadoDAO.readAll();// almacenamos en el array la lista
											// recogida de la BD.
			actualizarSalario(lsEmDTO);// leemos de nuevo la array pero con los
										// datos actualizados.
			transaction.commit();// verificado que todo funciona correctamente
									// hacemos que los datos se vuelquen a la BD
									// original y el estado del objeto cambie a
									// persistent.

			salarioincrementado = true;// decimos que es true cuando los cambios
										// se han ralizado correctamente.

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();// si la transaccion falla volveremos al
									// punto anterio y deshacemos los cambios
									// realizados.

		} finally {
			sm.cerrarSession(sesion); // cerramos la sesion.
		}
		// FIN DE LA TRANSACCION

		return salarioincrementado;
	}

	/**
	 * Este metodo obtiene la lista de empleados con el salario incrementado.
	 * 
	 * @param lsEmDTO
	 */
	private void actualizarSalario(List<Employees> lsEmDTO) {
		// TODO Auto-generated method stub
		// Recorremos la array de empleados para actualizar los datos antes de
		// que sean persistentes en la BD por medio de un for edge.

		for (Employees employees : lsEmDTO) {

			System.out.println("salario inicial" + employees.getSalary());

			// realizamos la operacion de multiplicarpor 1,20 para incrementar
			// el salario un 20%

			employees.setSalary(employees.getSalary().multiply(
					new BigDecimal(1.2)));// creamos un objeto de bigdecimal con
											// el valor de 1.2 para realizar la
											// operacion.
			System.out.println("Salario incrementado" + employees.getSalary());// imprimos
																				// el
																				// resultado
																				// para
																				// comrpobar
																				// que
																				// se
																				// ha
																				// incrementado
																				// correctamente.

		}

	}

	/**
	 * Este Metodo lista los empleados mejor pagados por departamento.
	 * 
	 * @return Empleados con mejor salario.
	 */
	@SuppressWarnings({ "static-access", "null" })
	public List<Employees> listarEmpleadosQueMasGanan() {
		Transaction transaction = null;
		Session sesion = null;
		List<Employees> ls = null;
		List<Departments> lsDptos = null;

		try {
			sesion = SesionManager.obtenerSesionNueva();
			empleadoDAO.setSesion(sesion);
			transaction = empleadoDAO.getSesion().beginTransaction();
			lsDptos = leerTodosLosDepartamentos(); // recuperar lista de
													// departamentos
			for (Departments dpto : lsDptos)// recorrer lista de departamentos
											// recogida
			{
				// por cada departamento buscar el empleado que más gana y
				// devolverlo
				// y meterlo en list
				ls.add(obtenerElQueMasGana(dpto)); // por cada departamento
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();// si algo ha ido mal, deshago la transacción
		} finally {
			sm.cerrarSession(sesion); // cierro la sesion
		}

		return ls;
	}

	/**
	 * Metodo que obtiene el empleado que mas gana por departamento.
	 * 
	 * @param department
	 * @return EmpleadoDTO
	 * 
	 */
	@SuppressWarnings("unused")
	private Employees obtenerElQueMasGana(Departments dpto) {
		// Creamos el objeto de empleado
		Employees employees = null;
		// Creamos el objeto que vamos a comparar para que guarde el mejor
		// sueldo por dpto.
		BigDecimal mejorSueldo = new BigDecimal(0);
		// Creamos el array donde vamos a guardar la información.
		List<Employees> ls = null;
		// Obtenemos la lista de los empleados por departamento.
		ls = empleadoDAO.listadoPorDepartamento(dpto);
		// Recorremos la lista con un foredge.
		for (Employees employee : ls) {
			// Ahora le decimos que nos guarde el que tenga el mayor salario.
			// Con intValue cambiamos el valor de BigDecimal a int para poder
			// operar.
			if (employee.getSalary().intValue() > mejorSueldo.intValue()) {

				mejorSueldo = employee.getSalary();// asignamos el salario a
													// mejorSueldo.
				employees = employee;// Lo guardamos en employees.

			}

		}

		return employees;
	}

	/**
	 * Metodo para leer la lista de todos los departamentos.
	 * 
	 * @param lsDepartments
	 */
	@SuppressWarnings("unused")
	private List<Departments> leerTodosLosDepartamentos() {
		List<Departments> lsDepartments = null;

		// Con readAll leemos todo de la misma categoria, en este caso son
		// departamentos pero lo podemos aplicar a trabajos, empleados, etc.
		lsDepartments = departmentsDAO.readAll();

		return lsDepartments;

	}

	/**
	 * Metodo para obtener empleados de un departamento dada la ID del
	 * departamento.
	 * 
	 * @param department
	 * @return Lista de Empleados del Departamento.
	 */
	@SuppressWarnings("static-access")
	public List<Employees> obtenerEmpleadosPorDepartamento(Object department) {
		// Preparamos la transaccion.
		List<Employees> ls = null;
		sesion = null;
		transaction = null;

		// Inicio de la transaccion.
		try {

			sesion = sm.obtenerSesionNueva();
			transaction = empleadoDAO.getSesion().beginTransaction();// no se
																		// porque
																		// me
																		// obliga
																		// a
																		// hacer
																		// cast.
			ls = empleadoDAO.listadoPorDepartamento(department);
			empleadoDAO.setSesion(sesion);// *****?¿?

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();// si algo ha ido mal, deshago la
									// transacción.
		} finally {
			sesion.close();
		}

		return ls;
	}

}
