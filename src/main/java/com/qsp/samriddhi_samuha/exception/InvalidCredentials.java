package com.qsp.samriddhi_samuha.exception;

public class InvalidCredentials extends RuntimeException
{
	String message ;
	
	public InvalidCredentials(String message)
	{
		super() ;
		this.message = message ;
	}
	
	@Override
	public String getMessage() 
	{
		return message ;
	}
}
