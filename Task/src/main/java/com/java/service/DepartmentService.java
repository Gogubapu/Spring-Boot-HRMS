package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.java.model.Department;
import com.java.repository.DepartmentRepository;
import com.java.exceptions.NoSuchElementException;
import com.java.exceptions.DepartmentAlreadyExist;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	//list out details based on search operation element(keyword)
	public List<Department> departmentAll(Department department){
		//list contains all the details of in the table.
		List<Department> list=departmentRepository.findAll();
		return list;
	} 
	//Here saving employee details into table in database(new or update).
	public void saveDepartment(Department department) {
		Department existDept=departmentRepository.findByName(department.getName());
		if(existDept!=null){
			throw new DepartmentAlreadyExist("Department already exists");
		}
		departmentRepository.save(department);
	}
	//here providing service for getting details from table by using id.
	public Department get(String id) {
		return departmentRepository.findById(id).get();
	}
	//here providing service for delete details in table by using id.
	public void deleteDepartmentById(String id) {
		this.departmentRepository.deleteById(id);
	}
	
}
