package com.hcl.activity.tracker.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hcl.activity.tracker.request.ActivityRequest;
import com.hcl.web.utils.DateFormat;

import lombok.Data;
@Data
@Entity
@Table(name = "activity")
public class ActivityTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String empName;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	private int empCode;
	private String date;
	public int getEmpCode() {
		return empCode;
	}
	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}
	private String updatedDate;
	private String description;
	private String status;
	
	public ActivityTracker(ActivityRequest request) {
		this.empName = request.getEmp_name();
		this.empCode = request.getEmpCode();
		this.date = DateFormat.convertDateToString("yyyy-MM-dd");
		this.updatedDate = DateFormat.convertDateToString("yyyy-MM-dd HH:mm:ss");
		this.description = request.getDescription();
		this.status = request.getStatus();
	}
	public ActivityTracker(ActivityTracker at , ActivityRequest req) {
		this.id = at.getId();
		this.empName = at.getEmpName();
		this.empCode = at.getEmpCode();
		this.date = at.getDate();
		this.updatedDate = DateFormat.convertDateToString("yyyy-MM-dd HH:mm:ss");
		this.description = req.getDescription();
		this.status = req.getStatus();
	}
	public ActivityTracker() {}
}
