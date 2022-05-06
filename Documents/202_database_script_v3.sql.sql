create database hotelbooking_database;
use hotelbooking_database;

drop table hotel;
Select * From hotel;

create table hotel(
	hotel_id int not null auto_increment,
	hotel_name varchar(500),
	hotel_location varchar(500),
	hotel_address varchar(500),
	hotel_zip_code varchar(500),
	hotel_contact varchar(500),
	hotel_manager_name varchar(500),
	hotelEmail varchar(500),
	primary key (hotel_id)
);
INSERT INTO hotel 
(hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail) 
VALUES 
('The Ocean Pearl','Mangalore','Navabharath Cir, KA, India','575003','12345667890','Rajesh Koothrappali','topm1@gmail.com');

INSERT INTO hotel
(hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail) 
VALUES 
('The Ocean Pearl','Udupi','Kunjibettu, KA India','576102','12345667890','Sheldon Cooper','topu1@gmail.com');

INSERT INTO hotel 
(hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail) 
VALUES 
('The Ocean Pearl GARDENIA','New Delhi','Chattarpur Mandir Rd, New Delhi, India','110074','12345667890','Leonard Hofstadter','topn1@gmail.com');

INSERT INTO hotel
(hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail)
VALUES
('Hilton','San Francisco','California,US','575077','12345660090','Tom Creek','tomcreek@gmail.com');

INSERT INTO hotel
(hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail)
VALUES
('JW Marriott','San Francisco','California,US','785077','19645660090','Steven Mary','stevem@gmail.com');
#------------------------------------------------------------------------------------------------------
Select * From customer;
drop table customer;

create table customer(
	customer_id int not null auto_increment,
	cust_first_name  varchar(500),
	cust_last_name  varchar(500),
	cust_password  varchar(500),
	cust_email varchar(500),
	cust_address varchar(500),
	loyalty_points int default 100,
    booking_count int, 
	contact_number varchar(500),
	primary key (customer_id)
);


INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, booking_count, contact_number)
VALUES 
('Archana','Kamath','test123','arc@gmail.com','123 North Rd, CA, 10001',100,0,'1234567890');

INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points,booking_count, contact_number) VALUES 
('Simran','memon','test123','sm@gmail.com','123 North Rd, CA, 10001',100,0,'1234567890');

INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, booking_count, contact_number) VALUES 
('Limeka','Dabre','test123','ld@gmail.com','123 North Rd, CA, 10001',100,0,'1234567890');

select * from customer;
#-----------------------------------------------------------------------------------------------
drop table room;
Select * from room;

create table room(
	room_id int not null,
    room_code varchar(10),
	room_type  varchar(500),
	room_cost  varchar(500),
    room_cost_spl  varchar(500),
	primary key (room_id)
);

INSERT INTO room (room_id, room_code, room_type, room_cost,room_cost_spl) VALUES ( 1001,'DR','Deluxe Room', 100, 110);
INSERT INTO room (room_id, room_code, room_type, room_cost,room_cost_spl) VALUES ( 1002,'SR','Suite Room', 120, 140);

#----------------------------------------------------------------------------------------------------
select * from amenity;
drop table amenity;

create table amenity(
	amenity_id int not null,
    amenity_code varchar(10),
	amenity_type  varchar(500),
	amenity_cost  varchar(500),
	amenity_cost_spl  varchar(500),
	primary key (amenity_id)
);

INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost, amenity_cost_spl) VALUES ( 1,'CB','Daily Continental Breakfast', 25,30);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost, amenity_cost_spl) VALUES ( 2,'FR','Access to fitness room', 25,30);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost, amenity_cost_spl) VALUES ( 3,'SJ','Access to Swimming Pool/Jacuzzi', 25,30);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost, amenity_cost_spl) VALUES ( 4,'DP','Daily Parking', 10,15);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost, amenity_cost_spl) VALUES ( 5,'BF','Breakfast', 10,15);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost, amenity_cost_spl) VALUES ( 6,'LN','Lunch', 10,15);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost, amenity_cost_spl) VALUES ( 7,'DN','Dinner', 10,15);

#---------------------------------------------------------------------------------------------------------
drop table booking;

Select * from booking;
Select * from customer;

create table booking(	
	booking_id			int not null auto_increment,
	hotel_id			int	references hotel(hotel_id),
	customer_id			int references customer(customer_id), 
	room 				varchar(100),
	amenity				varchar(100),
	booking_date_from 	date,
	booking_date_to 	date,
	no_of_guest			int,
	booking_status		varchar(100),
	amount				Double,
	total_amount		Double,
	payment_method		varchar(100),
	room_numbers		varchar(100),
    loyalty_points_used int default 0,
    primary key (booking_id)
);

INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers, loyalty_points_used)
VALUES ( 400,1,'DR1-SR2','CB-DP','2022-01-01','2022-01-15','1','Booked',1000,990,'Cash','A120',10);

INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers, loyalty_points_used)
VALUES ( 400,1,'DR1-SR3','CB-DP','2022-01-01','2022-01-10','1','Booked',1000,980,'Cash','A120',20);

INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers,loyalty_points_used)
VALUES ( 500,1,'DR2-SR2','CB-DP','2022-01-15','2022-01-18','1','Booked',1200,1190,'Credit Card','A120',10);

INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers,loyalty_points_used)
VALUES ( 500,1,'DR4-SR2','CB-DP','2022-01-19','2022-01-22','1','Booked',1200,1190,'Credit Card','A120',10);

#---------------------------------------------------------------------------------------------------
drop table hotel_rooms_map;

create table hotel_rooms_map (
id int not null auto_increment,
hotel_id int,
room_code  varchar(10),
total_rooms int,
primary key (id)
);

select * from hotel;

INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 1,'DR', 100);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 1,'SR', 100);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 2,'DR', 200);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 2,'SR', 200);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 3,'DR', 150);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 3,'SR', 100);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 4,'DR', 50);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 4,'SR', 50);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 5,'DR', 150);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 5,'SR', 150);

select * from hotel_rooms_map;

#-----------------------------------------------------------------------------------

drop table employee;

create table employee(
	employee_id int not null auto_increment,
	emp_first_name  varchar(500),
	emp_last_name  varchar(500),
    emp_email varchar(500),
	emp_password  varchar(500),
	emp_contact_number varchar(500),
	primary key (employee_id)
);

INSERT INTO employee
(emp_first_name, emp_last_name, emp_email, emp_password, emp_contact_number)
VALUES
('Paul','Newmen','paul@gmail.com','paul123','6692418563');

INSERT INTO employee
(emp_first_name, emp_last_name, emp_email, emp_password, emp_contact_number)
VALUES
('Mary','Jane','mary@gmail.com','mary123','6697489652');

INSERT INTO employee
(emp_first_name, emp_last_name, emp_email, emp_password, emp_contact_number)
VALUES
('Harry','Turner','harry@gmail.com','harry123','6698406952');

select * from employee;

#---------------------------------------------------------------------------------------------------

