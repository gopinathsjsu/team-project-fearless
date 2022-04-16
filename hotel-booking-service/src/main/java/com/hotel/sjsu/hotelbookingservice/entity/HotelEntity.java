package com.hotel.sjsu.hotelbookingservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
//@NoArgsConstructor
@Entity(name = "hotel")
@Table(name = "hotel")
@Component
public class HotelEntity {

    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    @Column(name = "hotel_name")
    private String hotelname;

    @Column(name = "hotel_location")
    private String hotelLocation;

    @Column(name = "hotel_address")
    private String hotel_address;

    @Column(name = "hotel_zip_code")
    private Integer hotelZipCode;

    @Column(name = "hotel_contact")
    private String hotelContact;

    @Column(name = "hotel_manager_name")
    private String hotelManagerName;


//    @Column(name = "hotelEmail")
//    private String hotelEmail;
    
    

}
