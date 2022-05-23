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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.repository.query.Param;


import com.java.model.Employee;
import com.java.model.Department;
import com.java.model.Location;
import com.java.service.EmployeeService;
import com.java.service.LocationService;
import com.java.exceptions.NumberFormatException;
import com.java.exceptions.NoSuchElementException;

@Controller
public class LocationController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private LocationService locservice;

	@GetMapping("/AutoCtc")
	public String atuoCtc(){

		return "autoCTC";
	}
	@GetMapping("/Calculate")
	public String autoCtc(@Param(value="number") String number,Model model){
		
			double month=Integer.parseInt(number)/12;
			double basic=(45.25/100)*month;
			double hra=(18.01/100)*month;
			double ca=(5.33/100)*month;
			double medical_Allowance=(4.166/100)*month;
			double special_Allowance=(13.983/100)*month;
			double meal_coupan=(3.66/100)*month;
	
			double grosspay=basic+hra+ca+medical_Allowance+special_Allowance+meal_coupan;
	
			double professional_tax=(0.66/100)*month;
			double provident_fund=(6.00/100)*month;
		
			double deductions=professional_tax+provident_fund;
			double takeHome=grosspay-deductions;
		
			model.addAttribute("basic",basic);
			model.addAttribute("hra",hra);
			model.addAttribute("ca",ca);
			model.addAttribute("medical_Allowance",medical_Allowance);
			model.addAttribute("special_Allowance",special_Allowance);
			model.addAttribute("meal_coupan",meal_coupan);
			model.addAttribute("professional_tax",professional_tax);
			model.addAttribute("provident_fund",provident_fund);
			model.addAttribute("takeHome",takeHome);
			model.addAttribute("deductions",deductions);
			model.addAttribute("grosspay",grosspay);
			return "autoCTC";
	}
	//In index page have all details in table format and search operation done on same page.
	
	
	@RequestMapping("/location")
	public String homePage(Location location,Model model)
	{
		List<Location> listlocations=locservice.listAll(location);
		if(listlocations!=null){
			model.addAttribute("listlocations",listlocations);

			return "locationindex";
		}
		throw new NumberFormatException("locations details are not found");
	}
	
	@GetMapping("/addLocation")
	public String addLocation(Model model) {
		Location location = new Location();
		if(location!=null){
			model.addAttribute("location", location);
			return "location";
		}
		throw new NumberFormatException("Location details are not found");
	}
	@PostMapping("/saveLocation")
	public String saveLocation(@Valid Location location){
		locservice.saveLocation(location);
		return "redirect:/location";
	}
	@GetMapping("/deleteto/{id}")
	public String deleteLocation(@PathVariable (value = "id") String id) {
		if(id!=null){
		this.locservice.deleteLocationById(id);
		return "redirect:/location";
		}
		throw new NumberFormatException("Entered Location id "+id+"details are not Valid");
	}
	
	
}
