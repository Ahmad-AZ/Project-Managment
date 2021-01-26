package com.jrp.pma.entities;
import org.hibernate.loader.plan.spi.BidirectionalEntityReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {


    @Id // to tell spring this is the actual unique identitfier is the id for each project
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "project_seq")// help us to map java objects to database tables (hibernate)
    private long projectId; // unique identifier for each instance

    
    private String name;
    private String stage;      // not Started , Completed, In progress
    private String description;

    //Bidirectional Relationship
/*    @OneToMany(mappedBy = "project")  // give up on the relationship
    private List<Employee> employees; // assing one Project to many employees
                                      //without parameter to OneToMany() we can just create a tabel in Database
    */

    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST }
            ,fetch =FetchType.LAZY )
    @JoinTable(name="project_employee",joinColumns = @JoinColumn(name ="project_id"),
            inverseJoinColumns = @JoinColumn(name ="employee_id"))
    private List<Employee> employees;





    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }








    public Project() {
    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public void addEmployee(Employee emp) {

        if (employees == null) {
            employees=new ArrayList<>();
        }
        employees.add(emp);

    }
}
