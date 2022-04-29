package com.hotel.sjsu.hotelbookingservice.amenity;

import com.hotel.sjsu.hotelbookingservice.model.Cost;

public class Dinner extends Decorator {

	Double cost;
	String description;
	
	public Dinner(Amenity amenity, Cost costObj) {
		super(amenity);
		cost = costObj.getFitnessRoomCost();
		description = "Dinner : " + cost;
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
