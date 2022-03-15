package com.hotel.sjsu.hotelbookingservice.service;

//import com.hotel.sjsu.hotelbookingservice.entity.SearchHotelEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
//import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.SearchHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional

public class SearchHotelService {


    @Autowired
    SearchHotelRepository searchHotelRepository;

    @Autowired
    EntityToModelMapper entityToModelMapper;

    @Autowired
    ModelToEntityMapper modelToEntityMapper;

//    public String searchhotel(Hotel hotel) {
//
//        SearchHotelEntity searchHotelEntity = modelToEntityMapper.map(hotel);
//        searchHotelRepository.save(searchHotelEntity);
//        return "Added Successfully!!";
//    }

//    get all hotel
    public List getAllHotels(){
        List hotels = new ArrayList<>();
        searchHotelRepository.findAll().forEach(hotels::add);
        return hotels;
    }

//    public List<Hotel> findByHotelLocation(String hotel_location) {
//        return null;
//    }


//    //get specific hotel
//    public List getAllHotels(){
//        List hotels = new ArrayList<>();
//        searchHotelRepository.findByHotelLocation("San Jose");
//        return hotels;
//    }

//    public List<Hotel> findByHotelLocation(String hotel_location) {
//        return null;
//    }

//    @Transactional(readOnly=true)
//    public List<Hotel> getHotelByLocation(String hotel_location) {
//        return SearchHotelRepository.findByLocation(hotel_location);
//    }


}
