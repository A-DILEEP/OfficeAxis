package com.emp.Management.mapper;

import com.emp.Management.dto.ProjectDto;
import com.emp.Management.entity.Project;

public class ProjectMapper {
    public static ProjectDto toDto(Project project) {
        if (project == null) return null;
        return new ProjectDto(
                project.getId(),
                project.getProjectName(),
                project.getProjectId()
        );
    }

    public static Project toEntity(ProjectDto dto) {
        if (dto == null) return null;
        Project project = new Project();
        project.setId(dto.getId());
        project.setProjectName(dto.getProjectName());
        project.setProjectId(dto.getProjectId());
        return project;
    }
}
