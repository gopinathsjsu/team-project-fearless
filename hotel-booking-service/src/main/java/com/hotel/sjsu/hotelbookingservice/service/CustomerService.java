package com.hotel.sjsu.hotelbookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Customer;
import com.hotel.sjsu.hotelbookingservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	ModelToEntityMapper modelToEntityMapper;
	
	@Autowired
	EntityToModelMapper entityToModelMapper;
	
	public String register(Customer customer) {
		
		CustomerEntity customerEntity = modelToEntityMapper.mapCustomer(customer);
		customerRepository.save(customerEntity);
		return "Added Successfully";
	}

	public Boolean login(Customer customer) {
		
		CustomerEntity customerEntity = modelToEntityMapper.mapCustomer(customer);
		CustomerEntity cusEnt = customerRepository.findByCustEmail(customerEntity.getCustEmail());
				
		if(cusEnt.getCustPassword().equals(customerEntity.getCustPassword())) {
			return true;
		}
		return false;
		
	}

}
