package com.example.employeeBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeeBackend.JPA.EmployeeRepository;
import com.example.employeeBackend.Model.Employee;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public String saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		return(this.employeeRepository.save(employee) instanceof Employee)?"Save Employee":"Occured Error";
	}

}
