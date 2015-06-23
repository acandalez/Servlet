package practica3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

@SuppressWarnings("serial")
public class Servlet extends HttpServlet {

	// Nuestro archivo log.
	@SuppressWarnings("unused")
	private final Logger log = LogManager.getRootLogger();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("nombre");
		String nombre = request.getParameter("nombre");

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("numero de letras" + nombre.length());

		// Hacemos referencia al contexto
		ServletContext sc = request.getServletContext();

		// Solicitamos al contexto el objeto de SessionFactory por medio del
		// getAtribute.

		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		// Abrimos la sesion
		sf.openSession();
		System.out.println("openSession");
		// Cerramos la sesion
		sf.close();
		System.out.println("close");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
