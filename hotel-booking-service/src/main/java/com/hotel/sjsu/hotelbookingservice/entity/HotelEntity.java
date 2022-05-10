package com.hotel.sjsu.hotelbookingservice.entity;


import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import lombok.AllArgsConstructor;
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
//@NoArgsConstructor
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
    private String hotelZipCode;

    @Column(name = "hotel_contact")
    private String hotelContact;

    @Column(name = "hotel_manager_name")
    private String hotelManagerName;

	@Column(name = "hotel_email")
	private String hotelEmail;


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

	public HotelEntity(Hotel hotel){

        this.hotelId = hotel.getHotelId();
        this.hotelname = hotel.getHotelname();
        this.hotelLocation = hotel.getHotelLocation();
        this.hotel_address = hotel.getHotel_address();
        this.hotelZipCode = hotel.getHotelZipCode();
        this.hotelContact = hotel.getHotelContact();
        this.hotelManagerName = hotel.getHotelManagerName();
		this.hotelEmail = hotel.getHotelEmail();

    }


    public HotelEntity() {

        super();

    }


	public HotelEntity(String hotelname, String hotelLocation, String hotel_address, String hotelZipCode, String hotelContact, String hotelManagerName, String hotelEmail) {

		this.hotelname = hotelname;
		this.hotelLocation = hotelLocation;
		this.hotel_address = hotel_address;
		this.hotelZipCode = hotelZipCode;
		this.hotelContact = hotelContact;
		this.hotelManagerName = hotelManagerName;
		this.hotelEmail = hotelEmail;
	}
}
