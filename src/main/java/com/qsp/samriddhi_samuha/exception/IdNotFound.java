package com.qsp.samriddhi_samuha.exception;

public class IdNotFound extends RuntimeException
{
	String message ;
	
	@Override
	public String getMessage() 
	{
		return message ;
	}
	
	public IdNotFound(String messgae)
	{
		super() ;
		this.message = messgae ;
	}
}
