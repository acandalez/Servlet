package practica3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filters implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

		System.out.println("Se ha destruido el filtro");

	}

	// FilterChain me permite transitar de un lado a otro (cliente servidor)
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("Se ha inicializado el filtro");

	}

}
