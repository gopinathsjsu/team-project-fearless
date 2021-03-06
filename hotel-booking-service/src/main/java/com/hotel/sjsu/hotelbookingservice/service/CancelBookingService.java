package com.hotel.sjsu.hotelbookingservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.CancelRepository;



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


    public String cancelBooking (Long booking_id) throws ParseException{
        String output = "";

        try{
            BookingEntity bookingEntity = cancelRepository.getbookingBybookingId(booking_id);
            Booking booking = entityToModelMapper.mapBooking(bookingEntity);

            Integer loyaltyPoints = booking.getLoyaltyPointsUsed();
            cancelRepository.cancelBookingStatus(booking_id);

            Integer newLoyaltyPoints = cancelRepository.getLoyaltyPoints(booking.getCustomerId()) + loyaltyPoints;
            cancelRepository.updateLoyaltyPoints(newLoyaltyPoints, booking.getCustomerId());

            //refund paid amt
            Double totalAmount = booking.getTotalAmount();
            cancelRepository.updateTotalAmount((double) 0, booking_id);

            output = "Booking has been cancelled successfully. Amount Paid will be refunded back in 5-7 business days!!";
            //JSONObject jsonResult = new JSONObject(output);
            //System.out.println(jsonResult);
            return output;

        }catch (Exception err){
            return output;
        }

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
            //check for past bookings
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
