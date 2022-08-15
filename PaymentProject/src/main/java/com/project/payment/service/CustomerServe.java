package com.project.payment.service;

import java.util.Optional;

import com.project.payment.exception.CustomerNotFoundException;
import com.project.payment.model.Customers;

public interface CustomerServe {
	
public String save(Customers cust);

//public Optional<Customer> findById(int i);
public Optional<Customers> findById(int id);

Optional<Customers> findById(String id) throws CustomerNotFoundException;

}
