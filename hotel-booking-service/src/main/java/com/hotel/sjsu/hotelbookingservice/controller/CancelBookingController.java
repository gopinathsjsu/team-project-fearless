package com.hotel.sjsu.hotelbookingservice.controller;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.service.CancelBookingService;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/hotel/")
public class CancelBookingController {

    @Autowired
    private CancelBookingService cancelBookingService;


    @RequestMapping(value="/cancel/{booking_id}", method = RequestMethod.PUT)
    public ResponseEntity<?> cancelBooking(@PathVariable("booking_id") String inputBookingId) throws IOException, ParseException {
        if (inputBookingId == null || inputBookingId.equals("")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide valid booking ID");


        }
        if (NumberUtils.isDigits((inputBookingId))) {
            Long bookingId = Long.parseLong(inputBookingId);
            String checkvalidBooking = cancelBookingService.validateCancelBooking(bookingId);
            if (checkvalidBooking.isEmpty()) {
                String cancelStatus = cancelBookingService.cancelBooking(bookingId);
                //return new ResponseEntity<>(cancelBookingService.cancelBooking(bookingId), HttpStatus.OK);
                if (Objects.equals(cancelStatus, "")){
                    return ResponseEntity.status(HttpStatus.OK).body("Failed to cancel Booking");
                }
                else{
                    return ResponseEntity.status(HttpStatus.OK).body(cancelStatus);
                }
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(checkvalidBooking);

            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide valid integer booking ID");
        }
    }
}




