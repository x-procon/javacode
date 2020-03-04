package com.hazer.gyo.hazer.springboot.controller;


import com.hazer.gyo.hazer.springboot.entity.Employee;
import com.hazer.gyo.hazer.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable(value = "id") Integer id){
       return employeeService.getEmpById(id);
    }



}
