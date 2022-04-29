package com.hotel.sjsu.hotelbookingservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
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


//    @Column(name = "hotelEmail")
//    private String hotelEmail;
    
    

}
