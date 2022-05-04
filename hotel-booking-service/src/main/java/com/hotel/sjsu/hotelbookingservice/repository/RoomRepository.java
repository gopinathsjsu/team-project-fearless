package com.hotel.sjsu.hotelbookingservice.repository;

import java.util.List;
import com.hotel.sjsu.hotelbookingservice.entity.HotelRoomsMapEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;


@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Double> {

	List<RoomEntity> findAll();

	@Modifying
	@Query("UPDATE room r set r.roomCost=?1 where r.roomCode=?2" )
	void updateroomcost( Double roomCost,String roomCode);

//    @Query("SELECT r.roomType, r.roomCode, r.roomCost  from room r where r.roomCode in ('DR','SR')" )
//    RoomEntity getExistingRoomDetails (String roomCode);

}
