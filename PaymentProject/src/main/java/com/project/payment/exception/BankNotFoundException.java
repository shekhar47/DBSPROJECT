package com.project.payment.exception;

public class BankNotFoundException extends Exception {

	public BankNotFoundException(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	public BankNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
public BankNotFoundException(Exception e) {
	super(e);
}
}
