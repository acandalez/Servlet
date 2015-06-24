package teoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ServletSesion
 */
@WebServlet("/ServletSesion")
public class ServletSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSesion() {
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

		HttpSession sesion = null;

		sesion = request.getSession(false);

		// verificamos si tiene sesion
		if (null == sesion) {
			// con es asignamos una sesion
			sesion = request.getSession();
			log.info("Peticion sin sesion asociada");
		} else {
			log.info("Cliente con sesion asociada");

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
