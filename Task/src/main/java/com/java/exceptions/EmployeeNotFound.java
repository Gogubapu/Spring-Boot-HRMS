package com.java.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.http.HttpStatus;

import com.java.exceptions.ApiErrors;

@ControllerAdvice  
public class EmployeeNotFound extends RuntimeException{
	private String msg;
	private int status; 
	
	public EmployeeNotFound(){
		super();		
		}
	public EmployeeNotFound(String msg){
		super(msg);
	}

}
