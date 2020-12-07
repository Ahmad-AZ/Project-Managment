package com.jrp.pma.controllers;


import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.entities.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;


    @GetMapping // will go to employees

    public String displayEmployees(Model model){
        List<Employee> employeesList=employeeRepository.findAll();


        model.addAttribute("employeeList",employeesList);
        return "employees/list-employees";

    }


    @GetMapping("/new")
    public String displayEmployeeForm(Model model){

        model.addAttribute("employee",new Employee());// attr. employee to access the empty Employee object in the form
                                                         //adding model attributes to a view
        return "employees/new-employee";
    }



    @PostMapping("/save")
    public String SaveEmployee(Employee employee, Model model, RedirectAttributes attributes){

        employeeRepository.save(employee);
        attributes.addFlashAttribute("employee",employee);

        return "redirect:/employees/new";

    }

    @GetMapping("/isCreated")
    public String diplayRegistration (Employee employee){


        return "create";
    }















}
