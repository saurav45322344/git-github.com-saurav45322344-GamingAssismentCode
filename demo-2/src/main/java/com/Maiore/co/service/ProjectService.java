package com.Maiore.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Maiore.co.entity.Project;
import com.Maiore.co.repository.ProjectRepository;

@Service
public class ProjectService {
@Autowired
	private ProjectRepository projectRepository;

public void saveProject(Project projectObj) {
	projectRepository.save(projectObj);
}
public List<Project> getProjectdetails(Long projectId){
	if(null!=projectId) {
		return projectRepository.findAllProjectId(projectId);
	}
	else {
	return projectRepository.findAll();
}
}
public void deleteProject(Long projectId) {
	//projectRepository.deleteById(projectId);
}
}
