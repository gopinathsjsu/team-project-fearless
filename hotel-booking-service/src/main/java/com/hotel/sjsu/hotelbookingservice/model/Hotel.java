package com.hotel.sjsu.hotelbookingservice.model;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Hotel {

    private Integer hotelId;
    private String hotelname;
    private String hotelLocation;
    private String hotel_address;
    private Integer hotelZipCode;
    private String hotelContact;
    private String hotelManagerName;
    //private String hotelEmail;


    public Hotel (HotelEntity hotelEntity){
        this.hotelId = hotelEntity.getHotelId();
        this.hotelname = hotelEntity.getHotelname();
        this.hotelLocation = hotelEntity.getHotelLocation();
        this.hotel_address = hotelEntity.getHotel_address();
        this.hotelZipCode = hotelEntity.getHotelZipCode();
        this.hotelContact = hotelEntity.getHotelContact();
        this.hotelManagerName = hotelEntity.getHotelManagerName();
        //this.hotelEmail = hotelEntity.getHotelEmail();
    }

}
