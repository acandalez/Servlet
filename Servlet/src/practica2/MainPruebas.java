package practica2;

import java.util.ArrayList;
import java.util.List;

/**
 * METODO DE PRUEBA.
 * 
 * @author Alexander Acanda
 *
 */

public class MainPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employees> ls = new ArrayList<Employees>();
		Services sv = new Services();

		ls = sv.listarEmpleadosQueMasGanan();
		for (Employees employees : ls) {
			System.out.println(employees.toString());
		}

	}

}
