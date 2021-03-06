package com.hotel.sjsu.hotelbookingservice.entity;

import com.hotel.sjsu.hotelbookingservice.model.Employee;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "employee")
@Table(name = "employee")
@Component
public class EmployeeEntity {

    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name="emp_first_name")
    private String empFirstName;

    @Column(name="emp_last_name")
    private String empLastName;

    @Column(name="emp_email")
    private  String empEmail;

    @Column(name="emp_password")
    private  String empPassword;


    @Column(name="emp_contact_number")
    private String empContactNumber;


    public EmployeeEntity( Integer employeeId, String empFirstName, String empLastName,  String empEmail,  String empPassword, String empContactNumber) {

        super();
        this.employeeId = employeeId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.empContactNumber = empContactNumber;

    }

    public EmployeeEntity() {

        super();

    }

    public EmployeeEntity(Employee employee){
        this.employeeId = employee.getEmployeeId();
        this.empFirstName = employee.getEmpFirstName();
        this.empLastName = employee.getEmpLastName();
        this.empEmail = employee.getEmpEmail();
        this.empPassword = employee.getEmpPassword();
        this.empContactNumber = employee.getEmpContactNumber();

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
