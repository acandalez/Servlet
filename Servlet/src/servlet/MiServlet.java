package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author acandalez
 *
 */
public class MiServlet extends HttpServlet {
	// METODOS QUE VAMOS A SOBREESCRIBR SON DOGET Y DOPOST.

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Has llamado a doGet");

		// super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Has llamado a doPost");
		System.out.println(req.getParameter("nombre"));

		String nombre = req.getParameter("nombre");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("El numero de letras que tiene el nombre es:"
				+ nombre.length());

		// super.doPost(req, resp);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Has llamado a service()");
		super.service(arg0, arg1);
	}

}
