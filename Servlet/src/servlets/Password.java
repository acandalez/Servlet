package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servlets.clases.Passwords;

/**
 * Servlet implementation class Password
 */
@WebServlet("/Password")
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Password() {
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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Creamos un objeto de passwords
		Passwords pass = null;

		String passwordd = request.getParameter("pass");
		// Le asignamos al objeto pass el objeto con el parametro passwords
		pass = new Passwords(passwordd);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		if (pass.esPasswordBuena()) {

			pw.print("<strong><br>Tu contraseña es:</strong> "
					+ passwordd
					+ " <strong>tipo de fortaleza Segura</strong><br><br><strong><i>Si quieres una contraseña segura debe contener:<br> Minimo 9 caracteres de los cuales 3 son mayusculas, 3 minusculas y 3 numeros.</strong></i><br><br><strong><i>Si quieres una contraseña regular debe contener:<br> Minimo 6 caracteres de los cuales 2 son mayusculas, 2 minusculas y 2 numeros.</strong></i><br><br><strong><i>Si quieres una contraseña insegura debe contener:<br> Minimo 3 caracteres de los cuales 1 son mayusculas, 1 minusculas y 1 numeros.</strong></i><br><br><br><a href=http://172.16.1.100:8081/Servlet/password.html>Volver</a>"
					+ " <br> Fecha de hoy: " + (new Date()));
			// pw.println("<br><strong><i>Si quieres una contraseña segura debe contener:<br> Minimo 9 caracteres de los cuales 3 son mayusculas, 3 minusculas y 3 numeros.</strong></i><br><br><strong><i>Si quieres una contraseña regular debe contener:<br> Minimo 6 caracteres de los cuales 2 son mayusculas, 2 minusculas y 2 numeros.</strong></i><br><br><strong><i>Si quieres una contraseña insegura debe contener:<br> Minimo 3 caracteres de los cuales 1 son mayusculas, 1 minusculas y 1 numeros.</strong></i>");
			log.info("Password Buena: " + passwordd);
		}

		else {
			ServletContext context = getServletContext();
			request.getRequestDispatcher("/PasswordRegular").include(request,
					response);
			pw.println("<br><strong><i>Si quieres una contraseña segura debe contener:<br> Minimo 9 caracteres de los cuales 3 son mayusculas, 3 minusculas y 3 numeros.</strong></i><br><br><strong><i>Si quieres una contraseña regular debe contener:<br> Minimo 6 caracteres de los cuales 2 son mayusculas, 2 minusculas y 2 numeros.</strong></i><br><br><strong><i>Si quieres una contraseña insegura debe contener:<br> Minimo 3 caracteres de los cuales 1 son mayusculas, 1 minusculas y 1 numeros.</strong></i><br><br><br><a href=http://172.16.1.100:8081/Servlet/password.html>Volver</a>"
					+ " <br> Fecha de hoy: " + (new Date()));
		}
	}

}
