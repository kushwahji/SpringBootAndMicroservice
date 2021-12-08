/**
 * 
 */
package com.hcl.employee.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * @author SANTOSH
 *
 */
@Data
@Entity
public class Employee {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProject_status() {
		return project_status;
	}

	public void setProject_status(String project_status) {
		this.project_status = project_status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(required = true,value = "Code",example = "1111")
	@Column(unique = true)
	private int code;

	@ApiModelProperty(required = true,value = "Name",example = "Santosh")
	private String name;
	
	@ApiModelProperty(required = true,value = "Job Title",example = "Java")
	private String job_title;
	
	@ApiModelProperty(required = true,value = "Code",example = "santosh.kushwah@hcl.com")
	private String emailId;
	
	@ApiModelProperty(required = true,value = "Experience",example = "5 yeay's")
	private String experience;
	
	@ApiModelProperty(required = true,value = "Phone Number",example = "9752572357")
	private long phoneNumber;

	@ApiModelProperty(required = true,value = "Location",example = "Noida")
	private String location;
	
	@ApiModelProperty(required = true,value = "Project Status",example = "In-Process")
	private String project_status;
}
