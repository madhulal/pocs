package com.mozanta.store.entity;

import org.springframework.data.annotation.Id;

import com.mozanta.store.common.model.Address;
import com.mozanta.store.common.model.ContactNumber;

public class Organization {
	
	@Id
	String id;
	String name;
	String emailId;
	Address address;
	ContactNumber contactNumber;
	Manufactures manufactures;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ContactNumber getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(ContactNumber contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Manufactures getManufactures() {
		return manufactures;
	}
	public void setManufactures(Manufactures manufactures) {
		this.manufactures = manufactures;
	}

	
	

}
