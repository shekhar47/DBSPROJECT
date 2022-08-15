package com.project.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Logger {
	
	@Id
	@Column(name="loggerid")
	private int loggerId;
	
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customers customers;
	
	@Column(name="screename")
	private String screeName;
	
	@Column(name="action")
	private String action;
	
	@Column(name="ipaddress")
	private String ipAddress;
	
	
	public Logger() {
		
	}
	
	
	public Logger(Employee employee, Customers customers,  String screename, String action,
			String ipaddress) {
		super();
		this.employee = employee;
		this.customers = customers;
		
		this.screeName = screename;
		this.action = action;
		this.ipAddress = ipaddress;
	}
	public int getLoggerid() {
		return loggerId;
	}
	public void setLoggerid(int loggerid) {
		this.loggerId = loggerid;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Customers getCustomer() {
		return customers;
	}
	public void setCustomer(Customers customers) {
		this.customers = customers;
	}
	
	public String getScreename() {
		return screeName;
	}
	public void setScreename(String screename) {
		this.screeName = screename;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getIpaddress() {
		return ipAddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipAddress = ipaddress;
	}
	@Override
	public String toString() {
		return "Logger [loggerid=" + loggerId + ", employee=" + employee + ", customers=" + customers + ", screename="
				+ screeName + ", action=" + action + ", ipaddress=" + ipAddress + "]";
	}
	
	
	

}
