**CMPE202-48 : SOFTWARE SYSTEMS ENGINEERING**

-----------------------------------------------------------------------------------------------------------------------------------------------------------


**GROUP PROJECT:**   **HOTEL MANAGEMENT APPLICATION**                                                                                                                       

------------------------------------------------------------------------------------------------------------------------------------------------------------


**TEAM NAME:** **FEARLESS**

------------------------------------------------------------------------------------------------------------------------------------------------------------

**TEAM MEMBERS:**    


 LIMEKA DABRE (015905812)

 SIMRAN MEMON (015950610)

 ARCHANA KAMATH (015276378)

 MOUNICA KAMIREDDY (015949414)
 
 --------------------------------------------------------------------------------------------------------------------------------------------------------------
              
**SCRUM MEETING SCHEDULE:**

Every Monday


---------------------------------------------------------------------------------------------------------------------------------------------------------------
**XP Core Values Implemented:**

**Communication:** Our team communicated with each other regularly and Scrum meetings were held every Monday. We discussed about the dependency, issues faced and provide constructive feedback to each other which helped to progress with the project. We used to GitHub Story Board to track progress of the sprints.


**Simplicity:** We implemented the essential and required tasks in the project.


**Feedback:** Each team member provided constructive feedback on the work performed and ensured that the feedback was implemented in the next sprint.


**Courage:** We had the courage to incorporate any additional details/tasks that were required for the project progress.


**Respect:** Each team member respected each other’s decisions and timelines.


----------------------------------------------------------------------------------------------------------------------------------------------------------

**Tools and Languages:**

Frontend - ReactJS

Backend - Spring Boot

Database – MySQL - AWS RDS

UI Icons – MaterialUI, ReactBootstrap and CSS

Postman - REST API client to test the developed APIs

Deployment - Amazon Web Services (AWS) - EC2 , S3


-----------------------------------------------------------------------------------------------------------------------------------------------------------

**Design Decisions:**


**Architecture-level:**

ReactJS as Frontend and Spring Boot as Backend

AWS as the cloud provider for deployment


----------------------------------------------------------------------------------------------------------------------------------------------------------

**Business- level:**


**Customer Features:**

Register

Login

Search Hotel

View searched Hotels

Select and book a hotel

Make the payment

Update Bookings

Cancel Bookings

Refund amount paid and loyalty points used

View booked hotel details

View loyalty points and profile details



**Employee Features:**

Register

Login

View Employee details

Add new hotel details

View existing room costs

Update room costs


---------------------------------------------------------------------------------------------------------------------------------------------------------------
**Database Design (Tables):**

https://github.com/gopinathsjsu/team-project-fearless/blob/main/Documents/202_database_script_v3.sql.sql

customer

hotel

hotel_rooms_map

room

amenity

booking

employee

----------------------------------------------------------------------------------------------------------------------------------------------------------

**Summary of contributions (for each team member):**


**Limeka Dabre:**

Customer - registration and login page

Booking a hotel room

Checkout and payment confirmation page

Employee - registration and login page

Employee - Add hotel page

Deployment Diagram

Frontend deployment

UI wireframes


----------------------------------------------------------------------------------------------------------------------------------------------------

**Simran Memon:**

Search Hotel on the basis of location, check-in date and check-out date for 7 days

Check room availability of selected hotel

Cancel bookings of customer

Refund amount paid and manage loyalty points

Employee - registration and login

Employee - Add new hotel feature

Employee - View room details

Employee - Update room cost

Deployment of backend


------------------------------------------------------------------------------------------------------------------------------------------------------

**Archana Kamath:**

Customer - registration and login

Book a hotel

Using design patterns(Decorator and Strategy) -  Calculate the total room cost of booked hotel

View booking details of customer

Update booking details of customer

View customer profile details

Manage loyalty points for customer after booking

Deployment of backend


--------------------------------------------------------------------------------------------------------------------------------------------------------


**Mounica Kamireddy:**

Search and select specific hotel page

Customer dashboard

Manage bookings page

Update and cancel existing booking page

Employee - View and update room cost

Architecture Diagram

UI wireframes

Component Diagram

Frontend deployment

----------------------------------------------------------------------------------------------------------------------------------------------------------

**Steps to start the application:**

**Follow the below steps to get the development environment running:**


Clone the repository from GitHub:

git clone https://github.com/gopinathsjsu/team-project-fearless


**Backend:**

cd hotel-booking-service

mvn clean install

mvn exec:java -Dexec.mainClass=com.hotel.sjsu.hotelbookingservice.HotelBookingServiceApplication

**Frontend:**

cd hotel_app_frontend

npm install

npm start


--------------------------------------------------------------------------------------------------------------------------------------------------------


**ARCHITECTURE DIAGRAM:**


![Architecture_Diagram](https://user-images.githubusercontent.com/91573255/167739879-98c71de7-1d5e-4ce3-806e-4c4b6648110b.png)

----------------------------------------------------------------------------------------------------------------------------------------------------------------

**COMPONENT DIAGRAM:**


![Component_Diagram](https://github.com/gopinathsjsu/team-project-fearless/blob/main/Documents/Component_Diagram.png)

----------------------------------------------------------------------------------------------------------------------------------------------------------------

**HOTEL SERVICE CLASS DIAGRAM:**


![HotelService_class_diagram](https://user-images.githubusercontent.com/91573255/167739954-7052615b-4a8b-4eda-8708-eb1693e2b2f4.png)

--------------------------------------------------------------------------------------------------------------------------------------------------------------


**DESIGN PATTERN CLASS DIAGRAM:**


![Design_Patterns](https://user-images.githubusercontent.com/91573255/167739959-73a1cb9f-54db-4257-a36c-d03d29ff574b.png)


------------------------------------------------------------------------------------------------------------------------------------------------------------------

**DEPLOYMENT DIAGRAM:**


![Deployment Diagram202](https://user-images.githubusercontent.com/91573255/167739978-729a8821-7b0c-440a-bd9e-7e6cac8a9266.png)


----------------------------------------------------------------------------------------------------------------------------------------------------------------

**Source Code:** https://github.com/gopinathsjsu/team-project-fearless


**Project board:** https://github.com/orgs/gopinathsjsu/projects/11


**Sprint Task Sheet:** https://docs.google.com/spreadsheets/d/1i8eWHIbbdOpVVJ7bxTmMopMeG-g3bVmW/edit#gid=882345882


**Application:** https://d331f1di2dfhi6.cloudfront.net/


**Postman Collection:** https://drive.google.com/file/d/1tVkhelec57uJbDsGKztUwHY5d40K4Eoh/view


**UI Wireframes:**  https://github.com/gopinathsjsu/team-project-fearless/tree/main/Documents/UI%20Wireframes




