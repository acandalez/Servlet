package practica3.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilterJDBC implements Filter {
	private Logger log = LogManager.getRootLogger();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Filtro destruido");
		log.trace("StopFilterJDBC - destroy()");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filtro iniciado");
		ServletContext sc = null;
		sc = arg0.getServletContext();

		sc = arg0.getServletContext();
		int c = (int) sc.getAttribute("contador");
		c++;
		sc.setAttribute("contador", c);
		long tiempo1 = System.currentTimeMillis();
		arg2.doFilter(arg0, arg1);
		long tiempo2 = System.currentTimeMillis();
		log.trace("FilterJDBC - doFilter() - tiempo:" + (tiempo2 - tiempo1));

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		log.trace("StartFilterJDBC - init()");
	}

}
