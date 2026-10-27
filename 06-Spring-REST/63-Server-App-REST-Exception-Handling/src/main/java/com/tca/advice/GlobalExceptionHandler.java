package com.tca.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tca.exception.EmployeeAlreadyExistException;
import com.tca.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException ex)
	{
		return new ResponseEntity<String>("Error : " + ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeAlreadyExistException.class)
	public ResponseEntity<String> handleEmployeeAlreadyExistException(EmployeeAlreadyExistException ex)
	{
		return new ResponseEntity<String>("Error : " + ex.getMessage(), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex)
	{
		return new ResponseEntity<String>("Error : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
