package com.project.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {	
	
	
	 
	

}
