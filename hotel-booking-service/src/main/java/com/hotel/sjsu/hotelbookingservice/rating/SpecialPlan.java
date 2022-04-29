package com.hotel.sjsu.hotelbookingservice.rating;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;
import com.hotel.sjsu.hotelbookingservice.model.Cost;
import com.hotel.sjsu.hotelbookingservice.repository.AmenityRepository;
import com.hotel.sjsu.hotelbookingservice.repository.RoomRepository;

public class SpecialPlan implements RatingPlan{

	
	@Override
	public Cost getPlan(List<RoomEntity> roomList, List<AmenityEntity> amenityList) {
		
		Cost cost = new Cost();
	
		
		for(RoomEntity roomEntity : roomList) {
			if(roomEntity.getRoomCode().equals("DR")) {
				cost.setDeluxeCost(roomEntity.getRoomCostSpl());
			}
			
			if(roomEntity.getRoomCode().equals("SR")) {
				cost.setSuiteCost(roomEntity.getRoomCostSpl());
			}
		}
		
		for(AmenityEntity amenityEntity : amenityList) {
			
			switch(amenityEntity.getAmenityCode()){
			case "CB":
				cost.setContBreakfastCost(amenityEntity.getAmenityCostSpl());
				break;
			case "FR":
				cost.setFitnessRoomCost(amenityEntity.getAmenityCostSpl());				
				break;
			case "SJ":
				cost.setSwimmingPoolCost(amenityEntity.getAmenityCostSpl());
				break;
			case "DP":
				cost.setParkingCost(amenityEntity.getAmenityCostSpl());
				break;
			case "BF":
				cost.setBreakfastCost(amenityEntity.getAmenityCostSpl());
				break;
			case "LN":
				cost.setLunchCost(amenityEntity.getAmenityCostSpl());
				break;
			case "DN":
				cost.setDinnerCost(amenityEntity.getAmenityCostSpl());
				break;
			}
		}
		
		System.out.println(cost.toString());
		return cost;
	}

}
