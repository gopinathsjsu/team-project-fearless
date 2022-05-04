package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelRoomsMapEntity;
import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.model.Room;
import com.hotel.sjsu.hotelbookingservice.repository.EmployeeRepository;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRoomsMapRepository;
import com.hotel.sjsu.hotelbookingservice.repository.RoomRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
        String hotelName = (String) json.get("hotelName");
        String hotelLocation = (String) json.get("hotelLocation");
        String hotelAddress = (String) json.get("hotelAddress");
        String hotelContact = (String) json.get("hotelContact");
        String hotelZipcode = (String) json.get("hotelZipcode");
        String hotelManagername = (String) json.get("hotelManagername");
        Integer DRCount = (Integer) json.get("DRCount");
        Integer SRCount = (Integer)json.get("SRCount");


        hotelRepository.save(new HotelEntity(hotelName, hotelLocation, hotelAddress, hotelZipcode,
                hotelContact,hotelManagername ));

        Integer newHotelId = employeeRepository.getNewHotelIdByZipcode(hotelZipcode);
//        System.out.println(employeeRepository.getNewHotelIdByZipcode(hotelZipcode));

        hotelRoomsMapRepository.save(new HotelRoomsMapEntity(newHotelId, "DR",DRCount));
        hotelRoomsMapRepository.save(new HotelRoomsMapEntity(newHotelId, "SR",SRCount));
//        System.out.println(hotelRoomsMapRepository.save(new HotelRoomsMapEntity(newHotelId, "DR",DRCount)));
//        System.out.println(hotelRoomsMapRepository.save(new HotelRoomsMapEntity(newHotelId, "SR",SRCount)));

        String output = "{\"result\": \"A new hotel has been added successfully!!\"}";
        JSONObject jsonResult = new JSONObject(output);
        System.out.println(jsonResult);
        return output;


    }

//    public void getNewHotelId(String hotelZipcode) {
//         System.out.println(employeeRepository.getNewHotelIdByZipcode((hotelZipcode)));
//
//    }

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


//        roomRepository.save(new RoomEntity(1001, roomDR, "Deluxe Room", roomCostDR));
//        roomRepository.save(new RoomEntity(1002, roomSR, "Suite Room", roomCostSR));
        roomRepository.updateroomcost(roomCostDR, roomDR);
        roomRepository.updateroomcost(roomCostSR, roomSR);

        String output = "{\"result\": \"The costs for Deluxe and Suite Room types have been updated!!\"}";
        JSONObject jsonResult = new JSONObject(output);
        System.out.println(jsonResult);
        return output;
    }

}
