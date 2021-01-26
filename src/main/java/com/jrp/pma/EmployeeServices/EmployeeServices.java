package com.jrp.pma.EmployeeServices;

import org.springframework.stereotype.Service;


import com.jrp.pma.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class EmployeeServices {

    EmployeeRepository repository;

    @Autowired
    public void setRepository(EmployeeRepository repository) {  // we need Autowired here cuz Spring doesn't know
                                                              // if he have to inject this method
        this.repository = repository;
    }


    /*    // constructor injection
    public EmployeeServices(EmployeeRepository repository) {
        this.repository = repository;
    }*/
}
