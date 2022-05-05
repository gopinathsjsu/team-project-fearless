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
import Payment from './components/Customer/Bookings/payment';
import Exit from './components/Customer/Exit/exit';
import Error from './components/Customer/Exit/error';
// import Amenities from './components/Customer/Bookings/amenities';

function App(){
  return(
    <BrowserRouter>
 <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="login" element={<LoginForm />} />
        <Route path="register" element={<RegisterUser />} />
        <Route path="displayhotels" element={<DisplayHotels/>} />
         <Route path="displayhotels/hotel/:id" element={<BookRoom/>} />
         <Route path="payment" element={<Payment/>} />
         <Route path="exit" element={<Exit/>}></Route>
         <Route path="error" element={<Error/>}></Route>
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
