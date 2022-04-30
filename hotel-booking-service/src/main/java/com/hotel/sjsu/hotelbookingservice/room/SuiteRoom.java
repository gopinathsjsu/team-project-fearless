package com.hotel.sjsu.hotelbookingservice.room;

import com.hotel.sjsu.hotelbookingservice.model.Cost;

public class SuiteRoom extends Decorator {

	Double cost;
	String description;
	int numberOfRooms;
	
	public SuiteRoom(Room room, int numberOfRooms, Cost costObj) {
		super(room, numberOfRooms);
		this.numberOfRooms = numberOfRooms;
		this.cost = costObj.getSuiteCost();
		this.description = "Suite (Prices per room) :"+cost;
	}

	@Override
	public Double calculateCost() {
		cost = cost * this.numberOfRooms ;
		return cost +super.calculateCost();
	}

	@Override
	public String getDescription() {
		return super.getDescription() + "\n" + description +
										"\n"+ "Number of Suite Rooms booked : "+ this.numberOfRooms
										+"\n" + "Total charge for Suite rooms : " + this.cost +"\n";
	}

}
