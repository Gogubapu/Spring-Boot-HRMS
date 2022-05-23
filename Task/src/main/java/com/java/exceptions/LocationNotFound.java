package com.java.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.http.HttpStatus;

import com.java.exceptions.ApiErrors;

@ControllerAdvice  
public class LocationNotFound extends RuntimeException{
	private String msg;
	private int status; 
	
	public LocationNotFound(){
		super();		
		}
	public LocationNotFound(String msg){
		super(msg);
	}

}
