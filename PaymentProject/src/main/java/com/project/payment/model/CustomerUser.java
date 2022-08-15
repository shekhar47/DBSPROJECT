package com.project.payment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="customeruser")
public class CustomerUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@NotNull
	private String username;
	@NotNull
	private String password;

	 @OneToOne 
	 @JoinColumn(name="customerid")
	 private Customers customers;
	 public CustomerUser(String username, String password, Customers customers) {
		super();
		this.username = username;
		this.password = password;
		// this.customer = customer;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	  public Customers getCustomer() { return customers; } public void
	  setCustomer(Customers customers) { this.customers = customers; }
	  
	  @Override public String toString() { return "CustomerUser [userid=" + userid
	  + ", username=" + username + ", password=" + password + ", customer=" +
	  customers + "]"; }
	 

}
