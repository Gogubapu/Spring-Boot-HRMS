package com.java.exceptions;

import org.springframework.http.HttpStatus;

public class ApiErrors
{
	private String message;
	private HttpStatus statusCode;

	public ApiErrors(String message){
		super();
		this.message=message;
	
	}
	public ApiErrors(HttpStatus statusCode){
		super();
		this.statusCode=statusCode;
	
	}
	
	
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message=message;
	}
	public HttpStatus getStatusCode(){
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode){
		this.statusCode=statusCode;
	}
}
	
	





