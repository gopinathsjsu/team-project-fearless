package com.hotel.sjsu.hotelbookingservice.model;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Getter
@Setter
@Component
public class Hotel {

    private Long hotelId;
    private String hotelname;
    private String hotelLocation;
    private String hotel_address;
    private String hotelZipCode;
    private String hotelContact;
    private String hotelManagerName;
    private String hotelEmail;


    public Hotel (HotelEntity hotelEntity){
        this.hotelId = hotelEntity.getHotelId();
        this.hotelname = hotelEntity.getHotelname();
        this.hotelLocation = hotelEntity.getHotelLocation();
        this.hotel_address = hotelEntity.getHotel_address();
        this.hotelZipCode = hotelEntity.getHotelZipCode();
        this.hotelContact = hotelEntity.getHotelContact();
        this.hotelManagerName = hotelEntity.getHotelManagerName();
        this.hotelEmail = hotelEntity.getHotelEmail();
    }

	public Hotel() {

		super();
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


	public String getHotelZipCode() {

		return hotelZipCode;
	}


	public void setHotelZipCode(String hotelZipCode) {

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

	public Hotel( String hotelname, String hotelLocation, String hotel_address, String hotelZipCode, String hotelContact, String hotelManagerName, String hotelEmail) {
//		this.hotelId = hotelId;
		this.hotelname = hotelname;
		this.hotelLocation = hotelLocation;
		this.hotel_address = hotel_address;
		this.hotelZipCode = hotelZipCode;
		this.hotelContact = hotelContact;
		this.hotelManagerName = hotelManagerName;
		this.hotelEmail = hotelEmail;
	}

}
