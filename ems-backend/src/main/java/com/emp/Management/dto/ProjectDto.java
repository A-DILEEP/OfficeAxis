package com.emp.Management.dto;

public class ProjectDto {
    private Long id;
    private String projectName;
    private String projectId;

    public ProjectDto() {}

    public ProjectDto(Long id, String projectName, String projectId) {
        this.id = id;
        this.projectName = projectName;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
