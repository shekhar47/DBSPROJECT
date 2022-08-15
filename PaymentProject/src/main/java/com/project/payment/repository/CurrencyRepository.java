package com.project.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.model.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {

}
