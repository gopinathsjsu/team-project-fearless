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

- **Communication:** Maintained healthy communication throughout the project implementation and participated in weekly scrum calls to discuss progress.


- **Simplicity:** Started with easy to understand functionality and scaled it up to meet project requirements


- **Feedback:** Constructive feedback was provided by the team members on features that needed improvement. The feedback was very well received and were effectively implemented by the team members. Frequent reviews helped us solve bugs and make fixes easily.


- **Courage:** We had the courage to incorporate any additional details/tasks that were required for the project progress.


- **Respect:** Respected everyone’s input and implemented the solution that all agreed upon


----------------------------------------------------------------------------------------------------------------------------------------------------------

**Tools and Languages:**

- Frontend - ReactJS

- Backend - Spring Boot

- Database – MySQL - AWS RDS

- UI Icons – MaterialUI, React Bootstrap and CSS

- Postman - REST API client to test the developed APIs

- Deployment - Amazon Web Services (AWS) - EC2 (With Load balancing and Auto scaling) , S3 and CloudFront

- Testing - JUnit MVC


-----------------------------------------------------------------------------------------------------------------------------------------------------------

**Design Decisions:**

**Strategy**  
             - To identify rating plan (Standard for weekdays and Special for weekends/holidays) for each booking dates selected</br>
**Decorator**</br>
             - To calculate room cost and get description for room types and number of rooms selected </br>
             - To calculate amenity cost and get description for amenities selected 


**Architecture-level:**

- ReactJS as Frontend because of ease and flexibility
- Spring Boot as Backend because of IoC and dependency injection
- AWS as the cloud provider for deployment


----------------------------------------------------------------------------------------------------------------------------------------------------------

**Business- level:**


**Customer Features:**

- Register

- Login

- Search Hotel

- View searched Hotels

- Select and book a hotel

- Make the payment

- Update Bookings

- Cancel Bookings

- Refund amount paid and loyalty points used

- View booked hotel details

- View loyalty points and profile details



**Employee Features:**

- Register

- Login

- View Employee details

- Add new hotel details

- View existing room costs

- Update room costs


---------------------------------------------------------------------------------------------------------------------------------------------------------------
**Database Design (Tables):**

https://github.com/gopinathsjsu/team-project-fearless/blob/main/Documents/202_database_script_v3.sql.sql

- customer

- hotel

- hotel_rooms_map

- room

- amenity

- booking

- employee

----------------------------------------------------------------------------------------------------------------------------------------------------------

**Summary of contributions (for each team member):**


**Limeka Dabre:**

- Customer - registration and login page

- Booking a hotel room

- Checkout and payment confirmation page

- Employee - registration and login page

- Employee - Add hotel page

- Deployment Diagram

- Frontend deployment

- UI wireframes


----------------------------------------------------------------------------------------------------------------------------------------------------

**Simran Memon:**

- Search Hotel on the basis of location, check-in date and check-out date for 7 days

- Check room availability of selected hotel

- Cancel bookings of customer

- Refund amount paid and manage loyalty points

- Employee - registration and login

- Employee - Add new hotel feature

- Employee - View room details

- Employee - Update room cost

- Employee - view employee details

- Deployment of backend


------------------------------------------------------------------------------------------------------------------------------------------------------

**Archana Kamath:**

- Customer - registration and login

- Book a hotel

- Using design patterns(Decorator and Strategy) -  Calculate the total room cost of booked hotel

- View booking details of customer

- Update booking details of customer

- View customer profile details

- Manage loyalty points for customer after booking

- Deployment of backend

- Written test cases to validate service class 

- Class diagram for design patterns used

--------------------------------------------------------------------------------------------------------------------------------------------------------


**Mounica Kamireddy:**

- Search and select specific hotel page

- Customer dashboard

- Manage bookings page

- Update and cancel existing booking page

- Employee - View and update room cost

- Architecture Diagram

- UI wireframes

- Component Diagram

- Frontend deployment

----------------------------------------------------------------------------------------------------------------------------------------------------------

**Steps to start the application:**

**Follow the below steps to get the development environment running:**


Clone the repository from GitHub:

- git clone https://github.com/gopinathsjsu/team-project-fearless


**Backend:**

Import backend maven project into your IDE

Run HotelBookingServiceApplication class as 'Java Application'. Default port is 8080

**Frontend:**

- cd hotel_app_frontend

- npm install

- npm start


--------------------------------------------------------------------------------------------------------------------------------------------------------


**ARCHITECTURE DIAGRAM:**


![Architecture_Diagram](https://github.com/gopinathsjsu/team-project-fearless/blob/main/Documents/Architecture_Diagram.png)

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

**TEST CASES:**


![testcases_screenshot](https://user-images.githubusercontent.com/91573255/167754084-bb798a1a-58bb-45f7-8500-0a8e0d7c580b.png)



![testcases_screenshot_1](https://user-images.githubusercontent.com/91573255/167754094-154dcce4-3620-49af-a927-61d73a062d4c.png)


------------------------------------------------------------------------------------------------------------------------------------------------------


**Source Code:** https://github.com/gopinathsjsu/team-project-fearless


**Project board:** https://github.com/orgs/gopinathsjsu/projects/11


**Project Journals:** https://github.com/gopinathsjsu/team-project-fearless/tree/main/Documents


**Sprint Task Sheet:** https://docs.google.com/spreadsheets/d/1i8eWHIbbdOpVVJ7bxTmMopMeG-g3bVmW/edit#gid=882345882


**Application:** https://d331f1di2dfhi6.cloudfront.net/


**Postman Collection:** https://drive.google.com/file/d/1tVkhelec57uJbDsGKztUwHY5d40K4Eoh/view


**UI Wireframes:**  https://github.com/gopinathsjsu/team-project-fearless/tree/main/Documents/UI%20Wireframes

