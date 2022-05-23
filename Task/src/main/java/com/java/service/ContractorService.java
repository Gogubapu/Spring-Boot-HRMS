package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.java.model.Contractor;
import com.java.repository.ContractorRepository;
import com.java.exceptions.EmployeeNotFound;
import com.java.exceptions.NoSuchElementException;

@Service
public class ContractorService {

	@Autowired
	private ContractorRepository contractorRepository;
	
	
	public List<Contractor> contractorAll(Contractor contractor){
		//list contains all the details of in the table.
		//throw new IllegalArgumentNotFound("Not contains all the Details of contracts...");
		List<Contractor> listprojects=contractorRepository.findAll();
		
		return listprojects;
	} 
	//Here saving employee details into table in database(new or update).
	public void saveContractor(Contractor contractor) {
		Contractor existContract=contractorRepository.findByProjectname(contractor.getProjectname());
		if(existContract!=null){
			throw new EmployeeNotFound("Contractor already there in my records...");
		}
		contractorRepository.save(contractor);
	}
	
	public void updateContractor(Contractor contractor) {
		contractorRepository.save(contractor);
	}
	
	//here providing service for getting details from table by using id.
	public Contractor get(String id) {
		return contractorRepository.findById(id).orElseThrow(()->new NoSuchElementException("invalid Contract id "+id));
	}
	//here providing service for delete details in table by using id.
	public void deleteContractorById(String id) {
		this.contractorRepository.deleteById(id);
	}
	
}
