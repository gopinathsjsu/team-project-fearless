package com.hotel.sjsu.hotelbookingservice.service.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.service.BookHotelService;
import com.hotel.sjsu.hotelbookingservice.service.RatesService;

@ContextConfiguration(classes = { BookHotelServiceTest.class })
@PropertySource(value = {"classpath:application.properties"})
@SpringBootTest
class BookHotelServiceTest {

	RatesService ratesService = new RatesService();
	BookHotelService bookHotelService = new BookHotelService();
	Booking booking;
	
	
	@Test
	void testValidateBooking01() throws ParseException{
		
		booking = new Booking(1L, 1L, 1L, "1DR-1SR", "CB-FR", 
				Calendar.getInstance(),Calendar.getInstance(), 2,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,4, 1);
		booking.setBookingDateFrom(calendar);
		calendar.set(2022,4, 3);
		booking.setBookingDateTo(calendar);
		assertTrue(bookHotelService.validateBooking(booking));
	}
	
	@Test
	void testValidateBooking02() throws ParseException{
		
		booking = new Booking(1L, 1L,null, "1DR-1SR", "CB-FR", 
				Calendar.getInstance(),Calendar.getInstance(), 2,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,4, 1);
		booking.setBookingDateFrom(calendar);
		calendar.set(2022,4, 3);
		booking.setBookingDateTo(calendar);
		assertFalse(bookHotelService.validateBooking(booking));
	}
	@Test
	void testValidateBooking03() throws ParseException{
		
		booking = new Booking(1L, 1L, 1L, "", "CB-FR", 
				Calendar.getInstance(),Calendar.getInstance(), 2,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,4, 1);
		booking.setBookingDateFrom(calendar);
		calendar.set(2022,4, 3);
		booking.setBookingDateTo(calendar);
		assertFalse(bookHotelService.validateBooking(booking));
	}
	
	@Test
	void testValidateBooking04() throws ParseException{
		
		booking = new Booking(1L, 1L, 1L, "1DR-1SR", "", 
				Calendar.getInstance(),Calendar.getInstance(), 2,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,4, 1);
		booking.setBookingDateFrom(calendar);
		calendar.set(2022,4, 3);
		booking.setBookingDateTo(calendar);
		assertFalse(bookHotelService.validateBooking(booking));
	}

	@Test
	void testValidateBooking05() throws ParseException{
		
		booking = new Booking(1L, 1L, 1L, "1DR-1SR", "CB-FR", 
				Calendar.getInstance(),Calendar.getInstance(), 2,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = null;
		booking.setBookingDateFrom(calendar);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2022,4, 3);
		booking.setBookingDateTo(calendar1);
		assertFalse(bookHotelService.validateBooking(booking));
	}
	
	@Test
	void testValidateBooking06() throws ParseException{
		
		booking = new Booking(1L, 1L, 1L, "1DR-1SR", "CB-FR", 
				Calendar.getInstance(),Calendar.getInstance(), 2,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,4, 1);
		booking.setBookingDateFrom(calendar);
		Calendar calendar1 = null;
		booking.setBookingDateTo(calendar1);
		assertFalse(bookHotelService.validateBooking(booking));
	}

	@Test
	void testValidateBooking07() throws ParseException{
		
		booking = new Booking(1L, 1L, 1L, "1DR-1SR", "CB-FR", 
				Calendar.getInstance(),Calendar.getInstance(), 0,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,4, 1);
		booking.setBookingDateFrom(calendar);
		calendar.set(2022,4, 3);
		booking.setBookingDateTo(calendar);
		assertFalse(bookHotelService.validateBooking(booking));
	}

	@Test
	void testValidateBooking08() throws ParseException{
		
		booking = new Booking(1L, 1L, 1L, "1DR-1SR", "CB-FR", 
				Calendar.getInstance(),Calendar.getInstance(), 0,
				"Booked", 1000D, 900D,"Card", "A100", 100);

		Calendar calendar = Calendar.getInstance();
		calendar.set(2022,4, 3);
		booking.setBookingDateFrom(calendar);
		calendar.set(2022,4, 3);
		booking.setBookingDateTo(calendar);
		assertFalse(bookHotelService.validateBooking(booking));
	}
}
