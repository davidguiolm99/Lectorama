package com.davidguiolm.app.lectorama.services.exceptions;

public class RegistroNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1047262991525661440L;

	public RegistroNotFoundException() {
	}

	public RegistroNotFoundException(String message) {
		super(message);
	}

	public RegistroNotFoundException(Throwable cause) {
		super(cause);
	}

	public RegistroNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegistroNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
