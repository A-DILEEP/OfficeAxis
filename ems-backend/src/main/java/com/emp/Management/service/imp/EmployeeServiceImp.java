package com.emp.Management.service.imp;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.emp.Management.dto.EmployeeSummaryDto;
import com.emp.Management.dto.EmployeeDetailDto;
import com.emp.Management.entity.Department;
import com.emp.Management.entity.Employee;
import com.emp.Management.entity.Project;
import com.emp.Management.exception.ResourceNotFoundException;
import com.emp.Management.mapper.EmployeeMapper;
import com.emp.Management.repository.EmployeeRepository;
import com.emp.Management.repository.ProjectRepository;
import com.emp.Management.repository.DepartmentRepository;
import com.emp.Management.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ProjectRepository projectRepository;
    public EmployeeServiceImp(EmployeeRepository employeeRepository,DepartmentRepository departmentRepository,ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository=projectRepository;
    }
    @Override
    public EmployeeDetailDto createEmployee(EmployeeDetailDto employeeDto) {
        Employee employee = EmployeeMapper.toEntity(employeeDto);
        if (employeeDto.getDepartment() != null && employeeDto.getDepartment().getId() != null) {
            Department department = departmentRepository.findById(employeeDto.getDepartment().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + employeeDto.getDepartment().getId()));
            employee.setDepartment(department);
        }
        if (employeeDto.getProject() != null && employeeDto.getProject().getId() != null) {
            Project project = projectRepository.findById(employeeDto.getProject().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + employeeDto.getProject().getId()));
            employee.setProject(project);
        }
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.toDetailDto(saved);
    }
    @Override
    public EmployeeDetailDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        return EmployeeMapper.toDetailDto(employee);
    }
    @Override
    public List<EmployeeSummaryDto> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toSummaryDto)
                .collect(Collectors.toList());
    }
    @Override
    public EmployeeDetailDto updateEmployee(Long id, EmployeeDetailDto updatedDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setFirstName(updatedDto.getFirstName());
        employee.setLastName(updatedDto.getLastName());
        employee.setEmail(updatedDto.getEmail());
        if (updatedDto.getDepartment() != null && updatedDto.getDepartment().getId() != null) {
            Department department = departmentRepository.findById(updatedDto.getDepartment().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + updatedDto.getDepartment().getId()));
            employee.setDepartment(department);
        } else {
            employee.setDepartment(null);
        }
        if (updatedDto.getProject() != null && updatedDto.getProject().getId() != null) {
            Project project = projectRepository.findById(updatedDto.getProject().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + updatedDto.getProject().getId()));
            employee.setProject(project);
        } else {
            employee.setProject(null); 
        }
        employee.setAddress(EmployeeMapper.toAddress(updatedDto.getAddressDto()));
        Employee updatedEntity = employeeRepository.save(employee);
        return EmployeeMapper.toDetailDto(updatedEntity);
    }
    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        employeeRepository.delete(employee);
    }
}
