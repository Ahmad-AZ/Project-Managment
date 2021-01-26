package com.jrp.pma.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {


//    @Value("${version}")
//    private String ver;




    @Autowired
    ProjectRepository proRepo;  // field Injection

    @Autowired
    EmployeeRepository empoList;





    @GetMapping("/")  // route to the application
    public String display(Model model) throws JsonProcessingException {


//        model.addAttribute("versionN",ver);




        //Column name, data
        Map<String,Object> map= new HashMap<>();
        List<ChartData> projectStatusList = proRepo.projectStatus();  // display the projects status

        // converting  project data object into a Jason structure for use in JavaScript.
        ObjectMapper objectMapper= new ObjectMapper();


        //This project data status is now converted into jason structure using this right value string from the object
        String jasonString =objectMapper.writeValueAsString(projectStatusList); //Object to JSON in String
      //[["NOTSTARTED",1],["INPROGRESS",2],["COMPLETED",3]] WHAT JASON STRING LOOK LIKE

        model.addAttribute("projectStatusCnt",jasonString);



        // we are querying the database for projects
       List<Project> projectList = proRepo.findAll();  // this gonna return  all the project that we have in the database
        // (key to reference that model, the actual data)
       model.addAttribute("projects", projectList); // add this projects list to the actual model that will be passed to the view




        // we are querying the database for employees
        List<EmployeeProject> employeesProjectCnt =empoList.employeeProjects();
        model.addAttribute("employeesListProjectCnt", employeesProjectCnt);





        return "main/home";
    }






}
