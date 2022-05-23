package com.java.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.http.HttpStatus;

import com.java.exceptions.ApiErrors;

@ControllerAdvice  
public class NumberFormatException extends RuntimeException{
	private String msg; 
	
	public NumberFormatException(){
		super();		
		}
	public NumberFormatException(String msg){
		super(msg);
	}

}
