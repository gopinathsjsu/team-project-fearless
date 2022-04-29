package com.hotel.sjsu.hotelbookingservice.amenity;

public class Decorator implements Amenity{
	
	private Amenity amenity;
	
	public Decorator(Amenity amenity) {
		this.amenity = amenity;
	}

	@Override
	public Double calculateCost() {
		return this.amenity.calculateCost();
	}

	@Override
	public String getDescription() {
		return this.amenity.getDescription();
	}
}
