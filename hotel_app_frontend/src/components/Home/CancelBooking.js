import React, { Component, useState } from "react";
import { Button } from "react-bootstrap";
import axios from 'axios';
import utilObj from '../Utils/utils'
import { useNavigate } from 'react-router-dom';
import './Styles/Profile.css';

function CancelBooking(props){
    const navigate = useNavigate();
    const onCancelClick = () => {
       const bookingId = props.currBooking.bookingId
        axios({
            method: "put",
            url:"http://ec2-18-236-174-30.us-west-2.compute.amazonaws.com:8080/api/hotel/cancel/"+bookingId,
            headers: {
            "Content-Type": "application/json",
          }
           }).then(res=>{
            if (res.status==200){
                alert(res.data.result);
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