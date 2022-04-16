package com.hotel.sjsu.hotelbookingservice.controller;

import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.service.CancelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/cancel/")
public class CancelBookingController {

    @Autowired
    private CancelBookingService cancelBookingService;

//    @RequestMapping(value = "/{bookingId}", method = RequestMethod.PUT)
//    public void updateBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
//        cancelBookingService.updateBooking(bookingId, booking);

//    @RequestMapping(value = "/{bookingId}", method = RequestMethod.PUT)
//    public @ResponseBody
//    String updateBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
//        return cancelBookingService.updateBooking(bookingId, booking);
//
//    }
}
