package com.tca.exceptions;

public class BookAlreadyExistsException extends RuntimeException
{
	public BookAlreadyExistsException(String msg)
	{
		super(msg);
	}
}
