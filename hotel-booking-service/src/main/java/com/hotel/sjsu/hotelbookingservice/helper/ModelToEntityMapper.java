package com.hotel.sjsu.hotelbookingservice.helper;

import org.springframework.stereotype.Component;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Customer;

@Component
public class ModelToEntityMapper {

	public BookingEntity mapBooking(Booking booking) {
		
		BookingEntity bookingEntity = new BookingEntity(
				booking.getBookingId(), 
				booking.getHotelId(), 
				booking.getCustomerId(), 
//				booking.getRoomDeluxe(),
//				booking.getRoomSuite(),
				booking.getRoom(),
				booking.getAmenity(), 
				booking.getBookingDateFrom(), 
				booking.getBookingDateTo(), 
				booking.getNoOfGuest(),
				booking.getBookingStatus(), 
				booking.getAmount(), 
				booking.getTotalAmount(), 
				booking.getPaymentMethod(), 
				booking.getRoomNumbers());
		
		return bookingEntity;
	}

	public CustomerEntity mapCustomer(Customer customer) {

		CustomerEntity customerEntity = new CustomerEntity(
				customer.getCustomerId(), 
				customer.getCustFirstName(), 
				customer.getCustLastName(), 
				customer.getCustPassword(), 
				customer.getCustEmail(), 
				customer.getCustAddress(), 
				customer.getLoyaltyPoints(), 
				customer.getContactNumber());
		return customerEntity;
	}

}
