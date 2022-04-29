package com.hotel.sjsu.hotelbookingservice.helper;

import org.springframework.stereotype.Component;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Customer;

@Component
public class EntityToModelMapper {

	public Booking mapBooking(BookingEntity bookingEntity) {
		Booking booking = new Booking(
				bookingEntity.getBookingId(),
				bookingEntity.getHotelId(),
				bookingEntity.getCustomerId(),
				bookingEntity.getRoom(),
				bookingEntity.getAmenity(),
				bookingEntity.getBookingDateFrom(),
				bookingEntity.getBookingDateTo(),
				bookingEntity.getNoOfGuest(),
				bookingEntity.getBookingStatus(),
				bookingEntity.getAmount(),
				bookingEntity.getTotalAmount(),
				bookingEntity.getPaymentMethod(),
				bookingEntity.getRoomNumbers(),
				bookingEntity.getLoyaltyPointsUsed()
		);

		return booking;
	}

	public Customer mapCustomer(CustomerEntity customerEntity) {

		Customer customer = new Customer(
				customerEntity.getCustomerId(),
				customerEntity.getCustFirstName(),
				customerEntity.getCustLastName(),
				customerEntity.getCustPassword(),
				customerEntity.getCustEmail(),
				customerEntity.getCustAddress(),
				customerEntity.getLoyaltyPoints(),
				customerEntity.getBookingCount(), 
				customerEntity.getContactNumber());
		return customer;
	}


}