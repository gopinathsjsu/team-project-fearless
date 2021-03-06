package com.hotel.sjsu.hotelbookingservice.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity(name="booking")
@Table(name = "booking")
@Component
public class BookingEntity {

	@Id
	@Column(name="booking_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private	Long bookingId;

	@Column(name="hotel_id")
	private	Long hotelId;

	@Column(name="customer_id")
	private	Long customerId;


	@Column(name="room")
	private	String room;	
	
	@Column(name="amenity")
	private	String amenity;

	@Column(name="booking_date_from")
	private	Calendar bookingDateFrom;

	@Column(name="booking_date_to")
	private	Calendar bookingDateTo;


	@Column(name="no_of_guest")
	private	Integer noOfGuest;

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

	@Column(name="loyalty_points_used")
	private Integer loyaltyPointsUsed;

	public BookingEntity() {
		super();
	}

	public BookingEntity(Long bookingId, Long hotelId, Long customerId,
						 String room
						 //Integer roomDeluxe,Integer roomSuite
			,String amenity, Calendar bookingDateFrom,
						 Calendar bookingDateTo, Integer noOfGuest, String bookingStatus,
						 Double amount, Double totalAmount, String paymentMethod, String roomNumbers, Integer loyaltyPointsUsed) {

		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.customerId = customerId;
		this.room = room;
//		this.roomDeluxe = roomDeluxe;
//		this.roomSuite = roomSuite;
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