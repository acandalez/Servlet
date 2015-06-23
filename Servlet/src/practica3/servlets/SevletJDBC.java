package practica3.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejemplopulldeconcexion.Pool;

public class SevletJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SevletJDBC() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String name = null;

		Pool.getInstance();

		System.out.println(request.getParameter("id_empleado"));
		String id_empleado = request.getParameter("id_empleado");

		try {
			conn = Pool.getConnection();
			pstmt = conn
					.prepareStatement("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?");
			pstmt.setInt(0, Integer.parseInt(id_empleado));
			rset = pstmt.executeQuery();

			if (rset.next()) {

				name = rset.getString("FIRST_NAME") + " "
						+ rset.getString("LAST_NAME") + " "
						+ rset.getString("SALARY");
			} else {
				name = "No existe el empleado con ese id_empleado";
			}
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println(name);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally // libero recursos, de "adentro a fuera" , ResultSet,
					// Statment, Conexion
		{
			Pool.liberarRecursos(conn, pstmt, rset);
		}
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
