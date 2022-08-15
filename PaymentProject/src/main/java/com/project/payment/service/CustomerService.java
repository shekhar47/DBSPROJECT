package com.project.payment.service;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payment.exception.CustomerNotFoundException;
import com.project.payment.model.Customers;
import com.project.payment.repository.CustomerRepo;

@Service
public class CustomerService implements CustomerServe {
	@Autowired
	CustomerRepo custrepo;
	
	@Override
	public String save(Customers cust) {
		custrepo.save(cust);
		return "Successfull";
	}


@Override
public Optional<Customers> findById(String id) throws CustomerNotFoundException {
	
	Optional<Customers> c=custrepo.findById(id);
	if(c.isEmpty())
	System.out.println("Customer not found");
	if(c.isEmpty()) throw new CustomerNotFoundException("Customers details not found");
	else
	return c;
	
}

public Iterable<Customers> findall() {
	// TODO Auto-generated method stub
	return custrepo.findAll();
}

public Customers updateCustomer(Customers customers) {
	// TODO Auto-generated method stub
	try {
		return custrepo.save(customers);
	}
	catch (Exception e) {
		return null;
	}
	
}


@Override
public Optional<Customers> findById(int id) {
	// TODO Auto-generated method stub
	return null;
}

}







