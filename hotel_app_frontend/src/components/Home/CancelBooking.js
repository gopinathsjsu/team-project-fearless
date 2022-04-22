import React, { Component, useState } from "react";
import { Button,  Container, Card } from "react-bootstrap";
import {getUpcomingBookings} from './Fetchjson.js'
import {getUserName} from './genericUtils.js'

function CancelBooking(){
    return <Button>Cancel Booking</Button>
} 

export default CancelBooking