package com.hotel.sjsu.hotelbookingservice.controller;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Customer;
import com.hotel.sjsu.hotelbookingservice.model.Employee;
import com.hotel.sjsu.hotelbookingservice.model.Response;
import com.hotel.sjsu.hotelbookingservice.model.Room;
import com.hotel.sjsu.hotelbookingservice.repository.EmployeeRepository;
import com.hotel.sjsu.hotelbookingservice.service.EmpLoginService;
import com.hotel.sjsu.hotelbookingservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.io.IOException;
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

    @Autowired
    EmpLoginService empLoginService;

//    @PostMapping("/addhotel")
//    public HotelEntity addhotel(@Valid @RequestBody  HotelEntity hotelEntity) {
//
//         return employeeRepository.save(hotelEntity);
//
//    }

    @RequestMapping(value="/addhotel", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> postBody(@RequestBody String payload ) throws  ParseException{
        if (payload == null || payload.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please provide valid hotel details");
        }
        String checkHotelDetails = employeeService.validateAddNewHotel(payload);
        if (checkHotelDetails.isEmpty()){
            return new ResponseEntity<>(employeeService.addNewHotel(payload), HttpStatus.OK);
        }

        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(checkHotelDetails);
        }
    }



//    @RequestMapping(value="/updateRoomCount", method = RequestMethod.POST, consumes = "application/json")
//    public String updateRoomsCount( @RequestBody String payload ) throws ParseException {
//        return employeeService.updateHotelRooms((payload));
//
//    }


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

    @RequestMapping(value="/empRegister")
    public @ResponseBody Response registerEmployee(@RequestBody Employee employee) throws IOException, ParseException {
        return empLoginService.register(employee);
    }

    @RequestMapping(value="/empLogin")
    public @ResponseBody Response loginEmployee(@RequestBody Employee employee) throws IOException, ParseException {
        return empLoginService.login(employee);
    }

    @RequestMapping(value="/{employeeId}")
    public @ResponseBody Response getEmployeeDetails(@PathVariable Integer employeeId) throws IOException, ParseException {
        return empLoginService.getEmployeeDetails(employeeId);
    }



}
