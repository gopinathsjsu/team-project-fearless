package com.hotel.sjsu.hotelbookingservice.room;

public class Decorator implements Room{
	
	private Room room;
	private int numberOfRooms;
	
	public Decorator(Room room, int numberOfRooms) {
		this.room = room;
		this.numberOfRooms = numberOfRooms;
	}

	@Override
	public Double calculateCost() {
		return this.room.calculateCost();
	}

	@Override
	public String getDescription() {
		return this.room.getDescription();
	}
}
