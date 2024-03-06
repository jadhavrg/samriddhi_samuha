package com.qsp.samriddhi_samuha.exception;

public class InstallementsIsNotFound extends RuntimeException
{
	String message ;
	
	public InstallementsIsNotFound(String message) 
	{
		super() ;
		this.message = message ;
	}
	
	@Override
	public String getMessage() 
	{
		return message;
	}
}
