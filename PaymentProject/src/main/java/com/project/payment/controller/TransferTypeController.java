package com.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.TransferTypeNotFoundException;
import com.project.payment.model.TransferType;
import com.project.payment.service.TransferTypeService;

@CrossOrigin("*")
@RestController
public class TransferTypeController {
	@Autowired
	private TransferTypeService transferTypeService;
	
	@GetMapping("/transfertype/findbyid/{ttype}")
	public TransferType findTransferType(@PathVariable String ttype) throws TransferTypeNotFoundException {
		return transferTypeService.findTransferType(ttype);
	}
	

}
