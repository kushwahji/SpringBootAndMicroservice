/**
 * 
 */
package com.hcl.activity.tracker.response;

import java.util.Date;

import com.hcl.activity.tracker.entity.ActivityTracker;
import lombok.Data;

/**
 * @author SANTOSH
 *
 */
@Data
public class ActivityResponse {
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String name;
	private String jobTitle;
	private String emailId;
	private String status;
	private String description;
	private String date;
	public ActivityResponse() {}
	public ActivityResponse(ActivityTracker at, Employee emp) {
		this.code =""+emp.getCode();
		this.name = emp.getName();
		this.jobTitle = emp.getJob_title();
		this.emailId = emp.getEmailId();
		this.status = at.getStatus();
		this.description = at.getDescription();
		this.date = at.getDate();
	}
	@Override
	public String toString() {
		return "ActivityResponse [code=" + code + ", name=" + name + ", jobTitle=" + jobTitle + ", emailId=" + emailId
				+ ", status=" + status + ", description=" + description + ", date=" + date + "]";
	}

}
