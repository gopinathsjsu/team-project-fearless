package com.hotel.sjsu.hotelbookingservice.repository;

import com.hotel.sjsu.hotelbookingservice.entity.HotelRoomsMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository

public interface HotelRoomsMapRepository extends JpaRepository<HotelRoomsMapEntity, String> {

    @Query("SELECT totalRooms from hotel_rooms_map where hotelId=?1 and roomCode=?2")
    Integer getTotalRooms(Integer hotel_id, String room_code);

}
