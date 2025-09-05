package com.emp.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emp.Management.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByProjectId(String projectId); // example check for unique projectId
}
