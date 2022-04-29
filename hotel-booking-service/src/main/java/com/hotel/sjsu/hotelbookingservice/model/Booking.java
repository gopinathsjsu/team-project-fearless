package com.hotel.sjsu.hotelbookingservice.model;

import java.util.Calendar;

public class Booking {

	private	Long bookingId;
	private	Long hotelId;
	private	Long customerId;
	private String room;
	private	String amenity;
	private	Calendar bookingDateFrom;
	private	Calendar bookingDateTo;
	private	Integer noOfGuest;
	private	String bookingStatus;
	private	Double amount;
	private	Double totalAmount;
	private	String paymentMethod;
	private	String roomNumbers;
	private  Integer loyaltyPointsUsed;

	public Booking() {
		super();
	}


	public Booking(Long bookingId, Long hotelId, Long customerId, String room,
				   //Integer roomDeluxe,Integer roomSuite,
				   String amenity, Calendar bookingDateFrom,
				   Calendar bookingDateTo, Integer noOfGuest, String bookingStatus,
				   Double amount, Double totalAmount, String paymentMethod, String roomNumbers, Integer loyaltyPointsUsed) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.customerId = customerId;
//		this.roomDeluxe = roomDeluxe;
//		this.roomSuite = roomSuite;
		this.room = room;
		this.amenity = amenity;
		this.bookingDateFrom = bookingDateFrom;
		this.bookingDateTo = bookingDateTo;
		this.noOfGuest = noOfGuest;
		this.bookingStatus = bookingStatus;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.roomNumbers = roomNumbers;
		this.loyaltyPointsUsed = loyaltyPointsUsed;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

//	public Integer getRoomDeluxe() {
//		return roomDeluxe;
//	}
//
//	public void setRoomDeluxe(Integer roomDeluxe) {
//		this.roomDeluxe = roomDeluxe;
//	}
//
//	public Integer getRoomSuite() {
//		return roomSuite;
//	}
//
//	public void setRoomSuite(Integer roomSuite) {
//		this.roomSuite = roomSuite;
//	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public Calendar getBookingDateFrom() {
		return bookingDateFrom;
	}

	public void setBookingDateFrom(Calendar bookingDateFrom) {
		this.bookingDateFrom = bookingDateFrom;
	}

	public Calendar getBookingDateTo() {
		return bookingDateTo;
	}

	public void setBookingDateTo(Calendar bookingDateTo) {
		this.bookingDateTo = bookingDateTo;
	}

	public Integer getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(Integer noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getRoomNumbers() {
		return roomNumbers;
	}

	public void setRoomNumbers(String roomNumbers) {
		this.roomNumbers = roomNumbers;
	}

	public Integer getLoyaltyPointsUsed() {
		return loyaltyPointsUsed;
	}

	public void setLoyaltyPointsUsed(Integer loyaltyPointsUsed) {
		this.loyaltyPointsUsed = loyaltyPointsUsed;
	}

}