package com.java.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//Enitity annotation mapped by repository hibernate automatically create table in database.
@Entity

public class Location
{
	//Creating data members for the application ,below
    	@Id
	@Size(min=3,max=6)
    	@Column(name="Location_id")
	private String id;

	@NotNull(message="Please provide location")
	@Size(max=25)
	@Column(name="Location")
	private String name;

	/*@OneToMany(fetch=FetchType.LAZY, targetEntity=Employee.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "Location", referencedColumnName="Location")
	private String location;*/

	//Generated getters and setters Methods above data members.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	

}

	
	





