package com.hotel.sjsu.hotelbookingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class BookingEntity {

	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	Long bookingId;	

	@Column(name="hotel_id")
	private	Long hotelId;	

	@Column(name="customer_id")
	private	Long customerId;

	@Column(name="room_id")
	private	String roomId;	

	@Column(name="amenity")
	private	String amenity;	

	@Column(name="booking_date_from")
	private	String bookingDateFrom;

	@Column(name="booking_date_to")
	private	String bookingDateTo; 	

	@Column(name="no_of_adult")
	private	Integer noOfAdult;

	@Column(name="no_of_children")
	private	Integer noOfChildren;

	@Column(name="no_of_rooms")
	private	Integer noOfRooms;

	@Column(name="booking_status")
	private	String bookingStatus;

	@Column(name="amount")
	private	Double amount;	

	@Column(name="total_amount")
	private	Double totalAmount;

	@Column(name="payment_method")
	private	String paymentMethod;

	@Column(name="room_numbers")
	private	String roomNumbers;

	public BookingEntity() {
		super();
	}

	public BookingEntity(Long bookingId, Long hotelId, Long customerId, String roomId, String amenity, String bookingDateFrom,
			String bookingDateTo, Integer noOfAdult, Integer noOfChildren, Integer noOfRooms, String bookingStatus,
			Double amount, Double totalAmount, String paymentMethod, String roomNumbers) {
		
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.customerId = customerId;
		this.roomId = roomId;
		this.amenity = amenity;
		this.bookingDateFrom = bookingDateFrom;
		this.bookingDateTo = bookingDateTo;
		this.noOfAdult = noOfAdult;
		this.noOfChildren = noOfChildren;
		this.noOfRooms = noOfRooms;
		this.bookingStatus = bookingStatus;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.roomNumbers = roomNumbers;
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

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getBookingDateFrom() {
		return bookingDateFrom;
	}

	public void setBookingDateFrom(String bookingDateFrom) {
		this.bookingDateFrom = bookingDateFrom;
	}

	public String getBookingDateTo() {
		return bookingDateTo;
	}

	public void setBookingDateTo(String bookingDateTo) {
		this.bookingDateTo = bookingDateTo;
	}

	public Integer getNoOfAdult() {
		return noOfAdult;
	}

	public void setNoOfAdult(Integer noOfAdult) {
		this.noOfAdult = noOfAdult;
	}

	public Integer getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public Integer getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
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
}
