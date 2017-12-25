package com.enterprise.test.api.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT,reason="Data Already Exists")
public class DuplicateEmployeeIDException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(DuplicateEmployeeIDException.class);

	public DuplicateEmployeeIDException() {
		super();
		LOGGER.info("Duplicate Employee ID exception is being handled...");
	}

	public DuplicateEmployeeIDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		LOGGER.info("Duplicate Employee ID exception is being handled...");
	}

	public DuplicateEmployeeIDException(String message, Throwable cause) {
		super(message, cause);
		LOGGER.info("Duplicate Employee ID exception is being handled...");
	}

	public DuplicateEmployeeIDException(String message) {
		super(message);
		LOGGER.info("Duplicate Employee ID exception is being handled...");
	}

	public DuplicateEmployeeIDException(Throwable cause) {
		super(cause);
		LOGGER.info("Duplicate Employee ID exception is being handled...");
	}

}
