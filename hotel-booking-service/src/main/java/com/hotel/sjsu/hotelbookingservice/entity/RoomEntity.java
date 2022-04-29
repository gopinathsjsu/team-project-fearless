package com.hotel.sjsu.hotelbookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "room")
@Component
public class RoomEntity {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(name = "room_code")
    private String roomCode;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "room_cost")
	private Double roomCost;

	@Column(name="room_cost_spl")
	private Double roomCostSpl;
	

	public RoomEntity() {
		super();
	}

	public RoomEntity(int roomId, String roomCode, String roomType, Double roomCost, Double roomCostSpl) {
		super();
		this.roomId = roomId;
		this.roomCode = roomCode;
		this.roomType = roomType;
		this.roomCost = roomCost;
		this.roomCostSpl = roomCostSpl;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(Double roomCost) {
		this.roomCost = roomCost;
	}

	public Double getRoomCostSpl() {
		return roomCostSpl;
	}

	public void setRoomCostSpl(Double roomCostSpl) {
		this.roomCostSpl = roomCostSpl;
	}

	@Override
	public String toString() {
		return "RoomEntity [roomId=" + roomId + ", roomCode=" + roomCode + ", roomType=" + roomType + ", roomCost="
				+ roomCost + ", roomCostSpl=" + roomCostSpl + "]";
	}

}
