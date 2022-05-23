package com.java.exceptions;

import org.springframework.ui.Model;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.java.exceptions.ApiErrors;
@ControllerAdvice  
public class NoSuchElementException extends RuntimeException{
	private String msg;
	
	public NoSuchElementException(){
		super();		
		}
	public NoSuchElementException(String msg){
		super(msg);
	}
	

}
