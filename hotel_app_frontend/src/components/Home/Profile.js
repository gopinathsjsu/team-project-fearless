import React, { useState } from "react";
import { Row, Col, Container, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import {getRewardPoints, getUserEmail, getUserLastName, getUserFirstName} from "./genericUtils.js"

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
        <Container>
            <Row>
                <Col>Username:</Col>
                <Col>{getUserFirstName()+" "+getUserLastName()}</Col>
            </Row>
            <Row>
                <Col>Email:</Col>
                <Col>{getUserEmail()}</Col>
            </Row>
            <Row>
                <Col>Reward Points:</Col>
                <Col>{getRewardPoints()}</Col>
            </Row>
            <Row>
                <div>
                    <Button onClick={profile}>Profile</Button>
                    <Button onClick={showPastBookings}>Past bookings</Button>
                    <Button onClick={showUpcomingBookings}>Upcoming bookings</Button>
                    
                </div>
                {/*<Button onClick={showUpcomingBookings}>Upcoming bookings</Button>*/}
            </Row>
        </Container>
    )
}

export default Profile;
