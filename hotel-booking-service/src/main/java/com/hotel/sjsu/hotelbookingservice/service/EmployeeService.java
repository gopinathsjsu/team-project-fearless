package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelRoomsMapEntity;
import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;
import com.hotel.sjsu.hotelbookingservice.model.*;
import com.hotel.sjsu.hotelbookingservice.repository.EmployeeRepository;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRoomsMapRepository;
import com.hotel.sjsu.hotelbookingservice.repository.RoomRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
//import java.util.HashMap;
//import java.util.Map;


@Service
@Transactional
public class EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HotelRepository hotelRepository;



    @Autowired
    private HotelRoomsMapRepository hotelRoomsMapRepository;

    @Autowired
    private RoomRepository roomRepository;


    public String addNewHotel(String inputPayload) throws ParseException {

        JSONObject json = new JSONObject(inputPayload);
        String hotelName = (String) tryToGet(json, "hotelName");
        String hotelLocation = (String) tryToGet(json, "hotelLocation");
        String hotelAddress = (String) tryToGet(json,"hotelAddress");
        String hotelContact = (String) tryToGet(json, "hotelContact");
        String hotelZipcode = (String) tryToGet(json, "hotelZipcode");
        String hotelManagername = (String) tryToGet(json, "hotelManagername");
        String hotelEmail = (String) tryToGet(json, "hotelEmail");
        Integer DRCount = (Integer) tryToGet(json, "DRCount");
        Integer SRCount = (Integer) tryToGet(json, "SRCount");


            hotelRepository.save(new HotelEntity(hotelName, hotelLocation, hotelAddress, hotelZipcode,
                    hotelContact, hotelManagername, hotelEmail));

            Integer newHotelId = employeeRepository.getNewHotelIdByZipcode(hotelZipcode);

            hotelRoomsMapRepository.save(new HotelRoomsMapEntity(newHotelId, "DR", DRCount));
            hotelRoomsMapRepository.save(new HotelRoomsMapEntity(newHotelId, "SR", SRCount));

            String output = "{\"result\": \"A new hotel has been added successfully!!\"}";
            JSONObject jsonResult = new JSONObject(output);
            System.out.println(jsonResult);
            return output;
        }



    public List<Room> getRoomDetails () {

        List<RoomEntity> roomEntityList = roomRepository.findAll();
        List<Room> roomList = new ArrayList<Room>();
        roomEntityList.forEach((roomEntity -> {
            roomList.add(new Room(roomEntity));
        }));
        return roomList;
    }


    public String updateRoomCost (String inputPayload) throws ParseException {

        JSONObject json = new JSONObject(inputPayload);
        String roomDR = (String) json.get("roomDR");
        String roomSR = (String) json.get("roomSR");
        Integer IroomCostDR = (Integer) (json.get("roomCostDR"));
        Integer IroomCostSR =  (Integer) (json.get("roomCostSR"));
        Double roomCostDR =  Double.valueOf(IroomCostDR);
        Double roomCostSR =  Double.valueOf(IroomCostSR);


        roomRepository.updateroomcost(roomCostDR, roomDR);
        roomRepository.updateroomcost(roomCostSR, roomSR);

        String output = "{\"result\": \"The costs for Deluxe and Suite Room types have been updated!!\"}";
        JSONObject jsonResult = new JSONObject(output);
        System.out.println(jsonResult);
        return output;
    }


    public  static Object tryToGet(JSONObject jsonObj, String key) {
        if (jsonObj.has(key))
            return jsonObj.opt(key);
        return null;
    }


    public String validateAddNewHotel (String inputPayload) throws ParseException {

        JSONObject json;
        json = new JSONObject(inputPayload);

        String hotelName = (String) tryToGet(json, "hotelName");
        String hotelLocation = (String) tryToGet(json, "hotelLocation");
        String hotelAddress = (String) tryToGet(json,"hotelAddress");
        String hotelContact = (String) tryToGet(json, "hotelContact");
        String hotelZipcode = (String) tryToGet(json, "hotelZipcode");
        String hotelManagername = (String) tryToGet(json, "hotelManagername");
        String hotelEmail = (String) tryToGet(json, "hotelEmail");

        Integer DRCount = (Integer) tryToGet(json, "DRCount");
        Integer SRCount = (Integer) tryToGet(json, "SRCount");

        String errorMessage = new String("");

        if (hotelName == null || hotelName.isEmpty()) {
            errorMessage = "Please enter a hotel name";
        }

        else if (hotelLocation == null || hotelLocation.isEmpty()) {
            errorMessage = errorMessage + "Please enter a location for hotel";
        }

        else if (hotelAddress == null || hotelAddress.isEmpty()) {
            errorMessage = errorMessage + "Please enter a hotel address";
        }


        else if (hotelContact == null || hotelContact.equals("")) {
            errorMessage = errorMessage + "Please enter a contact number for the hotel";
        }

        else if (hotelZipcode == null || hotelZipcode.equals("") || hotelZipcode.length() == 0 || hotelZipcode.length() > 6) {
            errorMessage = errorMessage + "Please enter valid zipcode upto 6 digits of the hotel location";
        }

        else if(hotelManagername == null || hotelManagername.isEmpty()) {
            errorMessage = errorMessage + "Please enter a manager number for the hotel";
        }

        else if(hotelEmail == null || hotelEmail.isEmpty()) {
            errorMessage = errorMessage + "Please enter email id for the hotel";
        }

        else if(DRCount == null || DRCount.equals("") || DRCount == 0 ) {
            errorMessage = errorMessage + "Please enter a valid deluxe room count for the hotel ";
        }

        else if(SRCount == null || SRCount.equals("") || SRCount ==0 ) {
            errorMessage = errorMessage + "Please enter a valid suite room count for the hotel ";
        }

        return errorMessage;
    }


}

