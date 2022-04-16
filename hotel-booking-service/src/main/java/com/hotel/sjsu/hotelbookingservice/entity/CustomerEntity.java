package com.hotel.sjsu.hotelbookingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerId;

	@Column(name="cust_first_name")
	private String custFirstName;
	
	@Column(name="cust_last_name")
	private String custLastName;
	
	@Column(name="cust_password")
	private String custPassword;
	
	@Column(name="cust_email")
	private String custEmail;
	
	@Column(name="cust_address")
	private String custAddress;
	
	@Column(name="loyalty_points")
	private Integer loyaltyPoints;
	
	@Column(name="contact_number")
	private String contactNumber;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(Long customerId, String custFirstName, String custLastName, String custPassword,
			String custEmail, String custAddress, Integer loyaltyPoints, String contactNumber) {
		super();
		this.customerId = customerId;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custPassword = custPassword;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.loyaltyPoints = loyaltyPoints;
		this.contactNumber = contactNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public Integer getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(Integer loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}

