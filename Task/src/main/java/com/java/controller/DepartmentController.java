package com.java.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.repository.query.Param;


import com.java.model.Employee;
import com.java.model.Department;
import com.java.model.Location;
import com.java.service.EmployeeService;
import com.java.service.DepartmentService;


@Controller
public class DepartmentController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private DepartmentService reservice;

	//In index page have all details in table format and search operation done on same page.
	@RequestMapping("/department")
	public String homePage(Department department,Model model)
	{
		List<Department> listdepartments=reservice.departmentAll(department);
		model.addAttribute("listdepartments",listdepartments);

		return "department";
	}
	@GetMapping("/addDepartment")
	public String addDepartment(Model model) {
		
		Department department = new Department();
		model.addAttribute("department", department);
		return "departmentAdd";
	}
	@PostMapping("/saveDepartment")
	public String saveDepartment(@Valid Department department){
		reservice.saveDepartment(department);
		return "redirect:/department";
	}
	@GetMapping("/deleteby/{id}")
	public String deleteDepartment(@PathVariable(value = "id") String id) {
		this.reservice.deleteDepartmentById(id);
		return "redirect:/department";
	}
	
}
