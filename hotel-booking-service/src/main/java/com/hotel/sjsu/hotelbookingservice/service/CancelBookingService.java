package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.CancelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;

import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CancelBookingService {

    @Autowired
    CancelRepository cancelRepository;

    @Autowired
    EntityToModelMapper entityToModelMapper;

//    public String cancelBooking(Long bookingId, Long customerId, Long hotelId, Booking booking) {
//
//        booking.setBookingStatus("Cancelled");
//        BookingEntity bookingEntity = modelToEntityMapper.map(booking);
////        System.out.println(bookingEntity);
//        cancelRepository.save(bookingEntity);
//        String successMsg;
//        successMsg= "Booking has been cancelled successfully!!";
//        return successMsg;
//    }

    public String cancelBooking (Long booking_id) {

        BookingEntity bookingEntity = cancelRepository.getbookingBybookingId(booking_id);
        Booking booking = entityToModelMapper.mapBooking(bookingEntity);
        Long customerId = booking.getCustomerId();
        Integer loyaltyPoints = booking.getLoyaltyPointsUsed();
        cancelRepository.cancelBookingStatus(booking_id);
        Integer newLoyaltyPoints = cancelRepository.getLoyaltyPoints(customerId) + loyaltyPoints;
        cancelRepository.updateLoyaltyPoints(newLoyaltyPoints, customerId);

        return "Booking has been cancelled successfully";

    }


}
