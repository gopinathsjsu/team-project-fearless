package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.CancelRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;

import org.springframework.transaction.annotation.Transactional;

import java.lang.constant.Constable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;



@Service
@Transactional
public class CancelBookingService {

    @Autowired
    CancelRepository cancelRepository;

    @Autowired
    BookHotelRepository bookHotelRepository;

    @Autowired
    EntityToModelMapper entityToModelMapper;

    @Autowired
    ModelToEntityMapper modelToEntityMapper;



    //public String cancelBooking (Long booking_id) {
    public String cancelBooking (Long booking_id) throws ParseException{

//        if(validateCancelBooking(booking)) {

        BookingEntity bookingEntity = cancelRepository.getbookingBybookingId(booking_id);
        Booking booking = entityToModelMapper.mapBooking(bookingEntity);
        //           Long customerId = booking.getCustomerId();

        Integer loyaltyPoints = booking.getLoyaltyPointsUsed();
        cancelRepository.cancelBookingStatus(booking_id);

        Integer newLoyaltyPoints = cancelRepository.getLoyaltyPoints(booking.getCustomerId()) + loyaltyPoints;
        cancelRepository.updateLoyaltyPoints(newLoyaltyPoints, booking.getCustomerId());

        //refund paid amt
        Double totalAmount = booking.getTotalAmount();
        cancelRepository.updateTotalAmount((double) 0, booking_id);

        String output = "{\"result\": \"Booking has been cancelled successfully. Amount Paid will be refunded back in 5-7 business days!!\"}";
        JSONObject jsonResult = new JSONObject(output);
        System.out.println(jsonResult);


        return output;
    }

    List<String> message = new ArrayList<String>();
    public String  validateCancelBooking(Long bookingId) throws ParseException {


        String errorMessage = new String("");
        BookingEntity bookingEntity = cancelRepository.getbookingBybookingId(bookingId);

        if(bookingEntity!=null) {
            SimpleDateFormat bformatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Calendar bookingCalDate = bookingEntity.getBookingDateFrom();
            String bookingDate = bformatter.format(bookingCalDate.getTime());
            LocalDate fBookingDate = LocalDate.parse(bookingDate);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateObj = LocalDate.now();
            String todayDate = dateObj.format(formatter);
            LocalDate fTodayDate = LocalDate.parse(todayDate);
            long noOfDaysDifference = ChronoUnit.DAYS.between(fTodayDate, fBookingDate);
            if (noOfDaysDifference <= 2){
                if(noOfDaysDifference < 0){
                    errorMessage = "Past completed bookings can not be canceled!!";
                }

                else {
                    errorMessage = "Booking can not be cancelled within 48 hours of booking date!!";

                }
            }
            else if (bookingEntity.getCustomerId() == null){
                errorMessage = "Customer doesn't exist for given booking ID "+ bookingId;


            }

        }

        else{
            errorMessage = "No active booking exist with given booking ID "+ bookingId;
        }


        return errorMessage;
    }

}
