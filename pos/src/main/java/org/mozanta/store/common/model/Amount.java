/**
 * 
 */
package com.mozanta.store.common.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Dhafnas
 *
 */
@Document(collection = "amount")
public class Amount {
	@Id
	private ObjectId	cashId;
	@NotEmpty
	@NotNull
	@Pattern(regexp = "\\d{4}/\\d{2}/\\d{2}")
	private String		date;
	@NotNull
	private float		total;
	@NotNull
	private float		balance;

	public Amount() {

	}

	public Amount(final ObjectId cashId, final String date, final float total,
			final float balance) {
		super();
		this.cashId = cashId;
		this.date = date;
		this.total = total;
		this.balance = balance;
	}

	public ObjectId getCashId() {
		return cashId;
	}

	public void setCashId(final ObjectId cashId) {
		this.cashId = cashId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(final float total) {
		this.total = total;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(final float balance) {
		this.balance = balance;
	}

}
