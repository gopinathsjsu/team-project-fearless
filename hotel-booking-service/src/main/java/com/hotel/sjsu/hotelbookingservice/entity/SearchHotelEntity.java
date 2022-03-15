package com.hotel.sjsu.hotelbookingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.criteria.CriteriaBuilder;



@Entity
@Table(name = "hotel")
public class SearchHotelEntity {

    @Id
    @Column(name = "hotelid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hotelId;

    @Column(name = "hotelname")
    private String hotelname;


    @Column(name = "hotel_location")
    private String hotel_location;

    @Column(name = "hotel_address")
    private String hotel_address;

    @Column(name = "hotel_zipcode")
    private Integer hotelZipCode;

    @Column(name = "hotel_contact")
    private String hotelContact;

    @Column(name = "hotel_managername")
    private String hotelManagerName;

    @Column(name = "hotel_email")
    private String hotelEmail;

    public SearchHotelEntity() {
        super();
    }

    public SearchHotelEntity(Integer hotelId, String hotelname, String hotel_location, String hotel_address, Integer hotelZipCode, String hotelContact, String hotelManagerName, String hotelEmail) {

        super();
        this.hotelId = hotelId;
        this.hotelname = hotelname;
        this.hotel_location = hotel_location;
        this.hotel_address = hotel_address;
        this.hotelZipCode = hotelZipCode;
        this.hotelContact = hotelContact;
        this.hotelManagerName = hotelManagerName;
        this.hotelEmail = hotelEmail;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public Integer getHotelZipCode() {
        return hotelZipCode;
    }

    public void setHotelZipCode(Integer hotelZipCode) {
        this.hotelZipCode = hotelZipCode;
    }

    public String getHotelContact() {
        return hotelContact;
    }

    public void setHotelContact(String hotelContact) {
        this.hotelContact = hotelContact;
    }

    public String getHotelManagerName() {
        return hotelManagerName;
    }

    public void setHotelManagerName(String hotelManagerName) {
        this.hotelManagerName = hotelManagerName;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }
}
