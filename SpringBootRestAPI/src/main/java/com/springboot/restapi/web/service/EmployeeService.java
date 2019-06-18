package com.springboot.restapi.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.restapi.web.dao.EmployeeDAO;
import com.springboot.restapi.web.model.Employee;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	public List<Employee> getEmployees(){
		
		return dao.getEmployees();
	}
	
}
