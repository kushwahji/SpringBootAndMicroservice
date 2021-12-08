/**
 * 
 */
package com.hcl.web.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.hcl.web.exception.ApplicationException;

/**
 * @author SANTOSH
 *
 */
@Component
public class MsValidation {
	public static void objectCheck(Object val, String field) throws ApplicationException {
		try {
			if (null==val) {
				throw new ApplicationException("Please Enter data " + field+" is null");
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}

	}
	
	public static void pattenCheck(String val, String patten, String field) throws ApplicationException {
		try {
			Pattern p = Pattern.compile(patten);
			Matcher m = p.matcher(val);
			if (!m.find()) {
				throw new ApplicationException("Please enter valid " + field);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}

	}

	public static void nullOrEmply(String val, String field) throws ApplicationException {
		try {
			if (null == val || val.isEmpty() || val.isBlank()) {
				throw new ApplicationException("Please enter valid " + field);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}

	}

	public static void length(int val, String field) throws ApplicationException {
		try {
			if (val == 0) {
				throw new ApplicationException("Please enter valid " + field);
			}
		} catch (Exception e) {
			throw new ApplicationException(e.getMessage());
		}

	}
}
