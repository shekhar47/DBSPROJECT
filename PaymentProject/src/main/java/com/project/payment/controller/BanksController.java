package com.project.payment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.exception.BankNotFoundException;
import com.project.payment.model.Banks;
import com.project.payment.service.BankService;

@CrossOrigin("*")
@RestController
public class BanksController {
	@Autowired
	private BankService bankService;
	
	@GetMapping("/bank/fetchbyid/{bic}")
	public Banks findBank(@PathVariable String bic) throws BankNotFoundException {
		Banks b= bankService.findBank(bic).get();
		System.out.println(b.toString()+"     "+bic);
		return b;
	}

}
