package com.hotel.sjsu.hotelbookingservice.controller;


import com.hotel.sjsu.hotelbookingservice.repository.HotelRoomsMapRepository;
import com.hotel.sjsu.hotelbookingservice.service.AmenityService;
import org.json.JSONException;
import org.json.JSONObject;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import com.hotel.sjsu.hotelbookingservice.service.ManageHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hotel/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HotelController {
    @Autowired
    ManageHotelService manageHotelService;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    AmenityService amenityService;

    @Autowired
    HotelRoomsMapRepository hotelRoomsMapRepository;


    // fetch all hotels
    @GetMapping("/allhotels")
    public List<Hotel> getAllHotels () {
        List<HotelEntity> hotelEntityList = manageHotelService.getAllHotels();
        List<Hotel> hotelList = new ArrayList<Hotel>();

        hotelEntityList.forEach((hotelEntity -> {
            hotelList.add(new Hotel(hotelEntity));
        }));

        return hotelList;
    }

    @RequestMapping(value="location/{hotel_location}")
    public @ResponseBody List<Hotel> getHotelLocation(@PathVariable("hotel_location") String  hotel_location) throws IOException, ParseException {
        System.out.println("fetching hotels at location "+hotel_location);
        return manageHotelService.getHotelsAtLocation(hotel_location);
    }

    @GetMapping("/hotel_ids/{hotel_location}")
    public ResponseEntity<List<Integer>> gethotelIdByhotelLocation(@PathVariable String hotel_location){
        return new ResponseEntity<>(manageHotelService.gethotelIds(hotel_location), HttpStatus.OK);
    }



    @RequestMapping(value="/search", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> postBody(@RequestBody String payload) throws ParseException {
        try {
            JSONObject jsonInput = new JSONObject(payload);
            if (jsonInput.length() == 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide valid JSON object with fromDate, toDate and location");

            }
            String checkSearch = manageHotelService.validateHotelSearch(jsonInput);
            if (checkSearch.isEmpty()) {
                List<Map> foundHotel =  manageHotelService.findHotels(payload);
                if (foundHotel.size() == 0){
                    return ResponseEntity.status(HttpStatus.OK).body("No Hotel found at given location for the given dates");
                }
                return new ResponseEntity<>(manageHotelService.findHotels(payload), HttpStatus.OK);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(checkSearch);
            }
        } catch(JSONException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provide valid JSON Input");
        }
    }



}




