package com.jrp.pma.entities;
import javax.persistence.*;
import java.util.List;

@Entity
public class Project {


    @Id // to tell spring this is the actual unique identitfier is the id for each project
    @GeneratedValue(strategy = GenerationType.AUTO)// help us to map java objects to database tables (hibernate)
    private long projectId; // unique identifier for each instance

    
    private String name;
    private String stage;      // not Started , Completed, In progress
    private String description;

    @OneToMany(mappedBy = "theProject")  // define a field in the Employee Class
    private List<Employee> employees; // assing one Project to many employees
                                      //without parameter to OneToMany() we can just create a tabel in Database

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
}
