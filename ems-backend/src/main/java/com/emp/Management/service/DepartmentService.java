package com.emp.Management.service;

import java.util.List;

import com.emp.Management.dto.DepartmentDto;
import com.emp.Management.entity.Department;

public interface DepartmentService {
	List<DepartmentDto> getAllDepartments();
	Department createDepartment(DepartmentDto department);
	DepartmentDto getDepartmentById(Long id);
	String deleteDepartment(Long id );
}
