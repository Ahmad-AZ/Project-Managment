package com.jrp.pma.entities;
import javax.persistence.JoinColumn;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employee_seq")
    private long employeeId;  // unique identifier
    private String firstName;
    private String lastName;
    private String email;

/*

    //The owning side is responsible for propagating the update of the relationship to the database. ( with the foreign key)
    @ManyToOne(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST }
     ,fetch =FetchType.LAZY ) // to fetch the related entities in a single query
    // column name which will store the primary key of the Project
    @JoinColumn(name = "project_id")  //It simply means that our Employee entity will have a foreign key column named project_id referring to the primary id of our Project entity.
    private Project project; // the project that this employee is going to be assigned to
                                // reference to the project entity
*/



    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST }
     ,fetch =FetchType.LAZY)
    @JoinTable(name = "project_employee",joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }





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
