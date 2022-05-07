package com.hotel.sjsu.hotelbookingservice.service.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

import com.hotel.sjsu.hotelbookingservice.model.Customer;
import com.hotel.sjsu.hotelbookingservice.service.CustomerService;

@ContextConfiguration(classes = { CustomerServiceTest.class })
@PropertySource(value = {"classpath:application.properties"})
@SpringBootTest

public class CustomerServiceTest {
	
	Customer customer;
	CustomerService customerService = new CustomerService();
	StringBuilder message = new StringBuilder();
	
	@Test
	void testValidateLogin01() throws ParseException{
		customer = new Customer(1L, "test", "test", "password", "", "address", 0, 0, "1234567890");
		assertFalse(customerService.validateLogin(customer, true, message));
	}

	@Test
	void testValidateLogin02() throws ParseException{
		customer = new Customer(1L, "test", "test", "", "email", "address", 0, 0, "1234567890");
		assertFalse(customerService.validateLogin(customer, true, message));
	}

	@Test
	void testValidateCustomer01() throws ParseException{
		customer = new Customer(1L, "", "test", "", "email", "address", 0, 0, "1234567890");
		assertFalse(customerService.validateLogin(customer, true, message));
	}
}
