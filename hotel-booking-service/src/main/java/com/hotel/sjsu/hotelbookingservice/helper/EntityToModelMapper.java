package com.hotel.sjsu.hotelbookingservice.helper;

import org.springframework.stereotype.Component;

import com.hotel.sjsu.hotelbookingservice.entity.SearchHotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;

@Component
public class EntityToModelMapper {
	
public Hotel map(SearchHotelEntity searchHotelEntity) {

	Hotel hotel = new Hotel(
			searchHotelEntity.getHotelId(),
			searchHotelEntity.getHotelname(),
			searchHotelEntity.getHotel_location(),
			searchHotelEntity.getHotel_address(),
			searchHotelEntity.getHotelZipCode(),
			searchHotelEntity.getHotelContact(),
			searchHotelEntity.getHotelManagerName(),
			searchHotelEntity.getHotelEmail());

		
		return hotel;
	}

}
