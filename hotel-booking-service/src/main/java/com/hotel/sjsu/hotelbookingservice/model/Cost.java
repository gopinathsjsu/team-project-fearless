package com.hotel.sjsu.hotelbookingservice.model;

public class Cost {
	
	
	private Double deluxeCost;
	private Double suiteCost;
	private Double contBreakfastCost;
	private Double fitnessRoomCost;
	private Double swimmingPoolCost;
	private Double parkingCost;
	private Double breakfastCost;
	private Double lunchCost;
	private Double dinnerCost;
	
	public Cost() {
		super();
	}

	public Cost(Double deluxeCost, Double suiteCost, Double contBreakfastCost, Double fitnessRoomCost,
			Double swimmingPoolCost, Double parkingCost, Double breakfastCost, Double lunchCost, Double dinnerCost) {
		super();
		this.deluxeCost = deluxeCost;
		this.suiteCost = suiteCost;
		this.contBreakfastCost = contBreakfastCost;
		this.fitnessRoomCost = fitnessRoomCost;
		this.swimmingPoolCost = swimmingPoolCost;
		this.parkingCost = parkingCost;
		this.breakfastCost = breakfastCost;
		this.lunchCost = lunchCost;
		this.dinnerCost = dinnerCost;
	}

	public Double getDeluxeCost() {
		return deluxeCost;
	}

	public void setDeluxeCost(Double deluxeCost) {
		this.deluxeCost = deluxeCost;
	}

	public Double getSuiteCost() {
		return suiteCost;
	}

	public void setSuiteCost(Double suiteCost) {
		this.suiteCost = suiteCost;
	}

	public Double getContBreakfastCost() {
		return contBreakfastCost;
	}

	public void setContBreakfastCost(Double contBreakfastCost) {
		this.contBreakfastCost = contBreakfastCost;
	}

	public Double getFitnessRoomCost() {
		return fitnessRoomCost;
	}

	public void setFitnessRoomCost(Double fitnessRoomCost) {
		this.fitnessRoomCost = fitnessRoomCost;
	}

	public Double getSwimmingPoolCost() {
		return swimmingPoolCost;
	}

	public void setSwimmingPoolCost(Double swimmingPoolCost) {
		this.swimmingPoolCost = swimmingPoolCost;
	}

	public Double getParkingCost() {
		return parkingCost;
	}

	public void setParkingCost(Double parkingCost) {
		this.parkingCost = parkingCost;
	}

	public Double getBreakfastCost() {
		return breakfastCost;
	}

	public void setBreakfastCost(Double breakfastCost) {
		this.breakfastCost = breakfastCost;
	}

	public Double getLunchCost() {
		return lunchCost;
	}

	public void setLunchCost(Double lunchCost) {
		this.lunchCost = lunchCost;
	}

	public Double getDinnerCost() {
		return dinnerCost;
	}

	public void setDinnerCost(Double dinnerCost) {
		this.dinnerCost = dinnerCost;
	}

	@Override
	public String toString() {
		return "Cost [deluxeCost=" + deluxeCost + ", suiteCost=" + suiteCost + ", contBreakfastCost="
				+ contBreakfastCost + ", fitnessRoomCost=" + fitnessRoomCost + ", swimmingPoolCost=" + swimmingPoolCost
				+ ", parkingCost=" + parkingCost + ", breakfastCost=" + breakfastCost + ", lunchCost=" + lunchCost
				+ ", dinnerCost=" + dinnerCost + "]";
	}

	
}
