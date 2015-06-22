package practica2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeService implements Recuperable {

	Recuperable objetodao = null;

	@Override
	public Object readEmployee(int id_employee) {

		Object employee = null;

		employee = this.objetodao.readEmployee(id_employee);

		return employee;
	}

	public void setRecuperable(Recuperable obj) {

		this.objetodao = obj;
	}

	@Override
	public Object readEmployee(int id_employee, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
