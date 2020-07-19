package net.doriv.ecommerce.exception;

import java.io.Serializable;

public class NotFoundException extends Exception implements Serializable {
	
	public String getMessage() {
		return message;
	}

	private String message;
	
	public NotFoundException() {
		this("It doesn't exist.");
	}
	
	public NotFoundException(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
	
}
