package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servlets.clases.PasswordsRegular;

/**
 * Servlet implementation class PasswordRegular
 */
@WebServlet("/PasswordRegular")
public class PasswordRegular extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PasswordRegular() {
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

		PasswordsRegular pass = null;

		String passwordd = request.getParameter("pass");
		// Le asignamos al objeto pass el objeto con el parametro passwords
		pass = new PasswordsRegular(passwordd);

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		if (pass.esPasswordRegular()) {

			pw.print("<strong><br>Tu contraseña es:</strong> " + passwordd
					+ " <strong>tipo de fortaleza Regular<br><br></strong>");
			log.info("Password Regular: " + passwordd);
		}

		else {
			ServletContext context = getServletContext();
			request.getRequestDispatcher("/PasswordMala").include(request,
					response);
			// pw.println("<br><strong><i>Si quieres una contraseña segura debe contener:<br> Minimo 9 caracteres de los cuales 3 son mayusculas, 3 minusculas y 3 numeros.</strong></i>");
		}
	}

}
