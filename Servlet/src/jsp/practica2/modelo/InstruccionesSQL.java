package jsp.practica2.modelo;

/**
 * INSTRUCCIONES PARA LA BASE DE DATOS.
 * 
 * @author Alexander Acanda
 *
 */
public class InstruccionesSQL {

	public static final String CONSULTAR_TODOS = "select * from employees";
	public static final String CONSULTAR_EMPLEADOS_X_DEPARTAMENTOS = "select * from employees where department_id = ?";
	public static final String COSULTAR_EMPLEADO_X_ID = "select * from employees where employee_id=?";
	public static final String CONSULTAR_DEPARTAMENTO_X_ID = "select department_id, department_name from departments";

}
