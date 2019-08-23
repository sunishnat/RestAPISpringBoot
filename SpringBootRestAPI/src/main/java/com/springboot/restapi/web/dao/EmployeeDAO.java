package com.springboot.restapi.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.restapi.web.connection.DBConnection;
import com.springboot.restapi.web.model.Employee;

@Repository
public class EmployeeDAO {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		con = DBConnection.getSQLConnection();
		String query = "select * from employee";
		try {
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setTech(rs.getString(3));
				employees.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return employees;
	}
	
	public Employee getEmployeeById(int id){
		con = DBConnection.getSQLConnection();
		Employee emp = new Employee();
		String query = "select * from employee where eid = ?";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			emp.setEid(id);
			while(rs.next()){
				emp.setEname(rs.getString(2));
				emp.setTech(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public void insertEmployee(Employee employee){
		con = DBConnection.getSQLConnection();
		String query = "insert into employee values(?, ?, ?)";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, employee.getEid());
			pst.setString(2, employee.getEname());
			pst.setString(3, employee.getTech());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
