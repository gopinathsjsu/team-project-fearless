package com.hotel.sjsu.hotelbookingservice.model;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Hotel {

    private Long hotelId;
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


	public Long getHotelId() {
		return hotelId;
	}


	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}


	public String getHotelname() {
		return hotelname;
	}


	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}


	public String getHotelLocation() {
		return hotelLocation;
	}


	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
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

    
}
