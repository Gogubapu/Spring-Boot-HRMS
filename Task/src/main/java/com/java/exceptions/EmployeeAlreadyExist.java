package com.java.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

import com.java.exceptions.ApiErrors;

@ControllerAdvice  
public class EmployeeAlreadyExist extends RuntimeException{
	private String msg;
	private int status; 
	private LocalDateTime timestamps;

	public EmployeeAlreadyExist(){
		super();		
		}
	public EmployeeAlreadyExist(String msg){
		super(msg);
	}
}
