package com.test.userlogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="folder")
public class TFolder {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fId;
	
	@Column
	private String fName;
	
	private String otp;
	
	public TFolder() {
		super();
	}
	public TFolder(Long fId, String fName, String otp) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.otp = otp;
	}
	public Long getfId() {
		return fId;
	}
	public void setfId(Long fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	

}
