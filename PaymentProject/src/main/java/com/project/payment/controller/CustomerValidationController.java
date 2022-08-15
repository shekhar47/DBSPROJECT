package com.project.payment.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.model.Customers;

@RestController
@RequestMapping("api/transaction")
public class CustomerValidationController {
	//private CustomerValidationService customerValidationService;
	
	@GetMapping("/getBody")
	public ResponseEntity<Customers>  displayCustomer(RequestEntity<Customers> customer){
		return ResponseEntity.ok(customer.getBody());
	}
	

}
