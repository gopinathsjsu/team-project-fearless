package com.hotel.sjsu.hotelbookingservice.repository;

import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.entity.EmployeeEntity;
import com.hotel.sjsu.hotelbookingservice.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpLoginRepository extends JpaRepository<EmployeeEntity, Integer> {

    EmployeeEntity findByempEmail(String empEmail);

    EmployeeEntity findByemployeeId(Integer employeeId);



}
