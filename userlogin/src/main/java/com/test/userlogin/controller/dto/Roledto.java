package com.test.userlogin.controller.dto;

public class Roledto {
	private String role;
	private int pid;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Roledto [role=" + role + ", pid=" + pid + "]";
	}
	public Roledto() {
		super();
		this.role = role;
		this.pid = pid;
	}
	
}

