import React, { Component, useState } from "react";
import { Button } from "react-bootstrap";
import axios from 'axios';
import utilObj from '../Utils/utils'
import { useNavigate } from 'react-router-dom';

function CancelBooking(bookingId, checkIn){
    const navigate = useNavigate();
    const onCancelClick = () => {
        var currDate = new Date().toISOString().substring(0,10)
        if(utilObj.getDays(currDate, checkIn) <= 2){
            alert("Cannot cancel booking before 48 hours of checkin")
            return
        }
        //send axios request to cancel
        axios({
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
            
        });
        
    }
    return <Button onClick = {onCancelClick}>Cancel Booking</Button>
        
} 

export default CancelBooking