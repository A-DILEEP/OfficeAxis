package com.emp.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.emp.Management.dto.DepartmentDto;
import com.emp.Management.entity.Department;
import com.emp.Management.repository.DepartmentRepository;
import com.emp.Management.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
    	List<DepartmentDto> allDepartments=departmentService.getAllDepartments();
    	return ResponseEntity.ok(allDepartments);
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentDto departmentDto) {
    	Department department=departmentService.createDepartment(departmentDto);
    	
        return ResponseEntity.status(HttpStatus.CREATED).body(department);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
    	DepartmentDto departmentDto=departmentService.getDepartmentById(id);
        return ResponseEntity.ok(departmentDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id ) {
    	String value=departmentService.deleteDepartment(id);
    	return ResponseEntity.status(HttpStatus.OK).body(value);
    }
}