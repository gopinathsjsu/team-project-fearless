package com.hotel.sjsu.hotelbookingservice.service;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class ManageHotelService {

    @Autowired
    HotelRepository hotelRepository;

    public List<HotelEntity> getAllHotels () {return (List<HotelEntity>) hotelRepository.findAll();}

    public List<Hotel> getHotel(String hotel_location) {
        List<HotelEntity> hotelEntityList = new ArrayList<HotelEntity>();
        hotelEntityList = hotelRepository.findByhotelLocation(hotel_location);

        List<Hotel> hotelList = new ArrayList<Hotel>();

        for(HotelEntity hotelEntity : hotelEntityList){
            hotelList.add(new Hotel(hotelEntity));
        }

        return hotelList;
    }
}
