package com.project.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String>{

}
