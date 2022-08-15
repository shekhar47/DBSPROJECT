package com.project.payment.exception;



public class CurrencyNotFoundException extends Exception {
	public CurrencyNotFoundException() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	 
	public CurrencyNotFoundException(String e){
		super(e);
		
	}
	CurrencyNotFoundException(Exception e){
		super(e);
	}

}
