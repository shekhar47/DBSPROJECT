package com.project.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.payment.exception.CurrencyNotFoundException;
import com.project.payment.model.Currency;
import com.project.payment.repository.CurrencyRepository;

@Service
public class CurrencyService {
	@Autowired
	private CurrencyRepository  currencyRepository;
	
	
	
	public Currency findCurrency(String ccode) throws CurrencyNotFoundException {
		Optional<Currency> result=currencyRepository.findById(ccode);
		if(!result.isEmpty()) 
		return result.get();
		else throw new CurrencyNotFoundException("Bank Details Not found");
	//Currency c=	
	}

}
