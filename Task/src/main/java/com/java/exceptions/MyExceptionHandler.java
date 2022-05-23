package com.java.exceptions;

import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import com.java.exceptions.NoSuchElementException;
import com.java.exceptions.EmployeeNotFound;
import com.java.exceptions.NumberFormatException;
import com.java.exceptions.DepartMentNotFound;
import com.java.exceptions.EmployeeAlreadyExist;
import com.java.exceptions.DepartmentAlreadyExist;
import com.java.exceptions.ContractorAlreadyExist;
import com.java.exceptions.LocationAlreadyExist;
import com.java.exceptions.ApiErrors;

@ControllerAdvice  
public class MyExceptionHandler{
	
	LocalDateTime datetime = LocalDateTime.now();

	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=Exception.class)
	public String handleNumberFormatException(Exception exception,Model model){
		model.addAttribute("error" ,exception.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		return "indexErrors";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=NoSuchElementException.class)
	public String handleNoSuchElementException(NoSuchElementException noSuchElementException,Model model){
		model.addAttribute("error",noSuchElementException.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.NOT_FOUND);
		return "indexErrors";
	}
	//NotFound
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=EmployeeNotFound.class)
	public String handleEmployeeNotFound(EmployeeNotFound employeeNotFound,Model model){
		model.addAttribute("error",employeeNotFound.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.NOT_FOUND);
		return "indexErrors";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=DepartMentNotFound.class)
	public String handleDepartMentNotFound(DepartMentNotFound departMentNotFound,Model model){
		model.addAttribute("error",departMentNotFound.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.NOT_FOUND);
		return "indexErrors";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value=LocationNotFound.class)
	public String handleLocationNotFound(LocationNotFound locationNotFound,Model model){
		model.addAttribute("error",locationNotFound.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.NOT_FOUND);
		return "indexErrors";
	}
	
	//Numberformat
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=NumberFormatException.class)
	public String handleNumberFormatException(NumberFormatException numberFormatException,Model model){
		model.addAttribute("error",numberFormatException.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR);
		return "indexErrors";
	}
	//Already exists
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=EmployeeAlreadyExist.class)
	public String handleEmployeeAlreadyExistException(EmployeeAlreadyExist employeeAlreadyExist,Model model){
		model.addAttribute("error",employeeAlreadyExist.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.BAD_REQUEST);
		return "indexErrors";
	}
	
	@ExceptionHandler(value=ContractorAlreadyExist.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public String handleContractorAlreadyExistException(ContractorAlreadyExist contractorAlreadyExist,Model model){
		//model.addattribute("status",HttpStatus.BAD_REQUEST.value());
		model.addAttribute("error",contractorAlreadyExist.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.BAD_REQUEST);
		return "indexErrors";
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=DepartmentAlreadyExist.class)
	public String handleDepartmentAlreadyExist(DepartmentAlreadyExist departmentAlreadyExist,Model model){
		model.addAttribute("error",departmentAlreadyExist.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.BAD_REQUEST);
		return "indexErrors";
	}
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value=LocationAlreadyExist.class)
	public String handleLocationAlreadyExist(LocationAlreadyExist locationAlreadyExist,Model model){
		model.addAttribute("error",locationAlreadyExist.getMessage());
		model.addAttribute("timestamp",datetime);
		model.addAttribute("status",HttpStatus.BAD_REQUEST);
		return "indexErrors";
	}

}
