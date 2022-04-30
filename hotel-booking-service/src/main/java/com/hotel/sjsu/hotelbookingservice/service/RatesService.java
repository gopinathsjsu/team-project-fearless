package com.hotel.sjsu.hotelbookingservice.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.sjsu.hotelbookingservice.amenity.Amenity;
import com.hotel.sjsu.hotelbookingservice.amenity.Breakfast;
import com.hotel.sjsu.hotelbookingservice.amenity.ConcreteAmenity;
import com.hotel.sjsu.hotelbookingservice.amenity.ContinentalBreakfast;
import com.hotel.sjsu.hotelbookingservice.amenity.DailyParking;
import com.hotel.sjsu.hotelbookingservice.amenity.Dinner;
import com.hotel.sjsu.hotelbookingservice.amenity.FitnessRoom;
import com.hotel.sjsu.hotelbookingservice.amenity.Lunch;
import com.hotel.sjsu.hotelbookingservice.amenity.SwimmingPool;
import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;
import com.hotel.sjsu.hotelbookingservice.model.Cost;
import com.hotel.sjsu.hotelbookingservice.model.Rating;
import com.hotel.sjsu.hotelbookingservice.model.Response;
import com.hotel.sjsu.hotelbookingservice.rating.RatingPlan;
import com.hotel.sjsu.hotelbookingservice.rating.SpecialPlan;
import com.hotel.sjsu.hotelbookingservice.rating.StandardPlan;
import com.hotel.sjsu.hotelbookingservice.repository.AmenityRepository;
import com.hotel.sjsu.hotelbookingservice.repository.RoomRepository;
import com.hotel.sjsu.hotelbookingservice.room.ConcreteRoom;
import com.hotel.sjsu.hotelbookingservice.room.DeluxeRoom;
import com.hotel.sjsu.hotelbookingservice.room.Room;
import com.hotel.sjsu.hotelbookingservice.room.SuiteRoom;

@Service
public class RatesService {
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	AmenityRepository amenityRepository;
	
	List<String> holidayList = Arrays.asList(
			"2022-01-17",
			"2022-02-21",
			"2022-03-31",
			"2022-02-21",
			"2022-05-30",
			"2022-07-04",
			"2022-09-05",
			"2022-09-09",
			"2022-09-23",
			"2022-11-11",
			"2022-11-24",
			"2022-12-26");

	public Rating calculateAmenityCharges(String amenitiesStr, Cost cost) {
		
		String[] amenityArray =  amenitiesStr.split("-");
		Amenity amenity = new ConcreteAmenity(); 
		
		for(String amenityCode : amenityArray) {
			
			switch(amenityCode){
			
			case "CB":
				amenity = new ContinentalBreakfast(amenity, cost);
				break;
			
			case "FR":
				amenity = new FitnessRoom(amenity, cost);
				break;
		
			case "SJ":
				amenity = new SwimmingPool(amenity, cost);
				break;

			case "DP":
				amenity = new DailyParking(amenity, cost);
				break;
				
			case "BF":
				amenity = new Breakfast(amenity, cost);
				break;
			
			case "LN":
				amenity = new Lunch(amenity, cost);
				break;
		
			case "DN":
				amenity = new Dinner(amenity, cost);
				break;
				
			}
		}
		return new Rating(amenity.calculateCost(), amenity.getDescription());
	}

	public Rating calculateRoomCharges(String roomCombination, Cost cost) {
		
		String[] roomArray =  roomCombination.split("-");
		Room room = new ConcreteRoom(); 
		
		for(String roomCode : roomArray) {
			
			String code = roomCode.substring(0, 2);
			int numberOfRooms = Integer.parseInt(roomCode.substring(2));
			switch(code){
			
			case "DR":
				room = new DeluxeRoom(room,numberOfRooms,cost);
				break;
			
			case "SR":
				room = new SuiteRoom(room,numberOfRooms,cost);
				break;
			
			}
		}
		Double totalCost = room.calculateCost(); 
		return new Rating(totalCost, room.getDescription() +"\n" +"Total Room charges :"+ totalCost);
	}

	
	public Response calculateTotalRating(Rating rating) {

		StringBuilder finalDesc = new StringBuilder();
		Double totalCost = 0.0D;
		
		int noOfNormalDays = 0;
		int noOfSpecialDays = 0;
		boolean isSpecialDay = false; 
		Cost cost = new Cost();
		
		StringBuilder message = new StringBuilder();
		if(validateRating(rating, message)) {
			List<RoomEntity> roomList = new ArrayList<RoomEntity>();
			roomList = roomRepository.findAll();
			
			List<AmenityEntity> amenityList = new ArrayList<AmenityEntity>();
			amenityList = amenityRepository.findAll();
		
			
			Calendar fromDate = getCalendarFromString(rating.getFromDate());
			Calendar toDate = getCalendarFromString(rating.getToDate());
			
			long noOfDays =TimeUnit.MILLISECONDS.toDays(
		            Math.abs(toDate.getTimeInMillis() - fromDate.getTimeInMillis()))+1;
			
			if(noOfDays>7 || noOfDays<=0) {
				return new Response(-1, "Select 7 or lessdays");
			}
			System.out.println("No of days "+noOfDays);
			
			for(int i=0; i<noOfDays;i++) {
				
				Calendar calendar = fromDate;
				// Sun =1, Mon =2, Tue =3, Wed =4, Thur =5, Fri =6, Sat =7
				
				int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
				System.out.println("Day of the week "+ dayOfWeek);
				
				String dateStr = getStringFromCalendar(calendar);
				
				System.out.println("Date : "+ dateStr);
				
				if(dayOfWeek==1 || dayOfWeek==7 || holidayList.contains(dateStr)) {
					isSpecialDay = true;
					noOfSpecialDays++;
				}else {
					isSpecialDay = false;
					noOfNormalDays++;
				}
				
				System.out.println("Weekend/Holiday? "+isSpecialDay);
				calendar.add(Calendar.DATE, 1);
			}
			
			System.out.println(noOfNormalDays+" "+noOfSpecialDays);
			
			finalDesc.append("Rates Description"+"\n");
			Double weekDayCost =0.0D;
			Double weekEndCost =0.0D;
			if(noOfSpecialDays>0) {
				 finalDesc.append("Rates for Weekend/Holiday(per day)"+"\n");
				 RatingPlan ratingPlan  = new SpecialPlan();
				 weekDayCost = calculateResult(rating, roomList, amenityList, ratingPlan, finalDesc, noOfSpecialDays);
				 totalCost = totalCost + weekDayCost;
				 finalDesc.append("\n"+"***********************************");
			}
			
			if (noOfNormalDays>0){
	    		 finalDesc.append("\n"+"Rates for Weekday(per day)"+"\n");
				 RatingPlan ratingPlan = new StandardPlan();
				 weekEndCost = calculateResult(rating, roomList, amenityList, ratingPlan, finalDesc,noOfNormalDays);
				 totalCost = totalCost + weekEndCost;
				 finalDesc.append("\n"+"***********************************");
			}
			
			Integer loyaltyPointsUsed = rating.getLoyaltyPointsUsed();
			
			Double billCost = weekDayCost+ weekEndCost;
			finalDesc.append("\n"+"Total Cost before discount: "+billCost);
			finalDesc.append("\n"+"Amount of Loyalty points used: "+loyaltyPointsUsed);
			finalDesc.append("\n"+"Total cost after disccount: "+(billCost-loyaltyPointsUsed));
			finalDesc.append("\n"+"***********************************");
			
			System.out.println(finalDesc.toString());		
			rating.setCost(totalCost-loyaltyPointsUsed);
			rating.setDescription(finalDesc.toString());
			
			return new Response(rating, " Rating successfull");
		}
		

		return new Response(-1, message.toString());
	}

	private boolean validateRating(Rating rating, StringBuilder message) {
		boolean result = true;
		
		if(rating.getRoom()==null || rating.getRoom().equals("") ) {
			message.append("Please select room"+"\n");
			result = false;
		}
		
		if(rating.getAmenity()==null || rating.getAmenity().equals("") ) {
			message.append("Please select amenity"+"\n");
			result = false;
		}
		
		return result;
	}

	public String getStringFromCalendar(Calendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(calendar.getTimeZone());
		String dateStr = dateFormat.format(calendar.getTime());
		return dateStr;
	}

	private Double calculateResult(Rating rating, List<RoomEntity> roomList, List<AmenityEntity> amenityList,
			RatingPlan ratingPlan, StringBuilder finalDesc, int noOfDays) {
		
		 Cost cost = new Cost();
		 cost = ratingPlan.getPlan(roomList, amenityList);
		
		 Rating amenityResult = calculateAmenityCharges(rating.getAmenity(),cost);
		 //System.out.println(amenityResult.toString());
		 
		 Rating roomResult = calculateRoomCharges(rating.getRoom(),cost);
		 //System.out.println(roomResult.toString());
		 double thisCost = (roomResult.getCost() + amenityResult.getCost()) * noOfDays;
		 finalDesc.append("\n"+roomResult.getDescription() 
		 +"\n----------------------------\n"
		 + amenityResult.getDescription()
		 +"\n----------------------------\n"
		 +"Cost for "+noOfDays+" days : "+ thisCost);
		 
		 return thisCost;
		 
	}

	public Calendar getCalendarFromString(String strDate) {
		//"0123456789"
		//"2022-10-20"
		Calendar calendar = Calendar.getInstance();
		int year = Integer.parseInt(strDate.substring(0, 4));
		int month = Integer.parseInt(strDate.substring(5, 7))-1;
		int date = Integer.parseInt(strDate.substring(8, 10));
		calendar.set(year,month, date);
		return calendar;
	}

}
