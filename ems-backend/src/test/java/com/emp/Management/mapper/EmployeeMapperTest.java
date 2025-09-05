package com.emp.Management.mapper;
import com.emp.Management.dto.*;
import com.emp.Management.entity.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class EmployeeMapperTest {
    @Test
    void toSummaryDto_shouldMapEmployeeToSummaryDto() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john@example.com");

        EmployeeSummaryDto dto = EmployeeMapper.toSummaryDto(employee);

        assertNotNull(dto);
        assertEquals(1L, dto.getId());
        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("john@example.com", dto.getEmail());
    }

    @Test
    void toDetailDto_shouldMapEmployeeToDetailDto_withProject() {
        Department dept = new Department();
        dept.setId(10L);
        dept.setName("IT");

        Address addr = new Address();
        addr.setId(20L);
        addr.setCity("Hyderabad");
        addr.setState("Telangana");

        Project project = new Project();
        project.setId(30L);
        project.setProjectName("Project X");
        project.setProjectId("PX-001");

        Employee employee = new Employee();
        employee.setId(2L);
        employee.setFirstName("Jane");
        employee.setLastName("Smith");
        employee.setEmail("jane@example.com");
        employee.setDepartment(dept);
        employee.setAddress(addr);
        employee.setProject(project);

        EmployeeDetailDto dto = EmployeeMapper.toDetailDto(employee);

        assertNotNull(dto);
        assertEquals(2L, dto.getId());
        assertEquals("Jane", dto.getFirstName());
        assertEquals("Smith", dto.getLastName());
        assertEquals("jane@example.com", dto.getEmail());

        assertNotNull(dto.getDepartment());
        assertEquals(10L, dto.getDepartment().getId());
        assertEquals("IT", dto.getDepartment().getName());

        assertNotNull(dto.getAddressDto());
        assertEquals("Hyderabad", dto.getAddressDto().getCity());
        assertEquals("Telangana", dto.getAddressDto().getState());

        assertNotNull(dto.getProject());
        assertEquals(30L, dto.getProject().getId());
        assertEquals("Project X", dto.getProject().getProjectName());
        assertEquals("PX-001", dto.getProject().getProjectId());
    }
}
