package com.hotel.sjsu.hotelbookingservice.repository;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, String> {

    List<HotelEntity> findByhotelLocation(String hotel_location);
}
