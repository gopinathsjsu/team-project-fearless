package com.hotel.sjsu.hotelbookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;

@Service
@Transactional
public class BookHotelService {

	@Autowired
	BookHotelRepository bookHotelRepository;
	
	public String bookinghotel(Booking booking) {
		
		BookingEntity bookingEntity = new BookingEntity();
		bookHotelRepository.save(bookingEntity);
		return "Added Successfully!!";
	}

}
