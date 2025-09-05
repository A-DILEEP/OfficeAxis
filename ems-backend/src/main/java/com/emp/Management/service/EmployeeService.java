package com.emp.Management.service;

import com.emp.Management.dto.EmployeeSummaryDto;
import com.emp.Management.dto.EmployeeDetailDto;
import java.util.List;

public interface EmployeeService {
    EmployeeDetailDto createEmployee(EmployeeDetailDto employeeDto);
    EmployeeDetailDto getEmployeeById(Long employeeId);
    List<EmployeeSummaryDto> getAllEmployees();
    EmployeeDetailDto updateEmployee(Long id, EmployeeDetailDto updatedEmployee);
    void deleteEmployee(Long employeeId);
}
