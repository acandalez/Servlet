package practica4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pool.Pool;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		log.info("Has entrado a doPost");
		Connection cx = null;
		Statement stmt = null;
		ResultSet rset = null;
		String name = null;

		Pool.getInstance();

		try {
			cx = Pool.getConnection();
			stmt = cx.createStatement();
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String consulta = "SELECT * FROM USERS WHERE USER_NAME ='" + user
					+ "' AND USER_PASS = '" + pass + "'";
			log.info("Consulta en ejecucion");
			rset = stmt.executeQuery(consulta);

			if (rset.next() == true) {

				name = rset.getString("USER_NAME");

			} else {
				name = "no existe";
			}
			response.setContentType("text/html");
			PrintWriter at = response.getWriter();
			at.println("El parámetro se ha recogido correctamente");
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("El usuario " + name
					+ " se encuentra en la Base de Datos");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Pool.liberarRecursos(cx, stmt, rset);
		}

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("Te has logueaado correctamente");
	}

	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		super.service(arg0, arg1);
	}

}
