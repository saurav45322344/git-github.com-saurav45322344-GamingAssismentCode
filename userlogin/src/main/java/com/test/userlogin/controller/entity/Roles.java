package com.test.userlogin.controller.entity;

import com.test.userlogin.common.Auditable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Roles extends Auditable {

	@Id
	@GeneratedValue
	private int r_id;
	private String role;
	@OneToOne(targetEntity = Roles.class, cascade = CascadeType.ALL)
	private Permission permission;
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

}

	