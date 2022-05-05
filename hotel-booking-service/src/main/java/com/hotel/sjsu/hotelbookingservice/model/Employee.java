package com.hotel.sjsu.hotelbookingservice.model;

import com.hotel.sjsu.hotelbookingservice.entity.EmployeeEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Getter
@Setter
@Component
public class Employee {

    private Integer employeeId;
    private String empFirstName;
    private String empLastName;
    private String empEmail;
    private String empPassword;
    private String empContactNumber;

    public Employee() {

        super();

    }

    public Employee(Integer employeeId, String empFirstName, String empLastName, String empEmail, String empPassword, String empContactNumber) {
        this.employeeId = employeeId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.empContactNumber = empContactNumber;
    }

    public Employee (EmployeeEntity employeeEntity){
        this.employeeId = employeeEntity.getEmployeeId();
        this.empFirstName = employeeEntity.getEmpFirstName();
        this.empLastName = employeeEntity.getEmpLastName();
        this.empEmail = employeeEntity.getEmpEmail();
        this.empPassword = employeeEntity.getEmpPassword();
        this.empContactNumber = employeeEntity.getEmpContactNumber();

    }


}
