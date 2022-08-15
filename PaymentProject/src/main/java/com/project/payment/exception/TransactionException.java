package com.project.payment.exception;

public class TransactionException extends Exception {
	public TransactionException() {
		// TODO Auto-generated constructor stub
	}
	public TransactionException(String e) {
		super(e);
	}
	public  TransactionException(Exception e) {super(e);

}
}