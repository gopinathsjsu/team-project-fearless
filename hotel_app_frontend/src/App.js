import React from 'react';
import { Routes, Route, Link, BrowserRouter } from "react-router-dom";
// import {
//     BrowserRouter as Router,
//     Switch,
//     Route,
//     Link
//   } from "react-router-dom";
import RegisterUser from './components/Customer/Register/registerForm';
import LoginForm from './components/Customer/Login/loginForm';
import BookingsPage from './components/Customer/Bookings/bookings';
import DisplayHotels from './components/Customer/DisplayHotels/displayHotels';
import BookRoom from './components/Customer/Bookings/bookroom';
import LandingPage from './components/Home/LandingPage';
import Profile from './components/Home/Profile';
import UpcomingBookings from './components/Home/UpcomingBookings';
import PastBookings from './components/Home/PastBookings';
import Payment from './components/Customer/Bookings/payment';
import Exit from './components/Customer/Exit/exit';
import Error from './components/Customer/Exit/error';
import  Header  from './components/Home/Header';
import Logout from './components/Customer/Login/logout';
import UpdateRoomCosts from './components/Employee/UpdateRoomCosts';
import EmployeeLogin from './components/Employee/EmployeeLogin';
import EmployeeRegister from './components/Employee/EmployeeRegister';
import EmpHomePage from './components/Employee/EmpHomePage';
import AddHotels from './components/Employee/AddHotels';
// import Amenities from './components/Customer/Bookings/amenities';

function App(){
  return(
    <BrowserRouter>
    <Header/>
    <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="login" element={<LoginForm />} />
        <Route path="register" element={<RegisterUser />} />
        {/* <Route path="displayhotels" element={<DisplayHotels/>} /> */}
         <Route path="displayhotels/hotel/:id" element={<BookRoom/>} />
         <Route path="payment" element={<Payment/>} />
         <Route path="exit" element={<Exit/>}></Route>
         <Route path="error" element={<Error/>}></Route>
         <Route path="/profile" element={<Profile/>}/>
          <Route path="/upcomingBookings" element={<UpcomingBookings/>} />
          <Route path="/pastBookings" element={<PastBookings/>} />
          <Route path="/updateRoomCosts" element={<UpdateRoomCosts/>} />
          <Route path ="/" element={<Logout/>}/>



         <Route path="/employee/login" element={<EmployeeLogin/>} />
         <Route path="/employee/register" element={<EmployeeRegister/>} />
         <Route path="/employee/homepage" element={<EmpHomePage/>} />
         <Route path="/addhotel" element={<AddHotels/>} />


      </Routes>
    </BrowserRouter>
   
    
      // <Router>
      //   <div>
      //   <Switch>
      //     <Route path="/register">
      //     <RegisterUser/>
      //     </Route>
        
      //   <Route path="/login">
      //     <LoginForm/>
      //     </Route>

      //     {/* <Route path="/test">
      //       <Amenities></Amenities>
      //     </Route> */}

      //     {/* <Route path="/bookings/{url}">
      //     <BookingsPage/>
      //     </Route> */}
      //    <Route path = "/user/:id"  component = {BookingsPage} />

          

      //     <Route path="/displayhotels">
      //     <DisplayHotels/>
      //     </Route>

      //   </Switch>
      //   </div>
      // </Router>

      
    
  )

}
export default App;
