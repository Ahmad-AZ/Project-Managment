package com.jrp.pma.dao;

import com.jrp.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// entity type,  type of primary key
public interface EmployeeRepository extends CrudRepository<Employee, Long> {


  @Override
  public List<Employee> findAll();

}
