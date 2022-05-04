package com.hotel.sjsu.hotelbookingservice.controller;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.service.CancelBookingService;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/hotel/")
public class CancelBookingController {

    @Autowired
    private CancelBookingService cancelBookingService;

//    @RequestMapping(value="/cancel/{booking_id}", method = RequestMethod.PUT)
//    public String cancelBooking(@PathVariable("booking_id") Long  booking_id) throws IOException, ParseException {
//
//        return cancelBookingService.cancelBooking(booking_id);
//
//    }

    @RequestMapping(value="/cancel/{booking_id}", method = RequestMethod.PUT)
    public String cancelBooking(@PathVariable("booking_id") Long  booking_id) throws IOException, ParseException {

        return cancelBookingService.cancelBooking(booking_id);

    }

//    @RequestMapping(value = "/{bookingId}", method = RequestMethod.PUT)
//    public void updateBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
//        cancelBookingService.updateBooking(bookingId, booking);

//    @RequestMapping(value = "/{bookingId}", method = RequestMethod.PUT)
//    public @ResponseBody
//    String updateBooking(@RequestBody Booking booking, @PathVariable Long bookingId) {
//        return cancelBookingService.updateBooking(bookingId, booking);
//
//    }

//    @GetMapping("/{booking_id}")
//    public Integer getAllBookingss () {
//        Integer bkng = cancelBookingService.getAllBookings();
//
//
//        return bkng;
//    }
//
//    @GetMapping("/cancelboo")
//    public Integer updatingToCancel () {
//        Integer cncl = cancelBookingService.cancellingBookings();
//
//
//        return cncl;
//    }
}
