package com.jrp.pma.entities;
import javax.persistence.JoinColumn;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;

@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;  // unique identifier
    private String firstName;
    private String lastName;
    private String email;

    //Composition
    @ManyToOne                           // column name which will store the primary key of the Project
    @JoinColumn(name = "project_id")  //It simply means that our Employee entity will have a foreign key column named project_id referring to the primary id of our Project entity.
    private Project theProject; // the project that this employee is going to be assigned to
                                // reference to the project entity


    public Employee() {
    }



 // we didn't choose Id in the constructor, cuz we want the database to handle this
    public Employee( String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
