package com.project.payment.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.model.Customers;

@Repository
public interface CustomerRepo extends CrudRepository<Customers, String> {

	Optional<Customers> findById(String id);

}
