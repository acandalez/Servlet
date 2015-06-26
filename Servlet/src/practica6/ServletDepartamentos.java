package practica6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import teoria.SesionManager;
import dto.Departments;

/**
 * Servlet implementation class ServletDepartamentos
 */
@WebServlet("/ServletDepartamentos")
public class ServletDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDepartamentos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session sesion = SesionManager.obtenerSesionNueva();

		List<Departments> ld = (List<Departments>) sesion
				.createSQLQuery("SELECT * FROM DEPARTMENTS")
				.addEntity(Departments.class).list();

		Departments d = null;

		PrintWriter pw = response.getWriter();

		pw.println("<select>");

		// usamos un iterador
		Iterator it = ld.iterator();

		while (it.hasNext()) {
			d = (Departments) it.next();

			pw.println("<option value=" + d.getDepartmentId() + ">"
					+ d.getDepartmentId() + "</option>");

		}

		pw.print("</select>");
	}
}
