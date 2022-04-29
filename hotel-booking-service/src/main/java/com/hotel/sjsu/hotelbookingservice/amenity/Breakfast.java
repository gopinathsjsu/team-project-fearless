package com.hotel.sjsu.hotelbookingservice.amenity;

import com.hotel.sjsu.hotelbookingservice.model.Cost;

public class Breakfast extends Decorator {

	Double cost;
	String description;
	
	public Breakfast(Amenity amenity, Cost costObj) {
		super(amenity);
		cost = costObj.getFitnessRoomCost();
		description = "Breakfast : " + cost;
	}
	
	@Override
	public Double calculateCost() {
		cost = cost + super.calculateCost();
		return cost;
	}

	@Override
	public String getDescription() {
		return super.getDescription() + "\n" + description;
	}

}
