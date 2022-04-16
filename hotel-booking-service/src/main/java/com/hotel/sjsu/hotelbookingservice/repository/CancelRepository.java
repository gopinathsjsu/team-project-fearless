package com.hotel.sjsu.hotelbookingservice.repository;

import com.hotel.sjsu.hotelbookingservice.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;

public interface CancelRepository extends CrudRepository<BookingEntity, Long> {
}
