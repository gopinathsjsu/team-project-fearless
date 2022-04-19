package com.hotel.sjsu.hotelbookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "room")
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
    private Integer roomCost;

}
