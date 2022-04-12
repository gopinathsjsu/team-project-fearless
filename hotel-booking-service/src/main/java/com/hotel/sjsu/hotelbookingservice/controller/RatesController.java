package com.hotel.sjsu.hotelbookingservice.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.sjsu.hotelbookingservice.service.RatesService;

@RestController
@RequestMapping(value = "/rates")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RatesController {

	@Autowired
	private RatesService ratesService;
	
	@RequestMapping(value="/amount")
    public @ResponseBody String calculateAmount() throws IOException, ParseException {
		return ratesService.calculateAmount();
    }
}
