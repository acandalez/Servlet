package practica2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Recuperable {

	Object readEmployee(int id_employee);

	Object readEmployee(int id_employee, HttpServletRequest request,
			HttpServletResponse response);
}
