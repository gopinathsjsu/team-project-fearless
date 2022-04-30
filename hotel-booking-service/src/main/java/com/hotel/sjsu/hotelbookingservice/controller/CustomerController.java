package com.hotel.sjsu.hotelbookingservice.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.sjsu.hotelbookingservice.model.Customer;
import com.hotel.sjsu.hotelbookingservice.model.Rating;
import com.hotel.sjsu.hotelbookingservice.model.Response;
import com.hotel.sjsu.hotelbookingservice.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/register")
    public @ResponseBody Response registerCustomer(@RequestBody Customer customer) throws IOException, ParseException {
		return customerService.register(customer);
    }

	@RequestMapping(value="/login")
    public @ResponseBody Response loginCustomer(@RequestBody Customer customer) throws IOException, ParseException {		
		return customerService.login(customer);
    }

	@RequestMapping(value="/loyalty/{customerId}")
    public @ResponseBody Response getLoyaltyPoints(@PathVariable Long customerId) throws IOException, ParseException {
		return customerService.getLoyaltyPoints(customerId);		
    }
	
	@RequestMapping(value="/{customerId}")
    public @ResponseBody Response getCustomerDetails(@PathVariable Long customerId) throws IOException, ParseException {
		return customerService.getCustomerDetails(customerId);
    }

}
