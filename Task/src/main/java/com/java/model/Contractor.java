package com.java.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;
import java.time.LocalDate;
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

public class Contractor
{
	//Creating data members for the application ,below

    	@Id
	@Size(max=6)
	@Column(name= "Project_Id")
	private String id;

	@NotNull(message="please provide project name..")
	@Size(max=25)
	@Column(name = "Project_Name")
	private String projectname;
	
	@DateTimeFormat(pattern="dd-mm-yyyy")
	@NotNull(message="please provide project Start date.")
	@Column(name= "Project_start_date")
	private String psd;

	@DateTimeFormat(pattern="dd-mm-yyyy")
	@NotNull(message="please provide project End date.")
	@Column(name= "project_end_date")
	private String ped;
	
	/*@OneToMany(fetch=FetchType.LAZY, targetEntity=Employee.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "Project_Name", referencedColumnName="Project_name")
	private Set pname;*/

	//Generated getters and setters Methods above data members.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname){
		this.projectname=projectname;
	}
	
	public String getPsd(){
		return psd;
	}
	public void setPsd(String psd){
		this.psd=psd;
	}
	public String getPed(){
		return ped;
	}
	public void setPed(String ped){
		this.ped=ped;
	}

}
