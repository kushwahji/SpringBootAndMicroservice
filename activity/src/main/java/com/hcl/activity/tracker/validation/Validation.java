/**
 * 
 */
package com.hcl.activity.tracker.validation;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.hcl.activity.tracker.request.ActivityDateRequest;
import com.hcl.activity.tracker.request.ActivityRequest;
import com.hcl.web.exception.ApplicationException;
import com.hcl.web.validation.MsValidation;

/**
 * @author SANTOSH
 *
 */
@Component
public class Validation {
	
	public static void validate(ActivityRequest v) {
		try {
			MsValidation.objectCheck(v, "activity");
			MsValidation.nullOrEmply(v.getDescription(), "Description");
			MsValidation.nullOrEmply(v.getEmp_name(), "Employee Name");
			MsValidation.nullOrEmply(v.getStatus(), "Status");
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}

	public static void validateDate(ActivityDateRequest request) {
		MsValidation.nullOrEmply(request.getFromDate(), "From Date");
		MsValidation.nullOrEmply(request.getToDate(), "From Date");
		//MsValidation.length(request.getEmp_code(), "Emp Code");
		
	}

}
