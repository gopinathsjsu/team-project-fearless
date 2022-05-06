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

////    @Column(name="login_status")
//    private boolean loggedIn;

    @Column(name="emp_contact_number")
    private String empContactNumber;

//    public boolean isLoggedIn() {
//        return loggedIn;
//    }
//    public void setLoggedIn(boolean loggedIn) {
//        this.loggedIn = loggedIn;
//    }

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

//
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(employeeId, empEmail, empPassword,
//                loggedIn);
//    }


}
