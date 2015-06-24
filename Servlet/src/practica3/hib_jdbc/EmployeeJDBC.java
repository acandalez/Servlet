package practica3.hib_jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pool.Pool;
import practica3.Recuperable;
import dto.JDBC.EmployeesDTO;

public class EmployeeJDBC implements Recuperable {

	@SuppressWarnings("unused")
	public Object ReadEmployee(int n) throws SQLException {
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;

		EmployeesDTO employeeDTO = null;

		try {

			// registro el driver, en realidad, hago que se ejecuten unas pocas
			// líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver (new
			// oracle.jdbc.driver.OracleDriver());// método equivalente al
			// anterior
			// Sea como sea, es, <<oye, si te piden una conexión, se la pides a
			// esa clase!>>
			conn = Pool.getConnection();
			stmt = conn.createStatement();
			String instruccion = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "
					+ n;
			rset = stmt.executeQuery(instruccion);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Creamos el objeto de empleado DTO
		EmployeesDTO employee = null;
		if (rset.next()) {
			try {

				// rset.next()
				employee = new EmployeesDTO(rset.getInt(1),

				rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6),
						rset.getString(7), rset.getString(8),
						rset.getString(9), rset.getString(10),
						rset.getString(11));

			} finally {
				Pool.liberarRecursos(conn, stmt, rset);
			}

		}
		return employeeDTO;

	}

	@Override
	public Object readEmployee(int id_employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
