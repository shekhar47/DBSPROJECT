package com.project.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.payment.model.Logger;

//import ch.qos.logback.classic.Logger;

@Repository
public interface LoggerRepository extends CrudRepository<Logger, Integer>{

}
