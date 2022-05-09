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

//    @RequestMapping(value="/booking_ids/{hotel_id}")
//    public @ResponseBody List<Booking> getbookingIdByhotelId(@PathVariable("hotel_id") Integer hotel_id) throws IOException, ParseException {
//        System.out.println("get all bookings for hotelid "+hotel_id);
//        return manageHotelService.getbookingIds(hotel_id, fromDate, toDate);
//    }

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

//        JSONObject json = new JSONObject(payload);
//        String fromDate = (String)json.get("from");
//        String toDate = (String)json.get("to");
//        String location = (String)  json.get("location");
//
//        ArrayList<Map> finalResult = new ArrayList<Map>();
//
//        ArrayList<Hotel> hotelList = (ArrayList<Hotel>) manageHotelService.getHotel(location);
//
//        for (Hotel entry : hotelList) {
//            HashMap<String, Object> hotelDetails = new HashMap<String, Object>();
//            ArrayList<String> bookingList = new ArrayList<String>();
//            Long hotelId = entry.getHotelId();
//            System.out.println("Hotel Id = "+hotelId);
//            hotelDetails.put("hotel", entry);
//            bookingList = (ArrayList<String>) manageHotelService.getbookingIds(hotelId, fromDate, toDate);
//
//            HashMap<String, Integer> roomsBooked = new HashMap<String, Integer>();
//            Integer hotelIdInt = hotelId.intValue();
//
//            Integer totalDrCount = hotelRoomsMapRepository.getTotalRooms(hotelIdInt, "DR");
//            Integer totalSrCount = hotelRoomsMapRepository.getTotalRooms(hotelIdInt, "SR");
//
//            //adding room cost
//            Integer roomDRCost = hotelRoomsMapRepository.getRoomCost("DR");
//            Integer roomSRCost = hotelRoomsMapRepository.getRoomCost("SR");
//            System.out.println(roomDRCost);
//            System.out.println(roomSRCost);
//            HashMap<String, Integer> costs = new HashMap<String, Integer>();
//            costs.put("DR",roomDRCost);
//            costs.put("SR",roomSRCost);
//
//
//            roomsBooked.put("DR", totalDrCount);
//            roomsBooked.put("SR", totalSrCount);
//
//            for (String booking : bookingList){
//                //System.out.println("Booking details=  "+entry);
//                String[] roomDetails = booking.split("-");
//                //System.out.println("room Details=\n" +(String.join("\n", roomDetails)));
//                for (String rooms : roomDetails){
//                    String roomType = rooms.substring(0,2);
//                    Integer roomCount = Integer.valueOf(rooms.substring(2));
//                    if (roomsBooked.containsKey(roomType)){
//                        Integer newCount = roomsBooked.get(roomType) - roomCount ;
//                        roomsBooked.put(roomType, newCount);
////                        roomsBooked.put("DRCost",roomDRCost);
////                        roomsBooked.put("SRCost",roomSRCost);
//                    }
//                }
//            }
//
//            System.out.println("DR rooms count= "+ roomsBooked.get("DR"));
//            System.out.println("SR rooms count= "+ roomsBooked.get("SR"));
//            List<AmenityEntity> amenityEntities = amenityService.getAllAmenities();
//            List<Amenity> amenities = new ArrayList<Amenity>();
//
//            amenityEntities.forEach((amenityEntity -> {
//                amenities.add(new Amenity(amenityEntity));
//            }));
//
//            //System.out.println("Amenities=  "+amenities);
//
//            HashMap<String, Object> result = new HashMap<String, Object>();
//            result.put("hotels", hotelList);
//            result.put("amenities", amenities);
//            hotelDetails.put("availability", roomsBooked);
//            hotelDetails.put("costsOfRooms", costs);
//            hotelDetails.put("amenities", amenities);
//            finalResult.add(hotelDetails);
//        }

    // return  finalResult;
}


//}

