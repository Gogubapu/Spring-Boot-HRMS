package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.java.model.Location;
import com.java.repository.LocationRepository;

import com.java.exceptions.LocationAlreadyExist;
import com.java.exceptions.NoSuchElementException;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	//list out details based on search operation element(keyword)
	public List<Location> listAll(Location location){
		//list contains all the details of in the table.
			List<Location> list=locationRepository.findAll();
		
			return list;
	} 
	//Here saving employee details into table in database(new or update).
	public Location saveLocation(Location location) {
		Location existloc=locationRepository.findByName(location.getName());
		//System.out.println(existloc);
		if(existloc!=null){
			throw new LocationAlreadyExist("Loctaion already exists");
		}
		return locationRepository.save(location);
	}
	//here providing service for getting details from table by using id.
	public Location get(String id) {
		return locationRepository.findById(id).get();
	}
	//here providing service for delete details in table by using id.
	public void deleteLocationById(String id) {
		this.locationRepository.deleteById(id);
	}
	
}
