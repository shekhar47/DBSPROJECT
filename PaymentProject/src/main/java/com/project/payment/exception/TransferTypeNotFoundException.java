package com.project.payment.exception;

public class TransferTypeNotFoundException extends Exception{
	public TransferTypeNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
	public TransferTypeNotFoundException(Exception e) {
		super(e);
		
	}
	public TransferTypeNotFoundException(String e) {
		super(e);
	}

}
