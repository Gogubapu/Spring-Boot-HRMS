package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.java.model.Employee;
import com.java.repository.EmployeeRepository;
import com.java.exceptions.EmployeeAlreadyExist;
import com.java.exceptions.NoSuchElementException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//list out details based on search operation element(keyword)
	public List<Employee> listAll(String keyword){
	
		if (keyword!=null) {
			 return employeeRepository.search(keyword);
		}
		//list contains all the details of in the table.
		List<Employee> list=employeeRepository.findAll();
		return list;
		
	} 
	//Here saving employee details into table in database(new or update).
	public Employee saveEmployee(Employee employee) {
		Employee existEmployee=employeeRepository.findByEmail(employee.getEmail());
		if(existEmployee!=null){
			throw new EmployeeAlreadyExist("Employee already exists");
		}
		return employeeRepository.save(employee);
	}
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	//here providing service for getting details from table by using id.
	public Employee get(String id) {
		return employeeRepository.findById(id).orElseThrow(()->new NoSuchElementException("Invalid employee id "+id));
		
	}
	//here providing service for delete details in table by using id.
	public void deleteEmployeeById(String id) {
		this.employeeRepository.deleteById(id);
	}
	
}
