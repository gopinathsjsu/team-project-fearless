package com.hotel.sjsu.hotelbookingservice.amenity;

public class ConcreteAmenity implements Amenity{

	@Override
	public Double calculateCost() {
		return 0D;
	}

	@Override
	public String getDescription() {
		return "Amenity Charges";
	}

}
