package com.hotel.sjsu.hotelbookingservice.repository;

import com.hotel.sjsu.hotelbookingservice.entity.HotelRoomsMapEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface HotelRoomsMapRepository extends JpaRepository<HotelRoomsMapEntity, String> {

    @Query("SELECT totalRooms from hotel_rooms_map where hotelId=?1 and roomCode=?2")
    Integer getTotalRooms(Integer hotel_id, String room_code);

    @Query("SELECT roomCost from room where roomCode=?1")
    Integer getRoomCost(String room_code);

//    @Modifying
//    @Query("UPDATE hotel_rooms_map r set r.totalRooms=?1 where r.roomCode=?2 and r.hotelId=?3" )
//    void updateHotelRooms( Integer totalRooms,String roomCode, Long hotelId);

}
