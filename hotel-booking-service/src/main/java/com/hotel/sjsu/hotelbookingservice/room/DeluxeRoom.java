package com.hotel.sjsu.hotelbookingservice.room;

import com.hotel.sjsu.hotelbookingservice.model.Cost;

public class DeluxeRoom extends Decorator {

	Double cost;
	String description;
	int numberOfRooms;
	
	public DeluxeRoom(Room room, int numberOfRooms, Cost costObj) {
		super(room, numberOfRooms);
		this.numberOfRooms = numberOfRooms;
		this.cost = costObj.getDeluxeCost();
		this.description = "Deluxe (Prices per room) :"+cost;
	}

	@Override
	public Double calculateCost() {
		cost = cost * this.numberOfRooms ;
		return cost + super.calculateCost();
	}

	@Override
	public String getDescription() {
		return super.getDescription() + "\n" + description +
				"\n"+ "Number of Deluxe Rooms booked : "+ this.numberOfRooms
				+"\n" + "Total charge for Deluxe rooms : " + this.cost+"\n";
	}

}
