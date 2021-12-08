/**
 * 
 */
package com.hcl.employee.validaion;

import org.springframework.stereotype.Component;

import com.hcl.employee.request.Employee;
import com.hcl.web.exception.ApplicationException;
import com.hcl.web.validation.MsValidation;

/**
 * @author SANTOSH
 *
 */
@Component
public class Validation {
	
	public static void validate(Employee v) {
		try {
			MsValidation.objectCheck(v, "employee");
			MsValidation.nullOrEmply(v.getName(), "Name");
			MsValidation.nullOrEmply(v.getExperience(), "Experience");
			MsValidation.nullOrEmply(v.getJob_title(), "Job Title");
			MsValidation.nullOrEmply(v.getLocation(), "Location");
			MsValidation.nullOrEmply(v.getProject_status(), "Project Status");
			MsValidation.nullOrEmply(v.getEmailId(), "EmailId");
			MsValidation.pattenCheck(""+v.getPhoneNumber(), "(0/91)?[7-9][0-9]{9}", "Phone Number");
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}
	}

}
