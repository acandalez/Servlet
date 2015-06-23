package practica3.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;

import practica3.SesionManager;

public class Listeners1Context implements ServletContextListener {

	/**
	 * SERVLET CONTEST ES COMO UN SACO Y VIVE EN TODO EL TRANSCURSO DE LA
	 * APLICACION
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");

		ServletContext sc = arg0.getServletContext();// Es un espacio donde
		// podemos meter
		// objetos.

		// Obtengo la sesion y le asignamos el atributo.
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");

		// Cerramos la sesion.
		sf.close();

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("contextInitialized");
		// Obtengo el objeto de ServletContext
		ServletContext sc = arg0.getServletContext();// Es un espacio donde
														// podemos meter
														// objetos.
		SessionFactory sf = SesionManager.getSessionFactory();
		sc.setAttribute("sf"/* identificador */, sf/* Objeto */);

	}
}
