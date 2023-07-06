package com.Maiore.co.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;

public class Employee {
private Long empId;
private String empName;
@ManyToMany(cascade = CascadeType.ALL)
private List<Project> projects;

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getEmpId() {
	return empId;
}
public void setEmpId(Long empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public List<Project> getProjects() {
	return projects;
}
public void setProjects(List<Project> projects) {
	this.projects = projects;
}

}
