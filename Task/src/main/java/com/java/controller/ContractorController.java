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
import com.java.model.Contractor;

import com.java.service.EmployeeService;
import com.java.service.ContractorService;

@Controller
public class ContractorController {
	@Autowired
	private EmployeeService service;
	@Autowired
	private ContractorService contractservice;


	//In index page have all details in table format and search operation done on same page.
	@RequestMapping("/contractorAdd")
	public String contractorHomePage(Contractor contractor,Model model)
	{
		List<Contractor> listcontracts= contractservice.contractorAll(contractor);
		
		model.addAttribute("listcontracts",listcontracts);
		return "contractorAdd";
	}

	//Creating new employee and based http request and Add.html page send to web.
	@GetMapping("/addProject")
	public String addContractor(Model model) {
		
		Contractor contractor = new Contractor();
		model.addAttribute("contractor", contractor);
		return "contractor";
	}

	//inserting or updating data into table
	@PostMapping("/saveProject")
	public String saveContractor(@Valid Contractor contractor) {
		
		contractservice.saveContractor(contractor);
		return "redirect:/contractorAdd";
	}
	@PostMapping("/updateProject")
	public String updateContractor(@Valid Contractor contractor) {
		
		contractservice.updateContractor(contractor);
		return "redirect:/contractorAdd";
	}
	
	//Update operation done by using id
	@RequestMapping("/editby/{id}")
	public ModelAndView showEditContractorForm(@PathVariable(name = "id") String id) {
		ModelAndView mav = new ModelAndView("contractorM");
		
		Contractor contractor = contractservice.get(id);
		mav.addObject("contractor", contractor);
		
		return mav;
	}	
	
	//Delete operation done by using id 
	@GetMapping("/deletewiths/{id}")
	public String deleteContractor(@PathVariable(value = "id") String id) {
		this.contractservice.deleteContractorById(id);
		return "redirect:/contractorAdd";
	}
	
	
}
