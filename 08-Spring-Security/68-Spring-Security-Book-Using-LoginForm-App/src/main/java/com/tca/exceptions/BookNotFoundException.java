package com.tca.exceptions;

public class BookNotFoundException extends RuntimeException
{
	public BookNotFoundException(String msg)
	{
		super(msg);
	}
}
