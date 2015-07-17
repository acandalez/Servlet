package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servlets.clases.PasswordsMala;

/**
 * Servlet implementation class PasswordRegular
 */
@WebServlet("/PasswordMala")
public class PasswordMala extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordMala() {
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

		PasswordsMala pass = null;

		String passwordd = request.getParameter("pass");
		// Le asignamos al objeto pass el objeto con el parametro passwords
		pass = new PasswordsMala(passwordd);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		if (pass.esPasswordMala()) {

			pw.print("<strong><br>Tu contraseña es:</strong> "
					+ passwordd
					+ " <strong>tipo de fortaleza MALA por no decir ES UNA M...<br><br></strong>");
			// pw.print("<strong>Tu contraseña es:</strong> " + passwordd
			// + " <strong>tipo de fortaleza INSEGURA.</strong>");

		}

		else {
			pw.print("<strong><br>Tu contraseña es:</strong> "
					+ passwordd
					+ " <strong>tipo de fortaleza INSEGURA. | NO SEAS UN MIERDA Y CREA UNA CONTRASEÑA SEGURA CACHO HUEVA.<br><br></strong>"
					+ " <br> Fecha de hoy: " + (new Date()));
			// pw.println("<br><strong><i>La contraseña introducida es insegura.<br>Tipos de contraseña: Segura debe de tener 9 caracteres de los cuales 3 son mayusculas 3 son minusculas y 3 son numeros <br> Regular: 6 caracteres minimo de los cuales 2 deben ser mayusculas, 2 minusculas y 2 numeros <br> Mala: Minimo 3 caracteres de los cuales 1 son mayusculas, 1 minusculas y 1 numeros.<br></strong></i><br><a href=http://172.16.1.100:8081/Servlet/password.html>Volver</a>");
			log.info("Password Mala: " + passwordd);
		}
	}

}
