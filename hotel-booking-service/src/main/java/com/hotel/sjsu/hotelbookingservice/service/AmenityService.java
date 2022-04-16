package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import com.hotel.sjsu.hotelbookingservice.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityService {

    @Autowired
    AmenityRepository amenityRepository;
    public List<AmenityEntity> getAllAmenities () {
        return amenityRepository.findAll();}
}
