package com.java;

import org.springframework.boot.ControllerAdvice;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@ControllerAdvice
public class ExceptionHandler{
	public String rollbackException(Model model){
		model.addAttribute("message","Rollback Exception occured");
		return "add";
    }
}
