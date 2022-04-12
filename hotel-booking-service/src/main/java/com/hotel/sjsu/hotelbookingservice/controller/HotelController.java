package com.hotel.sjsu.hotelbookingservice.controller;


import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import com.hotel.sjsu.hotelbookingservice.service.ManageHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel/")
public class HotelController {
    @Autowired
    ManageHotelService manageHotelService;

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/allhotels")
    public List<Hotel> getAllHotels () {
        List<HotelEntity> hotelEntityList = manageHotelService.getAllHotels();
        List<Hotel> hotelList = new ArrayList<Hotel>();

        hotelEntityList.forEach((hotelEntity -> {
            hotelList.add(new Hotel(hotelEntity));
        }));

        return hotelList;
    }

	@RequestMapping(value="location/{hotel_location}")
	public @ResponseBody List<Hotel> getHotelLocation(@PathVariable("hotel_location") String  hotel_location) throws IOException, ParseException {
		System.out.println("fetching hotels at location "+hotel_location);
		return manageHotelService.getHotel(hotel_location);
	}



}
