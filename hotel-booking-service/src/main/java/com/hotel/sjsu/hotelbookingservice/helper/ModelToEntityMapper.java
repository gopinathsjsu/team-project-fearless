package com.hotel.sjsu.hotelbookingservice.helper;

import org.springframework.stereotype.Component;

import com.hotel.sjsu.hotelbookingservice.entity.SearchHotelEntity;
import com.hotel.sjsu.hotelbookingservice.model.Hotel;

@Component
public class ModelToEntityMapper {

	public SearchHotelEntity map(Hotel hotel) {
		
		SearchHotelEntity searchHotelEntity = new SearchHotelEntity(
				hotel.getHotelId(),
				hotel.getHotelname(),
				hotel.getHotel_location(),
				hotel.getHotel_address(),
				hotel.getHotelZipCode(),
				hotel.getHotelContact(),
				hotel.getHotelManagerName(),
				hotel.getHotelEmail());


		return searchHotelEntity;
	}

}
