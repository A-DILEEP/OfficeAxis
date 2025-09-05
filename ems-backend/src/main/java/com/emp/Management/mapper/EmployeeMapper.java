package com.emp.Management.mapper;
import com.emp.Management.dto.*;
import com.emp.Management.entity.*;
public class EmployeeMapper {
    public static EmployeeSummaryDto toSummaryDto(Employee employee) {
        if (employee == null) return null;
        return new EmployeeSummaryDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    public static EmployeeDetailDto toDetailDto(Employee employee) {
        if (employee == null) return null;
        DepartmentDto departmentDto = toDepartmentDto(employee.getDepartment());
        AddressDto addressDto = toAddressDto(employee.getAddress());
        ProjectDto projectDto = ProjectMapper.toDto(employee.getProject());
        return new EmployeeDetailDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                departmentDto,
                addressDto,
                projectDto
        );
    }
    public static Employee toEntity(EmployeeDetailDto dto) {
        if (dto == null) return null;
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(toDepartment(dto.getDepartment()));
        employee.setAddress(toAddress(dto.getAddressDto()));
        employee.setProject(ProjectMapper.toEntity(dto.getProject()));
        return employee;
    }
    public static DepartmentDto toDepartmentDto(Department department) {
        if (department == null) return null;
        return new DepartmentDto(department.getId(), department.getName());
    }
    public static Department toDepartment(DepartmentDto dto) {
        if (dto == null || dto.getId() == null) return null;
        Department department = new Department();
        department.setId(dto.getId());
        department.setName(dto.getName());
        return department;
    }
    public static AddressDto toAddressDto(Address address) {
        if (address == null) return null;
        return new AddressDto(address.getId(), address.getCity(), address.getState());
    }
    public static Address toAddress(AddressDto dto) {
        if (dto == null) return null;
        Address address = new Address();
        address.setId(dto.getId());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        return address;
    }
}
