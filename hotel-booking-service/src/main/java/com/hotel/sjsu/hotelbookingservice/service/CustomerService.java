package com.hotel.sjsu.hotelbookingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Customer;
import com.hotel.sjsu.hotelbookingservice.model.Response;
import com.hotel.sjsu.hotelbookingservice.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	ModelToEntityMapper modelToEntityMapper;
	
	@Autowired
	EntityToModelMapper entityToModelMapper;
	
	
	
	public Response register(Customer customer) {
		
		customer.setLoyaltyPoints(100);
		customer.setBookingCount(0);
		
		StringBuilder message = new StringBuilder();
		if(validateCustomer(customer,message)) {
			CustomerEntity customerEntity = modelToEntityMapper.mapCustomer(customer);
			CustomerEntity customerEntityResult = customerRepository.save(customerEntity);
			
			if(customerEntityResult!= null && customerEntityResult.getCustomerId()>0) {
				return new Response((Long)customerEntityResult.getCustomerId(), "Registered Successfully");
			}else {
				return new Response(-1, "Unable to registerd");
			}

		}
		return new Response(-1,message.toString());

	}

	private boolean validateCustomer(Customer customer, StringBuilder message) {
		boolean result = true;
		
		
		if(customer.getCustFirstName()==null || customer.getCustFirstName().equals("") ) {
			message.append("Please enter first name."+"\n");
			result = false;
		}
		
		result = validateLogin(customer, result,message);
		
		return result;
	}

	public boolean validateLogin(Customer customer, boolean result, StringBuilder message) {
		if(customer.getCustEmail()==null || customer.getCustEmail().equals("") ) {
			message.append("Please enter email address."+"\n");
			result = false;
		}
		
		if(customer.getCustPassword()==null || customer.getCustPassword().equals("") ) {
			message.append("Please enter password."+"\n");
			result = false;
		}
		return result;
	}

	public Response login(Customer customer) {
		
		StringBuilder message = new StringBuilder();
		if(validateCustomerLogin(customer,message)) {
			
			CustomerEntity customerEntity = modelToEntityMapper.mapCustomer(customer);
			CustomerEntity customerEntityResult = customerRepository.findByCustEmail(customer.getCustEmail());
			
			if(customerEntityResult!= null && customerEntityResult.getCustomerId()>0
					&& customerEntityResult.getCustPassword().equals(customer.getCustPassword())) {
				customerEntityResult.setCustPassword("****");
				Customer cust = entityToModelMapper.mapCustomer(customerEntityResult);
				return new Response((Customer)cust, "Login Successfully");
			
			}else {
				return new Response(-1, "Incorrect email or password. Please check again");
			}

		}
		return new Response(-1,message.toString());
		
	}

	private boolean validateCustomerLogin(Customer customer, StringBuilder message) {

		boolean result = true;
		result = validateLogin(customer, result,message);
		return result;
	}

	public Response getLoyaltyPoints(Long customerId) {
		
		CustomerEntity cusEnt = customerRepository.findByCustomerId(customerId);
		
		if(cusEnt==null) {
			return new Response(-1, "Invalid customer Id");
		}
		
		return new Response(cusEnt.getLoyaltyPoints(), "Successfully fetched Loyalty Points");
	}

	public Response getCustomerDetails(Long customerId) {
		
		if(customerId<=0) {
			return new Response(-1, "Invalid customer Id");
		}
		
		CustomerEntity cusEnt = customerRepository.findByCustomerId(customerId);
		
		if(cusEnt==null) {
			return new Response(-1, "Invalid customer Id");
		}
		
		Customer customer = entityToModelMapper.mapCustomer(cusEnt);
		return new Response(customer, "Able to retrieve customer details");
	}

	public Response updateCustomer(Long customerId, Integer loyaltyPointsUsed) {
	
		CustomerEntity cusEnt = customerRepository.findByCustomerId(customerId);
		if(cusEnt==null) {
			return new Response(-1,"Could not find customer");
		}
		
		Customer customer = entityToModelMapper.mapCustomer(cusEnt);
		
		int bookingCount = customer.getBookingCount()+1;
		int loyaltyPoint = customer.getLoyaltyPoints();
		if(bookingCount==3) {
			customer.setBookingCount(0);
			loyaltyPoint = loyaltyPoint+50-loyaltyPointsUsed;
			customer.setLoyaltyPoints(loyaltyPoint);
		}else {
			customer.setBookingCount(bookingCount);
			loyaltyPoint = loyaltyPoint-loyaltyPointsUsed;
			customer.setLoyaltyPoints(loyaltyPoint);

		}
		
		CustomerEntity customerEntity = modelToEntityMapper.mapCustomer(customer);
		
		CustomerEntity customerEntityResult = customerRepository.save(customerEntity);
		
		if(customerEntityResult==null) {
			return new Response(-1,"Could not update booking details");
		}
		
		return new Response(customerEntity, "Success");
	}


}
