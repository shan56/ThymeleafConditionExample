package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {

    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/employeeForm")
    public String enterEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }

    @PostMapping("/displayEmployee")
    public String displayEmployee(@Valid Employee employee,
                                  BindingResult result){
        if (result.hasErrors()) {
            return "employeeform";
        } else {
            employees.add(employee);
            return "displayemployee";
        }
    }

    @RequestMapping("/allEmployees")
    public String showAll(Model model){

        // add array list of employees to model
        model.addAttribute("employees", employees);
        return "allemployees";
    }


}
