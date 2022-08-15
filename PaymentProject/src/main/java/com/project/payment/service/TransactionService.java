package com.project.payment.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.payment.controller.BanksController;
import com.project.payment.controller.CurrencyController;
import com.project.payment.controller.CustomerController;
import com.project.payment.controller.MessageController;
import com.project.payment.controller.TransferTypeController;
import com.project.payment.exception.BankNotFoundException;
import com.project.payment.exception.CurrencyNotFoundException;
import com.project.payment.exception.LoggerException;
import com.project.payment.exception.MessageCodeNotFoundException;
import com.project.payment.exception.TransactionException;
import com.project.payment.exception.TransferTypeNotFoundException;
import com.project.payment.model.Banks;
import com.project.payment.model.Currency;
import com.project.payment.model.CustomerUser;
import com.project.payment.model.Customers;
import com.project.payment.model.Employee;
import com.project.payment.model.Message;
import com.project.payment.model.Transaction;
import com.project.payment.model.TransferType;
import com.project.payment.repository.CustomerRepo;
import com.project.payment.repository.LoggerRepository;
import com.project.payment.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private CustomerRepo custRepo;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	
	private BanksController bankController;
	@Autowired
	private CustomerController customerController;
	@Autowired
	private CurrencyController currencyController;
	@Autowired
	private TransferTypeController transferTypecontroller;
	@Autowired
	private MessageController messageController;
	
	
//	public String saveTransaction(Transaction tr) throws TransactionException {
//		
//				Transaction updatedTr=transactionRepository.save(tr);
//				if(updatedTr==null) throw new TransactionException("Error!! Transaction Not save into the database!");
//				else return " Transaction Successfull";
//	}
//	
//	@Transactional
//	public String makeTransaction2(Transaction tr) throws TransactionException, UnknownHostException, LoggerException {
//		  java.util.Date utilDate = new java.util.Date();
//		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//		    tr.setTransferdate(sqlDate);
//		    
//		    Customers customer=tr.getCustomer();
//		    System.out.println("Customer Balance Before"+customer.getClearbalance());
//		    double setBalance=customer.getClearbalance()-tr.getInramount();
//		    int overdraft=1;
//		    boolean checkList=false;
//		    if(customer.getClearbalance()<tr.getInramount()) { 
//		    	
//		    	overdraft=customer.getOverdraftflag();}
//		    
//		    
//		    if(overdraft==1&&checkList==false) {
//		    
//		    customer.setClearbalance(setBalance);
//		    Customers updatedCustomer=custRepo.save(customer);
//		    System.out.println("updatedCustomer clear Balance:"+updatedCustomer.getClearbalance());
//		
//		Transaction updatedResult=transactionRepository.save(tr);
//		if(updatedResult==null) throw new TransactionException("Error!! Transaction Not save into the database!");
//		else {
//			
//			
//		Employee e=new Employee();
//		Customers cust=tr.getCustomer();
//		//CustomerUser custUser=new CustomerUser(tr.getCustomer().getAccountholdername(), null, cust);
//		String action="Transaction: "+tr.getMessage().getInstruction();
//		String screenName="";
//		 InetAddress localhost = InetAddress.getLocalHost();
//		String ipAddress=(localhost.getHostAddress()).trim();
//				
//		/*
//		 * //Logger log=new Logger(e, cust, custUser, screenName, action, ipAddress);
//		 * 
//		 * Logger updatedLog=loggerRepository.save(log); if(updatedLog==null) throw new
//		 * LoggerException("Error !! Can't write logs"); else
//		 */ return "Transaction Successfull";
//		}
//		    }
//		    
//		else
//		{
//			if(overdraft==0) return "Customer Can't Make transaction as due to low balance";
//			else  return "\nCustomer Appeared in the block list! Sorry!!!";
//		}
//		    //return "Transaction Unsuccessfull";
//		
//		
//	
//
//}

	public String saveTransaction(String senderId,String currencyCode, String senderBankId,String bankId,String recName,String senderName, String msgCode, String trType, double amount,double trFee, double clrBalance ) throws CurrencyNotFoundException, BankNotFoundException, TransferTypeNotFoundException, MessageCodeNotFoundException {
		
		Transaction tr = new Transaction();

//		String result = customerid + " " + currcode + " " + sbic + " " + rbic + " " + rbic + " " + rname + " " + sname
//				+ " " + ttype + " " + amount + " " + tfee + " " + inramount;
		Currency ccode = currencyController.findCurrency(currencyCode);
		Banks sb = bankController.findBank(senderBankId);
		Banks rb = bankController.findBank(bankId);
		Customers cust = customerController.findId(senderId);
		TransferType trtype = transferTypecontroller.findTransferType(trType);
		Message message = messageController.findMessage(msgCode);
		//Date date = new Date();

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		tr.setCurrency(ccode);
		tr.setCustomer(cust);
		tr.setSenderbank(sb);
		tr.setRecieverbank(rb);
		tr.setMessage(message);
		tr.setAccountholdernumber(senderName);
		tr.setRecieveraccountholdername(recName);
		tr.setTransferfees(trFee);
		tr.setCurrencyamount(ccode.getConversionrate());
		tr.setInramount(amount);
		tr.setTransferdate(sqlDate);
		tr.setTransferType(trtype);
		
		double customerUpdatedBalance=cust.getClearbalance()-clrBalance;
		cust.setClearbalance(customerUpdatedBalance);
		
		
        Customers updatedCustomer=custRepo.save(cust);
		
		Transaction result=transactionRepository.save(tr);
		if(result!=null&&updatedCustomer!=null)
		return "Transaction Successfull";
		else
		return "Transaction Failed!";
	}
}
