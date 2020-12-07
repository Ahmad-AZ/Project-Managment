package com.jrp.pma.controllers;


import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empoList;

    @GetMapping("/")  // route to the application
    public String displayDD(Model model){
        // we are querying the database for projects
       List<Project> projects= proRepo.findAll();  // this gonna return  all the project that we have in the database
        // (key to reference that model, the actual data)
       model.addAttribute("projects",projects); // add this projects list to the actual model that will be passed to the view


        // we are querying the database for employees
        List<Employee> employees=empoList.findAll();
        model.addAttribute("employees", employees);

        return "main/home";
    }






}
