import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import RegisterUser from './components/Customer/Register/registerForm';
import LoginForm from './components/Customer/Login/loginForm';
import BookingsPage from './components/Customer/Bookings/bookings';
import DisplayHotels from './components/Customer/DisplayHotels/displayHotels';
import BookRoom from './components/Customer/Bookings/bookroom';
// import Amenities from './components/Customer/Bookings/amenities';
import LandingPage from "./components/Home/LandingPage";
import Profile from './components/Home/Profile'
import UpcomingBookings from './components/Home/UpcomingBookings';

function App(){
  return(
      <Router>
        <div className="App">
          <Routes>
            <Route path="/register" element = {<RegisterUser/>}/>
            <Route path="/login" element = {<LoginForm/> }/>
          {/* <Route path="/test">
                <Amenities></Amenities>
              </Route> */}

              {/* <Route path="/bookings/{url}">
              <BookingsPage/>
              </Route> */}
            <Route exact path="/" element={<LandingPage/>}/>
            <Route path = "/user/:id"  element = {<BookingsPage/>} />
            <Route path="/displayhotels" element={<DisplayHotels/>} />
            <Route path="/profile" element={<Profile/>}/>
            <Route path="/upcomingBookings" element={<UpcomingBookings/>} />
          </Routes>
        </div>
      </Router>
  )

}
export default App;