package com.project.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {

	@Id
	@Column(name="customerid")
	private String customerId;
	
	@Column(name="accountholdername")
	private String accountHolderName;
	
	@Column(name="overdraftflag")
	private int overDraftFlag;
	
	@Column(name="clearbalance")
	private double clearBalance;
	
	@Column(name="customeraddress")
	private String customerAddress;
	
	@Column(name="customercity")
	private String customerCity;
	
	@Column(name="customertype")
	private String customerType;

	public Customers() {
		// TODO Auto-generated constructor stub
	}

	public Customers(String customerid, String accountholdername, int overdraftflag, double clearbalance,
			String customeraddress, String customercity, String customertype) {
		super();
		this.customerId = customerid;
		this.accountHolderName = accountholdername;
		this.overDraftFlag = overdraftflag;
		this.clearBalance = clearbalance;
		this.customerAddress = customeraddress;
		this.customerCity = customercity;
		this.customerType = customertype;
	}

	public String getCustomerid() {
		return customerId;
	}

	public void setCustomerid(String customerid) {
		this.customerId = customerid;
	}

	public String getAccountholdername() {
		return accountHolderName;
	}

	public void setAccountholdername(String accountholdername) {
		this.accountHolderName = accountholdername;
	}

	public int getOverdraftflag() {
		return overDraftFlag;
	}

	public void setOverdraftflag(int overdraftflag) {
		this.overDraftFlag = overdraftflag;
	}

	public double getClearbalance() {
		return clearBalance;
	}

	public void setClearbalance(double clearbalance) {
		this.clearBalance = clearbalance;
	}

	public String getCustomeraddress() {
		return customerAddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customerAddress = customeraddress;
	}

	public String getCustomercity() {
		return customerCity;
	}

	public void setCustomercity(String customercity) {
		this.customerCity = customercity;
	}

	public String getCustomertype() {
		return customerType;
	}

	public void setCustomertype(String customertype) {
		this.customerType = customertype;
	}

	@Override
	public String toString() {
		return "Customers [customerid=" + customerId + ", accountholdername=" + accountHolderName + ", overdraftflag="
				+ overDraftFlag + ", clearbalance=" + clearBalance + ", customeraddress=" + customerAddress
				+ ", customercity=" + customerCity + ", customertype=" + customerType + "]";
	}
	
}