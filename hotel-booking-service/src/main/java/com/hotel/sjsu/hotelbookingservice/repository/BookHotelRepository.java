package com.hotel.sjsu.hotelbookingservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;

@Repository
public interface BookHotelRepository extends CrudRepository<BookingEntity, Integer>{

	List<BookingEntity> findAllByCustomerId(Long customerID);
	
}
