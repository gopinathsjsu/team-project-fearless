package com.hotel.sjsu.hotelbookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "amenity")
@Table(name = "amenity")
@Component

public class AmenityEntity {

    @Id
    @Column(name="amenity_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private	Integer amenityId;

    @Column(name="amenity_code")
    private	String amenityCode;

    @Column(name="amenity_type")
    private	String amenityType;

    @Column(name="amenity_cost")
    private	Integer amenityCost;

}
