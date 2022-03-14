package com.hotel.sjsu.hotelbookingservice.helper;

import org.springframework.stereotype.Component;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;

@Component
public class ModelToEntityMapper {

	public BookingEntity map(Booking booking) {
		
		BookingEntity bookingEntity = new BookingEntity(
				booking.getBookingId(), 
				booking.getHotelId(), 
				booking.getCustomerId(), 
				booking.getRoomId(), 
				booking.getAmenity(), 
				booking.getBookingDateFrom(), 
				booking.getBookingDateTo(), 
				booking.getNoOfAdult(), 
				booking.getNoOfChildren(), 
				booking.getNoOfRooms(), 
				booking.getBookingStatus(), 
				booking.getAmount(), 
				booking.getTotalAmount(), 
				booking.getPaymentMethod(), 
				booking.getRoomNumbers());
		
		return bookingEntity;
	}

}
