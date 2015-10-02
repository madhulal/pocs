/**
 * 
 */
package com.mozanta.store.common.model;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhafnas
 *
 */
@Document(collection = "volunteer")
public class Volunteer {
	@Id
	private ObjectId	volunteerId;
	@NotEmpty
	@NotNull
	private String		volunteerUserName;
	@NotEmpty
	@NotNull
	private String		volunteerPassword;
	@NotEmpty
	@NotNull
	private String		volunteerName;
	@NotEmpty
	@NotNull
	private String		volunteerMobileNumber;
	@NotEmpty
	@NotNull
	@Email
	private String		volunteerEmail;

	public Volunteer() {
		super();
	}

	public Volunteer(final ObjectId volunteerId,
			final String volunteerUserName, final String volunteerPassword,
			final String volunteerName, final String volunteerMobileNumber,
			final String volunteerEmail) {
		super();
		this.volunteerId = volunteerId;
		this.volunteerUserName = volunteerUserName;
		this.volunteerPassword = volunteerPassword;
		this.volunteerName = volunteerName;
		this.volunteerMobileNumber = volunteerMobileNumber;
		this.volunteerEmail = volunteerEmail;
	}

	public ObjectId getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(final ObjectId volunteerId) {
		this.volunteerId = volunteerId;
	}

	public String getVolunteerUserName() {
		return volunteerUserName;
	}

	public void setVolunteerUserName(final String volunteerUserName) {
		this.volunteerUserName = volunteerUserName;
	}

	public String getVolunteerPassword() {
		return volunteerPassword;
	}

	public void setVolunteerPassword(final String volunteerPassword) {
		this.volunteerPassword = volunteerPassword;
	}

	public String getVolunteerName() {
		return volunteerName;
	}

	public void setVolunteerName(final String volunteerName) {
		this.volunteerName = volunteerName;
	}

	public String getVolunteerMobileNumber() {
		return volunteerMobileNumber;
	}

	public void setVolunteerMobileNumber(final String volunteerMobileNumber) {
		this.volunteerMobileNumber = volunteerMobileNumber;
	}

	public String getVolunteerEmail() {
		return volunteerEmail;
	}

	public void setVolunteerEmail(final String volunteerEmail) {
		this.volunteerEmail = volunteerEmail;
	}

}
