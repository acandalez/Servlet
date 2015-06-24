package teoria;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Listeners2Sesion implements HttpSessionListener {
	private final Logger log = LogManager.getRootLogger();

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("sesionCreated");

		System.out.println("sessionCreated");

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("Sesion destruida");
		System.out.println("sessionDestroyed");

	}

}
