package practica1;

import java.util.Date;

public class Employees {
	// PONER LOS ATRIBUTOS DE LOS ID

	private String FIRST_NAME;
	private String LAST_NAME;
	private String EMAIL;
	private String PHONE_NUMBER;
	private Date HIRE_DATE;
	private String JOB_ID;
	private int SALARY;
	private int COMMISSION_PCT;
	private int MANAGER_ID;
	private int DEPARTMENT_ID;

	public Employees(String FIRST_NAME, String LAST_NAME, String EMAIL,
			String PHONE_NUMBER, Date HIRE_DATE, String JOB_ID, int SALARY) {

		this.setFIRST_NAME(FIRST_NAME);
		this.setLAST_NAME(LAST_NAME);
		this.setEMAIL(EMAIL);
		this.setPHONE_NUMBER(PHONE_NUMBER);
		this.setHIRE_DATE(HIRE_DATE);
		this.setJOB_ID(JOB_ID);
		this.setSALARY(SALARY);

	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public void setPHONE_NUMBER(String pHONE_NUMBER) {
		PHONE_NUMBER = pHONE_NUMBER;
	}

	public Date getHIRE_DATE() {
		return HIRE_DATE;
	}

	public void setHIRE_DATE(Date hIRE_DATE) {
		HIRE_DATE = hIRE_DATE;
	}

	public int getSALARY() {
		return SALARY;
	}

	public void setSALARY(int sALARY) {
		SALARY = sALARY;
	}

	public String getJOB_ID() {
		return JOB_ID;
	}

	public void setJOB_ID(String jOB_ID) {
		JOB_ID = jOB_ID;
	}

	@Override
	public String toString() {
		return this.FIRST_NAME + " " + this.LAST_NAME + " " + this.EMAIL + " "
				+ this.PHONE_NUMBER + " " + this.HIRE_DATE + " " + this.JOB_ID
				+ " " + this.SALARY;
	}

	public int getCOMMISSION_PCT() {
		return COMMISSION_PCT;
	}

	public void setCOMMISSION_PCT(int cOMMISSION_PCT) {
		COMMISSION_PCT = cOMMISSION_PCT;
	}

	public int getMANAGER_ID() {
		return MANAGER_ID;
	}

	public void setMANAGER_ID(int mANAGER_ID) {
		MANAGER_ID = mANAGER_ID;
	}

	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}

}
