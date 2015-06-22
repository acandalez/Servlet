package practica2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import practica1.Employees;

@SuppressWarnings("serial")
public class EmployeeHibernateDAO extends HttpServlet implements Recuperable {

	Session session = null;

	@Override
	public Object readEmployee(int id_employee) {
		return id_employee;

	}

	@Override
	public Object readEmployee(int id_employee, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Object employee = null;

		Transaction transaction = null;

		try {
			session = SesionManager.obtenerSesionNueva();
			transaction = session.beginTransaction();

			employee = session.get(Employees.class, id_employee);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		} finally {
			SesionManager.cerrarSession(session);
		}
		return employee;
	}
}
