package com.hotel.sjsu.hotelbookingservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.service.BookHotelService;

public class BookHotelController {

	@Autowired
	private BookHotelService bookHotelService;
	
	@RequestMapping(value="/book")
    public @ResponseBody String bookingHotel(@RequestBody Booking booking) throws IOException {
		
		return bookHotelService.bookinghotel(booking);
    }
}
