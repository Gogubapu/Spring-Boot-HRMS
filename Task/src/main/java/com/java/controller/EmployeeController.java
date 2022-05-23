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
import com.java.model.Contractor;
import com.java.model.Location;
import com.java.service.EmployeeService;

import com.java.repository.ContractorRepository;
import com.java.repository.DepartmentRepository;
import com.java.repository.LocationRepository;

import com.java.exceptions.EmployeeNotFound;
import com.java.exceptions.NoSuchElementException;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private DepartmentRepository repo;

	@Autowired
	private LocationRepository locationrepo;

	@Autowired
	private ContractorRepository contractorservice;

	
	//In index page have all details in table format and search operation done on same page.
	@RequestMapping("/")
	public String viewHomePage(@Param("keyword") String keyword,Model model)
	{
		List<Employee> listemployees= service.listAll(keyword);
		model.addAttribute("listemployees",listemployees);
		model.addAttribute("keyword",keyword);
		
			return "index";
	}

	//Creating new employee and based http request and Add.html page send to web.
	@GetMapping("/addEmployee")
	public String addEmployee(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		List<Department> listdepartments=repo.findAll();
		model.addAttribute("listdepartments",listdepartments);
		
		List<Location> listlocations=locationrepo.findAll();
		model.addAttribute("listlocations",listlocations);
		
		List<Contractor> projects=contractorservice.findAll();
		model.addAttribute("projects",projects);

		return "add";
	}

	//inserting or updating data into table
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid Employee employee) {
			service.saveEmployee(employee);
			return "redirect:/";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(@Valid Employee employee) {
		
		service.updateEmployee(employee);
		return "redirect:/";
	}
	
	
	//Update operation done by using id
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeeForm(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("Modify");
		
		Employee employee = service.get(id);
		mav.addObject("employee", employee);

		List<Department> listdepartments=repo.findAll();
		mav.addObject("listdepartments",listdepartments);
		
		List<Location> listlocations=locationrepo.findAll();
		mav.addObject("listlocations",listlocations);
		
		List<Contractor> projects=contractorservice.findAll();
		mav.addObject("projects",projects);

		return mav;
	}	
	
	//Delete operation done by using id 
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") String id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/";
	}
	
	
}
