package practica3.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.dto_hibernate.Employees;
import practica3.EmployeeService;
import practica3.Recuperable;
import practica3.hib_jdbc.EmployeeHibernateDAO;

public class ServletHibernate extends HttpServlet {

	public ServletHibernate() {
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
		EmployeeService es = new EmployeeService();
		Recuperable hb = new EmployeeHibernateDAO();

		es.setRecuperable(hb);
		Employees employee = (Employees) es.readEmployee(Integer
				.parseInt(request.getParameter("id_empleado")));

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println(employee.getFirstName());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
