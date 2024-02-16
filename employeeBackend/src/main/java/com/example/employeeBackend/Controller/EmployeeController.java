package com.example.employeeBackend.Controller;

import com.example.employeeBackend.JPA.EmployeeRepository;
import com.example.employeeBackend.Model.Employee;
import com.example.employeeBackend.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/save/emp")
    public ResponseEntity<?> saveEmployee(Employee employee){
    	String saveEmployee = this.employeeService.saveEmployee(employee);
    	return new ResponseEntity<>(Map.of("message",saveEmployee,"status","200"), HttpStatus.OK);
    }
    
    
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
    	System.out.println("Hit This Service ... ");
        return employeeRepository.findAll();
    }

    
    
    
    
}
