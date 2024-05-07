package com.moop.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Employees {
	
    int id;
    String firstName;
    String lastName;
    String email;
    String phone;
    Date hireDate;
    
    ArrayList<Contracts> contracts;
    
    
    
//public Employees(int id, String firstName, String lastName, String email, String phone, Date hireDate,
//			ArrayList<Contracts> contracts) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.phone = phone;
//		this.hireDate = hireDate;
//		this.contracts = contracts;
//	}
	public Employees(int id, String firstName, String lastName, String email, String phone,Date hireDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.hireDate = hireDate;
		this.contracts =new ArrayList<>();
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<Contracts> getContracts() {
		return contracts;
	}
	public void setContracts(ArrayList<Contracts> contracts) {
		this.contracts = contracts;
	}
    
    

}
