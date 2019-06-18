package com.springboot.restapi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.web.model.Employee;
import com.springboot.restapi.web.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping(path = "/", produces = "application/json")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}

}
