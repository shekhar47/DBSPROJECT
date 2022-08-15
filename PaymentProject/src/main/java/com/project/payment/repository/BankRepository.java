package com.project.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.model.Banks;

@Repository
public interface BankRepository extends CrudRepository<Banks, String> {

}
