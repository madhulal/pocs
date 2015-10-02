package com.mozanta.store.common.model;

import java.util.Date;
import java.util.Map;

import com.mozanta.store.common.model.Address;
import com.mozanta.store.common.model.ContactNumber;
import org.springframework.data.annotation.Id;

public class User {
	

	@Id
	private String id;

	private String userName;

	private String passWord;

	private String firstName;

	private String middleName;

	private String lastName;

	private String gender;

	private String martialStatus;

	private Date dateOfBirth;

	private Map<String, Address> address;

	private Map<String, ContactNumber> contactNumber;

	private String password1;

	private String password2;

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Map<String, ContactNumber> getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Map<String, ContactNumber> contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Map<String, Address> getAddress() {
		return address;
	}

	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(final String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}
	
	

}
