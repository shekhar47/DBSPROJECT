package com.project.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="employeeid")
	private int employeeId;
	
	@Column(name="employeename")
	private String employeeName;
	
	@Column(name="employeepassword")
	private String employeePassword;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeename, String employeepassword) {
		super();
		this.employeeName = employeename;
		this.employeePassword = employeepassword;
	}
	public int getEmployeeid() {
		return employeeId;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeId = employeeid;
	}
	public String getEmployeename() {
		return employeeName;
	}
	public void setEmployeename(String employeename) {
		this.employeeName = employeename;
	}
	public String getEmployeepassword() {
		return employeePassword;
	}
	public void setEmployeepassword(String employeepassword) {
		this.employeePassword = employeepassword;
	}
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeId + ", employeename=" + employeeName + ", employeepassword="
				+ employeePassword + "]";
	}
	

}
