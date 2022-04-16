package com.hotel.sjsu.hotelbookingservice.repository;

import com.hotel.sjsu.hotelbookingservice.entity.AmenityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<AmenityEntity, String> {

    List<AmenityEntity> findAll();
}
