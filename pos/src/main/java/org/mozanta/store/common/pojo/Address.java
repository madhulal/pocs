/**
 * 
 */
package com.mozanta.store.common.pojo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Dhafnas
 *
 */
public class Address {
	@NotEmpty
	private String	postCode;
	@NotEmpty
	private String	district;
	@NotEmpty
	private String	state;

	public Address() {

	}

	public Address(final String postCode, final String district,
			final String state) {

		this.postCode = postCode;
		this.district = district;
		this.state = state;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(final String postCode) {
		this.postCode = postCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(final String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

}
