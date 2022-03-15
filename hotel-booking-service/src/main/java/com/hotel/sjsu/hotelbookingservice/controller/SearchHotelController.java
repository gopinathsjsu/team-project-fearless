package com.hotel.sjsu.hotelbookingservice.controller;

//import com.hotel.sjsu.hotelbookingservice.entity.SearchHotelEntity;
//import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.SearchHotelRepository;
import com.hotel.sjsu.hotelbookingservice.service.SearchHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

//import java.io.IOException;
import java.util.List;

@RestController
//@RequestMapping(value = "/hotel")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SearchHotelController {

    @Autowired
    SearchHotelRepository searchHotelRepository;

    @Autowired
    private SearchHotelService searchHotelService;

//    @RequestMapping(value="/hotel")
//    public @ResponseBody
//    String searchHotel(@RequestBody Hotel hotel) throws IOException {
//
//        return searchHotelService.searchhotel(hotel);
//    }

    //get all hotels
    @RequestMapping(value="/receivehotel", method = RequestMethod.GET)
    public List getAllHotels(){

        return searchHotelService.getAllHotels();
    }


}


//

//
//    @GetMapping("/hotel_location")
//    public ResponseEntity<List<SearchHotelEntity>> getHotelByLocation(@PathVariable String hotel_location) {
//        return new ResponseEntity<List<SearchHotelEntity>>(searchHotelRepository.getHotelByHotelLocation(hotel_location), HttpStatus.OK);
//
//    }

//    //specific hotels
//    @RequestMapping(value="/specific", method = RequestMethod.GET)
//    public List getAllHotels(){
//        return searchHotelService.getAllHotels();
//    }
//
//    @GetMapping("/specific")
//    public ResponseEntity<List<Hotel>> getHotelsByLocation(@RequestParam String hotel_location) {
//        return new ResponseEntity<List<Hotel>>(searchHotelService.findByHotelLocation(hotel_location), HttpStatus.OK);
//    }

//    List<SearchHotelEntity> hotelsbyLocation = SearchHotelRepository.getHotelByHotelLocation("San Jose");
//
//    hotelsbyLocation.forEach(e -> {
//        System.out.println(e);
//
//    });

//    searchHotelRepository.getHotelByHotelLocation("San Jose");