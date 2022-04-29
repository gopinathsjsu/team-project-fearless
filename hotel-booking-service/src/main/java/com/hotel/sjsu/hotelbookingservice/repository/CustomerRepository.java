package com.hotel.sjsu.hotelbookingservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{
	
	CustomerEntity findByCustEmail(String custEmail);
	
	CustomerEntity findByCustomerId(Long customerId);

}
