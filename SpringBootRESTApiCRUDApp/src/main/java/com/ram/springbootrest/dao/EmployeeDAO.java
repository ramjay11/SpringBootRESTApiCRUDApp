package com.ram.springbootrest.dao;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.springbootrest.model.Employee;
import com.ram.springbootrest.repository.EmployeeRepository;
//This is where we insert, create, update, delete data into the database
@Service //Whenever you define a DAO, @Service should be inclu
public class EmployeeDAO {
	@Autowired//need to wire this object
	EmployeeRepository employeeRepository;
	//save an employee. JPA has a predefined method called save
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	//search all employees
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	//get an employee by id
	public Employee findOne(Long empId) {
		return employeeRepository.findOne(empId);
	}
	//delete an employee
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
}
