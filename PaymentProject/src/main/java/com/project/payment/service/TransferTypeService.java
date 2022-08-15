package com.project.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payment.exception.TransferTypeNotFoundException;
import com.project.payment.model.TransferType;
import com.project.payment.repository.TransferTypeRepository;

@Service
public class TransferTypeService {
	
	@Autowired
	private TransferTypeRepository transferTypeRepository;
	
	
	public TransferType findTransferType(String ttype) throws TransferTypeNotFoundException {
		Optional<TransferType> result=transferTypeRepository.findById(ttype);
		if(result.isEmpty()) throw new TransferTypeNotFoundException("Error!!Transfer Type Not Found ! "); 
		return result.get();
	}

}
