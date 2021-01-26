package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")    // anything goes the URL projects that's rote to this controller
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;



    @GetMapping
    public String displayProjects(Model model){

        List<Project> projectsList= proRepo.findAll();

        model.addAttribute("projects",projectsList );

        return "projects/list-projects";
    }


    @GetMapping("/new")
    public String displayProjectForm(Model model){

        List<Employee> allEmployees= empRepo.findAll();

        model.addAttribute("project", new Project());  // object called in HTML form(project)
        model.addAttribute("allEmployees",allEmployees);

        return "projects/new-project";                        // project must have the same name in html object
    }


    @PostMapping("/save") // to handle with the submitted form from html(end point method)
    public String createProjectForm(  Project project,Model model){
            // this should handle saving to the database
        proRepo.save(project);  // trying to save the instance from Project



        // use a redirect to prevent duplicate submissions
        return "redirect:/projects";

    }


}
