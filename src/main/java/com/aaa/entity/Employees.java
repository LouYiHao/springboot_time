package com.aaa.entity;

   /**
    * employees 实体类
    * Thu Nov 08 16:19:10 GMT+08:00 2018 娄轶豪
    */ 


public class Employees{
	private String employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String officeCode;
	private String reportsTo;
	private String jobTitle;
	public void setEmployeeNumber(String employeeNumber){
	this.employeeNumber=employeeNumber;
	}
	public String getEmployeeNumber(){
		return employeeNumber;
	}
	public void setLastName(String lastName){
	this.lastName=lastName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setFirstName(String firstName){
	this.firstName=firstName;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setExtension(String extension){
	this.extension=extension;
	}
	public String getExtension(){
		return extension;
	}
	public void setEmail(String email){
	this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setOfficeCode(String officeCode){
	this.officeCode=officeCode;
	}
	public String getOfficeCode(){
		return officeCode;
	}
	public void setReportsTo(String reportsTo){
	this.reportsTo=reportsTo;
	}
	public String getReportsTo(){
		return reportsTo;
	}
	public void setJobTitle(String jobTitle){
	this.jobTitle=jobTitle;
	}
	public String getJobTitle(){
		return jobTitle;
	}
}

