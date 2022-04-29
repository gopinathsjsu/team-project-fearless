package com.hotel.sjsu.hotelbookingservice.model;

public class Rating {
	
	private Long customerId;
	private Long hotelId;
	private String fromDate;
	private String toDate;
	private String room;
	private String amenity;
	private	Integer noOfGuest;	
	private  Integer loyaltyPointsUsed;
	
	private Double cost;
	private String description;
	
	public Rating() {
		super();
	}

	public Rating(Double cost, String description) {
		super();
		this.cost = cost;
		this.description = description;
	}
	

	public Rating(Long customerId, Long hotelId, String fromDate, String toDate, String rooms, String amenities,
			Double cost, String description, Integer noOfGuest, Integer loyaltyPointsUsed) {
		super();
		this.customerId = customerId;
		this.hotelId = hotelId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.room = rooms;
		this.amenity = amenities;
		this.cost = cost;
		this.description = description;
		this.noOfGuest = noOfGuest;
		this.loyaltyPointsUsed = loyaltyPointsUsed;
	}

	public Rating(Long customerId, Long hotelId, String fromDate, String toDate, String rooms, 
			String amenities, Integer noOfGuest, Integer loyaltyPointsUsed) {
		super();
		this.customerId = customerId;
		this.hotelId = hotelId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.room = rooms;
		this.amenity = amenities;
		this.noOfGuest = noOfGuest;
		this.loyaltyPointsUsed = loyaltyPointsUsed;
	}

	
	public Integer getLoyaltyPointsUsed() {
		return loyaltyPointsUsed;
	}

	public void setLoyaltyPointsUsed(Integer loyaltyPointsUsed) {
		this.loyaltyPointsUsed = loyaltyPointsUsed;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenities) {
		this.amenity = amenities;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String rooms) {
		this.room = rooms;
	}

	public Integer getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(Integer noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	@Override
	public String toString() {
		return "Rating [customerId=" + customerId + ", hotelId=" + hotelId + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", room=" + room + ", amenity=" + amenity + ", noOfGuest=" + noOfGuest
				+ ", loyaltyPointsUsed=" + loyaltyPointsUsed + ", cost=" + cost + ", description=" + description + "]";
	}


	
}
