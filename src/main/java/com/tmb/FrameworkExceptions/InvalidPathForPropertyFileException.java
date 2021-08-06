package com.tmb.FrameworkExceptions;

@SuppressWarnings("serial")
public class InvalidPathForPropertyFileException extends FrameworkException {
	
	public InvalidPathForPropertyFileException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message Details about the exception or custom message
	 * @param cause Pass the enriched stacktrace or customised stacktrace
	 */
	public InvalidPathForPropertyFileException(String message,Throwable cause) {
		super(message,cause);
	}
}
