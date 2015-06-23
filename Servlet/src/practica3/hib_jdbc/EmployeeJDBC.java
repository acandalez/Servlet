package practica3.hib_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import practica3.Recuperable;
import dto.Employees;

public class EmployeeJDBC implements Recuperable {

	@SuppressWarnings("unused")
	public Object ReadEmployee(int n) {
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		String FIRST_NAME = null;
		String LAST_NAME = null;
		String EMAIL = null;
		String PHONE_NUMBER = null;
		Date HIRE_DATE = null;
		String JOB_ID = null;
		int SALARY = 0;
		Employees employeeDTO = null;

		try {

			// registro el driver, en realidad, hago que se ejecuten unas pocas
			// líneas de la clase OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager.registerDriver (new
			// oracle.jdbc.driver.OracleDriver());// método equivalente al
			// anterior
			// Sea como sea, es, <<oye, si te piden una conexión, se la pides a
			// esa clase!>>
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "HR", "a693232977");
			stmt = conn.createStatement();
			String instruccion = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			rset = stmt.executeQuery(instruccion);

			ArrayList<Employees> aEmployess = new ArrayList<Employees>();

			while (rset.next()) {
				System.out.println(rset.getString(1));
				FIRST_NAME = rset.getString("FIRST_NAME");
				LAST_NAME = rset.getString("LAST_NAME");
				EMAIL = rset.getString("EMAIL");
				PHONE_NUMBER = rset.getString("PHONE_NUMBER");
				HIRE_DATE = rset.getDate("HIRE_DATE");
				JOB_ID = rset.getString("JOB_ID");
				SALARY = rset.getInt("SALARY");

				Employees newEmployee = new Employees();
				aEmployess.add(newEmployee);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally // libero recursos, de "adentro a fuera" , ResultSet,
					// Statment, Conexion
		{
			if (rset != null) {
				try {
					rset.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
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
