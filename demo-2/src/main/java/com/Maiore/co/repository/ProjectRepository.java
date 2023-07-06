package com.Maiore.co.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Maiore.co.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
List<Project> findAllProjectId(long projectId);
}
