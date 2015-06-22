package practica2;

public class Main {

	public static void main(String[] args) {
	
		EmployeeService es = new EmployeeService();
		Recuperable hb = new EmployeeHibernateDAO();
		
		es.setRecuperable(hb);
		es.readEmployee(150);
		
//		Recuperable jdbc = new EmployeeJDBCdao();
//		
//		es.setRecuperable(jdbc);
//		es.readEmployee(150);
//		
//		Recuperable jpa = new EmployeeJPAdao();
//		
//		es.setRecuperable(jpa);
//		es.readEmployee(150);
	}
}
