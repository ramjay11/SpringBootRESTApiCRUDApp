package com.ram.springbootrest.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ram.springbootrest.dao.EmployeeDAO;
//This is where URL's entered on the browser or thru Postman will be handled
import com.ram.springbootrest.model.Employee;
@RestController
@RequestMapping("/company")
public class EmployeeController {
	//Save an employee. Controller will be accessing the DAO, we should create a DAO
	//object
	@Autowired
	EmployeeDAO employeeDAO;
	//Save an employee. Whenever a URL /employees is entered, this method will save an
	//employee
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}
	//Get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDAO.findAll();
	}
	//Get employee by empId. Whenever we get a request from @GetMapping with a URL
	//company/notes/id, this method will be called and will return getEmployeeById
	@GetMapping("/notes/{id}") 
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") 
	    Long empId) {
		Employee emp = employeeDAO.findOne(empId); 
		//message that is returned if no entity
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		//If it's not null
		return ResponseEntity.ok().body(emp); 
	}
	//Update an employee by empId
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmploye(@PathVariable(value="id") 
	    Long empId, @Valid @RequestBody Employee empDetails) {
		Employee emp = employeeDAO.findOne(empId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		Employee updateEmployee = employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);  
	}
	//Delete an employww
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empId) {
		Employee emp = employeeDAO.findOne(empId);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
	
}
