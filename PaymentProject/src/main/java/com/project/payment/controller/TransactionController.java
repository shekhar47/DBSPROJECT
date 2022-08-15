package com.project.payment.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.BankNotFoundException;
import com.project.payment.exception.CurrencyNotFoundException;
import com.project.payment.exception.LoggerException;
import com.project.payment.exception.MessageCodeNotFoundException;
import com.project.payment.exception.TransactionException;
import com.project.payment.exception.TransferTypeNotFoundException;
import com.project.payment.model.Banks;
import com.project.payment.model.Currency;
import com.project.payment.model.Customers;
import com.project.payment.model.Employee;
import com.project.payment.model.Logger;
import com.project.payment.model.Message;
import com.project.payment.model.Transaction;
import com.project.payment.model.TransferType;
import com.project.payment.repository.EmployeeRepository;
import com.project.payment.repository.LoggerRepository;
import com.project.payment.service.TransactionService;

@RestController
@CrossOrigin("*")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	@Autowired
	private LoggerRepository loggerRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	

	
	@PostMapping("/api/transaction/proceed/{senderId}/{currencyCode}/{senderBankId}/{bankId}/{msgCode}/{trType}/{amount}/{trFee}/{clrBalance}/{senderName}/{recName}")
	public String makeTransaction(@PathVariable String senderId, @PathVariable String currencyCode,
			@PathVariable String senderBankId, @PathVariable String bankId, @PathVariable String msgCode,
			@PathVariable String recName, @PathVariable String senderName,
			@PathVariable String trType, @PathVariable double amount,
			@PathVariable double trFee, @PathVariable double clrBalance)
			throws BankNotFoundException, CurrencyNotFoundException, MessageCodeNotFoundException, TransactionException,
			TransferTypeNotFoundException, UnknownHostException, LoggerException {

				
		    String trResult=transactionService.saveTransaction(senderId, currencyCode, senderBankId, bankId, recName, senderName, msgCode, trType, amount, trFee, clrBalance);
		     return   trResult;

	}

	
	
	private void saveLogger(Transaction tr) throws UnknownHostException, LoggerException {
		Employee e = employeeRepository.findById(1).get();

		Customers cust1 = tr.getCustomer();
		String action = "Transaction: " + tr.getMessage().getMessagecode();
		String screenName = "";
		InetAddress localhost = InetAddress.getLocalHost();
		String ipAddress = (localhost.getHostAddress()).trim();
	
		
		Logger log=new Logger(e, cust1, screenName, action, ipAddress);
		System.out.println("Logger:"+log);
		  Logger updatedLog=loggerRepository.save(log); if(updatedLog==null) throw new LoggerException("Error !! Can't write logs");
		 
	}

//	@PostMapping("/Proceed2")
//	public String makeTransaction2(@RequestBody Transaction tr)
//			throws TransactionException, UnknownHostException, LoggerException {
//		System.out.println(tr);
//		//saveLogger(tr);
//		return transactionService.makeTransaction2(tr);
//
//	}
//	
//	
	

}
