package com.hotel.sjsu.hotelbookingservice.rating;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;
import com.hotel.sjsu.hotelbookingservice.model.Cost;
import com.hotel.sjsu.hotelbookingservice.repository.AmenityRepository;
import com.hotel.sjsu.hotelbookingservice.repository.RoomRepository;

public class StandardPlan implements RatingPlan {


	
	@Override
	public Cost getPlan(List<RoomEntity> roomList, List<AmenityEntity> amenityList) {
		
		Cost cost = new Cost();
		
		
		for(RoomEntity roomEntity : roomList) {
			if(roomEntity.getRoomCode().equals("DR")) {
				cost.setDeluxeCost(roomEntity.getRoomCost());
			}
			
			if(roomEntity.getRoomCode().equals("SR")) {
				cost.setSuiteCost(roomEntity.getRoomCost());
			}
		}
		
		for(AmenityEntity amenityEntity : amenityList) {
			
			switch(amenityEntity.getAmenityCode()){
			case "CB":
				cost.setContBreakfastCost(amenityEntity.getAmenityCost());
				break;
			case "FR":
				cost.setFitnessRoomCost(amenityEntity.getAmenityCost());				
				break;
			case "SJ":
				cost.setSwimmingPoolCost(amenityEntity.getAmenityCost());
				break;
			case "DP":
				cost.setParkingCost(amenityEntity.getAmenityCost());
				break;
			case "BF":
				cost.setBreakfastCost(amenityEntity.getAmenityCost());
				break;
			case "LN":
				cost.setLunchCost(amenityEntity.getAmenityCost());
				break;
			case "DN":
				cost.setDinnerCost(amenityEntity.getAmenityCost());
				break;
			}
		}
		
		System.out.println(cost.toString());
		return cost;
	}

}
