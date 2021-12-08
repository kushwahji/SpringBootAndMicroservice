/**
 * 
 */
package com.hcl.web.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

public class ControllerExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ApplicationException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ResponseBody
	 * 
	 * @ExceptionHandler({MethodArgumentNotValidException.class,
	 * ConstraintViolationException.class}) public ResponseEntity<ErrorMessage>
	 * handleValidationExceptions(MethodArgumentNotValidException ex,WebRequest
	 * request) { ErrorMessage message = new
	 * ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage(),
	 * request.getDescription(false));
	 * 
	 * return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST); }
	 */
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	   Map<String, String> errors = new HashMap<>();
	 
	   ex.getBindingResult().getFieldErrors().forEach(error ->
	           errors.put(error.getField(), error.getDefaultMessage()));
	 
	   return errors;
	}
}
