package com.hotel.sjsu.hotelbookingservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "amenity")
@Component
public class AmenityEntity {

    @Id
    @Column(name="amenity_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private	int amenityId;

    @Column(name="amenity_code")
    private	String amenityCode;

    @Column(name="amenity_type")
    private	String amenityType;

	@Column(name="amenity_cost")
	private Double amenityCost;

	@Column(name="amenity_cost_spl")
	private Double amenityCostSpl;

	public AmenityEntity() {
		super();
	}

	public AmenityEntity(int amenityId, String amenityCode, String amenityType, Double amenityCost, Double amenityCostSpl) {
		super();
		this.amenityId = amenityId;
		this.amenityCode = amenityCode;
		this.amenityType = amenityType;
		this.amenityCost = amenityCost;
		this.amenityCostSpl = amenityCostSpl;
	}

	public int getAmenityId() {
		return amenityId;
	}

	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}

	public String getAmenityCode() {
		return amenityCode;
	}

	public void setAmenityCode(String amenityCode) {
		this.amenityCode = amenityCode;
	}

	public String getAmenityType() {
		return amenityType;
	}

	public void setAmenityType(String amenityType) {
		this.amenityType = amenityType;
	}

	public Double getAmenityCost() {
		return amenityCost;
	}

	public void setAmenityCost(Double amenityCost) {
		this.amenityCost = amenityCost;
	}

	public Double getAmenityCostSpl() {
		return amenityCostSpl;
	}

	public void setAmenityCostSpl(Double amenityCostSpl) {
		this.amenityCostSpl = amenityCostSpl;
	}

	@Override
	public String toString() {
		return "AmenityEntity [amenityId=" + amenityId + ", amenityCode=" + amenityCode + ", amenityType="
				+ amenityType + ", amenityCost=" + amenityCost + ", amenityCostSpl=" + amenityCostSpl + "]";
	}
    
}
