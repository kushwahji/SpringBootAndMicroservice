/**
 * 
 */
package com.hcl.web.exception;

import java.util.Date;

/**
 * @author SANTOSH
 *
 */
public class ErrorMessage {
	private int statusCode;
	private Date timestamp;
	private String errorDetails;
	private String errorMoreInfo;

	public ErrorMessage(int statusCode, Date timestamp, String errorDetails, String errorMoreInfo) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.errorDetails = errorDetails;
		this.errorMoreInfo = errorMoreInfo;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return errorDetails;
	}

	public String getDescription() {
		return errorMoreInfo;
	}
}