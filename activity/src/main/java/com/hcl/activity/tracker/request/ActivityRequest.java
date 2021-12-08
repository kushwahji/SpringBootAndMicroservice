/**
 * 
 */
package com.hcl.activity.tracker.request;

import lombok.Data;

/**
 * @author SANTOSH
 *
 */
@Data
public class ActivityRequest {
	private String emp_name;

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
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

	private String description;
	
	private int empCode;

	public int getEmpCode() {
		return empCode;
	}

	public void setEmpCode(int empCode) {
		this.empCode = empCode;
	}

	private String status;
}
