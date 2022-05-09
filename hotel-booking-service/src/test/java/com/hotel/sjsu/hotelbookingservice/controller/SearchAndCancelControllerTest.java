package com.hotel.sjsu.hotelbookingservice.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.hotel.sjsu.hotelbookingservice.model.SearchInput;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class SearchAndCancelControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

//    Hotel hotelHilton = new Hotel("Hilton", "San Jose", "San Jose", "95134", "6696696690", "Patrick");
//    Hotel hotelEmbassy = new Hotel("Embassy", "San Jose", "San Jose", "95135", "6696696691", "Robert");
//    Customer customer1 = new Customer(1L, "Michale", "Kiley",
//            "test123", "test@test.com", "San Jose", 100, 0, "1231231234");
//    Customer customer2 = new Customer(2L, "Roger", "Phil",
//            "test123", "test@test.com", "San Jose", 100, 0, "1231231235");

    @Test
    public void validInput() throws Exception {
        String uri = "/api/hotel/search";
        SearchInput searchInput = new SearchInput();
        searchInput.setFrom("2022-05-25");
        searchInput.setTo("2022-05-30");
        searchInput.setLocation("Tokyo");
        String inputJson = super.mapToJson(searchInput);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "No Hotel found at given location for the given dates");
    }
    @Test
    public void invalidInputFrom() throws Exception {
        String uri = "/api/hotel/search";
        SearchInput searchInput = new SearchInput();
        searchInput.setFrom("");
        searchInput.setTo("2022-05-30");
        searchInput.setLocation("San Jose");
        String inputJson = super.mapToJson(searchInput);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Please provide check-in date");
    }

    @Test
    public void invalidInputTo() throws Exception {
        String uri = "/api/hotel/search";
        SearchInput searchInput = new SearchInput();
        searchInput.setFrom("2022-05-30");
        searchInput.setTo("");
        searchInput.setLocation("San Jose");
        String inputJson = super.mapToJson(searchInput);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Please provide check-out date");
    }

    @Test
    public void invalidInputLocation() throws Exception {
        String uri = "/api/hotel/search";
        SearchInput searchInput = new SearchInput();
        searchInput.setFrom("2022-05-21");
        searchInput.setTo("2022-05-24");
        searchInput.setLocation("");
        String inputJson = super.mapToJson(searchInput);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Please provide valid hotel location");
    }

    @Test
    public void invalidInputNull() throws Exception {
        String uri = "/api/hotel/search";
        String inputJson = "{}";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Provide valid JSON object with fromDate, toDate and location");
    }

    @Test
    public void invalidInputFromDate() throws Exception {
        String uri = "/api/hotel/search";
        SearchInput searchInput = new SearchInput();
        searchInput.setFrom("23May2022");
        searchInput.setTo("2022-05-24");
        searchInput.setLocation("San Jose");
        String inputJson = super.mapToJson(searchInput);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Unable to parse dates - provide valid check-in/check-out dates");
    }

    @Test
    public void validInputCancel() throws Exception {
        String uri = "/api/hotel/cancel/99999";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content("{}")).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assertions.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals(content, "No active booking exist with given booking ID 99999");
    }

    @Test
    public void invalidBookingIdToCancel() throws Exception {
        String uri = "/api/hotel/cancel/abcde";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Provide valid integer booking ID");
    }

    @Test
    public void validPastBookinIdToCancel() throws Exception {
        String uri = "/api/hotel/cancel/3";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Past completed bookings can not be canceled!!");
    }

//    @Test
//    public void validFutureBookinIdToCancel() throws Exception {
//        String uri = "/api/hotel/cancel/10";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "{\"result\": \"Booking has been cancelled successfully. Amount Paid will be refunded back in 5-7 business days!!\"}");
//    }
//
//    @Test
//    public void validTwoDayBookinIdToCancel() throws Exception {
//        String uri = "/api/hotel/cancel/9";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        assertEquals(content, "Booking can not be cancelled within 48 hours of booking date!!");
//    }

}