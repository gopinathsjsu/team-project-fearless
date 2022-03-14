package com.hotel.sjsu.hotelbookingservice.helper;

import org.springframework.stereotype.Component;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;

@Component
public class EntityToModelMapper {
	
public Booking map(BookingEntity bookingEntity) {
		
		Booking booking = new Booking(
				bookingEntity.getBookingId(), 
				bookingEntity.getHotelId(), 
				bookingEntity.getCustomerId(), 
				bookingEntity.getRoomId(), 
				bookingEntity.getAmenity(), 
				bookingEntity.getBookingDateFrom(), 
				bookingEntity.getBookingDateTo(), 
				bookingEntity.getNoOfAdult(), 
				bookingEntity.getNoOfChildren(), 
				bookingEntity.getNoOfRooms(), 
				bookingEntity.getBookingStatus(), 
				bookingEntity.getAmount(), 
				bookingEntity.getTotalAmount(), 
				bookingEntity.getPaymentMethod(), 
				bookingEntity.getRoomNumbers());
		
		return booking;
	}

}
