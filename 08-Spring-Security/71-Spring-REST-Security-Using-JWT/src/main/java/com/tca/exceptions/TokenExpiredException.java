package com.tca.exceptions;

public class TokenExpiredException extends RuntimeException
{
	public TokenExpiredException(String msg)
	{
		super(msg);
	}
}
