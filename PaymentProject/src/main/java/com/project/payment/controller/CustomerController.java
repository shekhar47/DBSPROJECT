package com.project.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.payment.model.Customers;
import com.project.payment.service.CustomerService;

@CrossOrigin("*")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	
	
	@PostMapping("/addcustomer")
	public String save(@RequestBody Customers cust) {
		try {
		custService.save(cust);
		return "Customer Added";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	
	
	@GetMapping("/fetchbyid/{id}")
	public Customers findId(@PathVariable String id) {
		System.out.print(id.length());
		try {
		return custService.findById(id).get();
		}

		catch (Exception e) {	
			System.out.println(e.getMessage());

		return null;
		}
	}
	
	
	
	@GetMapping("/fetchall")
	public Iterable<Customers> fetchall() {
		try {
		return custService.findall();
		}
		catch (Exception e) {			
		return null;		
		}
	}
	
	
	@GetMapping("/updatecustomer")
	public Customers updateCustomer(@RequestBody Customers  customers) {
		try {
			return custService.updateCustomer(customers);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	

}





