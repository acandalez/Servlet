package servlets.clases;

public class PasswordsMala {
	/**
	 * @param args
	 */
	String password = null;
	final static int passLengthMin = 2; // con esto defino el num min de
										// caracteres de mi password para
										// considerarlo seguro
	final static int passMayusMin = 1; // con esto defino el numero minimo de
										// mayusculas de mi password para
										// considerarlo seguro
	final static int passMinusMin = 1;// con esto defino el numero minimo de
										// minusculas de mi password para
										// considerarlo seguro
	final static int passNumMin = 1; // con esto defino el numero minimo de
										// numeros de mi password para
										// considerarlo seguro

	public PasswordsMala(String pass) {

		this.password = pass;

	}

	public static boolean estosCohinciden(char letra, String cadena) {
		boolean rpta = false;
		boolean hacer = true;
		int longitud = cadena.length();
		int i = 0;

		do {
			if (letra == cadena.charAt(i)) {
				rpta = true;
				hacer = false;
			}
			i++;
			if (i == longitud) {
				hacer = false;
			}
		} while (hacer);

		return rpta;
	}

	public boolean esPasswordMala() { // con esto establesco si la password es
										// segura o no

		int longitud = 0;

		boolean rpta = false;
		int numeroMayus = 0;
		int numeroMinus = 0;
		int numeroNum = 0;
		String num = null;
		num = "0123456789";
		String mayus = null;
		mayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String minus = null;
		minus = "abcdefghijklmnopqrstuvwxyz";

		longitud = password.length();
		for (int i = 0; i < longitud; i++) {
			/*
			 * if (esNum(password.charAt(i))) numeroNum++; if
			 * (esMayuscula(password.charAt(i))) numeroMayus++; if
			 * (esMinuscula(password.charAt(i))) numeroMinus++;
			 */
			if (estosCohinciden(password.charAt(i), num))
				numeroNum++;
			if (estosCohinciden(password.charAt(i), mayus))
				numeroMayus++;
			if (estosCohinciden(password.charAt(i), minus))
				numeroMinus++;
			if ((longitud >= passLengthMin) && (numeroMayus >= passMayusMin)
					&& (numeroMinus >= passMinusMin)
					&& (numeroNum >= passNumMin)) {
				rpta = true;
			} else {
				rpta = false;
			}
		}
		// System.out.println(numeroMayus+" "+numeroMinus+" "+numeroNum); //Con
		// esto compruebo los contadores
		// System.out.println(password);
		// System.out.println(password.charAt(1));
		return rpta;
	}

}
