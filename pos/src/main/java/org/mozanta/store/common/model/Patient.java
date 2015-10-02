package com.mozanta.store.common.model;

/**
 * @author Dhafnas
 *
 */
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mozanta.store.common.pojo.Address;

@Document(collection = "patient")
public class Patient {
	@Id
	private ObjectId	patientId;
	@NotEmpty
	private String		patientNo;
	@NotEmpty
	private String		patientName;
	@Valid
	private Address		patientAddress;

	public Patient() {
		super();
	}

	public Patient(final ObjectId patientId, final String patientNo,
			final String patientName, final Address patientAddress) {
		super();
		this.patientId = patientId;
		this.patientNo = patientNo;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
	}

	public ObjectId getPatientId() {
		return patientId;
	}

	public void setPatientId(final ObjectId patientId) {
		this.patientId = patientId;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(final String patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(final String patientName) {
		this.patientName = patientName;
	}

	public Address getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(final Address patientAddress) {
		this.patientAddress = patientAddress;
	}

}
