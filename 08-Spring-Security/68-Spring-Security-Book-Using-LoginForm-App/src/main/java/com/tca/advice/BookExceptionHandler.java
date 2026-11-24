package com.tca.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tca.exceptions.BookAlreadyExistsException;
import com.tca.exceptions.BookNotFoundException;

@RestControllerAdvice
public class BookExceptionHandler 
{
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex)
	{
		return new ResponseEntity<String>("Error : " + ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookAlreadyExistsException.class)
	public ResponseEntity<String> handleBookAlreadyExistsException(BookAlreadyExistsException ex)
	{
		return new ResponseEntity<String>("Error : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex)
	{
		return new ResponseEntity<String>("Error : "+ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
