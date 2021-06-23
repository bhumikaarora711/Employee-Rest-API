package com.nagarro.model;
/*
 * @Author Bhumika_Arora
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	long id;
	
	@Column
	private int empCode;
	@Column
	private String empName;
	@Column
	private String empLoc;
	@Column
	private String empMail;
	@Column
	private String empDOB;
	
	public Employee(final int empCode, final String empName, final String empLoc, final String empMail, final String empDOB) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.empLoc = empLoc;
		this.empMail = empMail;
		this.empDOB = empDOB;
	}
	
	
	
	public long getId() {
		return id;
	}



	public void setId(final int id) {
		this.id = id;
	}



	public int getEmpCode() {
		return empCode;
	}


	public void setEmpCode(final int empCode) {
		this.empCode = empCode;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(final String empName) {
		this.empName = empName;
	}


	public String getEmpLoc() {
		return empLoc;
	}


	public void setEmpLoc(final String empLoc) {
		this.empLoc = empLoc;
	}


	public String getEmpMail() {
		return empMail;
	}


	public void setEmpMail(final String empMail) {
		this.empMail = empMail;
	}


	public String getEmpDOB() {
		return empDOB;
	}


	public void setEmpDOB(final String empDOB) {
		this.empDOB = empDOB;
	}
	

	public Employee() {
		super();
	}


	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", empName=" + empName + ", empLoc=" + empLoc + ", empMail=" + empMail
				+ ", empDOB=" + empDOB + "]";
	}
	
	
}
