package practica3.hib_jdbc;

import javax.servlet.http.HttpServlet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import practica1.Employees;
import practica3.Recuperable;

@SuppressWarnings("serial")
public class EmployeeHibernateDAO extends HttpServlet implements Recuperable {

	Session session = null;

	@Override
	public Object readEmployee(int id_employee) {
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
