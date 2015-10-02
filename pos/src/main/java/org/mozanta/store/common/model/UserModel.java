package com.mozanta.store.common.model;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import com.mozanta.store.common.model.Address;
import com.mozanta.store.common.model.ContactNumber;
import org.springframework.format.annotation.DateTimeFormat;

public class UserModel {
	@NotEmpty
	@Size(min = 1, max = 30)
	private String userName;
	@NotEmpty
	@Size(min = 8, max = 10)
	private String passWord;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String firstName;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String middleName;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String lastName;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String martialStatus;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull
	@Past
	private Date dateOfBirth;

	private String password1;

	private String password2;

	@Valid
	private Map<String, Address> addresses;

	@Valid
	private Map<String, ContactNumber> contactNumbers;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Map<String, Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Map<String, Address> addresses) {
		this.addresses = addresses;
	}

	public Map<String, ContactNumber> getContactNumbers() {
		return contactNumbers;
	}

	public void setContactNumbers(Map<String, ContactNumber> contactNumbers) {
		this.contactNumbers = contactNumbers;
	}
}
