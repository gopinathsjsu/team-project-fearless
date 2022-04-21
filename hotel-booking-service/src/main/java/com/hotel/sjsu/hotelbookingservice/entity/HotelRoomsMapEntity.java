package com.hotel.sjsu.hotelbookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "hotel_rooms_map")
@Table(name = "hotel_rooms_map")
@Component
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


}
