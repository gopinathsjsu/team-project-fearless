package com.hotel.sjsu.hotelbookingservice.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Response;
import com.hotel.sjsu.hotelbookingservice.service.BookHotelService;

@RestController
@RequestMapping(value = "/hotel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookHotelController {

	@Autowired
	private BookHotelService bookHotelService;
	
	@RequestMapping(value="/book")
    public @ResponseBody Response bookingHotel(@RequestBody Booking booking) throws IOException, ParseException {
		return bookHotelService.bookinghotel(booking);
    }
	
	@RequestMapping(value="/viewBookings/{customerID}")
    public @ResponseBody Response viewBooking(@PathVariable("customerID") Long customerID) throws IOException, ParseException{
		return bookHotelService.viewBookings(customerID);
    }
}
