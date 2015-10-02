package com.mozanta.store.common.model;

/**
 @author Ajith P James Sep 11, 2015
 */

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Address {

	@NotEmpty
	@Size(min = 1, max = 30)
	private String addressLine1;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String addressLine2;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String addressLine3;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String city;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String state;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String post;
	@NotEmpty
	@Size(min = 1, max = 30)
	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getPost() {
		return post;
	}

	public void setPost(final String post) {
		this.post = post;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
