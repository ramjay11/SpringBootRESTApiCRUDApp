package com.ram.springbootrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ram.springbootrest.model.Employee;

//This interface extends the JPA repository and make Employee class as a reference
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findOne(Long empId);
	
}
