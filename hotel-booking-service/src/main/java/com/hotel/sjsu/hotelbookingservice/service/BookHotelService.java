package com.hotel.sjsu.hotelbookingservice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;

@Service
@Transactional
public class BookHotelService {

	@Autowired
	BookHotelRepository bookHotelRepository;
	
	@Autowired
	EntityToModelMapper entityToModelMapper;
	
	@Autowired
	ModelToEntityMapper modelToEntityMapper;
	
	List<String> message = new ArrayList<String>();
	
	public List<String> bookinghotel(Booking booking) throws ParseException {
		
		if(validateBooking(booking)) {
			BookingEntity bookingEntity = modelToEntityMapper.map(booking);
			bookHotelRepository.save(bookingEntity);
			List<String> successMsg = new ArrayList<String>();
			successMsg.add("Successfully Booked!!");
			return successMsg;
		}else {
			message.add("Unable to book rooms due to above reason(s)");
			return message;
		}
	}

	private boolean validateBooking(Booking booking) throws ParseException {
		boolean result = true;
		
		if(booking.getCustomerId()==null ||booking.getCustomerId().equals("0")) {
			message.add("Customer ID is missing.");
			result = false;
		}
		
		if(booking.getRoomId()==null || booking.getRoomId().equals("") ) {
			message.add("Please select the type of room.");
			result = false;
		}
		
		if(booking.getAmenity()==null || booking.getAmenity().equals("") ) {
			message.add("Please select atleast one amenity.");
			result = false;
		}
		
		if(booking.getBookingDateFrom()==null || booking.getBookingDateFrom().equals("") ) {
			message.add("Please select check-in date");
			result = false;
		}
		
		if(booking.getBookingDateTo()==null || booking.getBookingDateTo().equals("") ) {
			message.add("Please select check-out date.");
			result = false;
		}
		
		if(booking.getNoOfAdult()==null || booking.getNoOfAdult()==0 ) {
			message.add("Please select the number of people staying.");
			result = false;
		}
		
		if(booking.getBookingDateFrom()!=null && !booking.getBookingDateFrom().isEmpty()
				&& booking.getBookingDateTo()!=null && !!booking.getBookingDateTo().isEmpty()) {
			
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		    Date fromDate = sdformat.parse(booking.getBookingDateFrom());
		    Date toDate = sdformat.parse(booking.getBookingDateTo());
		    
		    if(fromDate.compareTo(toDate) > 0) {
		    	message.add("Please select a check-out date after check-in date.");
		    }
		}
		
		return result;
	}

	public List<Booking> viewBookings(Long customerID) {
		List<BookingEntity> bookingEntList = new ArrayList<BookingEntity>();
		bookingEntList = bookHotelRepository.findAllByCustomerId(customerID);	

		List<Booking> bookingList = new ArrayList<Booking>();
				
		for(BookingEntity bookingEntity : bookingEntList){
			bookingList.add(entityToModelMapper.map(bookingEntity));
		}
		
		return bookingList;
	}
}
