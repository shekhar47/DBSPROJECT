package com.project.payment.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.payment.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
