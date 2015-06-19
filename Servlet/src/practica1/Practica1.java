package practica1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejemplopulldeconcexion.Pool;

/**
 * Servlet implementation class Practica1
 */
@WebServlet(description = "Aplicacion que nos proporciona la informacion de un empleado dada si ID", urlPatterns = { "/Practica1" })
public class Practica1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Practica1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String s_id = request.getParameter("id");
		int id = Integer.parseInt(s_id);// pasamos el string a int
		Connection cx = Pool.getConnection();
		Statement st = null;
		String nombre = null;
		ResultSet rs = null;
		try {
			st = cx.createStatement();
			String instruccion = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID ="
					+ id;
			rs = st.executeQuery(instruccion);
			if (rs.next()) {

				nombre = rs.getString("first_name");
			} else {
				nombre = "No existe nombre para esa ID";
			}
			response.setContentType("test/html");
			PrintWriter pw = response.getWriter();
			pw.println(nombre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} finally {
			Pool.liberarRecursos(cx, st, rs);
		}

		// Connection conn = null;
		// ResultSet rset = null;
		// Statement stmt = null;
		// String name = null;
		// PreparedStatement pstmt = null;
		// Pool.getInstance();
		//
		// System.out.println(request.getParameter("id_empleado"));
		// String id_empleado = request.getParameter("id_empleado");
		//
		// try {
		// conn = Pool.getConnection();
		// stmt = conn.createStatement();
		// rset = stmt.executeQuery(InstruccionesSQL.COSULTAR_EMPLEADO_X_ID);
		// pstmt.setInt(0, Integer.parseInt(id_empleado));
		//
		// if (rset.next()) {
		// response.setContentType("text/html");
		// PrintWriter pw = response.getWriter();
		// name = rset.getString("FIRST_NAME") + " "
		// + rset.getString("LAST_NAME");
		// pw.println(name + " " + rset.getString("SALARY"));
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// System.out.println("Error al recuperar el empleado.");
		// } finally {
		// Pool.liberarRecursos(conn, stmt, rset);
		// }

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
