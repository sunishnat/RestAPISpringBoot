package com.springboot.restapi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.web.model.Employee;
import com.springboot.restapi.web.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping(path = "/", produces = "application/json")
	public List<Employee> getEmployees(){
		return service.getEmployees();
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	@ApiOperation(value = "Finds Employees by ID",
			notes = "Provide an ID to get the details of the Employee",
			response = Employee.class)
	public Employee getEmployeeById(@RequestParam int id){
		return service.getEmployeeById(id);
	}
	
	@PostMapping(path = "/", consumes = "application/json")
	public void postEmployee(Employee emp){
		service.insertEmployee(emp);
	}

}
