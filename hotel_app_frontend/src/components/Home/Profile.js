import React, { useState } from "react";
import { Row, Col, Container, Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import {getRewardPoints, getUserEmail, getUserName} from "./genericUtils.js"

//TODO: add reward points
function Profile(){
    const navigate = useNavigate()

    const showUpcomingBookings = (e) =>{
        e.preventDefault()
        navigate("../upcomingBookings", {replace:true})
    }
    return(
        <Container>
            <Row>
                <Col>Username:</Col>
                <Col>{getUserName()}</Col>
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
                <Button onClick={showUpcomingBookings}>Upcoming bookings</Button>
            </Row>
        </Container>
    )
}

export default Profile;
