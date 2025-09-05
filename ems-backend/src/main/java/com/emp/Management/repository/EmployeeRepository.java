package com.emp.Management.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emp.Management.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
}
 