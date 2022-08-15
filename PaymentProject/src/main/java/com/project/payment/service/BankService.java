package com.project.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payment.exception.BankNotFoundException;
import com.project.payment.model.Banks;
import com.project.payment.repository.BankRepository;

@Service
public class BankService {
	
	@Autowired
	private BankRepository bankRepository;
	
	public Optional< Banks> findBank(String bic) throws BankNotFoundException {
		
				Optional<Banks> result= bankRepository.findById(bic);
				if(result.isEmpty()) throw new BankNotFoundException("Bank Details Not found");
				else
					return result;
		
}
}
