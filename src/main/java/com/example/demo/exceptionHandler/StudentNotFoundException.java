package com.example.demo.exceptionHandler;

public class StudentNotFoundException extends RuntimeException {
	private String message;

	public String getMessage() {
		return message;
	}

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}

}
