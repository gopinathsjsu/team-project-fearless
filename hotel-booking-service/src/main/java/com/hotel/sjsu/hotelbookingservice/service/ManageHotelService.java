package com.hotel.sjsu.hotelbookingservice.service;
import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Amenity;
import com.hotel.sjsu.hotelbookingservice.model.Booking;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRoomsMapRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

//    @Autowired
//    Booking booking;


    public List<HotelEntity> getAllHotels () {

        return (List<HotelEntity>) hotelRepository.findAll();

    }

    public List<Hotel> getHotel(String hotel_location) {

        List<HotelEntity> hotelEntityList = new ArrayList<HotelEntity>();
        hotelEntityList = hotelRepository.findByhotelLocation(hotel_location);

        List<Hotel> hotelList = new ArrayList<Hotel>();

        for(HotelEntity hotelEntity : hotelEntityList){
            hotelList.add(new Hotel(hotelEntity));
        }

        return hotelList;
    }

//    public List<Hotel>  gethotelDetails(String hotel_id) {
//        return hotelRepository.gethotel(hotel_location);
//    }
//

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

    public boolean maxDaysBooking(String checkInDate, String checkOutDate)
            throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date firstDate = sdf.parse(checkInDate);
        Date secondDate = sdf.parse(checkOutDate);

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        return diff <= 7;
    }

    public List<Map> findHotels(String inputPayload) throws ParseException {

        JSONObject json = new JSONObject(inputPayload);
        String fromDate = (String)json.get("from");
        String toDate = (String)json.get("to");
        String location = (String)  json.get("location");

        if (maxDaysBooking(fromDate, toDate)) {

            ArrayList<Map> finalResult = new ArrayList<Map>();

            ArrayList<Hotel> hotelList = (ArrayList<Hotel>) getHotel(location);


            for (Hotel entry : hotelList) {
                HashMap<String, Object> hotelDetails = new HashMap<String, Object>();
                ArrayList<String> bookingList = new ArrayList<String>();
                Long hotelId = entry.getHotelId();
                System.out.println("Hotel Id = " + hotelId);
                hotelDetails.put("hotel", entry);
                bookingList = (ArrayList<String>) getbookingIds(hotelId, fromDate, toDate);

                HashMap<String, Integer> roomsBooked = new HashMap<String, Integer>();
                Integer hotelIdInt = hotelId.intValue();

                Integer totalDrCount = hotelRoomsMapRepository.getTotalRooms(hotelIdInt, "DR");
                Integer totalSrCount = hotelRoomsMapRepository.getTotalRooms(hotelIdInt, "SR");

                //adding room cost
                Integer roomDRCost = hotelRoomsMapRepository.getRoomCost("DR");
                Integer roomSRCost = hotelRoomsMapRepository.getRoomCost("SR");
                System.out.println(roomDRCost);
                System.out.println(roomSRCost);
                HashMap<String, Integer> costs = new HashMap<String, Integer>();
                costs.put("DR", roomDRCost);
                costs.put("SR", roomSRCost);

                roomsBooked.put("DR", totalDrCount);
                roomsBooked.put("SR", totalSrCount);

                for (String booking : bookingList) {
                    //System.out.println("Booking details=  "+entry);
                    String[] roomDetails = booking.split("-");
                    //System.out.println("room Details=\n" +(String.join("\n", roomDetails)));
                    for (String rooms : roomDetails) {
                        String roomType = rooms.substring(0, 2);
                        Integer roomCount = Integer.valueOf(rooms.substring(2));
                        if (roomsBooked.containsKey(roomType)) {
                            Integer newCount = roomsBooked.get(roomType) - roomCount;
                            roomsBooked.put(roomType, newCount);
//                        roomsBooked.put("DRCost",roomDRCost);
//                        roomsBooked.put("SRCost",roomSRCost);
                        }
                    }
                }

                System.out.println("DR rooms count= " + roomsBooked.get("DR"));
                System.out.println("SR rooms count= " + roomsBooked.get("SR"));
                List<AmenityEntity> amenityEntities = amenityService.getAllAmenities();
                List<Amenity> amenities = new ArrayList<Amenity>();

                amenityEntities.forEach((amenityEntity -> {
                    amenities.add(new Amenity(amenityEntity));
                }));


                //System.out.println("Amenities=  "+amenities);

                HashMap<String, Object> result = new HashMap<String, Object>();
                result.put("hotels", hotelList);
                result.put("amenities", amenities);
                hotelDetails.put("availability", roomsBooked);
                hotelDetails.put("costsOfRooms", costs);
                hotelDetails.put("amenities", amenities);
                finalResult.add(hotelDetails);
            }

            return finalResult;
        }

        else {
            return Collections.<Map>emptyList();


        }
    }

//    public List<String> getbookingIds(Long hotel_id , String fromDate, String toDate) {
//
//            List<BookingEntity> bookingEntList = new ArrayList<BookingEntity>();
//            bookingEntList = hotelRepository.getbookingIdsByhotelId(hotel_id, fromDate, toDate);
//
//            //System.out.println("Booking Entity=  "+bookingEntList);
//            List<String> bookingList = new ArrayList<String>();
//
//            for (BookingEntity bookingEntity : bookingEntList) {
//                bookingList.add(entityToModelMapper.mapBooking(bookingEntity).getRoom());
//            }
//
////        return hotelRepository.getbookingIdsByhotelId(hotel_id);
//
//            return bookingList;
//
//    }

//    List<String> message = new ArrayList<String>();
//
//    private boolean validateHotelSearch(String checkInDate, String checkOutDate) throws ParseException {
//        boolean result = true;
//
//        if(booking.getBookingDateFrom()==null || booking.getBookingDateFrom().equals("") ) {
//            message.add("Please select check-in date");
//            result = false;
//        }
//        if(booking.getBookingDateTo()==null || booking.getBookingDateTo().equals("") ) {
//            message.add("Please select check-out date.");
//            result = false;
//        }
//        if(booking.getBookingDateFrom()!=null && booking.getBookingDateTo()!=null) {
//            System.out.println(booking.getBookingDateFrom().compareTo(booking.getBookingDateTo()));
//            if(booking.getBookingDateFrom().compareTo(booking.getBookingDateTo()) > 0) {
//                message.add("Please select a check-out date after check-in date.");
//            }
//        }
//        return result;
//    }


    public String getHotelName(Long hotelId) {
    	
    	HotelEntity hotelEntity = hotelRepository.findByHotelId(hotelId);
		return hotelEntity.getHotelname();
    }
}
