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
//Enitity annotations is used to create table in database.
@Entity

public class Department
{
	//Creating data members for the application ,below
    	@Id
	@Size(min=3,max=6)
    	@Column(name="Department_id")
	private String id;
	
	@NotNull
	@Size(max=25)
	@Column(name="Department_name")
	private String name;
	
	/*@OneToMany(fetch=FetchType.LAZY, targetEntity=Employee.class, cascade=CascadeType.ALL)
	@JoinColumn(name ="department", referencedColumnName="Department_name")	
	private Set department;*/
	
	//Generated getters and setters Methods above data members.
	public Department(){
	}
	public Department(String id,String name){
		this.id=id;
		this.name=name;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*public Set getDepartment(){
		return department;
	}
	public void setDepartment(Set department){
		this.department=department;
	}*/


}

