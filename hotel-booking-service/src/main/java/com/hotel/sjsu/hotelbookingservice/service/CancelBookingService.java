package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.repository.CancelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CancelBookingService {

    @Autowired
    CancelRepository cancelRepository;

    @Autowired
    ModelToEntityMapper modelToEntityMapper;

//    public String updateBooking(Long bookingId, Booking booking) {
//
//        booking.setBookingStatus("Cancelled");
//        BookingEntity bookingEntity = modelToEntityMapper.map(booking);
////        System.out.println(bookingEntity);
//        cancelRepository.save(bookingEntity);
//        String successMsg;
//        successMsg= "Booking has been cancelled successfully!!";
//        return successMsg;
//    }

}
