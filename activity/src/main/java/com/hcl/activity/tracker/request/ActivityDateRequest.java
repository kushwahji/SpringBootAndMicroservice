/**
 * 
 */
package com.hcl.activity.tracker.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author SANTOSH
 *
 */
@Data
public class ActivityDateRequest {
	@ApiModelProperty(required = true, value = "Employee Code", example = "1112")
	private int emp_code;

	
	public int getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(int emp_code) {
		this.emp_code = emp_code;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@ApiModelProperty(required = true, value = "From Date", example = "2021-12-05")
	private String fromDate;

	@ApiModelProperty(required = true, value = "From Date", example = "2021-12-05")
	private String toDate;
}
