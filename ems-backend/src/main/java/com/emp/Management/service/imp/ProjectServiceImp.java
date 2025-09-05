package com.emp.Management.service.imp;

import com.emp.Management.dto.ProjectDto;
import com.emp.Management.entity.Project;
import com.emp.Management.exception.ResourceNotFoundException;
import com.emp.Management.mapper.ProjectMapper;
import com.emp.Management.repository.ProjectRepository;
import com.emp.Management.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = ProjectMapper.toEntity(projectDto);
        Project saved = projectRepository.save(project);
        return ProjectMapper.toDto(saved);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
        return ProjectMapper.toDto(project);
    }

    @Override
    public ProjectDto updateProject(Long id, ProjectDto projectDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
        project.setProjectName(projectDto.getProjectName());
        project.setProjectId(projectDto.getProjectId());
        return ProjectMapper.toDto(projectRepository.save(project));
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
        projectRepository.delete(project);
    }
}
