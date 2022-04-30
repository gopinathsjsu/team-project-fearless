package com.hotel.sjsu.hotelbookingservice.room;

public class ConcreteRoom implements Room{

	@Override
	public Double calculateCost() {
		return 0D;
	}

	@Override
	public String getDescription() {
		return "Room Charges";
	}

}
