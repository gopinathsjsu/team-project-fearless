package com.hotel.sjsu.hotelbookingservice.model;

public class HotelRoomsMap {

    private Integer Id;
    private Integer hotelId;
    private String roomCode;
    private Integer totalRooms;


    public HotelRoomsMap(Integer id, Integer hotelId, String roomCode, Integer totalRooms) {

        super();
        this.Id = id;
        this.hotelId = hotelId;
        this.roomCode = roomCode;
        this.totalRooms = totalRooms;
    }

    public HotelRoomsMap() {
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

