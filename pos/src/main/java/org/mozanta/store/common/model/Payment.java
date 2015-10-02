/**
 * 
 */
package com.mozanta.store.common.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhafnas
 *
 */
@Document(collection = "payment")
public class Payment {
	@Id
	private ObjectId	paymentId;
	@NotNull
	private int			paymentNo;

	@Min(1)
	private float		paymentAmount;
	@NotEmpty
	private String		paymentDate;
	@NotEmpty
	private String		patientNo;

	public Payment() {

	}

	public Payment(final ObjectId paymentId, final int paymentNo,
			final float paymentAmount, final String paymentDate,
			final String patientNo) {
		super();
		this.paymentId = paymentId;
		this.paymentNo = paymentNo;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
		this.patientNo = patientNo;
	}

	public ObjectId getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(final ObjectId paymentId) {
		this.paymentId = paymentId;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(final String patientNo) {
		this.patientNo = patientNo;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(final int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(final float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(final String paymentDate) {
		// this.paymentDate = paymentDate;
		final Date d = new Date();
		final SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		final String date = format1.format(d);
		this.paymentDate = date;
	}

}
