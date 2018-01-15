package com.enterprise.test.api.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EmployeeNotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(EmployeeNotFoundException.class);
	
	
	public EmployeeNotFoundException() {
		super();
		LOGGER.info("Employee not found exception is being handled...");
	}


	public EmployeeNotFoundException(int status) {
		super(status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(Response response) {
		super(response);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(Status status) {
		super(status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message, int status) {
		super(message, status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message, Response response) {
		super(message, response);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message, Status status) {
		super(message, status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message, Throwable cause, int status) {
		super(message, cause, status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message, Throwable cause, Response response) {
		super(message, cause, response);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message, Throwable cause, Status status) throws IllegalArgumentException {
		super(message, cause, status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(String message) {
		super(message);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(Throwable cause, int status) {
		super(cause, status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(Throwable cause, Response response) {
		super(cause, response);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(Throwable cause, Status status) throws IllegalArgumentException {
		super(cause, status);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}


	public EmployeeNotFoundException(Throwable cause) {
		super(cause);
				LOGGER.info("Duplicate Employee ID exception is being handled...");
	}
}
