import React, { useState, useEffect } from 'react';
import { useHistory,Link ,useNavigate} from 'react-router-dom';
import axios from 'axios';
import { Card, Form, Row,Col, Button,ListGroup } from "react-bootstrap";
import { FormButton } from 'semantic-ui-react';
import BookRoom from '../Bookings/bookroom';

import { hotels } from './hotels';

export default function DisplayHotels() {

    const amenities=
    [
        {
            "amenityId": 1,
            "amenityCode": "CB",
            "amenityType": "Daily Continental Breakfast",
            "amenityCost": 25
        },
        {
            "amenityId": 2,
            "amenityCode": "FR",
            "amenityType": "Access to fitness room",
            "amenityCost": 25
        },
        {
            "amenityId": 3,
            "amenityCode": "SJ",
            "amenityType": "Access to Swimming Pool/Jacuzzi",
            "amenityCost": 25
        },
        {
            "amenityId": 4,
            "amenityCode": "DP",
            "amenityType": "Daily Parking",
            "amenityCost": 10
        },
        {
            "amenityId": 5,
            "amenityCode": "BF",
            "amenityType": "Breakfast",
            "amenityCost": 10
        },
        {
            "amenityId": 6,
            "amenityCode": "LN",
            "amenityType": "Lunch",
            "amenityCost": 10
        },
        {
            "amenityId": 7,
            "amenityCode": "DN",
            "amenityType": "Dinner",
            "amenityCost": 10
        }
    ]

    console.log("Amenities type =",typeof(amenities));
    console.log("Amenities type =",typeof(JSON.stringify(amenities)));

    localStorage.setItem("amenities",JSON.stringify(amenities));
   
    // useEffect(()=>{
    //     localStorage.setItem("hotels",JSON.stringify(hotels));
    //     // localStorage.setItem("amenities",JSON.stringify(amenities));
   
    // },[hotels]);
    console.log(typeof(hotels));


    const onSelectHotel=(val)=>{
        localStorage.setItem('hotel',JSON.stringify(val));

    }


    return (
        <React.Fragment>
            <Card>
          <Card.Header  style={{textAlign:'center', color:'green', fontStyle:"italic"}}>Displaying Search Results</Card.Header>
          <Card.Body>
              
        <ListGroup >
                {hotels.map(hotel=>{
                
                    return(
                        <ListGroup.Item key={hotel.hotel.hotelId} >
                            <Row >
                            <Col>{hotel.hotel.hotelname} 
                            </Col>
                            <Col>
                            {hotel.hotel.hotelLocation}
                            </Col>
                            <Col>
                           
                            <Link style={{variant:"success", fontStyle:"italic", color:"green"}} onClick={onSelectHotel(hotel)} to={{pathname :`hotel/${hotel.hotel.hotelId}`, state:hotel}} > Select</Link>
                            </Col>
                            </Row>
                            <Row>
                                <Col>
                                Description of the Hotel
                                </Col> 
                            </Row>
                            </ListGroup.Item>                         
                        );
                })}
        </ListGroup>
        </Card.Body>
        </Card>
        </React.Fragment>
)
       

}

