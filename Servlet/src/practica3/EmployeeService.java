package practica3;

public class EmployeeService implements Recuperable {

	Recuperable objetodao = null;

	@Override
	/**
	 * Metodo para leer empleado.
	 */
	public Object readEmployee(int id_employee) {
		// TODO Auto-generated method stub
		// Iniciamos un objeto de empleado
		Object employee = null;
		// le asignamos el objeto DAO y su atributo leerempleado dada su id.
		employee = this.objetodao.readEmployee(id_employee);

		return employee;
	}

	public void setRecuperable(Recuperable obj) {

		this.objetodao = obj;
	}

}
