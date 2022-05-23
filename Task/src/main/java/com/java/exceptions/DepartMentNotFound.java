package com.java.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.http.HttpStatus;

import com.java.exceptions.ApiErrors;

@ControllerAdvice  
public class DepartMentNotFound extends RuntimeException{
	private String msg;
	private int status; 
	
	public DepartMentNotFound(){
		super();		
		}
	public DepartMentNotFound(String msg){
		super(msg);
	}

}
