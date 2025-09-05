package com.emp.Management.controller;

import com.emp.Management.dto.EmployeeDetailDto;
import com.emp.Management.dto.ProjectDto;
import com.emp.Management.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private EmployeeService employeeService;

    @Test
    void createEmployee_success_withProject() throws Exception {
        ProjectDto projectDto = new ProjectDto(1L, "Project X", "PX-001");
        EmployeeDetailDto mockEmployee = new EmployeeDetailDto(
                1L, "John", "Doe", "john@example.com", null, null, projectDto
        );

        Mockito.when(employeeService.createEmployee(any(EmployeeDetailDto.class)))
                .thenReturn(mockEmployee);

        String employeeJson = """
            {
              "firstName": "John",
              "lastName": "Doe",
              "email": "john@example.com",
              "project": { "id": 1, "projectName": "Project X", "projectId": "PX-001" }
            }
            """;

        mockMvc.perform(post("/api/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.email").value("john@example.com"))
                .andExpect(jsonPath("$.project.projectName").value("Project X"))
                .andExpect(jsonPath("$.project.projectId").value("PX-001"));
    }

    @Test
    void getEmployeeById_success_withProject() throws Exception {
        ProjectDto projectDto = new ProjectDto(1L, "Project X", "PX-001");
        EmployeeDetailDto mockEmployee = new EmployeeDetailDto(
                1L, "Jane", "Smith", "jane@example.com", null, null, projectDto
        );

        Mockito.when(employeeService.getEmployeeById(eq(1L)))
                .thenReturn(mockEmployee);

        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Smith"))
                .andExpect(jsonPath("$.email").value("jane@example.com"))
                .andExpect(jsonPath("$.project.projectName").value("Project X"))
                .andExpect(jsonPath("$.project.projectId").value("PX-001"));
    }
}
