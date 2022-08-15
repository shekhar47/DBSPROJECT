package com.project.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.model.TransferType;


@Repository
public interface TransferTypeRepository extends CrudRepository<TransferType, String> {

}
