import React, { useState } from "react";
import { Row, Col, Container, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import {getRewardPoints, getUserEmail, getUserLastName, getUserFirstName} from "./genericUtils.js";
import './Styles/Profile.css';
import avatar from './Styles/avatar.jpeg';

//TODO: add reward points
function Profile(){
    const navigate = useNavigate()

    const profile= (e) => {
        e.preventDefault()
        navigate("../profile", {replace:true}) 
    }

    const showPastBookings= (e) => {
        e.preventDefault()
        navigate("../pastBookings", {replace:true}) 
    }

    const showUpcomingBookings = (e) =>{
        e.preventDefault()
        navigate("../upcomingBookings", {replace:true})
    }
    return(
        <div className="profile">
            <div className="avatar">
                 <img src={avatar} alt="avatar"></img>
            </div>
        <div className="userDetails">
        <Container>
            <Row>
                <Col>Username: {getUserFirstName()+" "+getUserLastName()}</Col>
            </Row>
            <br/>
            <Row>
                <Col>Email: {getUserEmail()}</Col>
            </Row>
            <br/>
            <Row>
                <Col>Reward Points: {getRewardPoints()}</Col>
            </Row>
        </Container>
             <div className="navbookings">
                    {/*<Button onClick={profile} style={{backgroundColor:`#044831` , width:`10em`}}>Profile</Button>*/}
                    <br/><br/>
                    <Button onClick={showPastBookings} variant="success" style={{width:`10.5em`}}>Past bookings</Button>
                    <br/><br/>
                    <Button onClick={showUpcomingBookings} variant="success">Upcoming bookings</Button>      
             </div>
        </div>
        </div>
    )
}

export default Profile;
