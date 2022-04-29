package com.hotel.sjsu.hotelbookingservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;

@Repository
public interface RoomRepository extends CrudRepository<RoomEntity, Long>{

	List<RoomEntity> findAll();

}
