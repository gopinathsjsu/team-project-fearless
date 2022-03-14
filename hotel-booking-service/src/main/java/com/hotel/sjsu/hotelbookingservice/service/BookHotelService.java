package com.hotel.sjsu.hotelbookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;

@Service
@Transactional
public class BookHotelService {

	@Autowired
	BookHotelRepository bookHotelRepository;
	
	@Autowired
	EntityToModelMapper entityToModelMapper;
	
	@Autowired
	ModelToEntityMapper modelToEntityMapper;
	
	public String bookinghotel(Booking booking) {
		
		BookingEntity bookingEntity = modelToEntityMapper.map(booking);
		bookHotelRepository.save(bookingEntity);
		return "Added Successfully!!";
	}

}
