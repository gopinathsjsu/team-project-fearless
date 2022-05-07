import React, { Component, useState } from "react";
import { Button } from "react-bootstrap";
import axios from 'axios';
import utilObj from '../Utils/utils'
import { useNavigate } from 'react-router-dom';
import './Styles/Profile.css';

function CancelBooking(bookingId, checkIn){
    const navigate = useNavigate();
    const onCancelClick = () => {
        
     var currBooking=JSON.parse(localStorage.getItem("currBooking"));
        // console.log("Current booking in cancel compo",localStorage.getItem("currBooking"));
      const bookingId=currBooking.bookingId;
      console.log("Booking iD in cancel compo",bookingId);
        // localStorage.setItem("bookingId",currBooking.bookingId);
        // console.log("Booking Id to be canclled is ",localStorage.getItem("bookingId"));
        var currDate = new Date();
        // var bookingId = localStorage.getItem("bookingId");
        if(utilObj.getDays(currDate, checkIn) <= 2){
            //alert("Cannot cancel booking before 48 hours of checkin");
            return
        }
        //send axios request to cancel
        axios({
            method: "put",
            url:"http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/api/hotel/cancel/"+bookingId,
            // url: utilObj.urls.backendURL+"/api/hotel/cancel"+{bookingId},
            headers: {
            "Content-Type": "application/json",
          }
           }).then(res=>{
            if (res.status==200){
                alert("Booking is cancelled")
                navigate('../upcomingBookings')
                console.log("cancel api response",res.data);
            }
            else{
                console.log("Bad response from server");
            }
            
        });
        
    }
    return <Button variant = "success" onClick = {onCancelClick}>Cancel</Button>
        
} 

export default CancelBooking