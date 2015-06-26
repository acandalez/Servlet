package practica5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class ServletActiveSesions
 */
@WebServlet("/ServletActiveSesions")
public class ServletActiveSesions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger log = LogManager.getRootLogger();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletActiveSesions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Recogemos el context
		ServletContext sc = getServletContext();
		// Creamos el mapa
		@SuppressWarnings({ "unchecked" })
		HashMap map = (HashMap<String, HttpSession>) sc
				.getAttribute("map_usuario");
		// RECORREMOS EL MAP | entry es el conjunto de KV entradas.
		Iterator it = map.entrySet().iterator();
		// Instanciamos la entrada.
		Map.Entry e = null;

		while (it.hasNext()) {
			e = (Entry) it.next();
			log.debug(e.getKey());
		}

	}

}
