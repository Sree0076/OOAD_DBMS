package com.moop.entity;

import java.util.ArrayList;

public class Clients {

    int clientId;
    String firstName;
    String lastName;
    String email;
    String phone;
    
    ArrayList<Contracts> contracts;
    
    
    
public Clients(int clientId, String firstName, String lastName, String email, String phone) {
		super();
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.contracts = new ArrayList<>();
	}

//	public Clients(int clientId, String firstName, String lastName, String email, String phone) {
//		super();
//		this.clientId = clientId;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.phone = phone;
//		this.contracts = new ArrayList<>();
//	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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
