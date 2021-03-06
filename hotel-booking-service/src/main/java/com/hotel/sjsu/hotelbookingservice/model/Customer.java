package com.hotel.sjsu.hotelbookingservice.model;

import javax.persistence.criteria.CriteriaBuilder;

public class Customer {

	private Long customerId;
	private String custFirstName;
	private String custLastName;
	private String custPassword;
	private String custEmail;
	private String custAddress;
	private Integer loyaltyPoints;
	private Integer bookingCount;
	private String contactNumber;
	
	public Customer() {
		super();
	}


	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custFirstName=" + custFirstName + ", custLastName="
				+ custLastName + ", custPassword=" + custPassword + ", custEmail=" + custEmail + ", custAddress="
				+ custAddress + ", loyaltyPoints=" + loyaltyPoints + ", bookingCount=" + bookingCount
				+ ", contactNumber=" + contactNumber + "]";
	}


	public Customer(Long customerId, String custFirstName, String custLastName, String custPassword, String custEmail,
			String custAddress, Integer loyaltyPoints, Integer bookingCount,String contactNumber) {
		
		super();
		this.customerId = customerId;		
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custPassword = custPassword;
		this.custEmail = custEmail;
		this.custAddress = custAddress;
		this.loyaltyPoints = loyaltyPoints;
		this.bookingCount = bookingCount;
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
	
	public Integer getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(Integer bookingCount) {
		this.bookingCount = bookingCount;
	}

}
