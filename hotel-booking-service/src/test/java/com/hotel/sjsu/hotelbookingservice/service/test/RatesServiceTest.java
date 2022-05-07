package com.hotel.sjsu.hotelbookingservice.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Rating;
import com.hotel.sjsu.hotelbookingservice.service.RatesService;

public class RatesServiceTest {
	
	RatesService ratesSerice = new RatesService();
	StringBuilder message = new StringBuilder();
	Rating rating;
	
	@Test
	void testValidateRating01(){
				
		rating = new Rating(1L, 1L,"2022-04-10","2022-04-13","", "CB-FR", 1, 100);	
		assertFalse(ratesSerice.validateRating(rating, message));
	}
	
	@Test
	void testValidateRating02(){
				
		rating = new Rating(1L, 1L,"2022-04-10","2022-04-13","1DR-1SR", "", 1, 100);	
		assertTrue(ratesSerice.validateRating(rating, message));
	}
	
	@Test
	void testGetCalendarFromString(){
				
		String date = "2022-05-05";
		Calendar result = ratesSerice.getCalendarFromString(date);
		
		assertEquals(2022, result.get(Calendar.YEAR));
		assertEquals(4, result.get(Calendar.MONTH));
		assertEquals(5, result.get(Calendar.DATE));
		
	}
	
	@Test
	void testGetStringFromCalendar(){
				
		Calendar input = Calendar.getInstance();
		input.set(2022,04, 05);
		assertEquals("2022-05-05", ratesSerice.getStringFromCalendar(input));
		
	}
}
