package practica2;

import org.hibernate.Session;

/**
 * USAMOS SESSION PARA ABRIR LA SESION DE CADA CLASE.
 * 
 * @author Alexander Acanda
 *
 */
public class SuperClassDAO {
	private Session sesion = null;

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}

}
