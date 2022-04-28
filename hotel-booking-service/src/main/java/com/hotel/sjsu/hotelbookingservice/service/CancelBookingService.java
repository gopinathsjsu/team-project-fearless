package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.CancelRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;

import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


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

    //public String cancelBooking (Long booking_id) {
    public String cancelBooking (Long booking_id) {

        BookingEntity bookingEntity = cancelRepository.getbookingBybookingId(booking_id);
        Booking booking = entityToModelMapper.mapBooking(bookingEntity);
        Long customerId = booking.getCustomerId();
        Calendar fromDate = booking.getBookingDateFrom();

        SimpleDateFormat bformat = new SimpleDateFormat("yyyy-MM-dd");
        String bookingDate = bformat.format(fromDate.getTime());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateObj = LocalDate.now();
        String date = dateObj.format(formatter);
        System.out.println("fromdate= "+bookingDate );
        System.out.println("today= "+ date);

        LocalDate localDate1 = LocalDate.parse(bookingDate);
        LocalDate localDate2 = LocalDate.parse(date);
        long noOfDaysDifference = ChronoUnit.DAYS.between(localDate2, localDate1);
        System.out.println("No of days diff is : " + noOfDaysDifference);
        if (noOfDaysDifference > 2){

            Integer loyaltyPoints = booking.getLoyaltyPointsUsed();
            cancelRepository.cancelBookingStatus(booking_id);

            Integer newLoyaltyPoints = cancelRepository.getLoyaltyPoints(customerId) + loyaltyPoints;
            cancelRepository.updateLoyaltyPoints(newLoyaltyPoints, customerId);

            //refund paid amt
            Double totalAmount = booking.getTotalAmount();
            cancelRepository.updateTotalAmount((double) 0,booking_id);

            String output = "{\"result\": \"Booking has been cancelled successfully. Amount Paid will be refunded back in 5-7 business days!!\"}";
            JSONObject jsonResult = new JSONObject(output);
            System.out.println(jsonResult);
            //String cancelled = json.getString("cancelled");
            //System.out.println(cancelled);

            //return "{'result': 'Booking has been cancelled successfully. Amount Paid will be refunded back in 5-7 business days!!'}";
            return output;
        }
        else {

            String output = "{\"result\": \"Booking can not be cancelled within 48 hours of booking date!!\"}";
            JSONObject jsonResult = new JSONObject(output);
            System.out.println(jsonResult);
            //String cancelled = json.getString("cancelled");
            //System.out.println(cancelled);

            //return "{'result': 'Booking has been cancelled successfully. Amount Paid will be refunded back in 5-7 business days!!'}";
            return output;
            //return "{'Booking can not be cancelled within 48 hours of booking date!!'}";

        }

    }

}
