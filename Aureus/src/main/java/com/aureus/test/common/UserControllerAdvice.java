package com.aureus.test.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice{
	
	/*@ExceptionHandler(UserNotFoundException.class)
	protected String handleUserNotFound(UserNotFoundException e)
	{
		return e.getMessage();
	}*/

}
