package com.hotel.sjsu.hotelbookingservice.model;

public class Room {

    private Integer roomId;
    private String roomCode;
    private String roomType;
    private Integer roomCost;

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

    public Integer getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(Integer roomCost) {
        this.roomCost = roomCost;
    }

    public Room(Integer roomId, String roomCode, String roomType, Integer roomCost) {

        super();
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomType = roomType;
        this.roomCost = roomCost;
    }

    public Room() {
        super();
    }
}


