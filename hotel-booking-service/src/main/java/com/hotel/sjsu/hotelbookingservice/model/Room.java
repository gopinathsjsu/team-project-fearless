package com.hotel.sjsu.hotelbookingservice.model;

import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import com.hotel.sjsu.hotelbookingservice.entity.RoomEntity;

public class Room {

    private Integer roomId;
    private String roomCode;
    private String roomType;
    private Double roomCost;
    private Double roomCostSpl;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
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
//    public Integer getRoomCost() {
//        return roomCost;
//    }
//
//    public void setRoomCost(Integer roomCost) {
//        this.roomCost = roomCost;
//    }

//    public Room(Integer roomId, String roomCode, String roomType, Integer roomCost) {
//
//        super();
//        this.roomId = roomId;
//        this.roomCode = roomCode;
//        this.roomType = roomType;
//        this.roomCost = roomCost;
//    }

    public Room(Integer roomId, String roomCode, String roomType, Double roomCost, Double roomCostSpl) {

        super();

        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomType = roomType;
        this.roomCost = roomCost;
        this.roomCostSpl = roomCostSpl;
    }

    public Room() {

        super();
    }

    public Room (RoomEntity roomEntity){

        this.roomId = roomEntity.getRoomId();
        this.roomType = roomEntity.getRoomType();
        this.roomCode = roomEntity.getRoomCode();
        this.roomCost = roomEntity.getRoomCost();
        this.roomCostSpl = roomEntity.getRoomCostSpl();

    }
}


