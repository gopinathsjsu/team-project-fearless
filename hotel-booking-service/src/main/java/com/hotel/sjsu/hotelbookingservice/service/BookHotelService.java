package com.hotel.sjsu.hotelbookingservice.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Rating;
import com.hotel.sjsu.hotelbookingservice.model.Response;
import com.hotel.sjsu.hotelbookingservice.repository.BookHotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;

@Service
@Transactional
public class BookHotelService {
	
	@Autowired
	ManageHotelService manageService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RatesService ratesService;

	@Autowired
	BookHotelRepository bookHotelRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	EntityToModelMapper entityToModelMapper;
	
	@Autowired
	ModelToEntityMapper modelToEntityMapper;
	
	List<String> message = new ArrayList<String>();
	
	public Response bookinghotel(Booking booking) throws ParseException {
		
		if(validateBooking(booking)) {
			BookingEntity bookingEntity = modelToEntityMapper.mapBooking(booking);
			
			Rating rating = new Rating(booking.getCustomerId(),  booking.getHotelId(), 
					ratesService.getStringFromCalendar(booking.getBookingDateFrom()), 
					ratesService.getStringFromCalendar(booking.getBookingDateTo()), 
					booking.getRoom(), booking.getAmenity(),0.0D, "", booking.getNoOfGuest(), booking.getLoyaltyPointsUsed());
			
			Response ratingResponse = ratesService.calculateTotalRating(rating);
			Rating ratingResult = (Rating)ratingResponse.getObject();
			
			bookingEntity.setAmount(ratingResult.getCost()+ booking.getLoyaltyPointsUsed());
			bookingEntity.setTotalAmount(ratingResult.getCost());
			
			
			Response response = customerService.updateCustomer(booking.getCustomerId(), booking.getLoyaltyPointsUsed());

			if(response.getObject()!=Integer.valueOf(-1)) {
				BookingEntity bookingEntityRes = bookHotelRepository.save(bookingEntity);
				return new Response(bookingEntityRes, "Successfully Booked!!");
			}else {
				
				return new Response(-1, response.getMessage());
			}
		
		}else {
			message.add("Unable to book rooms due to above reason(s)");
			return new Response(message, "Booking failed");
		}
	}

	public boolean validateBooking(Booking booking) throws ParseException {
		boolean result = true;
		
		if(booking.getCustomerId()==null ||booking.getCustomerId().equals("0")) {
			message.add("Customer ID is missing.");
			result = false;
		}
		
		if(booking.getRoom()==null || booking.getRoom().equals("") ) {
			message.add("Please select room type.");
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
		
		if(booking.getNoOfGuest()==null || booking.getNoOfGuest()==0 ) {
			message.add("Please select the number of people staying.");
			result = false;
		}
		
		if(booking.getBookingDateFrom()!=null && booking.getBookingDateTo()!=null) {
			System.out.println("Difference in dates");
			System.out.println(booking.getBookingDateFrom().compareTo(booking.getBookingDateTo()));
		    if(booking.getBookingDateFrom().compareTo(booking.getBookingDateTo()) > 0) {
		    	message.add("Please select a check-out date after check-in date.");
		    }
		}
		
		return result;
	}

	public Response viewBookings(Long customerID) {
		List<BookingEntity> bookingEntList = new ArrayList<BookingEntity>();
		
		bookingEntList = bookHotelRepository.findAllByCustomerId(customerID);	

		if(bookingEntList.size()==0) {
			return new Response(-1, "No booking found");
		}
		
		List<Booking> bookingList = new ArrayList<Booking>();
					
		for(BookingEntity bookingEntity : bookingEntList){
			HotelEntity hotelEntity = hotelRepository.findByHotelId(bookingEntity.getHotelId());
			
			Booking booking = entityToModelMapper.mapBooking(bookingEntity);
			if(hotelEntity!=null) {
				booking.setHotelName(hotelEntity.getHotelname());				
			}

			bookingList.add(booking);
		}
		
		return new Response(bookingList, "Bookings retrieved");
	}
}
