import React, { Component, useState } from "react";
import { Button } from "react-bootstrap";
import axios from 'axios';
import utilObj from '../Utils/utils'
import { useNavigate } from 'react-router-dom';
import './Styles/Profile.css';

function CancelBooking(bookingId, checkIn){
    const navigate = useNavigate();
    const onCancelClick = () => {
        var currDate = new Date();
        var from = localStorage.getItem("from");
        if(utilObj.getDays(currDate, checkIn) <= 2){
            alert("Cannot cancel booking before 48 hours of checkin");
            return
        }else{
            alert("Booking has been cancelled succesfully!!");
            navigate('/profile');
        }
        //send axios request to cancel
        /*axios({
            method: "put",
            url: utilObj.urls.backendURL+"/api/hotel/cancel"+{bookingId},
            headers: {
            "Content-Type": "application/json",
          }
           }).then(res=>{
            if (res.status==200){
                alert("Booking is cancelled")
                navigate('../upcomingBookings')
                console.log(res.data);
            }
            else{
                console.log("Bad response from server");
            }
            
        });*/
        
    }
    return <Button variant = "success" onClick = {onCancelClick}>Cancel</Button>
        
} 

export default CancelBooking