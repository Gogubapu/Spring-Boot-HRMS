package com.java.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import javax.validation.constraints.Pattern;
import com.java.model.Department;
import com.java.model.Location;

//Enitity annotations is used to create table in database.
@Entity
@Table(name = "employee")
public class Employee
{
	//Creating data members for the application ,below
    	@Id
    	@Column(name="id")
	@Size(min=1,max=10,message="The ID should follow upto 6 digits of alphanumeric only.")
	private String id;
	
	@NotNull
	@Column(name = "firstname")
	@Size(min=1,max=25,message="The First Name is maximum 25 characters only.")
	private String firstname;
	
	@NotNull
	@Column(name = "lastname")
	@Size(min=2,max=25,message="The Last Name is maximum 25 characters only.")
	private String lastname;
	
	@NotNull
	@Email(message="Enter a valid E-mail address..")
	@Column(name = "email")
	private String email;
	
	@Pattern(regexp="^\\d{10}$",message="Enter a valid mobile number 10 digits only..")
	@Column(name="mobile")
	private String mobile;
	
	@NotNull
	@Size(min=10,max=150,message="Enter your address maximum alphanumeric characters and numbers ,special characters..")
	@Column(name="address")
	private String address;
	
	@NotNull(message="Please enter employee designation..")
	@Size(max=25)
	@Column(name="designation")
	private String designation;
	
	
	@NotNull(message="please enter employee manager name..")
	@Size(max=12)
	@Column(name="manager")
	private String manager;
	
	@NotNull
	@Column(name="date_of_joining")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private String doj;
	
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@Column(name="date_of_termination")
	private String dot;
	
	@NotNull(message="please enter employee details..")
	@Column(name="status_of_Employee")
	private String status;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Contract_id")
	private Contractor contractor;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="Department_id")
	private Department department;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="Location_id")
	private Location location;
	
		
	//Generated getters and setters Methods above data members.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile(){
		return mobile;
	}
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getDesignation(){
		return designation;
	}
	public void setDesignation(String designation){
		this.designation=designation;
	}
	
	public String getManager(){
		return manager;
	}
	public void  setManager(String manager){
		this.manager=manager;
	}
	
	public String getDoj(){
		return doj;
	}
	public void setDoj(String doj){
		this.doj=doj;
	}
	public String getDot(){
		return dot;
	}
	public void setDot(String dot){
		this.dot=dot;
	}
	
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status=status;
	}
	
	public Contractor getContractor(){
		return contractor;
	}
	public void setContractor(Contractor contractor){
		this.contractor=contractor;
	}
	
	public Department getDepartment(){
		return department;
	}
	public void setDepartment(Department department){
		this.department=department;
	}
	
	public Location getLocation(){
		return location;
	}
	public void setLocation(Location location){
		this.location=location;
	}
}

	
	





