create database hotelbooking_database;
use hotelbooking_database;

drop table hotel;
Select * From hotel;

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

drop table customer;
select * from customer;

INSERT INTO customer 
(customer_id, cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, contact_number) 
VALUES 
(1,'Archana','Kamath','test123','arc@gmail.com','123 North Rd, CA, 10001',100,'1234567890');

INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, contact_number) VALUES 
('Simran','memon','test123','sm@gmail.com','123 North Rd, CA, 10001',100,'1234567890');

INSERT INTO customer 
(cust_first_name, cust_last_name, cust_password, cust_email, cust_address, loyalty_points, contact_number) VALUES 
('Limeka','Dabre','test123','ld@gmail.com','123 North Rd, CA, 10001',100,'1234567890');


create table room(
	room_id int not null,
	room_type  varchar(500),
	room_cost  varchar(500),
	primary key (room_id)
);

INSERT INTO room (room_id, room_type, room_cost) VALUES ( 1001,'Deluxe Room', 100);
INSERT INTO room (room_id, room_type, room_cost) VALUES ( 1002,'Suite Room', 120);

drop table room;
Select * from room;

drop table amenity;
create table amenity(
	amenity_id int not null,
	amenity_type  varchar(500),
	amenity_cost  varchar(500),
	primary key (amenity_id)
);

INSERT INTO amenity (amenity_id, amenity_type, amenity_cost) VALUES ( 1,'Daily Continental Breakfast', 25);
INSERT INTO amenity (amenity_id, amenity_type, amenity_cost) VALUES ( 2,'Access to fitness room', 25);
INSERT INTO amenity (amenity_id, amenity_type, amenity_cost) VALUES ( 3,'Access to Swimming Pool/Jacuzzi', 25);
INSERT INTO amenity (amenity_id, amenity_type, amenity_cost) VALUES ( 4,'Daily Parking', 10);
INSERT INTO amenity (amenity_id, amenity_type, amenity_cost) VALUES ( 5,'Breakfast', 10);
INSERT INTO amenity (amenity_id, amenity_type, amenity_cost) VALUES ( 6,'Lunch', 10);
INSERT INTO amenity (amenity_id, amenity_type, amenity_cost) VALUES ( 7,'Dinner', 10);


	
    
create table booking(	
	booking_id			int not null auto_increment,
	hotel_id			int	references hotel(hotel_id),
	customer_id			int references customer(customer_id), 
	room_id				varchar(100), 		
	amenity				varchar(100),
	booking_date_from 	varchar(100),
	booking_date_to 	varchar(100),
	no_of_adult			int,
	no_of_children		int,
	no_of_rooms			int,
	booking_status		varchar(100),
	amount				Double,
	total_amount		Double,
	payment_method		varchar(100),
	room_numbers		varchar(100),
    primary key (booking_id)
);

drop table booking;
Select * from booking;

INSERT INTO booking (booking_id, hotel_id, customer_id, room_id, amenity, booking_date_from,booking_date_to, no_of_adult, no_of_children, no_of_rooms, booking_status,amount,total_amount,payment_method,room_numbers)
VALUES ( 1,100,1,1001,'1-2-3','2022-01-01','2022-01-15','1','0','1','Complete',1000,900,'Cash','A120');
