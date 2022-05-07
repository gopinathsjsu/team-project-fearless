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

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpContactNumber() {
		return empContactNumber;
	}

	public void setEmpContactNumber(String empContactNumber) {
		this.empContactNumber = empContactNumber;
	}
    
    


}
