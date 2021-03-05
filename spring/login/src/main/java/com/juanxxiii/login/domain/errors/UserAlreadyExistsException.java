package com.juanxxiii.login.domain.errors;

public class UserAlreadyExistsException extends Exception{
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}
