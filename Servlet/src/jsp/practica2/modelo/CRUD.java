package jsp.practica2.modelo;

import java.util.List;

/**
 * Interface Create - Read - Update - Delete. Esta interfas se utiliza en todos 
 * los DAO y de esta forma podremos utilizar nuestras clases en cualquier 
 * base de datos.
 * @author Alexander Acanda
 *
 */


public interface CRUD <Generic>{
	

		// Utilizaremos Generic para que nuestros metodos funcionen en cualquier BD.
		/**
		 * crea un registro nuevo en la Base de Datos.
		 * @param c Tipo ObjectDTO
		 * @return boolean = true = Objeto creado correctamente en la BD.
		 */
		public Object create(Generic c);
		
		
		
		// Utilizaremos Object para que funcione con cualquiera.
		/**
		 * Elimina un registro de la Base de Datos
		 * @param Id Tipo Object
		 * @return boolean = true = el registro se ha eliminiado correctamente.
		 * @throws SQLException 
		 */
		public boolean delete(Object Id);
		
		
		
		
		/**
		 * Actualiza en la Base de Datos.
		 * @param c Tipo ObjectDTO.
		 * @return boolean = true = el registro se ha actualizado correctamente en la BD.
		 */
		public boolean update(Generic c);
		
		
		
		
		/**
		 * Leer por ID
		 * @param Id tipo Object
		 * @return ObjectDTO
		 */
		public Generic read(Object Id);
		
		
		
		
		/**
		 * Recupera todos los registros de la Base de Datos
		 * @return ArrayList
		 */
		public List<Generic> readAll();
		
		
		
	}


