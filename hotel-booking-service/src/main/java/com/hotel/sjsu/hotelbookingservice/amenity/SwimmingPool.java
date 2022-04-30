package com.hotel.sjsu.hotelbookingservice.amenity;

import com.hotel.sjsu.hotelbookingservice.model.Cost;

public class SwimmingPool extends Decorator {

		Double cost;
		String description;
		
		public SwimmingPool(Amenity amenity, Cost costObj) {
			super(amenity);
			cost = costObj.getFitnessRoomCost();
			description = "Swimming Pool and Jacuzzi : " + cost;
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
