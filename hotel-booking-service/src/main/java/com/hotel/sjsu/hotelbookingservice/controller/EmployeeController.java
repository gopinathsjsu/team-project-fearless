package com.hotel.sjsu.hotelbookingservice.controller;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Room;
import com.hotel.sjsu.hotelbookingservice.repository.EmployeeRepository;
import com.hotel.sjsu.hotelbookingservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

//    @PostMapping("/addhotel")
//    public HotelEntity addhotel(@Valid @RequestBody  HotelEntity hotelEntity) {
//
//         return employeeRepository.save(hotelEntity);
//
//    }

    @RequestMapping(value="/addhotel", method = RequestMethod.POST, consumes = "application/json")
    public String  addNewHotel( @RequestBody String payload ) throws ParseException {
         return employeeService.addNewHotel((payload));

    }

//    @GetMapping("/{zipcode}")
//    public ResponseEntity<List<Integer>> gethotelIdByzipcode(@PathVariable String hotelZipcode){
//        return new ResponseEntity<>(employeeService.getNewHotelId(hotelZipcode), HttpStatus.OK);
//    }

    @RequestMapping(value="/updateRCost", method = RequestMethod.POST, consumes = "application/json")
    public String updateRoomCosts( @RequestBody String payload ) throws ParseException {
        return employeeService.updateRoomCost((payload));

    }

    @RequestMapping(value="/viewRoomDetails", method = RequestMethod.GET )
    public List<Room> viewRoomsDetails(){
        return employeeService.getRoomDetails();

    }

}
