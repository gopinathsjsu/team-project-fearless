package com.hotel.sjsu.hotelbookingservice.service;

import com.hotel.sjsu.hotelbookingservice.entity.EmployeeEntity;
import com.hotel.sjsu.hotelbookingservice.model.Employee;
import com.hotel.sjsu.hotelbookingservice.repository.EmpLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.sjsu.hotelbookingservice.entity.CustomerEntity;
import com.hotel.sjsu.hotelbookingservice.helper.EntityToModelMapper;
import com.hotel.sjsu.hotelbookingservice.helper.ModelToEntityMapper;
import com.hotel.sjsu.hotelbookingservice.model.Customer;
import com.hotel.sjsu.hotelbookingservice.model.Response;
import com.hotel.sjsu.hotelbookingservice.repository.CustomerRepository;

@Service
public class EmpLoginService {

    @Autowired
    private EmpLoginRepository empLoginRepository;

    public Response register(Employee employee) {



        StringBuilder message = new StringBuilder();
        if(validateEmployee(employee,message)) {
            EmployeeEntity employeeEntity = new EmployeeEntity(employee);
            EmployeeEntity employeeEntityResult = empLoginRepository.save(employeeEntity);

            if(employeeEntityResult!= null && employeeEntityResult.getEmployeeId()>0) {
                return new Response((Integer)employeeEntityResult.getEmployeeId(), "Registered Successfully");
            }else {
                return new Response(-1, "Unable to register");
            }

        }
        return new Response(-1,message.toString());

    }

    private boolean validateEmployee(Employee employee, StringBuilder message) {
        boolean result = true;


        if(employee.getEmpFirstName()==null || employee.getEmpFirstName().equals("") ) {
            message.append("Please enter first name."+"\n");
            result = false;
        }

        result = validateLogin(employee, result,message);

        return result;
    }

    private boolean validateLogin(Employee employee, boolean result, StringBuilder message) {
        if(employee.getEmpEmail()==null || employee.getEmpEmail().equals("") ) {
            message.append("Please enter email address."+"\n");
            result = false;
        }

        if(employee.getEmpPassword()==null || employee.getEmpPassword().equals("") ) {
            message.append("Please enter password."+"\n");
            result = false;
        }
        return result;
    }

    public Response login(Employee employee) {

        StringBuilder message = new StringBuilder();
        if(validateEmployeeLogin(employee,message)) {

            EmployeeEntity employeeEntity = new EmployeeEntity(employee);
            EmployeeEntity employeeEntityResult = empLoginRepository.findByempEmail(employee.getEmpEmail());

            if(employeeEntityResult!= null && employeeEntityResult.getEmployeeId()>0
                    && employeeEntityResult.getEmpPassword().equals(employee.getEmpPassword())) {
                employeeEntityResult.setEmpPassword("****");
                Employee employee1 = new Employee(employeeEntityResult);

              //  return new Response((Integer)employeeEntityResult.getEmployeeId(), "Login Successfully");
                return new Response((Employee)employee1, "Login Successfully");
            }else {
                return new Response(-1, "Incorrect email or password. Please check again");
            }

        }
        return new Response(-1,message.toString());

    }

    private boolean validateEmployeeLogin(Employee employee, StringBuilder message) {

        boolean result = true;
        result = validateLogin(employee, result,message);
        return result;
    }

    public Response getEmployeeDetails(Integer employeeId) {

        if(employeeId<=0) {
            return new Response(-1, "Invalid employee Id");
        }

        EmployeeEntity employeeEntity = empLoginRepository.findByemployeeId(employeeId);

        if(employeeEntity==null) {
            return new Response(-1, "Invalid employee Id");
        }

        Employee employee = new Employee(employeeEntity);
        return new Response(employee, "Able to retrieve employee details");
    }

}

