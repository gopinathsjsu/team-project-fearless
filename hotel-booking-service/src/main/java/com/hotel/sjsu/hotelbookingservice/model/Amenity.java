package com.hotel.sjsu.hotelbookingservice.model;

import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Amenity {
    private Integer amenityId;
    private String amenityCode;
    private String amenityType;
    private Double amenityCost;

    public Amenity (AmenityEntity amenityEntity){
        this.amenityId = amenityEntity.getAmenityId();
        this.amenityCode = amenityEntity.getAmenityCode();
        this.amenityType = amenityEntity.getAmenityType();
        this.amenityCost = amenityEntity.getAmenityCost();

    }
}
