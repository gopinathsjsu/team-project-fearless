package com.hotel.sjsu.hotelbookingservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.service.BookHotelService;

@RestController
@RequestMapping(value = "/hotel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookHotelController {

	@Autowired
	private BookHotelService bookHotelService;
	
	@RequestMapping(value="/book")
    public @ResponseBody String bookingHotel(@RequestBody Booking booking) throws IOException {
		
		return bookHotelService.bookinghotel(booking);
    }
}
