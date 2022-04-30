package com.hotel.sjsu.hotelbookingservice.rating;

import java.util.List;

import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;
import com.hotel.sjsu.hotelbookingservice.model.Cost;

public interface RatingPlan {

	Cost getPlan(List<RoomEntity> roomList, List<AmenityEntity> amenityList);
}
