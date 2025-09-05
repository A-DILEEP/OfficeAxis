package com.emp.Management.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.emp.Management.dto.DepartmentDto;
import com.emp.Management.entity.Department;
import com.emp.Management.exception.ResourceNotFoundException;
import com.emp.Management.mapper.DepartmentMapper;
import com.emp.Management.repository.DepartmentRepository;
import com.emp.Management.service.DepartmentService;

@Service
public class DepartmentServiceImp implements DepartmentService{
	private DepartmentRepository departmentRepository;
	public DepartmentServiceImp(DepartmentRepository departmentRepository) {
		this.departmentRepository=departmentRepository;
	}
	
	@Override
	public List<DepartmentDto> getAllDepartments() {
		return departmentRepository.findAll()
				.stream()
				.map(DepartmentMapper::maptoDepartmentDto)
				.collect(Collectors.toList());
	}
	@Override
	public Department createDepartment(DepartmentDto departmentdto) {
		Department department=DepartmentMapper.maptoDepartment(departmentdto);
		departmentRepository.save(department);
		return department;
	}

	@Override
	public DepartmentDto getDepartmentById(Long id) {
		Optional<Department> department=departmentRepository.findById(id);
		DepartmentDto departmentDto=new DepartmentDto(department.get().getId(),department.get().getName());
		return departmentDto;
	}
	@Override
	public String deleteDepartment(Long id) {
	    Department department = departmentRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
	    department.getEmployees().forEach(emp -> emp.setDepartment(null));
	    department.getEmployees().clear();
	    departmentRepository.delete(department);
	    return "Department deleted";
	}
}
