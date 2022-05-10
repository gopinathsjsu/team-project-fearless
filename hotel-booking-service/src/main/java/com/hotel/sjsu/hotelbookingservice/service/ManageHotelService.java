package com.hotel.sjsu.hotelbookingservice.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.model.Amenity;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.AmenityRepository;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRoomsMapRepository;

@Service
public class ManageHotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    EntityToModelMapper entityToModelMapper;

    @Autowired
    HotelRoomsMapRepository hotelRoomsMapRepository;

    @Autowired
    AmenityService amenityService;
    @Autowired
    AmenityRepository amenityRepository;

//    @Autowired
//    Booking booking;


    public List<HotelEntity> getAllHotels () {

        return (List<HotelEntity>) hotelRepository.findAll();

    }

    public List<Hotel> getHotelsAtLocation(String hotel_location) {

        List<HotelEntity> hotelEntityList = new ArrayList<HotelEntity>();
        hotelEntityList = hotelRepository.findByhotelLocation(hotel_location);

        List<Hotel> hotelList = new ArrayList<Hotel>();

        for(HotelEntity hotelEntity : hotelEntityList){
            hotelList.add(new Hotel(hotelEntity));
        }

        return hotelList;
    }


    public static Object tryToGet(JSONObject jsonObj, String key) {
        if (jsonObj.has(key))
            return jsonObj.opt(key);
        return null;
    }

    public List<Integer> gethotelIds(String hotel_location) {
        return hotelRepository.gethotelIdByhotelLocation(hotel_location);
    }


    public List<String> getbookingIds(Long hotel_id , String fromDate, String toDate) {

        List<BookingEntity> bookingEntList = new ArrayList<BookingEntity>();
        bookingEntList = hotelRepository.getbookingIdsByhotelId(hotel_id, fromDate, toDate);

        //System.out.println("Booking Entity=  "+bookingEntList);
        List<String> bookingList = new ArrayList<String>();

        for (BookingEntity bookingEntity : bookingEntList) {
            bookingList.add(entityToModelMapper.mapBooking(bookingEntity).getRoom());
        }

//        return hotelRepository.getbookingIdsByhotelId(hotel_id);

        return bookingList;

    }

    public String maxDaysBooking(String checkInDate, String checkOutDate)
            throws ParseException {
        Date firstDate = new Date();
        Date secondDate = new Date();

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            firstDate = sdf.parse(checkInDate);
            secondDate = sdf.parse(checkOutDate);
        }catch(ParseException err){
            return "Unable to parse dates - provide valid check-in/check-out dates";
        }

        long diffInMillies = (secondDate.getTime() - firstDate.getTime());
        if (diffInMillies >0){
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if(diff <= 7){
                return "";
            }
            else{
                return " You can not book hotel more than 7 days, provide check-out date withing 7 days of check-in date";
            }
        }
        else{
            return "Please provide check-in date before check-out date";

        }
    }
    public Map<String, Integer> getCostOfRoom(Long hotelId){

        HashMap<String, Integer> roomCost = new HashMap<String, Integer>();
        Integer roomDRCost = hotelRoomsMapRepository.getRoomCost("DR");
        Integer roomSRCost = hotelRoomsMapRepository.getRoomCost("SR");
        System.out.println("DR room cost = " + roomDRCost);
        System.out.println("SR room cost = " + roomSRCost);
        roomCost.put("DR", roomDRCost);
        roomCost.put("SR", roomSRCost);
        return roomCost;

    }
    public List<Map> findHotels(String inputPayload) throws ParseException {

        ArrayList<Map> finalResult = new ArrayList<>(Collections.emptyList());
        JSONObject json;
        json = new JSONObject(inputPayload);
        String fromDate = (String) tryToGet(json, "from");
        String toDate = (String) tryToGet(json, "to");
        String location = (String) tryToGet(json,"location");


        ArrayList<Hotel> hotelList = (ArrayList<Hotel>) getHotelsAtLocation(location);

        if (hotelList.isEmpty()){
            System.out.println("No hotel found at location " + location);
            return finalResult;
        }

        for (Hotel entry : hotelList) {
            HashMap<String, Object> hotelDetails = new HashMap<String, Object>();
            ArrayList<String> bookingList = new ArrayList<String>();

            Long hotelId = entry.getHotelId();

            System.out.println("Hotel Id found  = " + hotelId);
            bookingList = (ArrayList<String>) getbookingIds(hotelId, fromDate, toDate);
            HashMap<String, Integer> roomsBooked = new HashMap<String, Integer>();
            Integer hotelIdInt = hotelId.intValue();
            Integer totalDrCount = hotelRoomsMapRepository.getTotalRooms(hotelIdInt, "DR");
            Integer totalSrCount = hotelRoomsMapRepository.getTotalRooms(hotelIdInt, "SR");
            if (totalDrCount==null || totalSrCount==null || totalSrCount <= 0 || totalDrCount <= 0){
                roomsBooked.put("DR", 0);
                roomsBooked.put("SR", 0);
                continue;
            }
            // calculating room booked
            roomsBooked.put("DR", totalDrCount);
            roomsBooked.put("SR", totalSrCount);
            for (String booking : bookingList) {
                String[] roomDetails = booking.split("-");
                for (String rooms : roomDetails) {
                    String roomType = rooms.substring(0, 2);
                    Integer roomCount = Integer.valueOf(rooms.substring(2));
                    if (roomsBooked.containsKey(roomType)) {
                        Integer newCount = roomsBooked.get(roomType) - roomCount;
                        roomsBooked.put(roomType, newCount);
                    }
                }
            }
            System.out.println("DR rooms count= " + roomsBooked.get("DR"));
            System.out.println("SR rooms count= " + roomsBooked.get("SR"));
            if ((roomsBooked.get("DR") <=0) || (roomsBooked.get("SR") <= 0)){
                continue;
            }

            hotelDetails.put("hotel", entry);
            // adding room cost
            hotelDetails.put("costOfRooms", getCostOfRoom(hotelId));

            List<AmenityEntity> amenityEntities = amenityService.getAllAmenities();
            List<Amenity> amenities = new ArrayList<Amenity>();
            amenityEntities.forEach((amenityEntity -> {
                amenities.add(new Amenity(amenityEntity));
            }));

            hotelDetails.put("availability", roomsBooked);
            hotelDetails.put("amenities", amenities);
            finalResult.add(hotelDetails);
            //System.out.println("Amenities=  "+amenities);
        }

        return finalResult;

    }


    public String  validateHotelSearch(JSONObject inputPayload) throws ParseException {
        
        String fromDate = (String) tryToGet(inputPayload, "from");
        String toDate = (String) tryToGet(inputPayload, "to");
        String location = (String) tryToGet(inputPayload,"location");
        String errorMessage = new String("");

        if(fromDate==null || fromDate.equals("") ) {
            errorMessage = "Please provide check-in date";
        }
        else if(toDate==null || toDate.equals("") ) {
            errorMessage = errorMessage + "Please provide check-out date";
        }
        else if (location==null || location.isEmpty()){
            errorMessage = errorMessage + "Please provide valid hotel location";
        }
        else  {
            String checkdates = maxDaysBooking(fromDate, toDate);
            if (! checkdates.isEmpty()){
                errorMessage = errorMessage + checkdates;
            }

        }
        return errorMessage;

    }


}
