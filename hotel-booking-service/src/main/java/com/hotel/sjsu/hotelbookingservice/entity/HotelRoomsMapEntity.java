package com.hotel.sjsu.hotelbookingservice.entity;

import com.hotel.sjsu.hotelbookingservice.model.Hotel;
import com.hotel.sjsu.hotelbookingservice.model.HotelRoomsMap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "hotel_rooms_map")
@Table(name = "hotel_rooms_map")
@Component
//@NoArgsConstructor
public class HotelRoomsMapEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "hotel_id")
    private Integer hotelId;

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "total_rooms")
    private Integer totalRooms;

    public HotelRoomsMapEntity(HotelRoomsMap hotelRoomsMap){
        this.hotelId = hotelRoomsMap.getHotelId();
        this.roomCode = hotelRoomsMap.getRoomCode();
        this.totalRooms = hotelRoomsMap.getTotalRooms();
//        this.Id = hotelRoomsMap.getId();

    }

    public HotelRoomsMapEntity(Integer hotelId, String roomCode, Integer totalRooms) {
        super();
//        this.Id = id;
        this.hotelId = hotelId;
        this.roomCode = roomCode;
        this.totalRooms = totalRooms;
    }

    public HotelRoomsMapEntity() {

        super();
    }

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public Integer getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(Integer totalRooms) {
		this.totalRooms = totalRooms;
	}
    
    
}
