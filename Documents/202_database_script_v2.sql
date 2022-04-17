create database hotelbooking_database;
use hotelbooking_database;
------------------------------------------------------------------------------------------------------------------------------------------
drop table hotel;

create table hotel(
	hotel_id int not null,
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
(hotel_id, hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail) 
VALUES 
(100,'The Ocean Pearl','Mangalore','Navabharath Cir, KA, India','575003','12345667890','Rajesh Koothrappali','topm1@gmail.com');

INSERT INTO hotel
(hotel_id, hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail) 
VALUES 
(200,'The Ocean Pearl','Udupi','Kunjibettu, KA India','576102','12345667890','Sheldon Cooper','topu1@gmail.com');

INSERT INTO hotel 
(hotel_id, hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail) 
VALUES 
(300,'The Ocean Pearl GARDENIA','New Delhi','Chattarpur Mandir Rd, New Delhi, India','110074','12345667890','Leonard Hofstadter','topn1@gmail.com');

INSERT INTO hotel
(hotel_id, hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail)
VALUES
(400,'Hilton','San Francisco','California,US','575077','12345660090','Tom Creek','tomcreek@gmail.com');

INSERT INTO hotel
(hotel_id, hotel_name, hotel_location, hotel_address, hotel_zip_code, hotel_contact, hotel_manager_name, hotelEmail)
VALUES
(500,'JW Marriott','San Francisco','California,US','785077','19645660090','Steven Mary','stevem@gmail.com');

Select * From hotel;

-----------------------------------------------------------------------------------------------------------------------------------------------------

drop table hotel_rooms_map;

create table hotel_rooms_map (
id int not null auto_increment,
hotel_id int,
room_code  varchar(10),
total_rooms int,
primary key (id)
);

INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 500,'DR', 100);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 500,'SR', 100);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 400,'DR', 200);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 400,'SR', 200);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 100,'DR', 150);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 100,'SR', 100);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 200,'DR', 50);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 200,'SR', 50);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 300,'DR', 150);
INSERT INTO hotel_rooms_map (hotel_id, room_code, total_rooms) VALUES ( 300,'SR', 150);

select * from hotel_rooms_map;

-------------------------------------------------------------------------------------------------------------------------------------------

drop table customer;

create table customer(
	customer_id int not null auto_increment,
	cust_first_name  varchar(500),
	cust_last_name  varchar(500),
	cust_password  varchar(500),
	cust_email varchar(500),
	cust_address varchar(500),
	loyalty_points int default 100,
	contact_number varchar(500),
	primary key (customer_id)
);


INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, contact_number)
VALUES 
('Archana','Kamath','test123','arc@gmail.com','123 North Rd, CA, 10001',100,'1234567890');

INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, contact_number) VALUES 
('Simran','memon','test123','sm@gmail.com','123 North Rd, CA, 10001',100,'1234567890');

INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, contact_number) VALUES 
('Limeka','Dabre','test123','ld@gmail.com','123 North Rd, CA, 10001',100,'1234567890');

select * from customer;

----------------------------------------------------------------------------------------------------------------------------------

drop table room;

create table room(
    room_id int not null,
    room_code varchar(10),
    room_type  varchar(500),
    room_cost  varchar(500),
    primary key (room_id)
);

INSERT INTO room (room_id, room_code, room_type, room_cost) VALUES ( 1001,'DR','Deluxe Room', 100);
INSERT INTO room (room_id, room_code, room_type, room_cost) VALUES ( 1002,'SR','Suite Room', 120);

Select * from room;

---------------------------------------------------------------------------------------------------------------------------------------

drop table amenity;

create table amenity(
    amenity_id int not null,
    amenity_code varchar(10),
    amenity_type  varchar(500),
    amenity_cost  varchar(500),
    primary key (amenity_id)
);

INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost) VALUES ( 1,'CB','Daily Continental Breakfast', 25);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost) VALUES ( 2,'FR','Access to fitness room', 25);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost) VALUES ( 3,'SJ','Access to Swimming Pool/Jacuzzi', 25);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost) VALUES ( 4,'DP','Daily Parking', 10);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost) VALUES ( 5,'BF','Breakfast', 10);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost) VALUES ( 6,'LN','Lunch', 10);
INSERT INTO amenity (amenity_id, amenity_code, amenity_type, amenity_cost) VALUES ( 7,'DN','Dinner', 10);

select * from amenity;

------------------------------------------------------------------------------------------------------------------------------

drop table booking;

create table booking(
    booking_id int not null auto_increment,
    hotel_id int references hotel(hotel_id),
    customer_id int references customer(customer_id),
    room varchar(100),
    amenity varchar(100),
    booking_date_from date,
    booking_date_to date,
    no_of_guest int,
    booking_status varchar(100),
    amount Double,
    total_amount Double,
    payment_method varchar(100),
    room_numbers varchar(100),
    primary key (booking_id)
);


ALTER TABLE booking ADD loyalty_points_used int default 0;

UPDATE booking SET loyalty_points_used = 10 WHERE booking_id = 1;


// booking_status = ("Booked" , "Cancelled")
INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers, loyalty_points_used)
VALUES ( 400,1,'DR1-SR2','CB-DP','2022-01-01','2022-01-15','1','Booked',1000,900,'Cash','A120',10);

INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers, loyalty_points_used)
VALUES ( 400,1,'DR1-SR3','CB-DP','2022-01-01','2022-01-10','1','Booked',1000,900,'Cash','A120',20);

INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers,loyalty_points_used)
VALUES ( 500,1,'DR2-SR2','CB-DP','2022-01-15','2022-01-18','1','Booked',1200,1000,'Credit Card','A120',10);

INSERT INTO booking (hotel_id, customer_id, room, amenity, booking_date_from,booking_date_to, no_of_guest, booking_status,amount,total_amount,payment_method,room_numbers,loyalty_points_used)
VALUES ( 500,1,'DR4-SR2','CB-DP','2022-01-19','2022-01-22','1','Booked',1200,1000,'Credit Card','A120',10);

Select * from booking;

------------------------------------------------------------------------------------------------------------------------------
