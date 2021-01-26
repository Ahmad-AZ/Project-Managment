package com.jrp.pma.dto;

public interface EmployeeProject {

    // need to have the property names begin with get
    public String getFirstName();  // is have to be get cuz spring gonna look for it
    public String getLastName();
    public int getProjectCount();
}
