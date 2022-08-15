package com.project.payment.model;

//import java.util.Date;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transactionid")
	private int transactionId;
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customers customers;
	
	@ManyToOne
	@JoinColumn(name="currencycode")
	private Currency currency;
	
	@ManyToOne
	@JoinColumn(name="senderbic")
	private Banks senderBank;
	
	@ManyToOne
	@JoinColumn(name="recieverbic")
	private Banks recieverBank;
	
	@Column(name="accountholdernumber")
	private String accountHolderNumber;
	
	@Column(name="recieveraccountholdername")
	private String recieverAccountHolderName;
	
	@ManyToOne
	@JoinColumn(name="transfertypecode")
	private TransferType transferType;
	
	@ManyToOne
	@JoinColumn(name="messagecode")
	private Message message;
	
	@Column(name="currencyamount")
	private double currencyAmount;
	
	@Column(name="transferfees")
	private double transferFees;
	
	@Column(name="inramount")
	private double inrAmount;
	
	@Column(name="transferdate")
	private Date transferDate;
	
	public Transaction() {
		
	}

	public Transaction(int transactionid, Customers customers, Currency currency, Banks senderbank, Banks recieverbank,
			String accountholdernumber, String recieveraccountholdername, TransferType transferType, Message message,
			double currencyamount, double transferfees, double inramount, Date transferdate) {
		super();
		this.transactionId = transactionid;
		this.customers = customers;
		this.currency = currency;
		this.senderBank = senderbank;
		this.recieverBank = recieverbank;
		this.accountHolderNumber = accountholdernumber;
		this.recieverAccountHolderName = recieveraccountholdername;
		this.transferType = transferType;
		this.message = message;
		this.currencyAmount = currencyamount;
		this.transferFees = transferfees;
		this.inrAmount = inramount;
		this.transferDate = transferdate;
	}

	public Transaction(String accountholdernumber, String recieveraccountholdername, double currencyamount,
			double transferfees, double inramount, Date transferdate) {
		super();
		this.accountHolderNumber = accountholdernumber;
		this.recieverAccountHolderName = recieveraccountholdername;
		this.currencyAmount = currencyamount;
		this.transferFees = transferfees;
		this.inrAmount = inramount;
		this.transferDate = transferdate;
	}

	public int getTransactionid() {
		return transactionId;
	}

	public void setTransactionid(int transactionid) {
		this.transactionId = transactionid;
	}

	public Customers getCustomer() {
		return customers;
	}

	public void setCustomer(Customers customers) {
		this.customers = customers;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Banks getSenderbank() {
		return senderBank;
	}

	public void setSenderbank(Banks senderbank) {
		this.senderBank = senderbank;
	}

	public Banks getRecieverbank() {
		return recieverBank;
	}

	public void setRecieverbank(Banks recieverbank) {
		this.recieverBank = recieverbank;
	}

	public String getAccountholdernumber() {
		return accountHolderNumber;
	}

	public void setAccountholdernumber(String accountholdernumber) {
		this.accountHolderNumber = accountholdernumber;
	}

	public String getRecieveraccountholdername() {
		return recieverAccountHolderName;
	}

	public void setRecieveraccountholdername(String recieveraccountholdername) {
		this.recieverAccountHolderName = recieveraccountholdername;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public double getCurrencyamount() {
		return currencyAmount;
	}

	public void setCurrencyamount(double currencyamount) {
		this.currencyAmount = currencyamount;
	}

	public double getTransferfees() {
		return transferFees;
	}

	public void setTransferfees(double transferfees) {
		this.transferFees = transferfees;
	}

	public double getInramount() {
		return inrAmount;
	}

	public void setInramount(double inramount) {
		this.inrAmount = inramount;
	}

	public Date getTransferdate() {
		return transferDate;
	}

	public void setTransferdate(java.util.Date date) {
		this.transferDate = (Date) date;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionId + ", customer=" + customers + ", currency=" + currency
				+ ", senderbank=" + senderBank + ", recieverbank=" + recieverBank + ", accountholdernumber="
				+ accountHolderNumber + ", recieveraccountholdername=" + recieverAccountHolderName + ", transferType="
				+ transferType + ", message=" + message + ", currencyamount=" + currencyAmount + ", transferfees="
				+ transferFees + ", inramount=" + inrAmount + ", transferdate=" + transferDate + "]";
	}
	
	

}
